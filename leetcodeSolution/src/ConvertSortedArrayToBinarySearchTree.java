public class ConvertSortedArrayToBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] num) {
		if (num.length == 0)
			return null;
		return sortedArrayToBSTHelper(num, 0, num.length - 1);
	}

	public TreeNode sortedArrayToBSTHelper(int[] num, int start, int end) {
		if (start > end)
			return null;
		if (start == end)
			return new TreeNode(num[start]);
		int middle = (start + end) >> 1;
		TreeNode root = new TreeNode(num[middle]);
		root.left = sortedArrayToBSTHelper(num, start, middle - 1);
		root.right = sortedArrayToBSTHelper(num, middle + 1, end);
		return root;
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
