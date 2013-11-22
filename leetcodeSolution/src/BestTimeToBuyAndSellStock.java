public class BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (prices == null || prices.length == 0)
			return 0;

		int bot = prices[0];
		int maxProfit = 0;
		for (int i = 1; i < prices.length; ++i) {
			if (prices[i] < bot)
				bot = prices[i];
			else {
				if (prices[i] - bot > maxProfit)
					maxProfit = prices[i] - bot;
			}
		}
		return maxProfit;
	}
}
