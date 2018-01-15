package tree;

import java.util.LinkedList;
import java.util.Queue;

/*

Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
Input:

    2
   / \
  1   3

Output:
1

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7

 */
public class BottomLeft {

	public static void main(String[] args) {
		BottomLeft obj = new BottomLeft();
		Node root = BuildTree.buildBinaryTree();
		System.out.println(obj.leftmost(root));
	}



   /*

   	1. Bottom Left
   	2. Right View
   	3.

   	 */

	public int leftmost(Node root){

		if(root == null) return -1;

		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		int leftMost = -1;

		while(!q.isEmpty()) {

			int size = q.size();

			for (int i = 0; i < size; i++) {
				Node res = q.poll();
				if (i == 0) {
					leftMost = res.data;
				}
				if (res.left != null) {
					q.offer(res.left);
				}

				if (res.right != null) {
					q.offer(res.right);
				}
			}
		}

		return leftMost;
	}
}
