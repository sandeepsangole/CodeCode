package cracking.coding.arraystring.tree;

import delete.TreeDelete;
import tree.BuildTree;
import tree.Node;
import java.util.*;

import java.util.LinkedList;

public class LinkedListByLevel {

	public static void main(String[] args) {
		LinkedListByLevel obj  = new LinkedListByLevel();
		Node       root = BuildTree.buildBinaryTree();

		obj.levelLinkedList(root);

		List<LinkedList<Integer>> res = new ArrayList<>();
		obj.buildLinkedListRec(root,res,0);
		System.out.println(res);

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

	public List<LinkedList<Integer>> levelLinkedList(Node root){

		List<LinkedList<Integer>> res = new ArrayList<>();

		if(root == null){
			return res;
		}

		buildLinkedList(root,res);

		res.stream().forEach(System.out::println);

		return res;
	}

	public void buildLinkedList(Node root , List<LinkedList<Integer>> res){

		Queue<Node> queue = new LinkedList<>();
		LinkedList<Integer> head = null;

		queue.offer(root);

		while (!queue.isEmpty()){
			head = new LinkedList<>();
			int size = queue.size();
			for (int i = 0;i<size;i++){

				Node tmp = queue.poll();
				if(tmp.left != null){
					queue.offer(tmp.left);
				}

				if(tmp.right != null){
					queue.offer(tmp.right);
				}

				head.add(tmp.data);
			}
			res.add(head);
			head = null;
		}

	}


	public void buildLinkedListRec(Node root , List<LinkedList<Integer>> res , int level) {

		if(root == null){
			return;
		}

		LinkedList<Integer> list = null;
		if(res.size() == level){
			list = new LinkedList<>();
			res.add(list);
		} else {
			list = res.get(level);
		}

		list.add(root.data);
		buildLinkedListRec(root.left,res,level + 1);
		buildLinkedListRec(root.right,res,level + 1);
	}


}
