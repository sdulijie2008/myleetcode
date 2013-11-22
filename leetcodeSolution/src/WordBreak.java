import java.util.Set;

public class WordBreak {

	public boolean wordBreak(String s, Set<String> dict) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		boolean[] f = new boolean[s.length() + 1];
		f[0] = true;
		for (int i = 0; i <= s.length(); i++)
			for (int j = 0; j < i; j++)
				if (f[j] && dict.contains(s.substring(j, i))) {
					f[i] = true;
					break;
				}
		return f[s.length()];
	}
}
