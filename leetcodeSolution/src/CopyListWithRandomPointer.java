import java.util.HashMap;

public class CopyListWithRandomPointer {

	class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	}

	public RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode currentNode = head;

		HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

		while (currentNode != null) {
			RandomListNode newNode = new RandomListNode(currentNode.label);
			map.put(currentNode, newNode);
			currentNode = currentNode.next;
		}

		currentNode = head;

		while (currentNode != null) {
			map.get(currentNode).next = map.get(currentNode.next);
			map.get(currentNode).random = map.get(currentNode.random);
			currentNode = currentNode.next;
		}

		return map.get(head);
	}
}
