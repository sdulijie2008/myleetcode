public class MaximumSubarray {
	public int maxSubArray(int[] A) {
		int currentMaxSum = 0;
		int totalMaxSum = Integer.MIN_VALUE;
		for (int num : A) {
			currentMaxSum = Math.max(currentMaxSum + num, num);
			totalMaxSum = Math.max(currentMaxSum, totalMaxSum);
		}
		return totalMaxSum;
	}
}
