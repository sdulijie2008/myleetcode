public class SingleNumber {

	public int singleNumber(int[] A) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		int result = 0;
		for (int i = 0; i < A.length; ++i) {
			result = result ^ A[i];
		}
		return result;
	}
}
