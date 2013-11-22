public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		int row = matrix.length;
		if (row == 0)
			return 0;
		int col = matrix[0].length;
		int[][] map = new int[row][col];
		int area = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int prev = 0;
				if (i != 0) {
					prev = map[i - 1][j];
				}
				if (matrix[i][j] == '1') {
					map[i][j] = prev + 1;
				} else {
					map[i][j] = prev;
				}
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = i; j < row; j++) {
				int[] line = new int[col];
				for (int k = 0; k < col; k++) {
					line[k] = map[j][k] - map[i][k]
							+ (matrix[i][k] == '0' ? 0 : 1);
				}
				int l = 0;
				int tmp = 0;
				for (int f = 0; f < col; f++) {
					if (line[f] == j - i + 1)
						tmp++;
					else {
						if (tmp > l) {
							l = tmp;
						}
						tmp = 0;
					}
				}
				if (tmp > l) {
					l = tmp;
				}
				int s = (j - i + 1) * l;
				if (s > area) {
					area = s;
				}
			}
		}
		return area;
	}
}
