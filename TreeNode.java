/*
 * Class: CMSC204
 * Instructor: Khandan Monshi
 * Description: Create a generic TreeNode class.
 * Due: 04/20/24
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 * Print your Name here: _Kevin Villegas_
 */
public class TreeNode<T> {
	private T data;
	private TreeNode<T> leftChild;
	private TreeNode<T> rightChild;
	/**
	 * Constructor - Create a new TreeNode with left and right child set to null and data set to the dataNode
	 * @param dataNode - the data to be stored in the TreeNode
	 */
	public TreeNode(T dataNode)
	{
		this.data = dataNode;
		this.leftChild = null;
		this.rightChild = null;
	}
	/**
	 * Constructor - used for making deep copies
	 * @param node - node to make copy of
	 */
	public TreeNode(TreeNode<T> node)
	{
		this.data = node.getData();
		if (node.getLeftChild() != null)
		{
			this.leftChild = new TreeNode<T>(node.getLeftChild());
		}
		if (node.getRightChild() != null)
		{
			this.rightChild = new TreeNode<T>(node.getRightChild());
		}
	}
	/**
	 * Return the data within this TreeNode
	 * @return the data within the TreeNode
	 */
	public T getData()
	{
		return this.data;
	}
	/**
	 * set method for leftChild
	 * @param leftChild - leftChild of the TreeNode
	 */
	public void setLeftChild(TreeNode<T> leftChild)
	{
		this.leftChild = leftChild;
	}
	/**
	 * set method for rightChild
	 * @param rightChild - rightChild of the TreeNode
	 */
	public void setRightChild(TreeNode<T> rightChild)
	{
		this.rightChild = rightChild;
	}
	/**
	 * get method for leftChild
	 * @return the leftChild of the TreeNode
	 */
	public TreeNode<T> getLeftChild()
	{
		return this.leftChild;
	}
	/**
	 * get method for rightChild
	 * @return the rightChild of the TreeNode
	 */
	public TreeNode<T> getRightChild()
	{
		return this.rightChild;
	}
}
