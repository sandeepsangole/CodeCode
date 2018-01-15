package tree;

import java.util.*;

public class Traversals {

	public static void main(String[] args) {
		Traversals obj = new Traversals();
		Node root = BuildTree.buildBinaryTree();
		System.out.println(obj.inOrder(root));
		System.out.println(obj.preOrder(root));
		System.out.println(obj.postOrder(root));
		System.out.println(obj.levelOrderTraversal(root));
		System.out.println(obj.spiralOrder(root));
		System.out.println(obj.verticalOrder(root));
		//System.out.println(obj.printNodePath(root , new Node(4)));
		System.out.println(obj.bottomLeftMostNode(root));
		System.out.println(obj.rightSideView(root));
		System.out.println("Longest "+obj.longestPath(root));
		obj.flatternTree(root);
		obj.flatternTreeIterative(root);
		System.out.println(root);

		System.out.println(obj.binaryTreePaths(root));



	}
	/*

	    	 1
	     /  \
	    2     3
	  /   \   / \
	 4     5 6   7

 */

	public List<String> binaryTreePaths(Node root){

		List<String> res = new ArrayList<>();
		binaryTreePathsUtil(root,"",res);
		return res;
	}

	public void binaryTreePathsUtil(Node root , String str, List<String> res){
		if(root.left == null && root.right == null){
			res.add(str+root.data);
		}
		if(root.left != null){
			binaryTreePathsUtil(root.left, str + root.data +"->", res);
		}

		if(root.right != null){
			binaryTreePathsUtil(root.right, str+root.data+"->",res);
		}

	}

	public int longestPath(Node root){
		int[] max = new int[1];
		longestPath(root , max);
		return max[0];
	}

	public int longestPath(Node root,int[] max){
		if(root == null) return 0;
		int left = longestPath(root.left,max);
		int right = longestPath(root.right,max);

		max[0] = Math.max(max[0],left + right);


		return 1 + Math.max(left, right);
	}

	public Node findNext(Node root , Node target){

		 while(root != null && root.right != null){
			 root = root.right;
		 }

		 if(root == null){
			 return root;
		 }

		 Node left = findNext(root.left, target) ;

		return left != null && left.data > target.data ? left : root;



	}

	Node tmp = null;
	public void flatternTree(Node root){

		if(root == null){
			return ;
		}

		flatternTree(root.right);
		flatternTree(root.left);

		root.right = tmp;
		root.left = null;
		tmp = root;
	}

	public void flatternTreeIterative(Node root){

		if(root == null){
			return ;
		}

		Stack<Node> stack = new Stack<>();
		Node curr = root;
		while (curr != null || !stack.isEmpty()){

			if(curr.right != null){
				stack.push(curr.right);
			}

			if(curr.left != null){
				curr.right = curr.left;
				curr.left = null;
			}

			else if(!stack.isEmpty()){

				curr.right = stack.pop();
			}

			curr = curr.right;
		}

	}

	public List<Integer> rightSideView(Node root){

		List<Integer> res = new ArrayList<>();
		rightSideViewUtil(root,res,0);
		return res;
	}

	public void rightSideViewUtil(Node root , List<Integer> res , int level){

		if(root == null) return;

		if(res.size() == level){
			res.add(root.data);
		}

		rightSideViewUtil(root.left,res,level+1);
		rightSideViewUtil(root.right,res,level+1);
	}



	public int bottomLeftMostNode(Node root){

		if(root == null) {
			return -1;
		}

		Queue<Node> queue = new LinkedList<>();
		int leftMost = -1;
		queue.offer(root);
		while(!queue.isEmpty()){

			int size = queue.size();
			for(int i = 0;i<size;i++){
				Node tmp = queue.poll();
				if(i == 0){
					leftMost = tmp.data;
				}

				if(tmp.left != null){
					queue.offer(tmp.left);
				}

				if(tmp.right != null){
					queue.offer(tmp.right);
				}

			}
		}

		return leftMost;
	}

	//Give node , print its path
	public boolean printNodePath(Node root , Node node){


		if(root == null){
			return false;
		}

		if(root.data == node.data || printNodePath(root.left,node) || printNodePath(root.right, node)){
			System.out.println(root.data);
			return true;
		}

		return false;
	}

