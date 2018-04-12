package tree;

import cracking.coding.arraystring.tree.LinkedListByLevel;

/*
Print all nodes that are at distance k from a leaf node
3.6
Given a Binary Tree and a positive integer k, print all nodes that are distance k from a leaf node.

Here the meaning of distance is different from previous post. Here k distance from a
leaf means k levels higher than a leaf node. For example if k is more than height of Binary Tree, then nothing should be printed. Expected time complexity is O(n) where n is the number nodes in the given Binary Tree.

 */

import java.util.*;

public class KthFromLeafNode {

	public static void main(String[] args) {
		KthFromLeafNode obj  = new KthFromLeafNode();
		Node            root = BuildTree.buildBinaryTree();
		//obj.printKthElementFromLeaf(root , 1);


		List<Integer>       sublst = new ArrayList<>();

		obj.printkdistanceNodeDown(root, 0);
		//sublst.stream().forEach(System.out::println);

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

	void printkdistanceNodeDown(Node node, int k)
	{
		// Base Case
		if (node == null || k < 0)
			return;

		// If we reach a k distant node, print it
		if (k == 0)
		{
			System.out.print(node.data +" ");
			return;
		}

		// Recur for left and right subtrees
		printkdistanceNodeDown(node.left, k - 1);
		printkdistanceNodeDown(node.right, k - 1);
	}


}
