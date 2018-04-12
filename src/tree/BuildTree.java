package tree;

public class BuildTree {

	/*
		50 (parent)
	   /   \
	 25     75
	/  \    / \
   10  30  60  80
   	 \	
	  15 (leaf)	
	 */

	public static Node buildBinarySearchTree(){

		Node root = new Node(50);

		Node n1 = new Node(25);
		Node n2 = new Node(75);

		Node n3 = new Node(10);
		Node n4 = new Node(30);

		Node n5 = new Node(60);
		Node n6 = new Node(80);


		root.left = n1;
		root.right = n2;

		n1.left = n3;
		n1.right = n4;

		n2.left = n5;
		n2.right = n6;

		n3.right = new Node(15);


		return root;

		/*

	      1
	     /  \
	    2     3
	  /   \   / \
	 4     5 6   7
     \
      9
 */

	}
	
	class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode(int data){
			this.data = data;
		}
		
	}
	
	

	public static Node buildBinaryTree(){

		Node root = new Node(1);

		Node n1 = new Node(2);
		Node n2 = new Node(3);

		Node n3 = new Node(4);
		Node n4 = new Node(5);

		Node n5 = new Node(6);
		Node n6 = new Node(7);


		root.left = n1;
		root.right = n2;

		n1.left = n3;
		n1.right = n4;

		n2.left = n5;
		n2.right = n6;

		n3.right = new Node(9);


		return root;

		/*

	      1
	     /  \
	    2     3
	  /   \   / \
	 4     5 6   7
     \
      9
 */

	}

	public static Node buildBinaryTreeMeetup(){

		Node root = new Node(50);

		Node n1 = new Node(30);
		Node n2 = new Node(70);

		Node n3 = new Node(10);
		Node n4 = new Node(40);

		Node n5 = new Node(60);
		Node n6 = new Node(80);

		Node n7 = new Node(55);
		Node n8 = new Node(60);

		root.left = n1;
		root.right = n2;

		n1.left = n3;
		n1.right = n4;

		n2.left = n5;
		n2.right = n6;

		n5.left = n7;



		return root;

		/*

	    	 1
	     /  \
	    2     3
	  /   \   / \
	 4     5 6   7
 */

	}



}
