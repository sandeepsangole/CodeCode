package tree;

public class BalancedBinaryTree {


	public boolean isHeightBalancedBT(Node root){

		if(root == null){
			return true;
		}

		if(isHeightDiff(root) == -1){
			return false;
		}

		return true;
	}

	public int isHeightDiff(Node root){

		if(root == null){
			return 0;
		}

		int left = isHeightDiff(root.left);
		int right = isHeightDiff(root.right);

		if(left == -1) return -1;
		if(right == -1) return  -1;
		if(Math.abs(left - right) > 1){
			return -1;
		}

		return 1 + Math.max(left, right);

	}
}


