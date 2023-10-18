public class MergeSingleArray {

    public static void main(String[] args) {

        int[] arr = new int[] { 1, 3, 5, 7, 2, 4, 6, 8 };
        int low = 0;
        int high = arr.length - 1;
        int mid = (low + high) / 2;
        int[] r = merge(arr, low, mid, high);
        printArr(r);
    }

    private static int[] merge(int[] arr, int low, int mid, int high) {
        int l = low;
        int r = mid + 1;
        int k = low;

        int[] temp = new int[high + 1];

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

        return temp;
    }

    private static void printArr(int[] sub) {

        for (int n : sub) {
            System.out.print(n + " ");
        }
        System.out.println("\n-----------------\n");
    }
}
