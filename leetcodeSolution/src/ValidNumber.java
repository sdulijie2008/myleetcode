
public class ValidNumber {
	public boolean isNumber(String s) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		s = s.trim();
		if (s == null || s.length() == 0) {
			return false;
		}

		boolean num = false; // is a digit
		boolean dot = false; // is a dot
		boolean e = false; // is a e

		for (int k = 0; k <= s.length() - 1; k++) {
			char c = s.charAt(k);
			if (Character.isDigit(c)) {
				num = true;
			} else if (c == '.') {
				if (e || dot) {
					return false;
				}
				dot = true;
			} else if (c == 'e') {
				if (e || !num) {
					return false;
				}
				e = true;
				num = false;
			} else if (c == '+' || c == '-') {
				if (k != 0 && s.charAt(k - 1) != 'e') {
					return false;
				}
			} else {
				return false;
			}

		}
		return num;
	}
}
