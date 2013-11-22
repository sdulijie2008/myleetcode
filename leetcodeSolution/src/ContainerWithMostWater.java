public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		if (height.length < 2)
			return 0;
		int most = 0;
		int start = 0;
		int end = height.length - 1;
		while (start < end) {
			int area = Math.min(height[start], height[end]) * (end - start);
			most = Math.max(area, most);
			if (height[start] <= height[end]) {
				++start;
			} else
				--end;
		}
		return most;
	}
}
