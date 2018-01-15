package tree;

/*

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees
of every node never differ by more than 1.


Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5

 */
public class SortedArrayBST {
	public static void main(String[] args) {

	}

	public Node convertSortedArrayBST(int[] arr){

			if(arr == null || arr.length == 0){
				return null;
			}

		return convertSortedArrayBST(arr , 0,arr.length - 1);
	}

	public Node convertSortedArrayBST(int[] arr , int left , int right){

		if(left > right){
			return null;
		}
		int mid = (left + right ) / 2;

		Node root = new Node(arr[mid]);
		root.left = convertSortedArrayBST(arr,left , mid - 1);
		root.right = convertSortedArrayBST(arr, mid + 1, right);

		return root;
	}

}
