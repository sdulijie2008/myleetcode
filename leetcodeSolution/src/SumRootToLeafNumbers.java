public class SumRootToLeafNumbers {
	public int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;
		return sumNumbersHelper(root, root.val);
	}

	private int sumNumbersHelper(TreeNode root, int currentSum) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return currentSum;
		if (root.left == null)
			return sumNumbersHelper(root.right, currentSum * 10
					+ root.right.val);
		else if (root.right == null)
			return sumNumbersHelper(root.left, currentSum * 10 + root.left.val);
		else
			return sumNumbersHelper(root.right, currentSum * 10
					+ root.right.val)
					+ sumNumbersHelper(root.left, currentSum * 10
							+ root.left.val);
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
