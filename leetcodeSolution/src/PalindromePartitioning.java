import java.util.ArrayList;

public class PalindromePartitioning {
	public ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();

	public ArrayList<ArrayList<String>> partition(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		res = new ArrayList<ArrayList<String>>();
		if (s.length() == 0) {
			return res;
		}
		ArrayList<String> sol = new ArrayList<String>();
		dfs(s, 0, sol);
		return res;
	}

	public void dfs(String s, int b, ArrayList<String> sol) {
		if (b >= s.length()) {
			res.add(new ArrayList<String>(sol));
		}
		for (int i = b; i <= s.length() - 1; i++) {
			if (isPalindrome(s, b, i)) {
				sol.add(s.substring(b, i + 1));
				dfs(s, i + 1, sol);
				sol.remove(sol.size() - 1);
			}
		}
	}

	public boolean isPalindrome(String s, int b, int e) {
		if (b > e) {
			return false;
		}
		while (b < e) {
			if (s.charAt(b) != s.charAt(e)) {
				return false;
			}
			b++;
			e--;
		}
		return true;
	}
}
