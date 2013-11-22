public class ReorderList {
	public void reorderList(ListNode head) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (head == null || head.next == null || head.next.next == null)
			return;
		int middle = (getLength(head) + 1) >> 1;
		ListNode middleNode = head;
		for (int i = 1; i < middle; ++i)
			middleNode = middleNode.next;
		ListNode secondPart = reverse(middleNode.next);
		middleNode.next = null;
		ListNode firstPart = head;
		ListNode firstPartNext = null;
		ListNode secondPartNext = null;
		for (int i = 0; i < middle; ++i) {
			firstPartNext = firstPart.next;
			if (secondPart != null)
				secondPartNext = secondPart.next;
			firstPart.next = secondPart;
			if (secondPart != null)
				secondPart.next = firstPartNext;
			firstPart = firstPartNext;
			secondPart = secondPartNext;
		}
	}

	private int getLength(ListNode head) {
		int i = 0;
		ListNode current = head;
		while (current != null) {
			++i;
			current = current.next;
		}
		return i;
	}

	private ListNode reverse(ListNode head) {
		if (head.next == null)
			return head;
		ListNode prev = head;
		ListNode current = head.next;
		ListNode next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			if (prev == head)
				prev.next = null;
			prev = current;
			current = next;
		}
		head = prev;
		return head;
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
