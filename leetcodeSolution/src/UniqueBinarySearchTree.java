public class UniqueBinarySearchTree {

	public int numTrees3(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int[] numberOfTrees = new int[n+1];
        numberOfTrees[0] = 1;
        numberOfTrees[1] = 1;
        for(int i = 2; i<=n; ++i){
            for(int k = 1; k<=i; ++k){
                numberOfTrees[i] += numberOfTrees[k-1] *numberOfTrees[i-k];
            }
        }
        return numberOfTrees[n];
     }
	
	public int numTrees2(int n) {
		int c = 1;
		for (int i = 2; i <= n; i++)
			c = 2 * (2 * i - 1) * c / (i + 1);
		return c;
	}

	public int numTrees(int n) {
		if (n <= 1) {
			return n;
		}
		// Start typing your Java solution below
		// DO NOT write main() function
		return helper(1, n);
	}

	public int helper(int start, int end) {
		if (start >= end) {
			return 1;
		}

		int result = 0;
		for (int i = start; i <= end; i++) {
			result += helper(start, i - 1) * helper(i + 1, end);
		}
		return result;
	}
}
