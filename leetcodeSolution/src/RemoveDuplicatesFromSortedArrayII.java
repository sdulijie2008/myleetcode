public class RemoveDuplicatesFromSortedArrayII {

	public int removeDuplicates(int[] A) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		int length = A.length;
		if (length == 0)
			return 0;
		int index = 0;
		int amount = 1;
		for (int i = 1; i < length; ++i) {
			if (A[i] != A[index]) {
				A[++index] = A[i];
				amount = 1;
			} else if (amount < 2) {
				A[++index] = A[i];
				amount += 1;
			}
		}
		return index + 1;
	}
}
