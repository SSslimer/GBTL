package dataStructures.trees.quadtrees;

import utils.Covering;

public class QuadTreeR
{
	private final int maxDepth;
	private final int minX, maxX, minY, maxY;
	
	private QuadTreeCell root;
	private BelongCriterion criterion;
	
	public QuadTreeR(int maxDepth, int width, int height, BelongCriterion criterion)
	{
		this.maxDepth = maxDepth;
		this.maxX = width/2;
		this.minX = -maxX;
		this.maxY = height/2;
		this.minY = -maxY;
		this.root  = new QuadTreeCell(1, 0, 0, width, height);
		this.criterion = criterion;
	}
	
	public QuadTreeR(int maxDepth, int minX, int maxX, int minY, int maxY, BelongCriterion criterion)
	{
		this.maxDepth = maxDepth;
		this.minX = minX;
		this.maxX = maxX;
		this.minY = minY;
		this.maxY = maxY;
		this.root  = new QuadTreeCell(1, (maxX+minX)/2, (maxY+minY)/2, (maxX-minX)/2, (maxY-minY)/2);
		this.criterion = criterion;
	}
	
	public class QuadTreeCell
	{
		private final int centerX, centerY, rangeX, rangeY;
		private final int depth;
		private boolean value;
		private QuadTreeCell[] childs;
		
		public QuadTreeCell(int depth, int centerX, int centerY, int rangeX, int rangeY)
		{
			this.depth = depth;
			this.centerX = centerX;
			this.centerY = centerY;
			this.rangeX = rangeX;
			this.rangeY = rangeY;
		}

		public boolean isInside(int posX, int posY)
		{
			return posX >= centerX - rangeX && posX <= centerX + rangeX && posY >= centerY - rangeY && posY <= centerY + rangeY;
		}
	}

	public interface BelongCriterion
	{
		public abstract Covering belongsTo(QuadTreeCell cell);
	}
	
	public boolean buildTree()
	{
		return checkCell(root);
	}
	private boolean checkCell(QuadTreeCell cell)
	{
		switch(criterion.belongsTo(cell))
		{
			case INSIDE:
				cell.value = true;
				return true;
				
			case OUTSIDE:
				cell.value = false;
				return true;
				
			case PARTIAL:
				if(cell.depth == maxDepth)
				{
					cell.value = true;
					return true;
				}
							
				divide(cell);
				checkCell(cell.childs[0]);
				checkCell(cell.childs[1]);
				checkCell(cell.childs[2]);
				checkCell(cell.childs[3]);
				return true;
			default:
				return false;
		}
	}
	
	private void divide(QuadTreeCell cell)
	{
		int halfRangeX = cell.rangeX/2;
		int halfRangeY = cell.rangeY/2;
		int leftCenterX = cell.centerX-halfRangeX;
		int rightCenterX = cell.centerX+halfRangeX;
		int upperCenterY = cell.centerY+halfRangeY;
		int bottomCenterY = cell.centerY-halfRangeY;		
		int childsDepth = cell.depth + 1;
		
		cell.childs = new QuadTreeCell[4];
		cell.childs[0] = new QuadTreeCell(childsDepth, leftCenterX, upperCenterY, halfRangeX, halfRangeY);
		cell.childs[1] = new QuadTreeCell(childsDepth, rightCenterX, upperCenterY, halfRangeX, halfRangeY);
		cell.childs[2] = new QuadTreeCell(childsDepth, leftCenterX, bottomCenterY, halfRangeX, halfRangeY);
		cell.childs[3] = new QuadTreeCell(childsDepth, rightCenterX, bottomCenterY, halfRangeX, halfRangeY);
	}
	
	public boolean getValue(int x, int y)
	{
		if(x > maxX || x < minX || y > maxY || y < minY) return false;
		
		return getValue(root, x, y);
	}
	
	private boolean getValue(QuadTreeCell cell, int x, int y)
	{
		if(cell.childs == null) return cell.value;

		if(x > cell.centerX) 
		{
			return getValue((y > cell.centerY ? cell.childs[1] : cell.childs[3]), x, y);
		}
		else
		{
			return getValue((y > cell.centerY ? cell.childs[0] : cell.childs[2]), x, y);
		}
	}
	
	@Override
	public String toString()
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("QuadTree String representation:\n");
		buffer.append("x("+minX+"; "+maxX+")\n");
		buffer.append("y("+minY+"; "+maxY+")\n");
		buffer.append(getStringRepresentation(root));
		
		return buffer.toString();
	}
	
	private String getStringRepresentation(QuadTreeCell cell)
	{
		if(cell == null) return "";
		StringBuffer buffer = new StringBuffer();

		if(cell.childs == null && cell.value)
		{
			buffer.append("depth = " + cell.depth + " ");
			buffer.append("center = (" + cell.centerX + " " + cell.centerY + ") ");
			buffer.append("range = (" + cell.rangeX + " " + cell.rangeY + ") \n");	
		}
		else
		{	
			buffer.append(getStringRepresentation(cell.childs[0]));
			buffer.append(getStringRepresentation(cell.childs[1]));
			buffer.append(getStringRepresentation(cell.childs[2]));
			buffer.append(getStringRepresentation(cell.childs[3]));	
		}
		
		return buffer.toString();
	}
}
