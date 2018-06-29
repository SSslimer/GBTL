package dataStructures;

import exceptions.EmptyDataStructureException;

public class BinarySearchTree
{
	private BinaryTreeNode root;
	
	public BinarySearchTree() {}
	
	public BinarySearchTree(int rootValue)
	{
		root = new BinaryTreeNode(rootValue);
	}
	
	private class BinaryTreeNode
	{
		private int value;

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
	
	public int[] toSortedArray()
	{
		return toSortedArray(root);
	}
	
	private int[] toSortedArray(BinaryTreeNode root)
	{
		if(root == null) return new int[0];
			
		if(root.left == null)
		{
			if(root.right == null)
			{
				int[] array = {root.value};
				return array;
			}
			else
			{
				int[] rightSubTree = toSortedArray(root.right);
				int[] array = new int[1 + rightSubTree.length];
				int[] tmp = {root.value};
				System.arraycopy(tmp, 0, array, 0, 1);
				System.arraycopy(rightSubTree, 0, array, 1, rightSubTree.length);
				
				return array;
			}
		}
		else
		{
			if(root.right == null)
			{
				int[] leftSubTree = toSortedArray(root.left);
				int[] array = new int[1 + leftSubTree.length];
				int[] tmp = {root.value};
				System.arraycopy(leftSubTree, 0, array, 0, leftSubTree.length);
				System.arraycopy(tmp, 0, array, leftSubTree.length, 1);
				return array;
			}
			else
			{
				int[] leftSubTree = toSortedArray(root.left);
				int[] rightSubTree = toSortedArray(root.right);
				int[] array = new int[1 + leftSubTree.length + rightSubTree.length];
				System.arraycopy(leftSubTree, 0, array, 0, leftSubTree.length);
				int[] tmp = {root.value};
				System.arraycopy(tmp, 0, array, leftSubTree.length, 1);
				System.arraycopy(rightSubTree, 0, array, leftSubTree.length+1, rightSubTree.length);
				return array;
			}
		}
	}
	
	public int getSize()
	{
		if(isEmpty()) return 0;
		else return 1 + getSize(root.left) + getSize(root.right);
	}
	
	private int getSize(BinaryTreeNode root)
	{
		if(root == null) return 0;
		
		return 1 + getSize(root.left) + getSize(root.right);
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

		if(root.value == value)
		{
			if(root.right != null) root = root.right;
			else root = null;
			
			return true;
		}
			
		BinaryTreeNode parentOfNodeToRemove = root;
		boolean left = true;
			
		while(true)
		{
			if(value < parentOfNodeToRemove.value)
			{
				if(parentOfNodeToRemove.left == null) return false;				
				else if(parentOfNodeToRemove.left.value == value)
				{
					left = true;
					break;
				}
				else parentOfNodeToRemove = parentOfNodeToRemove.left;  
			}
			else if(value > parentOfNodeToRemove.value)
			{
				if(parentOfNodeToRemove.right == null) return false;				
				else if(parentOfNodeToRemove.right.value == value)
				{
					left = false;
					break;
				}
				else parentOfNodeToRemove = parentOfNodeToRemove.right;
			}
		}
			
		if(left)
		{
			if(parentOfNodeToRemove.left.getNumberOfChildren() == 2)
			{
				BinaryTreeNode inorderSuccessorParent = getInorderSuccessorParent(parentOfNodeToRemove.left.right);
					
				if(inorderSuccessorParent.left.right != null)
				{
					inorderSuccessorParent.left = inorderSuccessorParent.left.right;
				}
					
				parentOfNodeToRemove.left.value = inorderSuccessorParent.left.value;
				
			}
			else if(parentOfNodeToRemove.left.getNumberOfChildren() == 1)
			{
				parentOfNodeToRemove.left = (parentOfNodeToRemove.left.left == null ? parentOfNodeToRemove.left.right : parentOfNodeToRemove.left.left);
			}
			else
			{
				parentOfNodeToRemove.left = null;
			}
		}
		else
		{
			if(parentOfNodeToRemove.right.getNumberOfChildren() == 2)
			{
				BinaryTreeNode inorderSuccessorParent = getInorderSuccessorParent(parentOfNodeToRemove.right.right);
					
				if(inorderSuccessorParent.left.right != null)
				{
					inorderSuccessorParent.left = inorderSuccessorParent.left.right;
				}
					
				parentOfNodeToRemove.right.value = inorderSuccessorParent.left.value;
					
			}
			else if(parentOfNodeToRemove.right.getNumberOfChildren() == 1)
			{
				parentOfNodeToRemove.right = (parentOfNodeToRemove.right.left == null ? parentOfNodeToRemove.right.right : parentOfNodeToRemove.right.left);
			}
			else
			{
				parentOfNodeToRemove.right = null;
			}
		}
			
		return true;
	}
	
	private BinaryTreeNode getInorderSuccessorParent(BinaryTreeNode root)
	{
		if(root == null) return null;
		
		BinaryTreeNode currentNode = root;
		
		while(true)
		{
			if(currentNode.left == null) return currentNode;
			else currentNode = currentNode.left;
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
		if(root == null) throw new EmptyDataStructureException("No max value, tree is empty");
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
		if(root == null) throw new EmptyDataStructureException("No min value, tree is empty");
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
	
	public boolean isEmpty()
	{
		return root == null;
	}
}
