public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		int begin = 0, end = A.length - 1, mid;
		while (begin <= end) {
			mid = (end + begin) >> 1;
			if (A[mid] == target)
				return mid;
			if (A[mid] < target)
				begin = mid + 1;
			else
				end = mid - 1;
		}
		return begin;
	}
}
