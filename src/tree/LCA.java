package tree;

public class LCA {

	public static void main(String[] args) {
		LCA obj  = new LCA();
		Node       rootBT = BuildTree.buildBinaryTree();
		Node       rootBST = BuildTree.buildBinarySearchTree();
		/*Node res = obj.lcaBT(rootBT,new Node(6),new Node(7));
		System.out.println(res.data);

		System.out.println(obj.isBST(rootBT));
		System.out.println(obj.isBST(rootBST));

		obj.printBST(rootBST);System.out.println();
		System.out.println(obj.kthSmallest(rootBST, 2));*/

		System.out.println(obj.findMaxNodeBT(rootBT));

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

	//print Kth Smallest element in BST



	static int count = 0;
	public int kthSmallest(Node root, int k){

		if(root != null){
			kthSmallest(root.left,k);
			//System.out.println(root.data);
			count++;
			if(count == k){

				System.out.println(root.data);
				return root.data;
			}
			kthSmallest(root.right,k);
		}

		return -1;
	}

	public boolean isBST(Node root){

		return isBST(root, Integer.MIN_VALUE,Integer.MAX_VALUE);
	}


	public int findMaxNodeBT(Node root){

		if(root == null) return -1;

		int max = Math.max(findMaxNodeBT(root.left),findMaxNodeBT(root.right));

		if(max > root.data){
			return max;
		}
		return root.data;
	}

	public boolean isBST(Node root , int min , int max){

		if(root == null) {
			return true;
		}

		if(root.data < min || root.data > max) {
			return false;
		}

		return isBST(root.left, min,root.data) && isBST(root.right, root.data,max);

	}

	public Node lcaBT(Node root, Node node1 , Node node2){

		if(root == null){
			return root;
		}
		if(root.data == node1.data || root.data == node2.data){
			return root;
		}

		Node left = lcaBT(root.left, node1,node2);
		Node right = lcaBT(root.right, node1,node2);

		if(left != null && right != null){
			return root;
		}

		if(left == null && right == null) {
			return null;
		}

		return left != null ? left : right;

	}

	public Node lcaBST(Node root, Node node1 , Node node2){

		if(root == null) {
			return root;
		}
		if(root == node1 || root == node2){
			return root;
		}

		if(root.data < node1.data && root.data < node2.data){
			return lcaBST(root.right, node1,node2);
		}


		if(root.data > node1.data && root.data > node2.data){
			return lcaBST(root.left,node1,node2);
		}

		return root;
	}

	public void printBST(Node root){
		if(root != null){
			printBST(root.left);
			System.out.print(root.data +" ");
			printBST(root.right);
		}
	}
}
