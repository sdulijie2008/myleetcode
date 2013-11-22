public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] A) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.

		if (A.length == 0) {
			return 0;
		}

		int i = 0;
		for (int j = 1; j < A.length; ++j) {
			if (A[j] != A[i]) {
				A[++i] = A[j];
			}
		}

		return i + 1;
	}
}
