public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (head == null)
			return head;
		ListNode prev = head;
		ListNode current = head.next;
		while (current != null) {
			if (current.val < head.val) {
				prev.next = current.next;
				current.next = head;
				head = current;
				current = prev.next;
				continue;
			}
			ListNode insertAfter = head;
			ListNode insertBefore = head.next;
			while (insertBefore.val < current.val) {
				insertAfter = insertBefore;
				insertBefore = insertBefore.next;
			}
			if (insertBefore == current) {
				prev = current;
				current = current.next;
				continue;
			}
			prev.next = current.next;
			current.next = insertBefore;
			insertAfter.next = current;
			current = prev.next;
		}
		return head;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
