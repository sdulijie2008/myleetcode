public class Candy {
	public int candy(int[] ratings) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		int rLen = ratings.length;
		if (rLen == 0)
			return 0;
		int min = rLen;
		int give = 0;
		int[] gives = new int[rLen];
		for (int i = 1; i < rLen; i++) {
			if (ratings[i] > ratings[i - 1])
				give++;
			else
				give = 0;
			gives[i] = give;
		}
		give = 0;
		for (int i = rLen - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1])
				give++;
			else
				give = 0;
			min += Math.max(give, gives[i]);
		}
		min += gives[rLen - 1];
		return min;
	}
}
