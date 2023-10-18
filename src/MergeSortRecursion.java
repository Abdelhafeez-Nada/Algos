public class MergeSortRecursion {

    public static void main(String[] args) {
        int[] arr = new int[] { 8, 3, 7, 4, 9, 2, 12, 14, 17 };
        mergeSort(arr, 0, arr.length - 1);
        printArr(arr);
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if (low >= high)
            return;
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {

        int[] temp = new int[high - low + 1];
        int r = mid + 1;
        int l = low;
        int k = 0;
        while (l <= mid && r <= high) {
            if (arr[l] <= arr[r]) {
                temp[k++] = arr[l++];
            } else {
                temp[k++] = arr[r++];
            }
        }
        while (l <= mid) {
            temp[k++] = arr[l++];
        }

        while (r <= high) {
            temp[k++] = arr[r++];
        }
        // transfering all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }
    }

    private static void printArr(int[] sub) {

        for (int n : sub) {
            System.out.print(n + " ");
        }
        System.out.println("\n-----------------\n");
    }
}
