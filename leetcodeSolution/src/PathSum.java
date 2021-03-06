public class PathSum {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean hasPathSum(TreeNode root, int sum) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (root == null)
			return false;
		if (root.val == sum && root.left == null && root.right == null)
			return true;
		return hasPathSum(root.left, sum - root.val)
				|| hasPathSum(root.right, sum - root.val);

	}
}
