public class MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		int a = m - 1;
		int b = n - 1;
		int c = m + n - 1;
		while (c >= 0) {
			if (a >= 0 && b >= 0) {
				A[c] = A[a] > B[b] ? A[a--] : B[b--];
			} else if (a < 0)
				A[c] = B[b--];
			else
				A[c] = A[a--];
			c--;
		}
	}
}
