public class RemoveDuplicatesFromSortedList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode currentNode = head;
		ListNode nextNode = head.next;
		int currentVal = currentNode.val;
		while (nextNode != null) {
			while (nextNode != null && nextNode.val == currentVal) {
				currentNode.next = nextNode.next;
				nextNode = currentNode.next;
			}
			if (nextNode != null) {
				currentNode = nextNode;
				nextNode = nextNode.next;
				currentVal = currentNode.val;
			}
		}
		return head;
	}
}
