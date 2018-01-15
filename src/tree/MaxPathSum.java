package tree;

/*


 Given a binary tree, find the maximum path sum.

		 For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

		 For example:
		 Given the below binary tree,

		 1
		 / \
		 2   3
		 Return 6.

*/

public class MaxPathSum {


	int  max=Integer.MIN_VALUE;;
	public int maxPathSum(Node root) {

		maxPathSumUtil(root);
		return max;
	}

	public int maxPathSumUtil(Node root) {
		if(root == null) return 0;
		int left = Math.max(0,maxPathSumUtil(root.left));
		int right = Math.max(0,maxPathSumUtil(root.right));

		max = Math.max(max, left + right + root.data);
		return Math.max(left,right) + root.data;
	}


}
