package dataStructures;

public class QuadTreeR
{
	private final int maxDepth;
	private final int minX, maxX, minY, maxY;
	
	private QuadTreeCell root;
	private BelongCriterion criterion;
	
	public QuadTreeR(int maxDepth, int width, int height, BelongCriterion criterion)
	{
		this.maxDepth = maxDepth;
		this.minX = -width/2;
		this.maxX = width/2;
		this.minY = -height/2;
		this.maxY = height/2;	
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
		private QuadTreeCell upperLeft, upperRight, bottomLeft, bottomRight;
		
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
	
	public enum Covering
	{
		INSIDE,
		PARTIAL,
		OUTSIDE
	}
	
	public interface BelongCriterion
	{
		public abstract Covering belongsTo(QuadTreeCell cell);
	}
	
	public boolean buildTree()
	{
		return checkCell(root);
	}
	
	public static long a = 0;
	public static long b = 0;
	
	private boolean checkCell(QuadTreeCell cell)
	{
		b++;
		switch(criterion.belongsTo(cell))
		{
			case INSIDE:
				cell.value = true;
				a++;
				return true;
				
			case OUTSIDE:
				cell.value = false;
				return true;
				
			case PARTIAL:
				if(cell.depth == maxDepth)
				{
					cell.value = true;
					a++;
					return true;
				}
							
				divide(cell);
				checkCell(cell.bottomLeft);				
				checkCell(cell.bottomRight);
				checkCell(cell.upperLeft);
				checkCell(cell.upperRight);				
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
		
		cell.upperLeft = new QuadTreeCell(childsDepth, leftCenterX, upperCenterY, halfRangeX, halfRangeY);
		cell.upperRight = new QuadTreeCell(childsDepth, rightCenterX, upperCenterY, halfRangeX, halfRangeY);
		cell.bottomLeft = new QuadTreeCell(childsDepth, leftCenterX, bottomCenterY, halfRangeX, halfRangeY);
		cell.bottomRight = new QuadTreeCell(childsDepth, rightCenterX, bottomCenterY, halfRangeX, halfRangeY);
	}
	
	public boolean getValue(int x, int y)
	{
		if(x > maxX || x < minX || y > maxY || y < minY) return false;
		
		return getValue(root, x, y);
	}
	
	private boolean getValue(QuadTreeCell cell, int x, int y)
	{
		if(cell.bottomLeft == null) return cell.value;

		if(x > cell.centerX) 
		{
			return getValue((y > cell.centerY ? cell.upperRight : cell.bottomRight), x, y);
		}
		else
		{
			return getValue((y > cell.centerY ? cell.upperLeft : cell.bottomLeft), x, y);
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

		if(cell.upperLeft == null && cell.value)
		{
			buffer.append("depth = " + cell.depth + " ");
			buffer.append("center = (" + cell.centerX + " " + cell.centerY + ") ");
			buffer.append("range = (" + cell.rangeX + " " + cell.rangeY + ") \n");	
		}
		else
		{
			buffer.append(getStringRepresentation(cell.upperLeft));
			buffer.append(getStringRepresentation(cell.upperRight));
			buffer.append(getStringRepresentation(cell.bottomLeft));
			buffer.append(getStringRepresentation(cell.bottomRight));	
		}
		
		return buffer.toString();
	}
}
