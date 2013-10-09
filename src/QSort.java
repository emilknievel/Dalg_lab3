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
    private static int partition(int[] a, int low, int high, int pivot) {

	int pivotValue = a[pivot];
	arraySwap(a, pivot, high); // move pivot to end
	int storeIndex = low;
	for (int i = low; i < high; i++) {
	    if (a[i] <= pivotValue) {
		arraySwap(a, i, storeIndex);
		storeIndex += 1;
	    }
	}
	arraySwap(a, storeIndex, high); // pivot to final place
	return storeIndex;
    }

    /**
     * Return the median of three integers.
     */
    private static int medianOfThree(int[] a, int low, int high) {
	int center = low + (high - low) / 2;

	if (a[low] > a[center])
	    swap(low, center);
	// order low & high
	if (a[low] > a[high])
	    swap(low, high);
	// order center & high
	if (a[center] > a[high])
	    swap(center, high);

	return center;
    }

    /**
     * Swap two integers.
     */
    private static void swap(int a, int b) {
	int tmp = a;
	a = b;
	b = tmp;
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
