public class SameTree {

	public boolean isSameTree(TreeNode p, TreeNode q) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (p == null && q == null) {
			return true;
		} else if ((p == null && q != null) || (p != null && q == null)) {
			return false;
		}

		if (p.val != q.val) {
			return false;
		} else {
			if (isSameTree(p.left, q.left) && isSameTree(p.right, q.right)) {
				return true;
			} else {
				return false;
			}
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
