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
		return;
	} // dummy code

	/**
	 * Sort from a[low] to a[high] using insertion sort.
	 */
	private static void insertionsort(int[] a, int low, int high) {
		return;
	} // dummy code

    /**
     * Swap two integers.
     */
    private static void swap(int a, int b) {
        int tmp = a;
        a = b;
        b = tmp;
    }
}
