public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		return isValidBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public boolean isValidBSTHelper(TreeNode root, int low, int high) {
		if (root == null)
			return true;
		return root.val > low && root.val < high
				&& isValidBSTHelper(root.left, low, root.val)
				&& isValidBSTHelper(root.right, root.val, high);
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