	//Vertical Order
	//4 , 2, (1,5,6), 3 , 7


	public List<List<Integer>> verticalOrder(Node root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}

		Map<Integer,List<Integer>> map = new HashMap<>();

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		Queue<Node> nodes = new LinkedList<>();
		Queue<Integer> levels = new LinkedList<>();

		nodes.offer(root);
		levels.offer(0);

		while(!nodes.isEmpty()){

			Node tmp = nodes.poll();
			int level = levels.poll();

		   if(map.containsKey(level)){
			   map.get(level).add(tmp.data);

		   } else {
			   ArrayList<Integer> tmpLst = new ArrayList<>();
			   tmpLst.add(tmp.data);
			   map.put(level, tmpLst);
		   }

			min = Math.min(min,level);
			max = Math.max(max,level);

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

	//Spiral Order
	//1 3 2 4 5 6 7

	public List<List<Integer>> spiralOrder(Node root){
		List<List<Integer>> res = new ArrayList<>();
		if(root == null) {
			return res;
		}

		List<Integer> subLst = new ArrayList<>();

		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();

		stack1.push(root);

		while(!stack1.isEmpty() || !stack2.isEmpty()){

			while (!stack1.isEmpty()){

				Node tmp = stack1.pop();

				subLst.add(tmp.data);
				if(tmp.left != null){
					stack2.push(tmp.left);
				}

				if(tmp.right != null){
					stack2.push(tmp.right);
				}
			}
			if(subLst.size() > 0)
			res.add(new ArrayList<>(subLst));
			subLst.clear();

			while (!stack2.isEmpty()){

				Node tmp = stack2.pop();
				subLst.add(tmp.data);

				if(tmp.right != null){
					stack1.add(tmp.right);
				}

				if(tmp.left != null){
					stack1.add(tmp.left);
				}
			}
			if(subLst.size() > 0)
			res.add(new ArrayList<>(subLst));
			subLst.clear();

		}

		return res;
	}

	//Level Order Traversal

	public List<Integer> levelOrderTraversal(Node root){

		List<Integer> res = new ArrayList<>();

		if(root == null){
			return res;
		}
		Queue<Node> q = new LinkedList<>();
		q.offer(root);

		while(!q.isEmpty()){

			int size = q.size();
			for(int i = 0;i<size;i++){

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

	//Left - right - root
	// 4 5 2 6 7 3 1
	public List<Integer> postOrder(Node root){

		List<Integer> res = new ArrayList<>();
		if(root == null){
			return res;
		}

		Stack<Node> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();

		stack1.push(root);
		while (!stack1.isEmpty()){

			if(!stack1.isEmpty()){
				Node tmp = stack1.pop();
				stack2.push(tmp.data);

				if(tmp.left != null){
					stack1.push(tmp.left);
				}

				if(tmp.right != null){
					stack1.push(tmp.right);
				}
			}


		}

		while (!stack2.isEmpty()){
			res.add(stack2.pop());
		}

		return res;

	}

	// Root - Left - Right
  // 1 2 4 5 3 6 7

	public List<Integer> preOrder(Node root){

		List<Integer> res = new ArrayList<>();
		if(root == null){
			return res;
		}
		Stack<Node> stack = new Stack<>();
		stack.push(root);

		while(!stack.isEmpty()){

			Node tmp = stack.pop();
			res.add(tmp.data);
			if(tmp.right != null){
				stack.push(tmp.right);
			}

			if(tmp.left != null){
				stack.push(tmp.left);
			}
		}

		return res;

	}

	//Left - root - right
	//4 2 5  1 6 3 7

	public List<Integer> inOrder(Node root){

		List<Integer> res = new ArrayList<>();
		if(root == null) return  res;

		Stack<Node> stack = new Stack<>();
		Node currrent = root;

		while(!stack.isEmpty() || currrent != null){

			if(currrent != null){
				stack.push(currrent);
				currrent = currrent.left;
			} else {

				Node tmp = stack.pop();
				res.add(tmp.data);
				if(tmp.right != null){
					currrent = tmp.right;
				}
			}
		}

		return res;
	}
}
