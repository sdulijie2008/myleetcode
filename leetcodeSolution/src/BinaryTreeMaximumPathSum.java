public class BinaryTreeMaximumPathSum {
	public int currentMaxSum = 0;

	public int maxPathSum(TreeNode root) {
		currentMaxSum = root.val;
		maxPathSumHelper(root);
		return currentMaxSum;
	}

	public int maxPathSumHelper(TreeNode root) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (root == null)
			return 0;
		int l = maxPathSumHelper(root.left);
		int r = maxPathSumHelper(root.right);
		int sum = root.val;
		if (l > 0)
			sum += l;
		if (r > 0)
			sum += r;
		currentMaxSum = Math.max(currentMaxSum, sum);
		int value = root.val;
		return Math.max(value, value + Math.max(r, l));
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
