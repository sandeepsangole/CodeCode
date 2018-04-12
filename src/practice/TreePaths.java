package practice;

import jdk.nashorn.internal.ir.WhileNode;
import tree.BuildTree;
import tree.Node;

import java.util.*;

public class TreePaths {

	public static void main(String[] args) {
		TreePaths obj  = new TreePaths();
		Node       root = BuildTree.buildBinaryTree();
		obj.inOrder(root);
		
		List<List<Integer>> res = obj.treePaths(root);
		res.stream().forEach(System.out::println);

		System.out.println(obj.hasPathSum(root , 81));
		
		System.out.println(obj.sumOfPaths(root));

		List<Integer> kdisroot = obj.kDistanceNodesFromRoot(root , 1);
		System.out.println(kdisroot.toString());
		
		
	}
	
	
	
	private List<List<Integer>> treePaths(Node root){
		
		List<List<Integer>> res = new ArrayList<>();
		if(root == null){
			return res;
		}
		
		List<Integer> path = new ArrayList<>();
		path.add(root.data);
		treePathsUtil(root , res,path);
		return res;
	}
	
	private void treePathsUtil(Node root , List<List<Integer>> res  ,List<Integer> path){
			
		if (root.left == null && root.right == null){
			res.add(new ArrayList<Integer>(path));
		}
		
		if (root.left != null){
			path.add(root.left.data);
			treePathsUtil(root.left , res , path);
			path.remove(path.size() - 1);
			
		}

		if (root.right != null){
			path.add(root.right.data);
			treePathsUtil(root.right , res , path);
			path.remove(path.size() - 1);

		}
	}
	
	public boolean hasPathSum(Node root , int sum){
		
		if(root == null){
			return false;
		}
		
		if(root.left == null && root.right == null && root.data == sum){
			return true;
		}
		
		return hasPathSum(root.left,sum - root.data) ||
			   hasPathSum(root.right, sum - root.data);
	}

	public int sumOfPaths(Node root){

		if(root == null) return 0;
		return sumOfPathsUtil(root, 0);
	}

	private int sumOfPathsUtil(Node root , int sum){
		
		if (root == null){
			return 0;
		}
		
		sum = sum * 10 + root.data;
		
		if(root.left == null && root.right == null){
			return sum;
		}
		
		return sumOfPathsUtil(root.left , sum) + sumOfPathsUtil(root.right , sum);
	}
	
	public List<Integer> kDistanceNodesFromRoot(Node root , int k){

		List<Integer> res = new ArrayList<>();
		if(root == null){
			return res;
		}

		kDistanceNodesFromRoot(root , res , k);
		
		return res;
		
	}

	public void kDistanceNodesFromRoot(Node root ,List<Integer>  res , int k){
			
		if (root == null){
			return;
		}
		
		if(k == 0){
			res.add(root.data);
		}

		kDistanceNodesFromRoot(root.left , res ,k - 1);
		kDistanceNodesFromRoot(root.right , res ,k - 1);
		

	}
	
	// 4 9 2 5 1 6 3 7
	private void inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}
	}
	
}
