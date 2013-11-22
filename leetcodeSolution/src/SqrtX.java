public class SqrtX {
	public int sqrt(int x) {
		int left = 1, right = x / 2;
		int mid = 0;
		int last_mid = 0;

		if (x < 2)
			return x;
		while (left <= right) {
			mid = (left + right) / 2;
			if (x / mid > mid) {
				left = mid + 1;
				last_mid = mid;
			} else if (x / mid < mid) {
				right = mid - 1;
			} else
				return mid;
		}
		return last_mid;
	}
}
