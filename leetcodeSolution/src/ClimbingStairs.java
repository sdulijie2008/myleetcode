public class ClimbingStairs {
	public int climbStairs(int n) {
		int[] results = new int[n + 1];
		if (n < 2)
			return n;
		results[0] = 0;
		results[1] = 1;
		for (int i = 2; i < n + 1; ++i) {
			results[i] = results[i - 2] + results[i - 1];
		}
		return results[n] + results[n - 1];
	}
}
