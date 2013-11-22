public class TwoSum {

	public int[] twoSum(int[] numbers, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function

		int length = numbers.length;
		int[] newNumbers = new int[length];
		for (int i = 0; i < length; ++i) {
			newNumbers[i] = numbers[i];
		}
		mergeSort(numbers, 0, length - 1);
		int low = 0;
		int high = length - 1;
		while (low < high) {
			if (numbers[low] + numbers[high] > target) {
				--high;
			} else if (numbers[low] + numbers[high] < target) {
				++low;
			} else {
				break;
			}
		}
		int index1 = -2;
		int index2 = -1;
		int twoNumbers = 0;
		for (int i = 0; i < length; ++i) {
			if (newNumbers[i] == numbers[low] && -2 == index1) {
				index1 = i;
				if (++twoNumbers == 2) {
					break;
				}
				;
			} else if (newNumbers[i] == numbers[high] && -1 == index2) {
				index2 = i;
				if (++twoNumbers == 2) {
					break;
				}
			}

		}
		if (index1 > index2) {
			return new int[] { index2 + 1, index1 + 1 };
		} else {
			return new int[] { index1 + 1, index2 + 1 };
		}

	}

	public void mergeSort(int[] inputArray, int low, int high) {
		if (low < high) {
			int middle = (high + low) / 2;
			mergeSort(inputArray, low, middle);
			mergeSort(inputArray, middle + 1, high);
			merge(inputArray, low, middle, high);
		}
	}

	public void merge(int[] inputArray, int low, int middle, int high) {
		int[] temp = new int[high - low + 1];
		int index = 0;
		int i = low;
		int j = middle + 1;
		while (i <= middle && j <= high) {
			if (inputArray[i] < inputArray[j]) {
				temp[index] = inputArray[i];
				++index;
				++i;
			} else {
				temp[index] = inputArray[j];
				++index;
				++j;
			}
		}

		while (i <= middle) {
			temp[index] = inputArray[i];
			++index;
			++i;
		}

		while (j <= high) {
			temp[index] = inputArray[j];
			++index;
			++j;
		}

		for (int m = 0; m < high - low + 1; ++m) {
			inputArray[low + m] = temp[m];
		}
	}
}
