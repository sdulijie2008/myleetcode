public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		if (head == null) // list does not exist..so no loop either.
			return null;

		ListNode fast, slow;
		slow = fast = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow)
				break;

		}
		// no cycle
		if (fast == null || fast.next == null)
			return null;
		fast = head;
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
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
