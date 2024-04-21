import java.util.ArrayList;
/*
 * Class: CMSC204
 * Instructor: Khandan Monshi
 * Description: Create a generic MorseCodeTree class.
 * Due: 04/20/24
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 * Print your Name here: _Kevin Villegas_
 */
public class MorseCodeTree<T> implements LinkedConverterTreeInterface<T>{
	private TreeNode<T> root;
	/**
	 * Constructor - calls the buildTree method
	 */
	public MorseCodeTree()
	{
		buildTree();
	}
	/**
	 * Returns a reference to the root
	 * @return reference to root
	 */
	public TreeNode<T> getRoot()
	{
		return this.root;
	}
	/**
	 * sets the root of the Tree
	 * @param newNode a TreeNode<T> that will be the new root
	 */
	public void setRoot(TreeNode<T> newNode)
	{
		this.root = newNode;
	}
	/**
	 * Adds result to the correct position in the tree based on the code
	 * This method will call the recursive method addNode
	 * 
	 * @param code the code for the new node to be added
	 * 
	 */
	public void insert(T code, T result)
	{
		addNode(this.root, code, result);
	}
	/**
	 * This is a recursive method that adds element to the correct position 
	 * in the tree based on the code.
	 * 
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of addNode
	 * @param letter the data of the new TreeNode to be added
	 */
	public void addNode(TreeNode<T> root, T code, T letter)
	{
		if (root == null)
		{
			this.root = new TreeNode<>(letter);
			this.root.setLeftChild(null);
			this.root.setRightChild(null);
		}
		else
		{
			TreeNode<T> current = root;
			for (int index = 0; index < code.toString().length(); index++)
			{
				char way = code.toString().charAt(index);
				if (way == '.')
				{
					if (current.getLeftChild() == null)
					{
						current.setLeftChild(new TreeNode<>(letter));
					}
					current = current.getLeftChild();
				}
				else if (way == '-')
				{
					if (current.getRightChild() == null)
					{
						current.setRightChild(new TreeNode<>(letter));
					}
					current = current.getRightChild();
				}
			}
		}
	}
	/**
	 * Fetch the data in the tree based on the code
	 * This method will call the recursive method fetchNode
	 * 
	 * @param code the code that describes the traversals within the tree
	 * @return the result that corresponds to the code
	 */
	@SuppressWarnings("unchecked")
	public T fetch(String code)
	{
		return fetchNode(this.root, (T)code);
	}
	/**
	 * This is the recursive method that fetches the data of the TreeNode
	 * that corresponds with the code
	 * 
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of fetchNode
	 * @return the data corresponding to the code
	 */
	@SuppressWarnings("unchecked")
	public T fetchNode(TreeNode<T> root, T code)
	{
		if (code.equals(""))
		{
			return root.getData();
		}
		char way = code.toString().charAt(0);
		if (way == '.')
		{
			return fetchNode(root.getLeftChild(), (T)code.toString().substring(1));
		}
		else if (way == '-')
		{
			return fetchNode(root.getRightChild(), (T)code.toString().substring(1));
		}
		else
		{
			return null;
		}
	}
	/**
	 * This operation is not supported for a LinkedConverterTree
	 * @param data data of node to be deleted
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	public LinkedConverterTreeInterface<T> delete(T data) throws UnsupportedOperationException
	{
		throw new UnsupportedOperationException();
	}
	/**
	 * This operation is not supported for a LinkedConverterTree
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	public LinkedConverterTreeInterface<T> update() throws UnsupportedOperationException
	{
		throw new UnsupportedOperationException();
	}
	/**
	 * This method builds the LinkedConverterTree by inserting TreeNodes<T>
	 * into their proper locations
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void buildTree()
	{
		setRoot(null);
		insert((T)"",(T)"");
		insert((T)".",(T)"e");
		insert((T)"-",(T)"t");
		insert((T)"..",(T)"i");
		insert((T)".-",(T)"a");
		insert((T)"-.",(T)"n");
		insert((T)"--",(T)"m");
		insert((T)"...",(T)"s");
		insert((T)"..-",(T)"u");
		insert((T)".-.",(T)"r");
		insert((T)".--",(T)"w");
		insert((T)"-..",(T)"d");
		insert((T)"-.-",(T)"k");
		insert((T)"--.",(T)"g");
		insert((T)"---",(T)"o");
		insert((T)"....",(T)"h");
		insert((T)"...-",(T)"v");
		insert((T)"..-.",(T)"f");
		insert((T)".-..",(T)"l");
		insert((T)".--.",(T)"p");
		insert((T)".---",(T)"j");
		insert((T)"-...",(T)"b");
		insert((T)"-..-",(T)"x");
		insert((T)"-.-.",(T)"c");
		insert((T)"-.--",(T)"y");
		insert((T)"--..",(T)"z");
		insert((T)"--.-",(T)"q");
	}
	/**
	 * Returns an ArrayList of the items in the linked converter Tree in LNR (Inorder) Traversal order
	 * Used for testing to make sure tree is built correctly
	 * @return an ArrayList of the items in the linked Tree
	 */
	public ArrayList<T> toArrayList()
	{
		ArrayList<T> arrayList = new ArrayList<T>();
		LNRoutputTraversal(this.root, arrayList);
		return arrayList;
	}
	/**
	 * The recursive method to put the contents of the linked converter tree in an ArrayList<T> 
	 * LNR (Inorder)
	 * @param root the root of the tree for this particular recursive instance
	 * @param list the ArrayList that will hold the contents of the tree in LNR order
	 */
	public void LNRoutputTraversal(TreeNode<T> root, ArrayList<T> list)
	{
		if (root == null)
		{
			return;
		}
		LNRoutputTraversal(root.getLeftChild(), list);
		if (root.getData() != null)
		{
			list.add(root.getData());
		}
		LNRoutputTraversal(root.getRightChild(), list);
	}
}
