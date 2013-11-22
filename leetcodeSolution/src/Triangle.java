import java.util.ArrayList;

public class Triangle {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		for (int i = triangle.size() - 2; i >= 0; --i) {
			for (int j = 0; j < i + 1; ++j) {
				int original = triangle.get(i).get(j);
				triangle.get(i).set(
						j,
						original
								+ Math.min(triangle.get(i + 1).get(j), triangle
										.get(i + 1).get(j + 1)));
			}
		}
		return triangle.get(0).get(0);
	}
}
