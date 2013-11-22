import java.util.ArrayList;

public class PathSumII {

	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return results;
		ArrayList<Integer> result = new ArrayList<Integer>();
		pathSumHelper(root, sum, result, results);
		return results;
	}

	private void pathSumHelper(TreeNode root, int sum,
			ArrayList<Integer> result, ArrayList<ArrayList<Integer>> results) {
		if (root == null)
			return;
		if (root.val == sum && root.left == null && root.right == null) {
			result.add(root.val);
			results.add(result);
			return;
		}
		result.add(root.val);
		pathSumHelper(root.left, sum - root.val,
				new ArrayList<Integer>(result), results);
		pathSumHelper(root.right, sum - root.val,
				new ArrayList<Integer>(result), results);
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
