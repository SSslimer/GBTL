package dataStructures;

import exceptions.EmptyDataStructureException;

public class BinaryTree
{
	private BinaryTreeNode root;
	
	public BinaryTree() {}
	
	public BinaryTree(int rootValue)
	{
		root = new BinaryTreeNode(rootValue);
	}
	
	private class BinaryTreeNode
	{
		private final int value;

		private BinaryTreeNode left;
		private BinaryTreeNode right;

		public BinaryTreeNode(int value)
		{
			this.value = value;
		}
		
		public int getNumberOfChildren()
		{
			if(left == null && right == null) return 0;
			else if(left == null && right != null || left != null && right == null) return 1;
			else return 2;
		}
	}
	
	public void add(int valueToAdd)
	{
		if(root == null) root = new BinaryTreeNode(valueToAdd);
		else
		{
			BinaryTreeNode currentNode = root;

			while(true)
			{
				if(currentNode.value > valueToAdd)
				{					
					if(currentNode.left == null)
					{
						currentNode.left = new BinaryTreeNode(valueToAdd);
						return;
					}
					else currentNode = currentNode.left;
				}
				else if(currentNode.value < valueToAdd)
				{
					if(currentNode.right == null)
					{
						currentNode.right = new BinaryTreeNode(valueToAdd);
						return;
					}
					else currentNode = currentNode.right;
				}
				else return;
			}
		}
	}

	public boolean remove(int value)
	{
		if(root == null) return false;
		else
		{
			BinaryTreeNode currentNode = root;
			
			while(true)
			{
				if(currentNode.value == value) break;
				else if(value < currentNode.value)
				{
					if(currentNode.left == null) return false;				
					else if(currentNode.left.value == value)
					{
						if(currentNode.left.getNumberOfChildren() == 2)
						{
							
						}
						else if(currentNode.left.getNumberOfChildren() == 1)
						{
							currentNode.left = (currentNode.left.left == null ? currentNode.left.right : currentNode.left.left);
						}
						else
						{
							currentNode.left = null;
						}
					}
					else currentNode = currentNode.left;  
				}
				else if(value > currentNode.value)
				{
					if(currentNode.right == null) return false;				
					else if(currentNode.right.value == value)
					{
						currentNode.right = null;
					}
					else currentNode = currentNode.right;
				}
			}
			
			return false;
		}
	}
	
	public boolean contains(int value)
	{
		if(root == null) return false;
		else
		{
			BinaryTreeNode currentNode = root;
			
			while(true)
			{
				if(currentNode.value == value) return true;
				else if(value < currentNode.value)
				{
					if(currentNode.left == null) return false;				
					else currentNode = currentNode.left;
					 
				}
				else if(value > currentNode.value)
				{
					if(currentNode.right == null) return false;				
					else currentNode = currentNode.right;
				}
			}
		}
	}

	public int getMax() throws EmptyDataStructureException
	{
		if(root == null) throw new EmptyDataStructureException();
		else
		{
			BinaryTreeNode currentNode = root;
			
			while(true)
			{
				if(currentNode.right == null) return currentNode.value;
				else currentNode = currentNode.right;
			}
		}
	}

	public int getMin() throws EmptyDataStructureException
	{
		if(root == null) throw new EmptyDataStructureException();
		else
		{
			BinaryTreeNode currentNode = root;
			
			while(true)
			{
				if(currentNode.left == null) return currentNode.value;
				else currentNode = currentNode.left;
			}
		}
	}
}
