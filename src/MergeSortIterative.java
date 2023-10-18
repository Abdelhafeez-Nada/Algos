public class MergeSortIterative {

    public static void main(String[] args) {

        int[] arr = new int[] { 8, 3, 7, 4, 9, 2, 12, 14, 17 };
        mergeSort(arr);
        printArr(arr);
    }

    private static void mergeSort(int[] arr) {

        int block;
        for (block = 2; block <= arr.length; block *= 2) {
            for (int i = 0; i < arr.length; i += block) {
                int low = i;
                int high = Math.min(i + block - 1, arr.length - 1);
                int mid = (low + high) / 2;
                merge(arr, low, mid, high);
            }
        }

        merge(arr, 0, (block / 2) - 1, arr.length - 1);

    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int l = low;
        int r = mid + 1;
        int k = 0;

        int[] temp = new int[high - low + 1]; // Adjust the size

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
