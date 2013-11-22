import java.util.ArrayList;

public class Combinations {
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		ArrayList<ArrayList<Integer>> combinations = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> current = new ArrayList<Integer>();
		combineHelper(combinations, current, n, 1, k);
		return combinations;
	}

	private void combineHelper(ArrayList<ArrayList<Integer>> combinations,
			ArrayList<Integer> current, int n, int start, int k) {
		if (current.size() == k) {
			combinations.add(new ArrayList<Integer>(current));
			return;
		}
		if (start > n)
			return;
		current.add(start);
		combineHelper(combinations, current, n, start + 1, k);
		current.remove(current.size() - 1);
		combineHelper(combinations, current, n, start + 1, k);
	}
}
