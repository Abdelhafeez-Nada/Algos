public class A12_QuickSortDesc {

    public static void main(String[] args) {

        int[] arr = new int[] { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

        print(arr);
        quickSortDesc(arr, 0, arr.length - 1);
        print(arr);
    }

    private static void quickSortDesc(int[] arr, int low, int high) {
        if (low >= high)
            return;
        int pIndex = partitionDesc(arr, low, high);
        quickSortDesc(arr, low, pIndex - 1);
        quickSortDesc(arr, pIndex + 1, high);
    }

    private static int partitionDesc(int[] arr, int low, int high) {
        int left = low + 1;
        int right = high;
        int pivot = arr[low];

        while (left <= right) {

            while (left <= right && arr[left] >= pivot) {
                left++;
            }
            while (left <= right && arr[right] < pivot) {
                right--;
            }
            if (left < right) {
                swap(arr, right, left);
            }
        }

        swap(arr, low, right);
        return right;

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void print(int[] arr) {
        for (int n : arr)
            System.out.print(n + " ");
        System.out.println();
    }
}
