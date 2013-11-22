public class DistinctSubsequences {
	public int numDistinct(String S, String T) {
		int[] results = new int[T.length() + 1];
		results[0] = 1;
		for (int i = 0; i < S.length(); ++i) {
			for (int j = T.length() - 1; j >= 0; --j)
				results[j + 1] += T.charAt(j) == S.charAt(i) ? results[j] : 0;
		}
		return results[T.length()];
	}
}
