public class PopulatingNextRightPointersInEachNode {
	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	public void connect(TreeLinkNode root) {

		TreeLinkNode leftWall = root;
		while (leftWall != null) {

			TreeLinkNode across = leftWall;
			while (across != null) {
				if (across.left != null) {
					across.left.next = across.right;
				}

				if (across.right != null && across.next != null) {
					across.right.next = across.next.left;
				}

				across = across.next;
			}
			leftWall = leftWall.left;
		}

	}
}
