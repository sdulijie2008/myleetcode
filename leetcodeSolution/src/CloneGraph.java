import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class CloneGraph {
	class UndirectedGraphNode {
		int label;
		ArrayList<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	}

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.

		if (node == null)
			return node;

		Hashtable<UndirectedGraphNode, UndirectedGraphNode> cloneNodes = new Hashtable<UndirectedGraphNode, UndirectedGraphNode>();

		Queue<UndirectedGraphNode> remainNodes = new LinkedList<UndirectedGraphNode>();
		remainNodes.add(node);
		UndirectedGraphNode current = null;
		while ((current = remainNodes.poll()) != null) {
			cloneNodes.put(current, new UndirectedGraphNode(current.label));
			for (UndirectedGraphNode neighbor : current.neighbors) {
				if (!cloneNodes.containsKey(neighbor)) {
					remainNodes.add(neighbor);
				}
			}
		}

		ArrayList<UndirectedGraphNode> neighbors = null;

		for (Iterator it = cloneNodes.keySet().iterator(); it.hasNext();) {
			neighbors = new ArrayList<UndirectedGraphNode>();
			UndirectedGraphNode currentNode = (UndirectedGraphNode) it.next();
			ArrayList<UndirectedGraphNode> originalNeighbors = currentNode.neighbors;
			for (UndirectedGraphNode neighbor : originalNeighbors) {
				neighbors.add(cloneNodes.get(neighbor));
			}
			cloneNodes.get(currentNode).neighbors = neighbors;
		}

		return cloneNodes.get(node);
	}

}
