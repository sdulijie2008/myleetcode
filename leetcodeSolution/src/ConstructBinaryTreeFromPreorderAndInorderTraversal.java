public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0)
			return null;
		return buildTreeHelper(preorder, inorder, 0, preorder.length - 1, 0,
				inorder.length - 1);
	}

	public TreeNode buildTreeHelper(int[] preorder, int[] inorder, int pstart,
			int pend, int istart, int iend) {
		if (pend < pstart)
			return null;
		if (pstart == pend)
			return new TreeNode(preorder[pstart]);
		TreeNode root = new TreeNode(preorder[pstart]);
		int i = 0;
		while (inorder[istart + i] != preorder[pstart])
			++i;
		root.left = buildTreeHelper(preorder, inorder, pstart + 1, pstart + i,
				istart, istart + i - 1);
		root.right = buildTreeHelper(preorder, inorder, pstart + i + 1, pend,
				istart + i + 1, iend);
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
