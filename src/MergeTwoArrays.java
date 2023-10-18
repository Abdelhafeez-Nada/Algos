public class MergeTwoArrays {

    public static void main(String[] args) {

        int[] a = new int[] { 1, 2, 4, 9 };
        int[] b = new int[] { 12, 13, 14, 17, 18 };

        int[] merged = merge(a, b);
        printArr(merged);

    }

    private static int[] merge(int[] a, int[] b) {
        int[] merged = new int[a.length + b.length];

        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                merged[k] = a[i];
                i++;
            } else {
                merged[k] = b[j];
                j++;
            }
            k++;
        }
        while (i < a.length) {
            merged[k] = a[i];
            i++;
            k++;
        }

        while (j < b.length) {
            merged[k] = b[j];
            j++;
            k++;
        }

        return merged;
    }

    private static void printArr(int[] sub) {

        for (int n : sub) {
            System.out.print(n + " ");
        }
        System.out.println("\n-----------------\n");
    }
}
