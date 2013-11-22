public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (root == null)
			return true;
		if (!isBalanced(root.left) || !isBalanced(root.right))
			return false;
		int leftTreeHeight = height(root.left);
		int rightTreeHeight = height(root.right);
		if (Math.abs(leftTreeHeight - rightTreeHeight) > 1)
			return false;
		return true;
	}

	public int height(TreeNode node) {
		if (node == null)
			return 0;
		int leftTreeHeight = height(node.left);
		int rightTreeHeight = height(node.right);
		return leftTreeHeight > rightTreeHeight ? leftTreeHeight + 1
				: rightTreeHeight + 1;
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
