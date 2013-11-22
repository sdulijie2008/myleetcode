public class SearchInRotatedSortedArrayII {
	public boolean search(int[] A, int target) {
		int n = A.length;
		if (n == 0)
			return false;
		int start = 0;
		int end = n - 1;
		int middle = 0;
		while (start <= end) {
			middle = (start + end) >> 1;
			if (A[middle] == target)
				return true;
			if (A[start] < A[middle]) {
				if (A[start] <= target && A[middle] > target)
					end = middle - 1;
				else
					start = middle + 1;
			} else if (A[start] > A[middle]) {
				if (A[middle] < target && A[end] >= target)
					start = middle + 1;
				else
					end = middle - 1;
			} else
				start++;
		}
		return false;
	}
}
