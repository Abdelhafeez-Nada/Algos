public class ReverseArray {

    public static void main(String[] args) {
        int[] arr = reverse(0, new int[] { 1, 2, 3, 4, 5, 6 });
        for (int num : arr) {
            System.out.println(num);
        }
    }

    private static int[] reverse(int i, int[] arr) {
        if (i >= arr.length / 2)
            return arr;
        swap(i, arr.length - i - 1, arr);
        return reverse(i + 1, arr);
    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
