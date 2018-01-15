package tree;

/*

Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.

 */
public class SumRootLeaf {

	public static void main(String[] args) {
		SumRootLeaf obj = new SumRootLeaf();
		Node root = BuildTree.buildBinaryTree();

		System.out.println(obj.sumRootToLeaf(root,0));
	}

	public int sumRootToLeaf(Node root, int sum ){

		if(root == null){
			return 0;
		}

		 sum = sum * 10 + root.data;

		if(root.left == null && root.right == null){
			System.out.println(sum);
			return sum;
		}

		return sumRootToLeaf(root.left,sum) + sumRootToLeaf(root.right, sum);

	}
}
