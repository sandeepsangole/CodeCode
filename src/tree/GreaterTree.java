package tree;

/*

Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original
BST is changed
to the original key plus sum of all keys greater than the original key in BST.

Example:

Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

Output: The root of a Greater Tree like this:
             18
            /   \
          20     13


	1. Traverse to right
	2. Sum current value with root.data

	do inorder..right first

 */





public class GreaterTree {


	public static void main(String[] args) {
		GreaterTree obj     = new GreaterTree();
		Node        rootBST = BuildTree.buildBinarySearchTree();
		obj.reverseInOrderTraversal(rootBST);
		System.out.println();
		System.out.println(obj.greaterTree(rootBST));
		obj.reverseInOrderTraversal(rootBST);

	}


	public void greaterTreeDelete(Node root , int[] sum){

		if(root == null){
			return;
		}
		greaterTreeDelete(root.right , sum);
		sum[0]+=root.data;
		root.data = sum[0];
		root.data = sum[0];
		greaterTreeDelete(root.left , sum);



	}

	public int greaterTree(Node root){
		int[] tmp = new int[1];
		greaterTreeUtil(root,tmp);
		return tmp[0];

	}
	public void greaterTreeUtil(Node root, int[] prev){

		if(root != null){
			greaterTreeUtil(root.right,prev);
			prev[0] += root.data;
			root.data = prev[0];
			//System.out.print(prev[0] +" ");
			greaterTreeUtil(root.left,prev);
		}
	}

	
	
	public void reverseInOrderTraversal(Node root){

		if(root != null){
			reverseInOrderTraversal(root.right);
			System.out.print(root.data +" ");
			reverseInOrderTraversal(root.left);
		}
	}
}
