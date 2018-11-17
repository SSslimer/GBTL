package dataStructures.trees.octrees;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import dataStructures.trees.Criterion;
import dataStructures.trees.TreeCell;

public class OctreePR<E>
{
	private final int cellCapacity;
	private final int maxDepth;
	private final long minX, maxX, minY, maxY, minZ, maxZ;
	
	private OctreeCell root;
	
	public OctreePR(int cellCapacity, int maxDepth, long rangeX, long rangeY, long rangeZ)
	{
		this.cellCapacity = cellCapacity;
		this.maxDepth = maxDepth;
		this.minX = -rangeX;
		this.maxX = rangeX;
		this.minY = -rangeY;
		this.maxY = rangeY;
		this.minZ = -rangeZ;
		this.maxZ = rangeZ;	
		root  = new OctreeCell(1, 0, 0, 0, rangeX, rangeY, rangeZ);
	}
	
	public OctreePR(int cellCapacity, int maxDepth, long minX, long maxX, long minY, long maxY, long minZ, long maxZ)
	{
		this.cellCapacity= cellCapacity;
		this.maxDepth = maxDepth;
		this.minX = minX;
		this.maxX = maxX;
		this.minY = minY;
		this.maxY = maxY;
		this.minZ = minZ;
		this.maxZ = maxZ;
		root  = new OctreeCell(1, (maxX-minX)/2, (maxY-minY)/2, (maxZ-minZ)/2, maxX-minX, maxY-minY, maxZ-minZ);
	}

	public class OctreeCell implements TreeCell<E>
	{
		private final long centerX, centerY, centerZ, rangeX, rangeY, rangeZ;
		private final int depth;
		private List<OctreeElement<E>> elements = new ArrayList<>(cellCapacity);
		private OctreeCell[] children;
		
		public OctreeCell(int depth, long centerX, long centerY, long centerZ, long rangeX, long rangeY, long rangeZ)
		{
			this.depth = depth;
			this.centerX = centerX;
			this.centerY = centerY;
			this.centerZ = centerZ;
			this.rangeX = rangeX;
			this.rangeY = rangeY;
			this.rangeZ = rangeZ;
		}
		
		public long[] getCenterPos()
		{
			long[] pos = {centerX, centerY, centerZ}; 
			return pos;
		}
		
		public long getRangeX()
		{
			return rangeX;
		}

		public long getRangeY()
		{
			return rangeY;
		}

		public long getRangeZ()
		{
			return rangeZ;
		}

		public long[] getCornerPos()
		{
			long centerXP = centerX+rangeX;
			long centerXM = centerX-rangeX;
			long centerYP = centerY+rangeY;
			long centerYM = centerY-rangeY;
			long centerZP = centerZ+rangeZ;
			long centerZM = centerZ-rangeZ;
			
			long[] pos = {centerXP, centerYP, centerZP,														
						  centerXP, centerYP, centerZM,
						  centerXP, centerYM, centerZP,
						  centerXP, centerYM, centerZM,
						  centerXM, centerYP, centerZP,
						  centerXM, centerYP, centerZM,
						  centerXM, centerYM, centerZP,
						  centerXM, centerYM, centerZM};
			
			return pos;
		}
	}

	public boolean add(E valueToAdd, long x, long y, long z)
	{
		if(x < minX || x > maxX || y < minY || y > maxY || z < minZ || z > maxZ) return false;
		
		OctreeCell currentCell = getCell(x, y, z);
		
		if(currentCell.elements.size() == cellCapacity && currentCell.depth != maxDepth)
		{
			divideCell(currentCell);

			if(x >= currentCell.centerX)
			{
				if(y >= currentCell.centerY)
				{
					currentCell = (z >= currentCell.centerZ ? currentCell.children[0] : currentCell.children[1]);	
				}
				else
				{
					currentCell = (z >= currentCell.centerZ ? currentCell.children[2] : currentCell.children[3]);	
				}				
			}
			else
			{
				if(y >= currentCell.centerY)
				{
					currentCell = (z >= currentCell.centerZ ? currentCell.children[4] : currentCell.children[5]);	
				}
				else
				{
					currentCell = (z >= currentCell.centerZ ? currentCell.children[6] : currentCell.children[7]);	
				}				
			}
		}

		addRecursive(currentCell, currentCell.depth, valueToAdd, x, y, z);		

		return true;
	}

