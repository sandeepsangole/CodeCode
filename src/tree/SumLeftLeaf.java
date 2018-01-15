package tree;
/*

Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.

 */
public class SumLeftLeaf {


	public void leftLeafSum(Node root, Node parent, int[] sum){
		if(root != null){

			if(root.left == null && root.right == null && root.left == parent){
				sum[0] += root.data;
			}
			leftLeafSum(root.left, root,sum);
			leftLeafSum(root.right,root,sum);
		}

		return ;
	}
}
