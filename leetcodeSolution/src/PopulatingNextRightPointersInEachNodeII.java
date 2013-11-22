public class PopulatingNextRightPointersInEachNodeII {
	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	public void connect(TreeLinkNode root) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (root == null) {
			return;
		}
		root.next = null;
		connectBFS(root);
		// connectDFS(root);
	}

	// BFS: travel level by level, from left to right
	public void connectBFS(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		TreeLinkNode newHead = null;// new head for next level
		while (root != null) {
			if (root.left != null) {
				root.left.next = getNextSibling(root, true);
				if (newHead == null) {
					newHead = root.left;
				}
			}
			if (root.right != null) {
				root.right.next = getNextSibling(root, false);
				if (newHead == null) {
					newHead = root.right;
				}
			}
			root = root.next;
		}
		connectBFS(newHead);
	}

	public TreeLinkNode getNextSibling(TreeLinkNode curNode, boolean isLeft) {
		if (curNode == null) {
			return null;
		}
		if (isLeft == true) {// if we are looking for a sibling of a left child
			if (curNode.right != null) {
				return curNode.right;
			}
		}
		while ((curNode = curNode.next) != null) {
			if (curNode.left != null) {
				return curNode.left;
			}
			if (curNode.right != null) {
				return curNode.right;
			}
		}
		return null;

	}
}
