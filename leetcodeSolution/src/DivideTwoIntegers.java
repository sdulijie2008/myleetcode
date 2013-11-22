public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (dividend == 0) {
			return 0;
		}
		long a = dividend;
		long b = divisor;
		boolean neg = false; // used to indicate whether the result is positive
								// or negative
		int result = 0;
		neg = dividend < 0 ? !neg : neg;
		neg = divisor < 0 ? !neg : neg;

		a = Math.abs(a);
		b = Math.abs(b);

		int c = 0;// c is the number of digits moved
		while (b << c <= a) {
			c++;
		}

		while (c >= 0) {
			if (b << c <= a) {
				a -= b << c;
				result |= 1 << c;
			}
			c--;
		}
		if (neg) {
			result = -result;
		}
		return result;
	}
}