	private void addRecursive(OctreeCell cell, int depth, E valueToAdd, long x, long y, long z)
	{
		OctreeCell currentCell = cell;
		
		if(currentCell.elements.size() == cellCapacity && depth != maxDepth)
		{
			divideCell(currentCell);

			if(x >= currentCell.centerX)
			{
				if(y >= currentCell.centerY)
				{
					currentCell = (z >= currentCell.centerZ ? currentCell.children[0] : currentCell.children[1]);	
				}
				else
				{
					currentCell = (z >= currentCell.centerZ ? currentCell.children[2] : currentCell.children[3]);	
				}				
			}
			else
			{
				if(y >= currentCell.centerY)
				{
					currentCell = (z >= currentCell.centerZ ? currentCell.children[4] : currentCell.children[5]);	
				}
				else
				{
					currentCell = (z >= currentCell.centerZ ? currentCell.children[6] : currentCell.children[7]);	
				}				
			}

			addRecursive(currentCell, depth+1, valueToAdd, x, y, z);
		}		
		else currentCell.elements.add(new OctreeElement<E>(valueToAdd, x, y, z));
	}
	
	@SuppressWarnings("unchecked")
	private void divideCell(OctreeCell cellToDivide)
	{
		long halfRangeX = cellToDivide.rangeX/2;
		long halfRangeY = cellToDivide.rangeY/2;
		long halfRangeZ = cellToDivide.rangeZ/2;
		long leftCenterX = cellToDivide.centerX-halfRangeX;
		long rightCenterX = cellToDivide.centerX+halfRangeX;
		long upperCenterY = cellToDivide.centerY+halfRangeY;
		long bottomCenterY = cellToDivide.centerY-halfRangeY;
		long frontCenterZ = cellToDivide.centerZ+halfRangeZ;
		long rearCenterZ = cellToDivide.centerZ-halfRangeZ;	
		int childsDepth = cellToDivide.depth + 1;
		
		cellToDivide.children = (OctreePR<E>.OctreeCell[]) Array.newInstance(OctreeCell.class, 8);
		cellToDivide.children[0] = new OctreeCell(childsDepth, rightCenterX, upperCenterY, frontCenterZ, halfRangeX, halfRangeY, halfRangeZ);
		cellToDivide.children[1] = new OctreeCell(childsDepth, rightCenterX, upperCenterY, rearCenterZ, halfRangeX, halfRangeY, halfRangeZ);
		cellToDivide.children[2] = new OctreeCell(childsDepth, rightCenterX, bottomCenterY, frontCenterZ, halfRangeX, halfRangeY, halfRangeZ);
		cellToDivide.children[3] = new OctreeCell(childsDepth, rightCenterX, bottomCenterY, rearCenterZ, halfRangeX, halfRangeY, halfRangeZ);
		
		cellToDivide.children[4] = new OctreeCell(childsDepth, leftCenterX, upperCenterY, frontCenterZ, halfRangeX, halfRangeY, halfRangeZ);
		cellToDivide.children[5] = new OctreeCell(childsDepth, leftCenterX, upperCenterY, rearCenterZ, halfRangeX, halfRangeY, halfRangeZ);
		cellToDivide.children[6] = new OctreeCell(childsDepth, leftCenterX, bottomCenterY, frontCenterZ, halfRangeX, halfRangeY, halfRangeZ);
		cellToDivide.children[7] = new OctreeCell(childsDepth, leftCenterX, bottomCenterY, rearCenterZ, halfRangeX, halfRangeY, halfRangeZ);
		
		for(OctreeElement<E> element : cellToDivide.elements)
		{
			if(element.x >= cellToDivide.centerX)
			{
				if(element.y >= cellToDivide.centerY)
				{
					cellToDivide.children[element.z >= cellToDivide.centerZ ? 0 : 1].elements.add(element);
				}
				else
				{
					cellToDivide.children[element.z >= cellToDivide.centerZ ? 2 : 3].elements.add(element);
				}				
			}
			else
			{
				if(element.y >= cellToDivide.centerY)
				{
					cellToDivide.children[element.z >= cellToDivide.centerZ ? 4 : 5].elements.add(element);	
				}
				else
				{
					cellToDivide.children[element.z >= cellToDivide.centerZ ? 6 : 7].elements.add(element);
				}				
			}
		}
		
		cellToDivide.elements = null;
	}
	
	private String getStringRepresentation(OctreeCell cell, int depth)
	{
		if(isEmptyLeaf(cell)) return "";
		
		StringBuffer buffer = new StringBuffer();

		if(cell.children == null)
		{
			buffer.append("depth = " + depth + "\n");
			buffer.append("size = " + cell.elements.size() + "\n");	
			buffer.append("center = ("+cell.centerX+" "+cell.centerY+" "+cell.centerZ+")\n");
			buffer.append("range = ("+cell.rangeX+" "+cell.rangeY+" "+cell.rangeZ+")\n");	
		}
		else
		{
			for(OctreeCell c : cell.children)
			{
				buffer.append(getStringRepresentation(c, depth+1));
			}
		}
		
		return buffer.toString();
	}
	
	private boolean isEmptyLeaf(OctreeCell cell)
	{
		return (cell.children == null && cell.elements.isEmpty());
	}
	
	public boolean contains(E element)
	{
		return contains(root, element);	
	}
	
