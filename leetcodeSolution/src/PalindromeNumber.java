public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		if (x < 10) {
			return true;
		}

		int len = 0;
		while ((int) (x / Math.pow(10.0, len)) != 0) {
			len++;
		}
		for (int i = 0; i < len / 2; i++) {
			if ((int) (x / Math.pow(10.0, i)) % 10 != (int) (x / Math.pow(10.0,
					len - 1 - i)) % 10) {
				return false;
			}
		}

		return true;
	}
}
