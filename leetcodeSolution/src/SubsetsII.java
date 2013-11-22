import java.util.ArrayList;

public class SubsetsII {
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		java.util.Arrays.sort(num);
		ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> subset = new ArrayList<Integer>();
		subsetsHelper(num, 0, subsets, subset);
		return subsets;
	}

	private void subsetsHelper(int[] S, int off,
			ArrayList<ArrayList<Integer>> subsets, ArrayList<Integer> subset) {
		if (off == S.length) {
			subsets.add(new ArrayList<Integer>(subset));
			return;
		}
		if (subset.size() == 0
				|| (subset.size() != 0 && subset.get(subset.size() - 1) != S[off]))
			subsetsHelper(S, off + 1, subsets, subset);
		subset.add(S[off]);
		subsetsHelper(S, off + 1, subsets, subset);
		subset.remove(subset.size() - 1);
	}
}
