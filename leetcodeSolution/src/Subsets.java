import java.util.ArrayList;

public class Subsets {
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {

		java.util.Arrays.sort(S);
		ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> subset = new ArrayList<Integer>();
		subsetsHelper(S, 0, subsets, subset);
		return subsets;
	}

	private void subsetsHelper(int[] S, int off,
			ArrayList<ArrayList<Integer>> subsets, ArrayList<Integer> subset) {
		if (off == S.length) {
			subsets.add(new ArrayList<Integer>(subset));
			return;
		}
		subset.add(S[off]);
		subsetsHelper(S, off + 1, subsets, subset);
		subset.remove(subset.size() - 1);
		subsetsHelper(S, off + 1, subsets, subset);
	}
}
