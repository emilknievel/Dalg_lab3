public class QSort {

    /**
     * Quicksort the array a[] using m as cutoff to insertion sort.
     */
    public static void quicksort(int[] a, int m) {
	quicksort(a, 0, a.length - 1, m);
    }

    /**
     * Quicksort the subarray a[low .. high].
     * Uses median-of-three partitioning
     * and a cutoff to insertion sort of m.
     */
    private static void quicksort(int[] a, int low, int high, int m) {
	if (high <= low + m) {
	    insertionsort(a, low, high);
	    return;
	}

	int median = medianOfThree(a, low, high);

	int index = partition(a, low, high, median);
	quicksort(a, low, index - 1, m);
	quicksort(a, index + 1, high, m);

    }

    /**
     * Partition the array.
     */
    private static int partition(int[] a, int low, int high, int pivotValue) {
	int left = low;
	int right = high - 1;
	while (left <= right) {
	    while (a[left] <= pivotValue) {
		left++;
	    }
	    while (a[right] >= pivotValue) {
		right--;
	    }
	    if (left < right) {
		arraySwap(a, left, right);
	    }
	}
	arraySwap(a, left, high);

	return left;
    }

    /**
     * Return the median of three integers.
     */
    private static int medianOfThree(int[] a, int low, int high) {
	int center = low + (high - low) / 2;

	if (a[low] > a[center])
	    arraySwap(a, low, center);
	// order low & high
	if (a[low] > a[high])
	    arraySwap(a, low, high);
	// order center & high
	if (a[center] < a[high])
	    arraySwap(a, center, high);

	return a[high]; // Returns center value that has been put at the end of the array
    }

    /**
     * Swap two array objects.
     */
    private static void arraySwap(int[] a, int x, int y) {
	int tmp = a[x];
	a[x] = a[y];
	a[y] = tmp;
    }

    /**
     * Sort from a[low] to a[high] using insertion sort.
     */
    private static void insertionsort(int[] a, int low, int high) {
	for (int i = low + 1; i <= high; i++) {
	    int cur = a[i];
	    int j = i - 1;
	    while ((j >= 0) && (a[j] > cur)) {
		a[j + 1] = a[j--];
	    }
	    a[j + 1] = cur;
	}
    }
}
