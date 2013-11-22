public class NQueensII {
	public int result;

	public int totalNQueens(int n) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		result = 0;
		if (n <= 0)
			return 0;
		int[] sol = new int[n];
		placeQueen(sol, 0);
		return result;
	}

	public void placeQueen(int[] sol, int row) {
		int n = sol.length;
		if (row == n) {
			++result;
			return;
		}
		for (int i = 0; i < n; ++i) {
			if (feasible(sol, row, i)) {
				sol[row] = i;
				placeQueen(sol, row + 1);
			}
		}
	}

	public boolean feasible(int[] sol, int row, int col) {
		for (int i = 0; i < row; ++i) {
			if (sol[i] == col)
				return false;
			if (row - i == Math.abs(col - sol[i]))
				return false;
		}
		return true;
	}
}
