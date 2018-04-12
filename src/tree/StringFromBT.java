package tree;

/*

606. Construct String from Binary Tree

You need to construct a string consists of parenthesis and integers from a binary tree with the
preorder traversing way.

The null node needs to be represented by empty parenthesis pair "()". And you need to omit all
the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and
the original binary tree.

Example 1:
Input: Binary tree: [1,2,3,4]
       1
     /   \
    2     3
   /
  4

Output: "1(2(4))(3)"

Explanation: Originallay it needs to be "1(2(4)())(3()())",
but you need to omit all the unnecessary empty parenthesis pairs.
And it will be "1(2(4))(3)".
Example 2:
Input: Binary tree: [1,2,3,null,4]
       1
     /   \
    2     3
     \
      4

Output: "1(2()(4))(3)"

Explanation: Almost the same as the first example,
except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.
 */
public class StringFromBT {


	public static void main(String[] args) {
		BuildTree obj  = new BuildTree();
		Node      root = obj.buildBinaryTree();
		preOrder(root);
		System.out.println();
		System.out.println();
		System.out.println(tree2str(root));
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


	public static String tree2str(Node t) {
		if (t == null) {
			return "";
		}

		String val   = t.data + "";
		String left  = tree2str(t.left);
		String right = tree2str(t.right);

		if (left == "" && right == "")
			return val;

		if (left == "") {
			return val + "()(" + right + ")";
		} else if (right == "") {
			return val + "(" + left + ")";
		} else {
			return val + "(" + left + ")(" + right + ")";
		}
	}
	
	

	public static void preOrder(Node root) {

		if (root != null) {
			System.out.print(root.data + " ");
			preOrder(root.left);
			preOrder(root.right);

		}
	}

}
