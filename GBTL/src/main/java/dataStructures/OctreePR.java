package dataStructures;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OctreePR<E>
{
	private final int cellCapacity;
	private final int maxDepth;
	private final float minX, maxX, minY, maxY, minZ, maxZ;
	
	private OctreeCell root;
	
	public OctreePR(int cellCapacity, int maxDepth, float rangeX, float rangeY, float rangeZ)
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
	
	public OctreePR(int cellCapacity, int maxDepth, float minX, float maxX, float minY, float maxY, float minZ, float maxZ)
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
	
	private class OctreeCell
	{
		private final float centerX, centerY, centerZ, rangeX, rangeY, rangeZ;
		private final int depth;
		private List<OctreeElement> elements = new ArrayList<>(cellCapacity);
		private OctreeCell[] childs;
		
		public OctreeCell(int depth, float centerX, float centerY, float centerZ, float rangeX, float rangeY, float rangeZ)
		{
			this.depth = depth;
			this.centerX = centerX;
			this.centerY = centerY;
			this.centerZ = centerZ;
			this.rangeX = rangeX;
			this.rangeY = rangeY;
			this.rangeZ = rangeZ;
		}
	}
	
	private class OctreeElement
	{
		private final E value;
		private final float x, y, z;
		
		public OctreeElement(E value, float x, float y, float z)
		{
			this.value = value;
			this.x = x;
			this.y = y;
			this.z = z;
		}
		
		@Override
		public String toString()
		{
			return "x="+x+" y="+y+" "+z+" "+value.toString();
		}
	}

	public boolean add(E valueToAdd, float x, float y, float z)
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
					currentCell = (z >= currentCell.centerZ ? currentCell.childs[0] : currentCell.childs[1]);	
				}
				else
				{
					currentCell = (z >= currentCell.centerZ ? currentCell.childs[2] : currentCell.childs[3]);	
				}				
			}
			else
			{
				if(y >= currentCell.centerY)
				{
					currentCell = (z >= currentCell.centerZ ? currentCell.childs[4] : currentCell.childs[5]);	
				}
				else
				{
					currentCell = (z >= currentCell.centerZ ? currentCell.childs[6] : currentCell.childs[7]);	
				}				
			}
		}

		addRecursive(currentCell, currentCell.depth, valueToAdd, x, y, z);		

		return true;
	}

	private void addRecursive(OctreeCell cell, int depth, E valueToAdd, float x, float y, float z)
	{
		OctreeCell currentCell = cell;
		
		if(currentCell.elements.size() == cellCapacity && depth != maxDepth)
		{
			divideCell(currentCell);

			if(x >= currentCell.centerX)
			{
				if(y >= currentCell.centerY)
				{
					currentCell = (z >= currentCell.centerZ ? currentCell.childs[0] : currentCell.childs[1]);	
				}
				else
				{
					currentCell = (z >= currentCell.centerZ ? currentCell.childs[2] : currentCell.childs[3]);	
				}				
			}
			else
			{
				if(y >= currentCell.centerY)
				{
					currentCell = (z >= currentCell.centerZ ? currentCell.childs[4] : currentCell.childs[5]);	
				}
				else
				{
					currentCell = (z >= currentCell.centerZ ? currentCell.childs[6] : currentCell.childs[7]);	
				}				
			}

			addRecursive(currentCell, depth+1, valueToAdd, x, y, z);
		}		
		else currentCell.elements.add(new OctreeElement(valueToAdd, x, y, z));
	}
	
	private void divideCell(OctreeCell cellToDivide)
	{
		float halfRangeX = cellToDivide.rangeX/2;
		float halfRangeY = cellToDivide.rangeY/2;
		float halfRangeZ = cellToDivide.rangeZ/2;
		float leftCenterX = cellToDivide.centerX-halfRangeX;
		float rightCenterX = cellToDivide.centerX+halfRangeX;
		float upperCenterY = cellToDivide.centerY+halfRangeY;
		float bottomCenterY = cellToDivide.centerY-halfRangeY;
		float frontCenterZ = cellToDivide.centerZ+halfRangeZ;
		float rearCenterZ = cellToDivide.centerZ-halfRangeZ;	
		int childsDepth = cellToDivide.depth + 1;
		
		cellToDivide.childs = (OctreePR<E>.OctreeCell[]) Array.newInstance(OctreeCell.class, 8);
		cellToDivide.childs[0] = new OctreeCell(childsDepth, rightCenterX, upperCenterY, frontCenterZ, halfRangeX, halfRangeY, halfRangeZ);
		cellToDivide.childs[1] = new OctreeCell(childsDepth, rightCenterX, upperCenterY, rearCenterZ, halfRangeX, halfRangeY, halfRangeZ);
		cellToDivide.childs[2] = new OctreeCell(childsDepth, rightCenterX, bottomCenterY, frontCenterZ, halfRangeX, halfRangeY, halfRangeZ);
		cellToDivide.childs[3] = new OctreeCell(childsDepth, rightCenterX, bottomCenterY, rearCenterZ, halfRangeX, halfRangeY, halfRangeZ);
		
		cellToDivide.childs[4] = new OctreeCell(childsDepth, leftCenterX, upperCenterY, frontCenterZ, halfRangeX, halfRangeY, halfRangeZ);
		cellToDivide.childs[5] = new OctreeCell(childsDepth, leftCenterX, upperCenterY, rearCenterZ, halfRangeX, halfRangeY, halfRangeZ);
		cellToDivide.childs[6] = new OctreeCell(childsDepth, leftCenterX, bottomCenterY, frontCenterZ, halfRangeX, halfRangeY, halfRangeZ);
		cellToDivide.childs[7] = new OctreeCell(childsDepth, leftCenterX, bottomCenterY, rearCenterZ, halfRangeX, halfRangeY, halfRangeZ);
		
		for(OctreeElement element : cellToDivide.elements)
		{
			if(element.x >= cellToDivide.centerX)
			{
				if(element.y >= cellToDivide.centerY)
				{
					cellToDivide.childs[element.z >= cellToDivide.centerZ ? 0 : 1].elements.add(element);
				}
				else
				{
					cellToDivide.childs[element.z >= cellToDivide.centerZ ? 2 : 3].elements.add(element);
				}				
			}
			else
			{
				if(element.y >= cellToDivide.centerY)
				{
					cellToDivide.childs[element.z >= cellToDivide.centerZ ? 4 : 5].elements.add(element);	
				}
				else
				{
					cellToDivide.childs[element.z >= cellToDivide.centerZ ? 6 : 7].elements.add(element);
				}				
			}
		}
		
		cellToDivide.elements = null;
	}
	
	private String getStringRepresentation(OctreeCell cell, int depth)
	{
		if(isEmptyLeaf(cell)) return "";
		
		StringBuffer buffer = new StringBuffer();

		if(cell.childs == null)
		{
			buffer.append("depth = " + depth + "\n");
			buffer.append("size = " + cell.elements.size() + "\n");	
			buffer.append("center = ("+cell.centerX+" "+cell.centerY+" "+cell.centerZ+")\n");
			buffer.append("range = ("+cell.rangeX+" "+cell.rangeY+" "+cell.rangeZ+")\n");	
		}
		else
		{
			for(OctreeCell c : cell.childs)
			{
				buffer.append(getStringRepresentation(c, depth+1));
			}
		}
		
		return buffer.toString();
	}
	
	private boolean isEmptyLeaf(OctreeCell cell)
	{
		return (cell.childs == null && cell.elements.isEmpty());
	}
	
	public boolean contains(E element)
	{
		return contains(root, element);	
	}
	
	private boolean contains(OctreeCell cell, E element)
	{
		if(cell.childs == null)
		{
			for(OctreeElement e : cell.elements)
			{
				if(element.equals(e.value)) return true;
			}
			
			return false;
		}
		
		for(OctreeCell child : cell.childs)
		{
			if(contains(child, element)) return true;
		}
		return false;
	}
	
	public boolean contains(E element, float x, float y, float z)
	{
		OctreeCell cell = getCell(x, y, z);
		
		for(OctreeElement e : cell.elements)
		{
			if(element.equals(e.value)) return true;
		}
		
		return false;
	}
	
	private OctreeCell getCell(float x, float y, float z)
	{
		OctreeCell currentCell = root;
		
		while(true)
		{
			if(currentCell.childs == null) break;
			
			if(x >= currentCell.centerX)
			{
				if(y >= currentCell.centerY)
				{
					currentCell = (z >= currentCell.centerZ ? currentCell.childs[0] : currentCell.childs[1]);	
				}
				else
				{
					currentCell = (z >= currentCell.centerZ ? currentCell.childs[2] : currentCell.childs[3]);	
				}				
			}
			else
			{
				if(y >= currentCell.centerY)
				{
					currentCell = (z >= currentCell.centerZ ? currentCell.childs[4] : currentCell.childs[5]);	
				}
				else
				{
					currentCell = (z >= currentCell.centerZ ? currentCell.childs[6] : currentCell.childs[7]);	
				}				
			}
		}
		
		return currentCell;
	}
	
	public boolean remove(E element)
	{
		return false;
	}
	
	public boolean remove(E element, float x, float y, float z)
	{
		return remove(root, element, x, y, z);
	}

	private boolean remove(OctreeCell cell, E element, float x, float y, float z)
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
		for(OctreeCell c : cell.childs)
		{
			if(c.elements == null) return;
		}

		int size = 0;
		for(OctreeCell c : cell.childs)
		{
			size += c.elements.size();
		}

		if(size != cellCapacity) return;
		
		cell.elements = new ArrayList<>(cellCapacity);
		for(OctreeCell c : cell.childs)
		{
			cell.elements.addAll(c.elements);
		}

		cell.childs = null;
	}
	
	private boolean removeElementFromCell(OctreeCell cell, E element)
	{
		Iterator<OctreeElement> iterator = cell.elements.iterator();
			
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
