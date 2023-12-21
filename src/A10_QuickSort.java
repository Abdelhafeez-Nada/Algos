public class A10_QuickSort {

    public static void main(String[] args) {

        int[] arr = new int[] { 4, 3, 8, 4, 6, 5 };
        // int[] arr = new int[] {1,2,3};
        print(arr);
        // int p = partition(arr, 0, arr.length - 1);
        // System.out.println(p);
        quickSort(arr, 0, arr.length - 1);
        print(arr);

    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low >= high)
            return;
        int partition = partition(arr, low, high);
        quickSort(arr, low, partition - 1);
        quickSort(arr, partition + 1, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low + 1;
        int j = high;

        while (i <= j) {
            while (i <= j && arr[i] <= pivot) {
                i++;
                System.out.println("i++ >> " + i);
            }

            while (i <= j && arr[j] > pivot) {
                j--;
                System.out.println("j-- >> " + j);
            }

            if (i < j) {
                swap(arr, i, j);
            }
        }

        swap(arr, low, j);
        return j;
    }

    // private static int partition(int[] arr, int low, int high) {
    // int pivot = arr[low];
    // int i = low;
    // int j = high;
    // int partition = 0;

    // while (i < j) {
    // if (!(arr[i] > pivot)) {
    // i++;
    // continue;
    // }

    // if (!(arr[j] <= pivot)) {
    // j--;
    // continue;
    // }
    // swap(arr, i, j);
    // partition = i;
    // }
    // swap(arr, partition, low);
    // return partition;
    // }

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
