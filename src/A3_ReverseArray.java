public class A3_ReverseArray {

    public static void main(String[] args) {

        Util.printArr(loopRev(new int[] { 1, 2, 3, 4, 5 }));
        Util.printArr(recRev(0, new int[] { 1, 2, 3, 4, 5 }));
    }

    // loop and two pointers

    private static int[] loopRev(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (right > left) {
            Util.swap(arr, left, right);
            right--;
            left++;
        }

        return arr;
    }

    // recursion two pointers

    private static int[] recRev(int left, int[] arr) {

        if (left >= arr.length - left - 1)
            return arr;
        Util.swap(arr, left, arr.length - left - 1);
        return recRev(left + 1, arr);
    }

}
