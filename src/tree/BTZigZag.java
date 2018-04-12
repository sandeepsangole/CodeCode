package tree;
/*
Given a binary tree, return the zigzag level order traversal of its nodes' values.
(ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],

      3
   /     \
  9       20
 / \     /  \
 1  2     15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]


Stack 1 - 7 15 2 1
Stack 2 - 9 , 20

3
20 9
 */

import java.util.*;

public class BTZigZag {

	public static void main(String[] args) {
		BTZigZag obj  = new BTZigZag();
		Node     root = BuildTree.buildBinaryTree();
		obj.printZigZag(root);
	}

	public List<List<Integer>> printZigZag(Node root) {

		List<List<Integer>> res = new ArrayList<>();
		if (root == null) return res;

		printZigZag(root, res);
		res.stream().forEach(System.out::println);
		return res;
	}

	public void printZigZag(Node root, List<List<Integer>> res) {

		List<Integer> subLst = new ArrayList<>();
		Stack<Node>   stack1 = new Stack<>();
		Stack<Node>   stack2 = new Stack<>();
		stack1.push(root);

		while (!stack1.isEmpty() || !stack2.isEmpty()) {

			while (!stack1.isEmpty()) {
				Node tmp = stack1.pop();
				subLst.add(tmp.data);
				if (tmp.left != null) {
					stack2.push(tmp.left);
				}
				if (tmp.right != null) {
					stack2.push(tmp.right);
				}
			}

			if (subLst.size() > 0) {
				res.add(new ArrayList<>(subLst));
				subLst.clear();
			}

			while (!stack2.isEmpty()) {
				Node tmp = stack2.pop();
				subLst.add(tmp.data);
				if (tmp.right != null) {
					stack1.push(tmp.right);
				}
				if (tmp.left != null) {
					stack1.push((tmp.left));
				}
			}

			if (subLst.size() > 0) {
				res.add(new ArrayList<>(subLst));
				subLst.clear();
			}

		}

	}
}
