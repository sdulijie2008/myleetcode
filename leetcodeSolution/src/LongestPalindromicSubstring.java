public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (s == null || s.length() == 0)
			return s;
		String lp = s.substring(0, 1);
		for (int i = 1; i < s.length(); i++) {
			String lp1 = find_prolindrome(s, i - 1, i);
			String lp2 = find_prolindrome(s, i - 1, i + 1);
			String longer = lp1.length() > lp2.length() ? lp1 : lp2;
			lp = longer.length() > lp.length() ? longer : lp;
		}
		return lp;

	}

	public String find_prolindrome(String s, int p, int q) {
		if (q < s.length() && s.charAt(p) == s.charAt(q)) {
			while (p - 1 >= 0 && q + 1 < s.length()
					&& s.charAt(p - 1) == s.charAt(q + 1)) {
				p--;
				q++;
			}

			return s.substring(p, q + 1);
		}
		return "";
	}
}
