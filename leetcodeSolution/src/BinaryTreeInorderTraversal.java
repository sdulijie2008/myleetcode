import java.util.ArrayList;

public class BinaryTreeInorderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return result;
		result.addAll(inorderTraversal(root.left));
		result.add(root.val);
		result.addAll(inorderTraversal(root.right));
		return result;
	}
}
