public class AddTwoNumbers {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.

		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		ListNode head = new ListNode(-1);
		ListNode current = head;

		ListNode currentInL1 = l1;
		ListNode currentInL2 = l2;

		int upperBit = 0;
		int total = 0;

		while (currentInL1 != null && currentInL2 != null) {
			total = currentInL1.val + currentInL2.val + upperBit;
			ListNode newNode = new ListNode(total % 10);
			current.next = newNode;
			current = current.next;
			upperBit = total > 9 ? 1 : 0;
			currentInL1 = currentInL1.next;
			currentInL2 = currentInL2.next;
		}

		while (currentInL1 != null) {
			total = currentInL1.val + upperBit;
			ListNode newNode = new ListNode(total % 10);
			current.next = newNode;
			current = current.next;
			upperBit = total > 9 ? 1 : 0;
			currentInL1 = currentInL1.next;
		}

		while (currentInL2 != null) {
			total = currentInL2.val + upperBit;
			ListNode newNode = new ListNode(total % 10);
			current.next = newNode;
			current = current.next;
			upperBit = total > 9 ? 1 : 0;
			currentInL2 = currentInL2.next;
		}

		if (upperBit == 1) {
			ListNode newNode = new ListNode(1);
			current.next = newNode;
		}

		return head.next;
	}
}
