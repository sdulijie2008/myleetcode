public class MedianOfTwoSortedArray {

	public double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length;
		int n = B.length;
		int median1 = (m + n) / 2 + 1;
		int median2 = (m + n - 1) / 2 + 1;
		return (findKth(A, 0, m, B, 0, n, median1) + findKth(A, 0, m, B, 0, n,
				median2)) / 2f;
	}

	private int findKth(int a[], int as, int ae, int b[], int bs, int be, int k) {
		int m = ae - as;
		int n = be - bs;
		if (m == 0) {
			return b[bs + k - 1];
		} else if (n == 0) {
			return a[as + k - 1];
		}
		if (m == 1 && n == 1) {
			if (k == 1) {
				return Math.min(a[as], b[bs]);
			} else {
				return Math.max(a[as], b[bs]);
			}
		}
		if (k == m + n) {
			return Math.max(a[ae - 1], b[be - 1]);
		}
		float ratio = k * m * 1f / (m + n);
		int i = Math.round(m * ratio);
		i = fit(i, 0, m - 1);
		i = fit(i, k - 1 - n, k - 1);
		int j = k - 1 - i;
		if (a[as + i] > b[bs + j]) {
			return findKth(a, as, as + i, b, bs + j, be, k - j);
		} else {
			return findKth(a, as + i, ae, b, bs, bs + j, k - i);
		}
	}

	private int fit(int a, int lower, int upper) {
		if (a < lower)
			return lower;
		else if (a > upper)
			return upper;
		else
			return a;
	}

	public double findMedianSortedArrays2(int A[], int B[]) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		return findMedianHelper(A, B, Math.max(0, (A.length - B.length) / 2),
				Math.min(A.length - 1, (A.length + B.length) / 2));
	}

	public double findMedianHelper(int A[], int B[], int l, int r) {
		int m = A.length;
		int n = B.length;

		if (l > r)
			return findMedianHelper(B, A, Math.max(0, (n - m) / 2),
					Math.min(n - 1, (m + n) / 2));
		int i = (l + r) / 2;
		int j = (m + n) / 2 - i;

		assert (i >= 0 && i <= m && j >= 0 && j <= n);
		int Ai_1 = ((i == 0) ? Integer.MIN_VALUE : A[i - 1]);
		int Bj_1 = ((j == 0) ? Integer.MIN_VALUE : B[j - 1]);
		int Ai = ((i == m) ? Integer.MAX_VALUE : A[i]);
		int Bj = ((j == n) ? Integer.MAX_VALUE : B[j]);

		if (Ai < Bj_1)
			return findMedianHelper(A, B, i + 1, r);
		if (Ai > Bj)
			return findMedianHelper(A, B, l, i - 1);

		if (((m + n) % 2) == 1)
			return A[i];
		return (Math.max(Ai_1, Bj_1) + Ai) / 2.0;
	}
}
