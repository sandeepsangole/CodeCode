package tree;

import org.omg.CORBA.INTERNAL;

import java.util.*;

public class Tree {

	public static final String SPLITTER = (",");
	public static final String REPLACE_NULL = ("#");

	public static void main(String[] args) {
		Node root = BuildTree.buildBinaryTree();

/*		Tree t = new Tree();
		StringBuilder sb = new StringBuilder();
		//1. Serialize
		t.serialize(root, sb);

		t.preOder(root);
		System.out.println();
		System.out.println(sb.toString());

		//2. Derialize
		Node root1 = t.deserialize(sb.toString());
		System.out.println();
		t.preOder(root1);

		//3. Flatten BT
		t.flattenBT(root);
		t.preOder(root);*/

		Tree t = new Tree();
		Node root1 = BuildTree.buildBinaryTreeMeetup();
		t.inOrder(root1);
		Node res = t.findNext(root1,new Node(40));
		System.out.println();
		System.out.println(res.data);

		System.out.println(t.isBST(root1));

	}

/*
           50
        /      \
       30      70
      /  \    /  \
     10  40  60  80

 */

	public void inOrder(Node root){
		if(root != null){
			inOrder(root.left);
			System.out.print(root.data +" ");
			inOrder(root.right);
		}
	}


	public Node findNext(Node root , Node target){

		// Go to right until root is smaller than target.
		while(root != null && root.data <= target.data){
				root = root.right;
		}

		//If target is grater that root ..means target is not there
		if(root == null){
			return root;
		}

		//go to left if target node is smaller than root.
		Node left = findNext(root.left,target);

		//If target doesnt exist but less that any existing node.
		return left != null && left.data > target.data ? left : root;


	}


	/*
		Serialize BT to String
	*/

	public void serialize(Node root , StringBuilder sb){

		if(root == null){
			sb.append(REPLACE_NULL).append(SPLITTER);
		} else {

			sb.append(root.data).append(SPLITTER);

			serialize(root.left,sb);
			serialize(root.right,sb);
		}

	}

	public Node deserialize(String sb){

		if(sb == null && sb.length() == 0){
			return null;
		}
		Queue<String> q = new LinkedList<>();
		q.addAll(Arrays.asList(sb.split(SPLITTER)));

		return deserializeUtil(q);
	}

	public Node deserializeUtil(Queue<String> q){

		if(q.isEmpty()){
			return null;
		}

		String val = q.poll();
		if(REPLACE_NULL.equals(val)){
			return null;
		}

		Node root = new Node(Integer.parseInt(val));
		root.left = deserializeUtil(q);
		root.right = deserializeUtil(q);

		return root;
	}

	Node prev = null;

	public void flattenBT(Node root){

		if(root == null){
			return;
		}

		flattenBT(root.right);
		flattenBT(root.left);
		root.right = prev;
		root.left = null;
		prev = root;

	}

	public void preOder(Node root){
		if(root != null){
			System.out.print(root.data +" ");
			preOder(root.left);
			preOder(root.right);
		}
	}


	public boolean isBST(Node root){

		if(root == null){
			return true;
		}

		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public boolean isBST(Node root , int min , int max){

			if(root == null) return true;

			if(root.data < min || root.data > max){
				return false;
			}

			return isBST(root.left , min,root.data) &&
					isBST(root.right,root.data,max);
	}


}


	/*

	    	 1
	     /  \
	    2      3 (r)
	  /   \   / \
	 4     5 6   7 prev
 */