package tree;

/*

687. Longest Univalue Path

Given a binary tree, find the length of the longest path where each node in the path has the same value.
This path may or may not pass through the root.

Note: The length of path between two nodes is represented by the number of edges between them.

Example 1:

Input:

              5
             / \
            4   5
           / \   \
          1   1   5
Output:

2



public int uniValuePath(Node root){

	int left = (root != null && root.left != null) ? uniValuePath(root.left) : 0;
	int right = (root != null && root.right != null) uniValuePath(root.right) : 0;

	int leftLen = (root.left != null && root.left.data == root.data) ? left + 1 : 0;
	int rightLen = (root.right != null && root.right.data == root.data ? right + 1 : 0;

	max[0] = Math.max(max[0], leftLen + rightLen);

	return 1 + Math.max(left , right)


}


 */
public class UnivaluePath {

	public static void main(String[] args) {
		UnivaluePath obj = new UnivaluePath();
		Node root = BuildTree.buildBinaryTree();

		obj.uniValuePathLength(root);
	}

	public int uniValuePathLength(Node root){
	if(root == null) return 0;
		int[] res = new int[1];
		longestUnivaluePath(root , res);
		System.out.println(res[0]);
		return res[0];
	}

	public int longestUnivaluePath(Node root , int[] res){

		if(root == null){
			return 0;
		}


			int left = (root.left != null) ? longestUnivaluePath(root.left,res) : 0;
			int right = (root.right != null) ?longestUnivaluePath(root.right, res) : 0;


		int leftLen = root.left != null  ? left + 1 : 0;
		int rightLen = root.right != null ? right + 1 :0;

		res[0] = Math.max(res[0], leftLen + rightLen);

		return Math.max(leftLen,rightLen);






	}


}
