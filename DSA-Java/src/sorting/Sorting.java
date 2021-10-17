package sorting;

public class Sorting {

	public static void main(String[] args) {
		int[] arr = { 5, 2, 1, 6, 3, 4 };

//		bubbleSort(arr);

//		insertionSort(arr);

//		selectionSort(arr);

//		quickSort(arr, 0, arr.length - 1);

//		mergeSort(arr, 0, arr.length - 1);

		heapSort(arr);

		arrayPrinter(arr);
	}

	/**
	 * @BubbleSort: Compare two adjacent elements until all sorted.
	 * 
	 * @time O(N^2) Time - N is the length of the array
	 * @space O(1) Space
	 * 
	 */
	static void bubbleSort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	/**
	 * @InsertionSort: Compare element with its preceding elements & move it to its
	 *                 right position.
	 * 
	 * @time O(N^2) Time - N is the length of the array
	 * @space O(1) Space
	 * 
	 */
	static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int prev = i - 1;
			while (prev >= 0 && arr[prev] > key) {
				arr[prev + 1] = arr[prev];
				prev -= 1;
			}
			arr[prev + 1] = key;
		}
	}

	/**
	 * @SelectionSort: find the lowest element & bring it to its position.
	 * 
	 * @time O(N^2) Time - N is the length of the array
	 * @space O(1) Space
	 * 
	 */
	static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int pos = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[pos])
					pos = j;
			}
			if (pos != i) {
				int temp = arr[pos];
				arr[pos] = arr[i];
				arr[i] = temp;
			}
		}
	}

	/**
	 * @QuickSort: find the pivot element & move its lowest to left & highest to
	 *             right.
	 * 
	 * @time O(N*logN) Time - N is the length of the array
	 * @space O(1) Space
	 * 
	 */
	static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int p = partitioning(arr, low, high);

			quickSort(arr, low, p - 1);
			quickSort(arr, p + 1, high);
		}
	}

	/**
	 * @QuickSort partitioning function.
	 * 
	 */
	static int partitioning(int[] arr, int low, int high) {
		int pivot = arr[high];
		int pos = low - 1;

		for (int curr = low; curr < high; curr++) {
			if (arr[curr] <= pivot) {
				pos++;

				int temp = arr[pos];
				arr[pos] = arr[curr];
				arr[curr] = temp;
			}
		}

		int temp = arr[pos + 1];
		arr[pos + 1] = arr[high];
		arr[high] = temp;

		return pos + 1;
	}

	/**
	 * @MergeSort: Divide the array into two until two elements left & while merging
	 *             compare & place.
	 * 
	 * @time O(N*logN) Time - N is the length of the array
	 * @space O(N) Space - N is the length of the array
	 * 
	 */
	static void mergeSort(int[] arr, int low, int high) {
		if (low < high) {

			int mid = low + (high - low) / 2;

			mergeSort(arr, low, mid);
			mergeSort(arr, mid + 1, high);

			merger(arr, low, mid, high);

		}
	}

	/**
	 * @QuickSort merging function.
	 * 
	 */
	static void merger(int arr[], int low, int mid, int high) {
		int n1 = mid - low + 1;
		int n2 = high - mid;

		int[] A1 = new int[n1];
		int[] A2 = new int[n2];

		for (int i = 0; i < n1; i++) {
			A1[i] = arr[low + i];
		}
		for (int i = 0; i < n2; i++) {
			A2[i] = arr[mid + 1 + i];
		}

		int i = 0, j = 0, k = low;

		while (i < n1 && j < n2) {
			if (A1[i] <= A2[j]) {
				arr[k] = A1[i++];
			} else {
				arr[k] = A2[j++];
			}
			k++;
		}

		while (i < n1) {
			arr[k++] = A1[i++];
		}

		while (j < n2) {
			arr[k++] = A2[j++];
		}
	}

	/**
	 * @HeapSort: Create the heap & remove the largest element from heap & insert in
	 *            sorted array.
	 * 
	 * @time O(N*logN) Time - N is the length of the array
	 * @space O(1) Space - N is the length of the array
	 * 
	 */
	static void heapSort(int[] arr) {
		int len = arr.length;

		for (int i = len / 2 - 1; i >= 0; i--)
			heapify(arr, len, i);

		for (int i = len - 1; i >= 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			heapify(arr, i, 0);
		}
	}

	/**
	 * @HeapSort heapify function.
	 * 
	 */
	static void heapify(int[] arr, int len, int root) {
		int largest = root;
		int left = 2 * root + 1;
		int right = 2 * root + 2;

		if (left < len && arr[left] > arr[largest])
			largest = left;

		if (right < len && arr[right] > arr[largest])
			largest = right;

		if (largest != root) {
			int temp = arr[root];
			arr[root] = arr[largest];
			arr[largest] = temp;

			heapify(arr, len, largest);
		}
	}

	static void arrayPrinter(int[] arr) {
		for (int a : arr) {
			System.out.print(a + " ");
		}
		System.out.println();
	}
}
