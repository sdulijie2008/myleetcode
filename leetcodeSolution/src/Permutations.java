import java.util.ArrayList;

public class Permutations {
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		permuteHelper(result, num, 0);
		return result;
	}

	public void permuteHelper(ArrayList<ArrayList<Integer>> result, int[] num,
			int i) {
		if (i < 0)
			return;
		if (i == num.length) {
			ArrayList<Integer> permutation = arrayToArrayList(num);
			result.add(permutation);
		} else {
			for (int j = i; j < num.length; j++) {
				swap(num, i, j);
				permuteHelper(result, num, i + 1);
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

	public ArrayList<Integer> arrayToArrayList(int[] num) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i : num) {
			result.add(i);
		}
		return result;
	}
}
