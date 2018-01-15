package tree;
import java.util.*;

public class BTPaths {

	public static void main(String[] args) {
		BTPaths obj = new BTPaths();
		Node root = BuildTree.buildBinaryTree();
		System.out.println(obj.printAllPaths(root));

		//7.Has Path sum - recursion
		boolean res = obj.hasPathSum(root, 10);
		System.out.println(res);

		int sum = obj.sumOfPaths(root);
		System.out.println(sum);

		System.out.println(obj.sumOfPaths(root));
	}

	public int sumOfPaths(Node root){

		if(root == null) return 0;
		return sumOfPathsUtil(root, 0);
	}

	public int sumOfPathsUtil(Node root , int sum){

		if(root == null){
			return 0;
		}

		sum = sum * 10 + root.data;

		if(root.left == null || root.right == null){
			return sum ;
		}

		return sumOfPathsUtil(root.left , sum) + sumOfPathsUtil(root.right, sum);
	}


	public boolean hasPathSum(Node root , int sum){
		if(root == null){
			return false;
		}

		if(root.left == null && root.right == null && root.data == sum){
			return true;
		}

		return hasPathSum(root.left, sum - root.data) || hasPathSum(root.right, sum - root.data);
	}

	public List<List<Integer>> printAllPaths(Node root){

		List<List<Integer>> res = new ArrayList<>();
		if(root == null){
			return res;
		}
		List<Integer> subLst = new ArrayList<>();
		subLst.add(root.data);
		printAllPaths(root,res,subLst);
		return res;
	}

	public void printAllPaths(Node root , List<List<Integer>> res , List<Integer> subLst){

		if(root.left == null && root.right == null){
			res.add(new ArrayList<>(subLst));
		}

		if(root.left != null){
			subLst.add(root.left.data);
			printAllPaths(root.left,res,subLst);
			subLst.remove(subLst.size() - 1);
		}

		if(root.right != null){
			subLst.add(root.right.data);
			printAllPaths(root.right,res,subLst);
			subLst.remove(subLst.size() - 1);
		}
	}



}
