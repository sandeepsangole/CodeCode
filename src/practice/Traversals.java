package practice;

import tree.BuildTree;
import tree.Node;

import java.util.*;

public class Traversals {

	public static void main(String[] args) {
		Traversals obj  = new Traversals();
		Node       root = BuildTree.buildBinaryTree();
		obj.inOrder(root);
		System.out.println();
		List<Integer> res = obj.inOrderIterative(root);
		System.out.println(res.toString());

		obj.preOrder(root);
		System.out.println();
		List<Integer> preLst = obj.preOrderIterative(root);
		System.out.println(preLst.toString());

		
		System.out.println();
		List<Integer> levelLst = obj.levelOrderTraversal(root);
		System.out.println(levelLst.toString());

		System.out.println();
		List<Integer> spLst = obj.spiralOrderTraversal(root);
		System.out.println(spLst.toString());

		System.out.println();
		List<Integer> rightView = obj.rightSideView(root);
		System.out.println(rightView.toString());

		System.out.println();
		int height = obj.heightOfBT(root);
		System.out.println(height);
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

	// 4 9 2 5 1 6 3 7
	private void inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}
	}

	private List<Integer> inOrderIterative(Node root) {

		Stack<Node>   stack = new Stack<>();
		Node          curr  = root;
		List<Integer> res   = new ArrayList<>();

		while (curr != null || !stack.isEmpty()) {
			if (curr != null) {
				stack.push(curr);
				curr = curr.left;
			} else {

				if (!stack.isEmpty()) {
					Node tmp = stack.pop();
					res.add(tmp.data);

					if (tmp.right != null) {
						curr = tmp.right;
					}
				}
			}
		}

		return res;
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

	// 1 2 4 9 5 3 6 7 
	private void preOrder(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	private List<Integer> preOrderIterative(Node root) {
		List<Integer> res   = new ArrayList<>();
		Stack<Node>   stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			Node tmp = stack.pop();
			res.add(tmp.data);

			if (tmp.right != null) {
				stack.push(tmp.right);
			}

			if (tmp.left != null) {
				stack.push(tmp.left);
			}
		}
	
		return res;	
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
	// 1 2 3 4 5 6 7 9
	private List<Integer> levelOrderTraversal(Node root) {
		List<Integer> res = new ArrayList<>();
		
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()){
			
			int size = q.size();
			
			for (int i = 0; i < size ; i++){
				Node tmp = q.poll();
				res.add(tmp.data);
				if(tmp.left != null){
					q.offer(tmp.left);
				}
				
				if(tmp.right != null){
					q.offer(tmp.right);
				}
			}
		}
		return res;
	}

		/*
	
		      1
		     /  \
		    2     3
		  /   \   / \
		 4     5 6   7
	     \
	      9
	    
	    Stack1 : 7 6 5 4  
	    Stack2 :   
	    res : 1 3 2  
	 */
	
		// 1 3 2 4 5 6 7 9
	
	private List<Integer> spiralOrderTraversal(Node root) {
		List<Integer> res = new ArrayList<>();
		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();
		stack1.push(root);
		while (!stack1.isEmpty() || !stack2.isEmpty()){
			
			while (!stack1.isEmpty()){
				Node tmp = stack1.pop();
				res.add(tmp.data);
				if(tmp.left != null){
					stack2.push(tmp.left);
				}

				if(tmp.right != null){
					stack2.push(tmp.right);
				}
			}

			while (!stack2.isEmpty()){
				Node tmp = stack2.pop();
				res.add(tmp.data);
				if(tmp.right != null){
					stack1.push(tmp.right);
				}

				if(tmp.left != null){
					stack1.push(tmp.left);
				}
			}
			
		}
		
		return res;
	}
	
	private int heightOfBT(Node root){
		
		if(root == null){
			return 0;
		}
		
		int left = heightOfBT(root.left);
		int right = heightOfBT(root.right);
		return 1 + Math.max(left , right);
	        
	}
	
	private List<Integer> rightSideView(Node root){
		List<Integer> res = new ArrayList<>();
		rightSideViewUtil(root , res, 0);
		return res;
	}

	private void rightSideViewUtil(Node root , List<Integer> res , int level){
		
		if(root == null){
			return;
		}
		
		if(level == res.size()){
			res.add(root.data);
		}

		rightSideViewUtil(root.right, res, level + 1);
		rightSideViewUtil(root.left, res, level + 1);

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

	public List<List<Integer>> verticalOrder(Node root) {

		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		
		Map<Integer , List<Integer>> map = new HashMap<>();
		Queue<Node> nodes = new LinkedList<>();
		Queue<Integer> levels = new LinkedList<>();
		
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		
		nodes.offer(root);
		levels.offer(0);
		
		while (!nodes.isEmpty()){
			
			Node tmp = nodes.poll();
			int level = levels.poll();
			
			if(map.containsKey(level)){
				map.get(level).add(tmp.data);
			} else {
				List<Integer> lst = new ArrayList<>();
				map.put(level ,lst);
			}
			
			min = Math.min(min ,level);
			max = Math.max(max , level);
			
			if(tmp.left != null){
				nodes.offer(tmp.left);
				levels.offer(level - 1);
			}

			if(tmp.right != null){
				nodes.offer(tmp.right);
				levels.offer(level + 1);
			}


		}

		for(int i=min;i<=max;i++){
			res.add(map.get(i));
		}

		return res;
	         
	                   
	}
	
	
}
