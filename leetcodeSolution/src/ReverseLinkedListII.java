public class ReverseLinkedListII {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		ListNode dummyNode = new ListNode(0);
		dummyNode.next = head;
		ListNode p = dummyNode;
		ListNode endOfFirstList = null;
		ListNode startOfThirdList = null;
		ListNode endOfSecondList = null;
		int count = 0;
		while (count <= n) {
			if (count == m - 1)
				endOfFirstList = p;
			if (count == n) {
				endOfSecondList = p;
				startOfThirdList = p.next;
			}
			p = p.next;
			count++;
		}

		endOfSecondList.next = null;
		endOfSecondList = endOfFirstList.next;
		endOfFirstList.next = reverseLinkedList(endOfFirstList.next);
		endOfSecondList.next = startOfThirdList;
		return dummyNode.next;
	}

	private ListNode reverseLinkedList(ListNode head) {
		if (head == null)
			return head;
		ListNode prev = null;
		ListNode curr = head;

		while (curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
}
