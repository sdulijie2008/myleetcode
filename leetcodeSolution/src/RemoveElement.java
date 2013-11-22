public class RemoveElement {
	public int removeElement(int[] A, int elem) {
		int j = 0;
		for (int i = 0; i < A.length; ++i) {
			while (i < A.length && A[i] == elem)
				++i;
			if (i == A.length)
				break;
			A[j++] = A[i];
		}
		return j;
	}
}
