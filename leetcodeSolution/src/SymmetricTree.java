public class SymmetricTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isSymmetric(TreeNode root) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if (root == null)
			return true;
		return isSymmetricHelper(root.left, root.right);
	}

	public boolean isSymmetricHelper(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;
		if ((left == null && right != null) || (left != null && right == null)
				|| left.val != right.val)
			return false;
		return isSymmetricHelper(left.left, right.right)
				&& isSymmetricHelper(left.right, right.left);
	}
}
