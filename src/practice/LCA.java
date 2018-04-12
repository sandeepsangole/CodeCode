package practice;

import tree.BuildTree;
import tree.Node;

public class LCA {

	public static void main(String[] args) {

			LCA obj  = new LCA();
			Node       root = BuildTree.buildBinaryTree();
			obj.inOrder(root);
			System.out.println();
	}
	
	/*

	      1
	     /  \
	    2     3
	  /   \   / \
	 4     5 6   7
     \
      9
 */

	private Node lcaBinaryTree(Node root , Node node1, Node node2){
		
		if(root == null){
			return null;
		}
		
		if(node1 == root || node2 == root){
			return root;
		}

		Node left = lcaBinaryTree(root.left ,node1,node2);
		Node right = lcaBinaryTree(root.right ,node1,node2);
		
		if(left != null & right != null){
			return root;
		}
		
		if(left == null && right == null){
			return null;
		}
		
		return left == null ? right : left;
		
			
	}

	private Node lcaBinarySearchTree(Node root , Node node1, Node node2){
		
		if(root == null){
			return root;
		}
		
		if (root == node1 || root == node2){
			return root;
		}
		
		if (root.data >node1.data && root.data > node2.data){
			return lcaBinarySearchTree(root.left , node1 , node2);
		} else if(root.data < node1.data && root.data < node2.data){
			return lcaBinarySearchTree(root.right , node1 , node2);
		} 
		
		return root;
		
	}
	
	private boolean isBST(Node root){
		
		if(root == null){
			return true;
		}
		
		return isBSTUtil(root , Integer.MIN_VALUE , Integer.MAX_VALUE);
	}


	private boolean isBSTUtil(Node root , int min , int max){

		if(root == null){
			return true;
		}
		
		if (root.data < min || root.data > max){
			return false;
		}
		return isBSTUtil(root.left , min , root.data) &&
				isBSTUtil(root.right , root.data , max);
		


	}
	
	// 4 9 2 5 1 6 3 7
	private void inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}
	}
	
	
}
