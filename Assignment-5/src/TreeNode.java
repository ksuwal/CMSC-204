public class TreeNode<T> {

	protected T data;	
	protected TreeNode<T> left;	
	protected TreeNode<T> right;
	
	
	/**
	 * Creates a new TreeNode
	 * left and right child set to null
	 * data set to the dataNode
	 * @param dataNode - the data to be stored in the TreeNode
	 */
	public TreeNode (T dataNode) {	

		data = dataNode;
		left = null;
		right = null;
	}
		
	
	/**
	 * for making deep copies
	 * @param node - node to make copy of
	 */
	public TreeNode (TreeNode<T> node) {

		this.data = node.data;
		this.left = node.left;
		this.right = node.right;
	}
	
	
	/**
	 * @return the data within the TreeNode
	 */
	public T getData() {

		return data;

	}

}