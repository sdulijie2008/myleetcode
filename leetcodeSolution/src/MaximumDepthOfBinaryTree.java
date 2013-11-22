public class MaximumDepthOfBinaryTree {

	public int maxDepth(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null) {
			return 0;
		}
		int leftDepth = maxDepth(root.left);
		int rightDepth = maxDepth(root.right);
		if (leftDepth > rightDepth) {
			return leftDepth + 1;
		} else {
			return rightDepth + 1;
		}
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
