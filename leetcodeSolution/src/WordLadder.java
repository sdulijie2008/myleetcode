import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadder {
	public int ladderLength(String start, String end, HashSet<String> dict) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (dict.isEmpty()) {
			return 0;
		}
		int currentLevel = 1, nextLevel = 0;
		int steps = 0;
		boolean found = false;
		HashSet<String> visited = new HashSet<String>();

		Queue<String> q = new LinkedList<String>();
		q.add(start);
		while (!q.isEmpty()) {
			String st = q.remove();
			currentLevel--;
			if (st.equals(end)) {
				steps++;
				found = true;
				break;
			} else {
				for (int i = 0; i < st.length(); i++) {
					StringBuffer sb = new StringBuffer(st);
					for (int j = 0; j < 26; j++) {
						sb.setCharAt(i, (char) ('a' + j));
						String next = sb.toString();
						if (dict.contains(next) && !visited.contains(next)) {
							q.add(next);
							visited.add(next);
							nextLevel++;
						}
					}
				}
			}
			if (currentLevel == 0) {
				steps++;
				currentLevel = nextLevel;
				nextLevel = 0;
			}
		}

		return found ? steps : 0;
	}
}
