import java.util.ArrayList;

/**
 * 
 * @author Kabindra Raj Suwal
 * class used for the conversion of morse code to english.
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String>{

	private TreeNode<String> root;
	
	
	/**
	 * Constructor - calls the buildTree method
	 */
	public MorseCodeTree() {
		buildTree();
	}
	
	
	/**
	 * Returns a reference to the root
	 */
	public TreeNode<String> getRoot(){
		return root;		
	}
	
	
	/**
	 * sets the root of the MorseCodeTree
	 * @param newNode - a copy of newNode will be the new root
	 */
	public void setRoot (TreeNode<String> newNode) {	
		root = newNode;
	}
	
	
	/**
	 * to add element in the tree.
	 * This method will call addNode method
	 * @param code - the code for the new node to be added
	 * @param letter - the letter for the corresponding code
	 * @return the MorseCodeTree with the new node added
	 */
	public MorseCodeTree insert(String code, String letter) {	
		addNode(root,code,letter);
		return this;
	}
	
	
	/**
	 * adds element to the correct position in the tree 
	 * @param root - the root of the tree for this particular recursive instance of addNode
	 * @param code  - the code for this particular recursive instance of addNode
	 * @param letter  - the data of the new TreeNode to be added
	 */
	public void addNode(TreeNode<String> root, String code, String letter) {
		if(code.length() == 1) {
			if(code.charAt(0) == '.') {
				root.left = new TreeNode<String>(letter);
			}else if(code.charAt(0) == '-'){
				root.right = new TreeNode<String>(letter);
			}

		} else {
			if(code.charAt(0) == '.')
				addNode(root.left, code.substring(1),letter);
			else if(code.charAt(0) == '-')
				addNode(root.right, code.substring(1), letter);
		}
	}
	
	
	/**
	 * to fetch the data in the tree
	 * @param code - the code that describes the traversals to retrieve the string (letter)
	 * calls fetchNode
	 */
	public String fetch(String code) {

		return fetchNode(root, code);
	}
	
	
	/**
	 * fetches the data of the TreeNode that corresponds with the code
	 * @param code - the code for this particular recursive instance of addNode
	 * @param root - the root of the tree for this particular recursive instance of addNode
	 */
	public String fetchNode(TreeNode<String> root, String code) {
		
		String letter;
		if(code.length()<=1) {
			if(code.equals("."))
				return root.left.data;
			else
				return root.right.data;

		}
		else {
			if(code.charAt(0) == '.')
				letter = fetchNode(root.left, code.substring(1));
			else 
				letter = fetchNode(root.right, code.substring(1));
		}		
		return letter;
	}
	
	
	public MorseCodeTree delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	
	
	public MorseCodeTree update() throws UnsupportedOperationException {		
		throw new UnsupportedOperationException();
	}
	
	
	/**
	 * to build the MorseCodeTree by inserting the nodes
	 * of the tree level by level based on the code
	 */
	public void buildTree() {
		root = new TreeNode<String>("");
		
		insert(".", "e");
		insert("-", "t");

		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");

		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");

		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
	}

	
	/**
	 * @return an ArrayList of the items in the linked Tree
	 */
	public ArrayList<String> toArrayList() {
		
		ArrayList<String> toArray = new ArrayList<String>();
		LNRoutputTraversal(root, toArray);	
		
		return toArray;
		
	}
	
	
	/**
	 * to put the contents of the tree in an ArrayList in LNR (Inorder)
	 * @param root - the root of the tree for this particular recursive instance
	 * @param list - the ArrayList that will hold the contents of the tree
	 */
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		
		if(root.left != null)
			LNRoutputTraversal(root.left,list);
		list.add(root.data);
		if(root.right != null)
			LNRoutputTraversal(root.right,list);
	}


}