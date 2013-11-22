import java.util.ArrayList;

public class UniqueBinarySearchTreeII {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}

	public ArrayList<TreeNode> generateTrees(int n) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		ArrayList<TreeNode> res = new ArrayList<TreeNode>();
		generateTrees(res, 1, n);
		return res;
	}

	public void generateTrees(ArrayList<TreeNode> res, int left, int right) {
		if (left > right)
			res.add(null);
		else
			for (int i = left; i <= right; i++) {
				ArrayList<TreeNode> lefts = new ArrayList<TreeNode>();
				generateTrees(lefts, left, i - 1);
				ArrayList<TreeNode> rights = new ArrayList<TreeNode>();
				generateTrees(rights, i + 1, right);
				for (int x = 0; x < lefts.size(); x++)
					for (int y = 0; y < rights.size(); y++) {
						TreeNode root = new TreeNode(i);
						root.left = lefts.get(x);
						root.right = rights.get(y);
						res.add(root);
					}
			}
	}
}
