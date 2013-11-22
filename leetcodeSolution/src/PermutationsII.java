import java.util.ArrayList;
import java.util.Hashtable;

public class PermutationsII {
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		Hashtable<String, Boolean> occur = new Hashtable<String, Boolean>();
		permuteHelper(result, num, 0, occur);
		return result;
	}

	public void permuteHelper(ArrayList<ArrayList<Integer>> result, int[] num,
			int i, Hashtable<String, Boolean> occur) {
		if (i < 0) {
			return;
		}
		if (i == num.length) {
			ArrayList<Integer> permutation = arrayToArrayList(num);
			String perm = arrayToString(num);
			if (!occur.containsKey(perm)) {
				result.add(permutation);
				occur.put(perm, true);
			}
		} else {
			for (int j = i; j < num.length; j++) {
				swap(num, i, j);
				permuteHelper(result, num, i + 1, occur);
				swap(num, i, j);
			}

		}
		return;
	}

	public void swap(int[] num, int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

	public String arrayToString(int[] num) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < num.length; i++) {
			sb.append(String.valueOf(num[i]));
		}
		return sb.toString();
	}

	public ArrayList<Integer> arrayToArrayList(int[] num) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < num.length; i++) {
			result.add(num[i]);
		}
		return result;
	}
}
