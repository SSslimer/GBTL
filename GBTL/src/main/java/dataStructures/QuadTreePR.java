package dataStructures;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QuadTreePR<E>
{
	private final int cellCapacity;
	private final int maxDepth;
	private final float minX, maxX, minY, maxY;
	
	private QuadTreeCell root;
	
	public QuadTreePR(int cellCapacity, int maxDepth, float rangeX, float rangeY)
	{
		this.cellCapacity = cellCapacity;
		this.maxDepth = maxDepth;
		this.minX = -rangeX;
		this.maxX = rangeX;
		this.minY = -rangeY;
		this.maxY = rangeY;	
		root  = new QuadTreeCell(1, 0, 0, rangeX, rangeY);
	}
	
	public QuadTreePR(int cellCapacity, int maxDepth, float minX, float maxX, float minY, float maxY)
	{
		this.cellCapacity= cellCapacity;
		this.maxDepth = maxDepth;
		this.minX = minX;
		this.maxX = maxX;
		this.minY = minY;
		this.maxY = maxY;
		root  = new QuadTreeCell(1, (maxX-minX)/2, (maxY-minY)/2, maxX-minX, maxY-minY);
	}
	
	private class QuadTreeCell
	{
		private final float centerX, centerY, rangeX, rangeY;
		private final int depth;
		private List<QuadTreeElement> elements = new ArrayList<>(cellCapacity);
		private QuadTreeCell[] children;
		
		public QuadTreeCell(int depth, float centerX, float centerY, float rangeX, float rangeY)
		{
			this.depth = depth;
			this.centerX = centerX;
			this.centerY = centerY;
			this.rangeX = rangeX;
			this.rangeY = rangeY;
		}
	}
	
	private class QuadTreeElement
	{
		private final E value;
		private final float x, y;
		
		public QuadTreeElement(E value, float x, float y)
		{
			this.value = value;
			this.x = x;
			this.y = y;
		}
		
		@Override
		public String toString()
		{
			return "x=" + x + " y=" + y + " " + value.toString();
		}
	}

	public boolean add(E valueToAdd, float x, float y)
	{
		if(x < minX || x > maxX || y < minY || y > maxY) return false;
		
		QuadTreeCell currentCell = getCell(x, y);
		
		if(currentCell.elements.size() == cellCapacity && currentCell.depth != maxDepth)
		{
			divideCell(currentCell);

			if(x >= currentCell.centerX)
			{
				currentCell = (y >= currentCell.centerY ? currentCell.children[1] : currentCell.children[3]);
			}
			else
			{
				currentCell = (y >= currentCell.centerY ? currentCell.children[0] : currentCell.children[2]);
			}
		}

		addRecursive(currentCell, currentCell.depth, valueToAdd, x, y);		

		return true;
	}

	private void addRecursive(QuadTreeCell cell, int depth, E valueToAdd, float x, float y)
	{
		QuadTreeCell currentCell = cell;
		
		if(currentCell.elements.size() == cellCapacity && depth != maxDepth)
		{
			divideCell(currentCell);

			if(x >= currentCell.centerX)
			{
				currentCell = (y >= currentCell.centerY ? currentCell.children[1] : currentCell.children[3]);
			}
			else
			{
				currentCell = (y >= currentCell.centerY ? currentCell.children[0] : currentCell.children[2]);
			}
			
			addRecursive(currentCell, depth+1, valueToAdd, x, y);
		}		
		else currentCell.elements.add(new QuadTreeElement(valueToAdd, x, y));
	}
	
	private void divideCell(QuadTreeCell cellToDivide)
	{
		float halfRangeX = cellToDivide.rangeX/2;
		float halfRangeY = cellToDivide.rangeY/2;
		float leftCenterX = cellToDivide.centerX-halfRangeX;
		float rightCenterX = cellToDivide.centerX+halfRangeX;
		float upperCenterY = cellToDivide.centerY+halfRangeY;
		float bottomCenterY = cellToDivide.centerY-halfRangeY;		
		int childsDepth = cellToDivide.depth + 1;

		cellToDivide.children = (QuadTreePR<E>.QuadTreeCell[]) Array.newInstance(QuadTreeCell.class, 4);
		cellToDivide.children[0] = new QuadTreeCell(childsDepth, leftCenterX, upperCenterY, halfRangeX, halfRangeY);
		cellToDivide.children[1] = new QuadTreeCell(childsDepth, rightCenterX, upperCenterY, halfRangeX, halfRangeY);
		cellToDivide.children[2] = new QuadTreeCell(childsDepth, leftCenterX, bottomCenterY, halfRangeX, halfRangeY);
		cellToDivide.children[3] = new QuadTreeCell(childsDepth, rightCenterX, bottomCenterY, halfRangeX, halfRangeY);
		
		for(QuadTreeElement element : cellToDivide.elements)
		{
			if(element.x >= cellToDivide.centerX)
			{
				if(element.y >= cellToDivide.centerY) cellToDivide.children[1].elements.add(element);
				else cellToDivide.children[3].elements.add(element);
			}
			else
			{
				if(element.y >= cellToDivide.centerY) cellToDivide.children[0].elements.add(element);
				else cellToDivide.children[2].elements.add(element);
			}
		}
		
		cellToDivide.elements = null;
	}
	
	private String getStringRepresentation(QuadTreeCell cell, int depth)
	{
		if(isEmptyLeaf(cell)) return "";
		
		StringBuffer buffer = new StringBuffer();

		if(cell.children == null)
		{
			buffer.append("depth = " + depth + "\n");
			buffer.append("size = " + cell.elements.size() + "\n");	
			buffer.append("center = (" + cell.centerX + " " + cell.centerY + ")\n");
			buffer.append("range = (" + cell.rangeX + " " + cell.rangeY + ")\n");	
		}
		else
		{
			buffer.append(getStringRepresentation(cell.children[0], depth+1));
			buffer.append(getStringRepresentation(cell.children[1], depth+1));
			buffer.append(getStringRepresentation(cell.children[2], depth+1));
			buffer.append(getStringRepresentation(cell.children[3], depth+1));	
		}
		
		return buffer.toString();
	}
	
	private boolean isEmptyLeaf(QuadTreeCell cell)
	{
		return (cell.children == null && cell.elements.isEmpty());
	}
	
	public boolean contains(E element)
	{
		return contains(root, element);	
	}
	
	private boolean contains(QuadTreeCell cell, E element)
	{
		if(cell.children == null)
		{
			for(QuadTreeElement e : cell.elements)
			{
				if(element.equals(e.value)) return true;
			}
		}
		else
		{
			for(QuadTreeCell child : cell.children)
			{
				if(contains(child, element)) return true;
			}
		}
		
		return false;
	}
	
	public boolean contains(E element, float x, float y)
	{
		QuadTreeCell cell = getCell(x, y);
		
		for(QuadTreeElement e : cell.elements)
		{
			if(element.equals(e.value)) return true;
		}
		
		return false;
	}
	
	private QuadTreeCell getCell(float x, float y)
	{
		QuadTreeCell currentCell = root;
		
		while(true)
		{
			if(currentCell.children == null) break;
			
			if(x >= currentCell.centerX)
			{
				currentCell = (y >= currentCell.centerY ? currentCell.children[1] : currentCell.children[3]);
			}
			else
			{
				currentCell = (y >= currentCell.centerY ? currentCell.children[0] : currentCell.children[2]);
			}
		}
		
		return currentCell;
	}
	
	public boolean remove(E element)
	{	
		return remove(element, root);
	}
	
	public boolean remove(E element, QuadTreeCell cell)
	{
		if(cell.children == null)
		{
			Iterator<QuadTreeElement> iterator = cell.elements.iterator();
			
			while(iterator.hasNext())
			{
				if(iterator.next().value.equals(element))
				{
					iterator.remove();
					return true;
				}
			}
		}
		else
		{
			for(QuadTreeCell child : cell.children)
			{
				if(remove(element, child)) return true;
			}
		}
		
		return false;
	}
	
	public boolean remove(E element, float x, float y)
	{
		return remove(root, element, x, y);
	}

	private boolean remove(QuadTreeCell cell, E element, float x, float y)
	{
		if(cell.elements != null) return removeElementFromCell(cell, element);

		QuadTreeCell cellInPos = getCell(x, y);

		if(remove(cellInPos, element, x, y))
		{ 
			mergeCellsIfNeeded(cell);
			
			return true;
		}
		
		return false;
	}

	private void mergeCellsIfNeeded(QuadTreeCell cell)
	{
		for(QuadTreeCell child : cell.children)
		{
			if(child.elements == null) return;
		}

		int size = 0;
		for(QuadTreeCell child : cell.children)
		{
			size += child.elements.size();
		}

		if(size != cellCapacity) return;
		
		cell.elements = new ArrayList<>(cellCapacity);
		for(QuadTreeCell child : cell.children)
		{
			cell.elements.addAll(child.elements);
		}
		
		cell.children = null;
	}
	
	private boolean removeElementFromCell(QuadTreeCell cell, E element)
	{
		Iterator<QuadTreeElement> iterator = cell.elements.iterator();
			
		while(iterator.hasNext())
		{
			if(iterator.next().value.equals(element))
			{
				iterator.remove();
				return true;
			}
		}
		
		return false;
	}

	@Override
	public String toString()
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("QuadTree String representation:\n");
		buffer.append("Cell capacity = " + cellCapacity + "\n");
		buffer.append("Min x = " + minX + "\n");
		buffer.append("Max x = " + maxX + "\n");
		buffer.append("Min y = " + minY + "\n");
		buffer.append("Max y = " + maxY + "\n\n");
		buffer.append(getStringRepresentation(root, 1));
		
		return buffer.toString();
	}
}
