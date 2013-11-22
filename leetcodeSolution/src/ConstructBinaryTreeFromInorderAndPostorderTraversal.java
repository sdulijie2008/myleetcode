public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder.length == 0)
			return null;
		return buildTreeHelper(inorder, postorder, 0, inorder.length - 1, 0,
				postorder.length - 1);
	}

	public TreeNode buildTreeHelper(int[] inorder, int[] postorder, int istart,
			int iend, int pstart, int pend) {
		if (iend < istart)
			return null;
		if (istart == iend)
			return new TreeNode(inorder[istart]);
		TreeNode root = new TreeNode(postorder[pend]);
		int i = 0;
		while (inorder[istart + i] != postorder[pend])
			++i;
		root.left = buildTreeHelper(inorder, postorder, istart, istart + i - 1,
				pstart, pstart + i - 1);
		root.right = buildTreeHelper(inorder, postorder, istart + i + 1, iend,
				pstart + i, pend - 1);
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
