public class A11_MergeSortDesc {

    public static void main(String[] args) {

        int[] arr = new int[] { 1, 3, 5, 2, 4, 8, 6, 7, 5, 3 };
        print(arr);
        mergeSortDesc(arr, 0, arr.length - 1);
        print(arr);
    }

    private static void mergeSortDesc(int[] arr, int low, int high) {
        if (low >= high)
            return;
        int mid = low + (high - low) / 2;
        mergeSortDesc(arr, low, mid);
        mergeSortDesc(arr, mid + 1, high);
        mergeDesc(arr, low, mid, high);
    }

    private static void mergeDesc(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = 0;
        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if (arr[left] > arr[right]) {
                temp[i] = arr[left];
                i++;
                left++;
            } else {
                temp[i] = arr[right];
                i++;
                right++;
            }
        }
        while (left <= mid) {
            temp[i] = arr[left];
            i++;
            left++;
        }
        while (right <= high) {
            temp[i] = arr[right];
            i++;
            right++;
        }
        for (i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }
    }

    private static void print(int[] arr) {
        for (int n : arr)
            System.out.print(n + " ");
        System.out.println();
    }
}
