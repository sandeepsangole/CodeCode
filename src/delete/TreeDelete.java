package delete;

import tree.BuildTree;
import tree.Node;

import java.util.*;
import java.util.List;

public class TreeDelete {

	public static void main(String[] args) {
		TreeDelete obj  = new TreeDelete();
		Node       root = BuildTree.buildBinaryTree();



		//obj.rightSideView(root);
		//obj.flatternBT(root);
		//System.out.println();

		System.out.println(obj.longestPath(root));
	}



	/*

		lonest path length

	 */

	public int longestPath(Node root){
		int[] max = new int[1];
		longestPath(root,max);
		return max[0];
	}
	public int longestPath(Node root , int[] max){

		if(root == null){
			return 0;
		}

		int left =  longestPath(root.left,max);
		int right = longestPath(root.right,max);

		max[0] = Math.max(max[0] , left + right);

		return Math.max(left , right)  + 1;
	}

		/*
			Flattern Tree

			       1
			     /  \
			    2     3
			  /   \   / \
			 4     5 6   7
		     \
		      9

   */



	Node prev = null;
	public void flatternBT(Node root){

		if(root == null) {
			return;
		}

		flatternBT(root.right);
		flatternBT(root.left);
		root.right = prev;
		root.left = null;
		prev = root;

	}

	public List<String> binaryTreePaths(Node node) {

		List<String> res = new ArrayList<>();
		if (node == null) {
			return res;
		}

		String str = "" + node.data;

		binaryTreePaths(node, str, res);

		res.stream().forEach(System.out::println);
		return res;
	}



	public void binaryTreePaths(Node node, String str, List<String> res) {

		if (node.left == null && node.right == null) {
			res.add(str);
		} else {
			if (node.left != null)
				binaryTreePaths(node.left, str + "->" + node.left.data, res);

			if (node.right != null)
				binaryTreePaths(node.right, str + "->" + node.right.data, res);
		}
	}

	/*
	199. Binary Tree Right Side View

	Given a binary tree, imagine yourself standing on the right side of it, return the values of
	the nodes you can see ordered from top to bottom.

	For example:
	Given the following binary tree,
			1            <---
			/   \
			2     3         <---
			\     \
			5     4       <---
	You should return [1, 3, 4].

*/

	public List<Integer> rightSideView(Node root){
		List<Integer> res = new ArrayList<>();
		if(root == null){
			return res;
		}

		rightSideView(root , 1, res);

		res.stream().forEach(System.out::println);

		return res;
	}

	public void rightSideView(Node root , int level,List<Integer> res){

			if(root == null){
				return;
			}

			if(level > res.size()){
				res.add(root.data);
			}

			rightSideView(root.right , level + 1 ,res);
			rightSideView(root.left , level + 1,res);



	}


	/*

		is height Balanced

		if diff of height between any subtree is grater than one return false
	 */






	/*
		LCA BT
	 */


		public Node lcsBT(Node root , Node node1, Node node2){

			if(root == null){
				return root;
			}

			if(root == node1 || root == node2){
				return root;
			}

			Node left = lcsBT(root.left,node1, node2);
			Node right = lcsBT(root.right,node1,node2);

			if(left != null && right != null){
				return root;
			}

			if(left == null || right == null){
				return null;
			}

			return left != null ? left : right;

		}

	/*
	LCA BST
	 */

	public Node lcaBST(Node root , Node node1 , Node node2){

		if(root == node1 || root == node2){
			return root;
		}

		if(node1.data < root.data && node2.data < root.data){
			return lcaBST(root.left, node1 , node2);
		}

		if(node1.data > root.data && node2.data > root.data){
			return lcaBST(root.right,node1,node2);
		}

		return root;
	}

}