	private boolean contains(OctreeCell cell, E element)
	{
		if(cell.children == null)
		{
			for(OctreeElement<E> e : cell.elements)
			{
				if(e.value.equals(element)) return true;
			}
		}
		else
		{
			for(OctreeCell child : cell.children)
			{
				if(contains(child, element)) return true;
			}
		}

		return false;
	}
	
	public boolean contains(E element, long x, long y, long z)
	{
		OctreeCell cell = getCell(x, y, z);
		
		for(OctreeElement<E> e : cell.elements)
		{
			if(element.equals(e.value)) return true;
		}
		
		return false;
	}
	
	private OctreeCell getCell(long x, long y, long z)
	{
		OctreeCell currentCell = root;
		
		while(true)
		{
			if(currentCell.children == null) break;
			
			if(x >= currentCell.centerX)
			{
				if(y >= currentCell.centerY)
				{
					currentCell = (z >= currentCell.centerZ ? currentCell.children[0] : currentCell.children[1]);	
				}
				else
				{
					currentCell = (z >= currentCell.centerZ ? currentCell.children[2] : currentCell.children[3]);	
				}				
			}
			else
			{
				if(y >= currentCell.centerY)
				{
					currentCell = (z >= currentCell.centerZ ? currentCell.children[4] : currentCell.children[5]);	
				}
				else
				{
					currentCell = (z >= currentCell.centerZ ? currentCell.children[6] : currentCell.children[7]);	
				}				
			}
		}
		
		return currentCell;
	}
	
	public boolean remove(E element)
	{	
		return remove(element, root);
	}
	
	public boolean remove(E element, OctreeCell cell)
	{
		if(cell.children == null)
		{
			Iterator<OctreeElement<E>> iterator = cell.elements.iterator();
			
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
			for(OctreeCell child : cell.children)
			{
				if(remove(element, child)) return true;
			}
		}
		
		return false;
	}
	
	public boolean remove(E element, long x, long y, long z)
	{
		return remove(root, element, x, y, z);
	}

	private boolean remove(OctreeCell cell, E element, long x, long y, long z)
	{
		if(cell.elements != null) return removeElementFromCell(cell, element);

		OctreeCell cellInPos = getCell(x, y, z);

		if(remove(cellInPos, element, x, y, z))
		{ 
			mergeCellsIfNeeded(cell);
			
			return true;
		}
		
		return false;
	}

	private void mergeCellsIfNeeded(OctreeCell cell)
	{
		for(OctreeCell c : cell.children)
		{
			if(c.elements == null) return;
		}

		int size = 0;
		for(OctreeCell c : cell.children)
		{
			size += c.elements.size();
		}

		if(size != cellCapacity) return;
		
		cell.elements = new ArrayList<>(cellCapacity);
		for(OctreeCell c : cell.children)
		{
			cell.elements.addAll(c.elements);
		}

		cell.children = null;
	}

	public List<E> getElements(Criterion criterion)
	{
		return getElements(criterion, root);
	}
	
	private List<E> getElements(Criterion criterion, OctreeCell cell)
	{
		List<E> elements = new ArrayList<E>();

		switch(criterion.belongs(cell))
		{			
			case OUTSIDE: return Collections.emptyList();		
			case INSIDE:		
				if(cell.children == null)
				{
					for(OctreeElement<E> e : cell.elements)
					{
						elements.add(e.value);
					}
				}
				else
				{
					for(OctreeCell c : cell.children)
					{
						if((c.elements == null || c.elements.isEmpty()) && c.children == null) continue;
						elements.addAll(getElements(c));
					}
				}
				return elements;
				
			case PARTIAL: 
				if(cell.children == null)
				{
					/** TODO, add second criterion */
					for(OctreeElement<E> e : cell.elements)
					{
						elements.add(e.value);
					}
				}
				else
				{
					for(OctreeCell c : cell.children)
					{
						if((c.elements == null || c.elements.isEmpty()) && c.children == null) continue;
						elements.addAll(getElements(criterion, c));
					}
				}
				return elements;
			default: return Collections.emptyList();
		}	
	}
	
	private List<E> getElements(OctreeCell cell)
	{
		List<E> elements = new ArrayList<E>();
		
		if(cell.children == null)
		{
			for(OctreeElement<E> e : cell.elements)
			{
				elements.add(e.value);
			}	
		}
		else
		{
			for(OctreeCell c : cell.children)
			{
				if((c.elements == null || c.elements.isEmpty()) && c.children == null) continue;
				elements.addAll(getElements(c));
			}
		}

		return elements;
	}

	private boolean removeElementFromCell(OctreeCell cell, E element)
	{
		Iterator<OctreeElement<E>> iterator = cell.elements.iterator();
			
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
		buffer.append("Max y = " + maxY + "\n");
		buffer.append("Min z = " + minZ + "\n");
		buffer.append("Max z = " + maxZ + "\n\n");
		buffer.append(getStringRepresentation(root, 1));
		
		return buffer.toString();
	}
}
