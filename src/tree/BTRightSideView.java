package tree;

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

import java.util.*;

public class BTRightSideView {

	public static void main(String[] args) {
		BTRightSideView obj = new BTRightSideView();
		Node root = BuildTree.buildBinaryTree();
		List<Integer> res = new ArrayList<>();
		obj.rightSideView(root,res,1);
		res.stream().forEach(System.out::println);
	}

	public void rightSideView(Node root , List<Integer> res , int level){

		if(root == null){
			return;
		}

		if(level > res.size()){
				res.add(root.data);
		}

		rightSideView(root.right,res,level + 1);
		rightSideView(root.left,res,level + 1);
	}
}
