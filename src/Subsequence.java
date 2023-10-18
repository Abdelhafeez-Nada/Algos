import java.util.ArrayList;

public class Subsequence {

    private static int[] arr = new int[] { 3, 1, 2 };

    public static void main(String[] args) {
        subR(0, new ArrayList<>());
    }

    private static void subR(int index, ArrayList<Integer> sub) {

        if (index >= arr.length) {
            printArr(sub, index);
            return;
        }
        sub.add(arr[index]);
        subR(index + 1, sub);

        sub.remove(sub.size() - 1);
        subR(index + 1, sub);

    }

    private static void printArr(ArrayList<Integer> sub, int i) {

        System.out.println("Index: " + i);
        for (int n : sub) {
            System.out.print(n + " ");
        }
        System.out.println("\n-----------------\n");
    }

}
