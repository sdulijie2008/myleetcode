import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClosest(int[] num, int target) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (num.length < 3)
			return Integer.MAX_VALUE;
		Arrays.sort(num);
		int close = num[0] + num[1] + num[2];
		for (int k = 0; k < num.length - 2; k++)
			for (int i = k + 1, j = num.length - 1; i < j;) {
				int temp = num[k] + num[i] + num[j];
				if (target == temp)
					return target;
				else if (Math.abs(target - temp) < Math.abs(target - close))
					close = temp;
				if (target < temp)
					j--;
				else
					i++;
			}
		return close;
	}
}
