public class LinkedListCycle {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public boolean hasCycle(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(head == null) // list does not exist..so no loop either.
        return false;

    ListNode slow, fast; // create two references.

    slow = fast = head; // make both refer to the start of the list.

    while(true) {

        slow = slow.next;          // 1 hop.

        if(fast.next != null)
            fast = fast.next.next; // 2 hops.
        else
            return false;          // next node null => no loop.

        if(slow == null || fast == null) // if either hits null..no loop.
            return false;

        if(slow == fast) // if the two ever meet...we must have a loop.
            return true;
    }
    }
}
