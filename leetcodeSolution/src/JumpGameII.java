public class JumpGameII {
	public int jump(int[] A) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		int[] steps = new int[A.length];
		int limit = 0;// reachable range *
		steps[0] = 0;

		for (int i = 0; i < A.length - 1; i++) {
			if (A[i] + i > limit) {
				if (A[i] + i >= A.length - 1) {
					return steps[i] + 1;
				}
				for (int j = limit + 1; j <= i + A[i] && j <= A.length - 1; j++) {
					steps[j] = steps[i] + 1;
				}
				limit = A[i] + i;

			}

		}

		return steps[A.length - 1];
	}
}
