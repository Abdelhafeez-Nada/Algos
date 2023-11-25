public class Util {

    public static void swap(int[] arr, int left, int right) {

        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void printArr(int[] arr) {
        for (int n : arr)
            System.out.print(n + " ");
        System.out.println();
    }
}
