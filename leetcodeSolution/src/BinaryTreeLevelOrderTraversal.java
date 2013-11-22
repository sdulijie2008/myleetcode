import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> currentLevelValues = null;
		if (root == null)
			return result;
		Queue<TreeNode> currentLevel = new LinkedList<TreeNode>();
		Queue<TreeNode> nextLevel = null;
		currentLevel.add(root);
		TreeNode currentNode = null;
		while (currentLevel.peek() != null) {
			currentLevelValues = new ArrayList<Integer>();
			nextLevel = new LinkedList<TreeNode>();
			while ((currentNode = currentLevel.poll()) != null) {
				currentLevelValues.add(currentNode.val);
				if (currentNode.left != null)
					nextLevel.add(currentNode.left);
				if (currentNode.right != null)
					nextLevel.add(currentNode.right);
			}
			result.add(currentLevelValues);
			currentLevel = nextLevel;
		}
		return result;
	}
}
