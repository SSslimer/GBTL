package dataStructures.trees.octrees;

class OctreeElement<E>
{
	final E value;
	final long x, y, z;
	
	OctreeElement(E value, long x, long y, long z)
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
