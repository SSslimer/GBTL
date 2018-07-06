package dataStructures;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;

public class QuadTree<E>
{
	private final int cellCapacity;
	private final float minX, maxX, minY, maxY;
	
	private QuadTreeCell<E> root;
	
	public QuadTree(int cellCapacity, float rangeX, float rangeY)
	{
		this.cellCapacity= cellCapacity;
		this.minX = -rangeX;
		this.maxX = rangeX;
		this.minY = -rangeY;
		this.maxY = rangeY;	
		root  = new QuadTreeCell<E>(0, 0, rangeX, rangeY);
	}
	
	public QuadTree(int cellCapacity, float minX, float maxX, float minY, float maxY)
	{
		this.cellCapacity= cellCapacity;
		this.minX = minX;
		this.maxX = maxX;
		this.minY = minY;
		this.maxY = maxY;
		root  = new QuadTreeCell<E>((maxX-minX)/2, (maxY-minY)/2, maxX-minX, maxY-minY);
	}
	
	private class QuadTreeCell<E>
	{
		private final float centerX, centerY, rangeX, rangeY;
		private List<QuadtreeElement<E>> elements = new ArrayList<>(cellCapacity);
		private QuadTreeCell<E> upperLeft, upperRight, bottomLeft, bottomRight;
		
		public QuadTreeCell(float centerX, float centerY, float rangeX, float rangeY)
		{
			this.centerX = centerX;
			this.centerY = centerY;
			this.rangeX = rangeX;
			this.rangeY = rangeY;
		}
	}
	
	private class QuadtreeElement<E>
	{
		private final E value;
		private final float x, y;
		
		public QuadtreeElement(E value, float x, float y)
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
		
		@Override
		public boolean equals(Object obj)
		{
	        if(this == obj) return true;
	        if(obj == null || getClass() != obj.getClass()) return false;
	        
	        QuadtreeElement<E> element = (QuadtreeElement<E>) obj;
	        return new EqualsBuilder()
	        		.append(value, element.value)
	        		.append(x, element.x)
	        		.append(y, element.y)
	        		.isEquals();
		}
	}

	public boolean add(E valueToAdd, float posX, float posY)
	{
		if(posX < minX || posX > maxX || posY < minY || posY > maxY) return false;
		
		QuadTreeCell<E> currentCell = root;
		
		while(true)
		{
			if(currentCell.upperLeft == null) break;
			
			if(posX >= currentCell.centerX)
			{
				currentCell = (posY >= currentCell.centerY ? currentCell.upperRight : currentCell.bottomRight);
			}
			else
			{
				currentCell = (posY >= currentCell.centerY ? currentCell.upperLeft : currentCell.bottomLeft);
			}
		}
		
		if(currentCell.elements.size() == cellCapacity)
		{
			divide(currentCell);
			
			if(posX >= currentCell.centerX)
			{
				currentCell = (posY >= currentCell.centerY ? currentCell.upperRight : currentCell.bottomRight);
			}
			else
			{
				currentCell = (posY >= currentCell.centerY ? currentCell.upperLeft : currentCell.bottomLeft);
			}
		}

		currentCell.elements.add(new QuadtreeElement<E>(valueToAdd, posX, posY));
		return true;
	}

	private void divide(QuadTreeCell<E> cellToDivide)
	{
		float halfRangeX = cellToDivide.rangeX/2;
		float halfRangeY = cellToDivide.rangeY/2;
		float leftCenterX = cellToDivide.centerX-halfRangeX;
		float rightCenterX = cellToDivide.centerX+halfRangeX;
		float upperCenterY = cellToDivide.centerY+halfRangeY;
		float bottomCenterY = cellToDivide.centerY-halfRangeY;
		
		cellToDivide.upperLeft = new QuadTreeCell<E>(leftCenterX, upperCenterY, halfRangeX, halfRangeY);
		cellToDivide.upperRight = new QuadTreeCell<E>(rightCenterX, upperCenterY, halfRangeX, halfRangeY);
		cellToDivide.bottomLeft = new QuadTreeCell<E>(leftCenterX, bottomCenterY, halfRangeX, halfRangeY);
		cellToDivide.bottomRight = new QuadTreeCell<E>(rightCenterX, bottomCenterY, halfRangeX, halfRangeY);
		
		for(QuadtreeElement<E> element : cellToDivide.elements)
		{
			if(element.x >= cellToDivide.centerX)
			{
				if(element.y >= cellToDivide.centerY) cellToDivide.upperRight.elements.add(element);
				else cellToDivide.bottomRight.elements.add(element);
			}
			else
			{
				if(element.y >= cellToDivide.centerY) cellToDivide.upperLeft.elements.add(element);
				else cellToDivide.bottomLeft.elements.add(element);
			}
		}
		
		cellToDivide.elements = null;
	}
	
	private String getStringRepresentation(QuadTreeCell<E> cell, int depth)
	{
		if(isEmptyLeaf(cell)) return "";
		
		StringBuffer buffer = new StringBuffer();

		if(cell.upperLeft == null)
		{
			buffer.append("depth = " + depth + "\n");
			buffer.append("size = " + cell.elements.size() + "\n");	
			buffer.append("centerX = " + cell.centerX + "\n");
			buffer.append("centerY = " + cell.centerY + "\n");
			buffer.append("rangeX = " + cell.rangeX + "\n");
			buffer.append("rangeY = " + cell.rangeY + "\n\n");	
		}
		else
		{
			buffer.append(getStringRepresentation(cell.upperLeft, depth+1));
			buffer.append(getStringRepresentation(cell.upperRight, depth+1));
			buffer.append(getStringRepresentation(cell.bottomLeft, depth+1));
			buffer.append(getStringRepresentation(cell.bottomRight, depth+1));	
		}
		
		return buffer.toString();
	}
	
	private boolean isEmptyLeaf(QuadTreeCell<E> cell)
	{
		return (cell.bottomLeft == null && cell.elements.isEmpty());
	}
	
	public boolean contains(E element)
	{
		return contains(root, element);	
	}
	
	private boolean contains(QuadTreeCell<E> cell, E element)
	{
		if(cell.bottomLeft == null)
		{
			for(QuadtreeElement<E> e : cell.elements)
			{
				if(element.equals(e.value)) return true;
			}
			
			return false;
		}
		
		return contains(cell.bottomLeft, element) || contains(cell.bottomRight, element) || contains(cell.upperLeft, element) || contains(cell.upperRight, element);	
	}
	
	public boolean contains(E element, float posX, float posY)
	{
		QuadTreeCell<E> currentCell = root;
		
		while(true)
		{
			if(currentCell.upperLeft == null) break;
			
			if(posX >= currentCell.centerX)
			{
				currentCell = (posY >= currentCell.centerY ? currentCell.upperRight : currentCell.bottomRight);
			}
			else
			{
				currentCell = (posY >= currentCell.centerY ? currentCell.upperLeft : currentCell.bottomLeft);
			}
		}
		
		for(QuadtreeElement<E> e : currentCell.elements)
		{
			if(element.equals(e.value)) return true;
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
		buffer.append(getStringRepresentation(root, 0));
		
		return buffer.toString();
	}
}
