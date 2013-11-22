public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
		s = s.trim();
		if (s.length() == 0)
			return 0;
		int lastIndex = s.lastIndexOf(" ");
		return s.length() - 1 - lastIndex;
	}
}
