import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstring(String s) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.

		if (s.length() == 0)
			return 0;
		int i = 0, j = 0;
		int result = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		while (j < s.length()) {
			Integer c = new Integer(s.charAt(j));
			if (!map.containsKey(c)) {
				map.put(c, j);
			} else {
				int length = j - i;
				if (result < length) {
					result = length;
				}
				Integer index = map.get(c);
				i = Math.max(i, index + 1);
				map.put(c, j);
			}
			j++;
		}

		if (result < j - i)
			return j - i;
		else
			return result;
	}
}
