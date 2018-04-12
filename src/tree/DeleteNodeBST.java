package tree;

public class DeleteNodeBST {
	
	public static void main(String[] args) {
		Node root = BuildTree.buildBinarySearchTree();
		preOrder(root);
		System.out.println();
		Node res = deleteNode(root, 10);
		System.out.println();
		preOrder(res);

	}

	/*
	/*
		50
	   /   \
	 25     75
	/  \    / \
   10  30  60  80
   	 \	
	  15	
	 */

	public static Node deleteNode(Node root, int key) {

		if(root == null){
			return root;
		}

		if(key < root.data) {
			root.left = deleteNode(root.left , key);
		}else if(key > root.data){
			root.right = deleteNode(root.right, key);
		} else {
			if(root.left == null) return root.right;
			if(root.right == null) return root.left;

			root.data = findMin(root.right);
			root.right = deleteNode(root.right, root.data);
		}

		return root;

	}
	
	public static Node delete(Node root , int key){
		if(root == null){
			return root;
		}
		
		if(key < root.data){
			root.left = deleteNode(root.left,key);
		} else if(key > root.data){
			root.right = deleteNode(root.right, key);
		} else {
			if(root.left == null) return root.right;
			if(root.right == null) return root.left;
			
			root.data = findMin(root.right);
			root.right = delete(root.right , key);
		}
		return root;
	}

	public static int findMin(Node root){
		while(root.left != null) root = root.left;
		return root.data;
	}

	public static void preOrder(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
}
