import java.util.ArrayList;
import java.util.List;

public class SubsetAllCount {

    private static int[] nums = new int[] { 1, 2, 1 };

    // private static int count = 0;

    public static void main(String[] args) {
        int count = subset(0, new ArrayList<>(), 0);
        System.out.println("\nCount: " + count);
    }

    private static int subset(int index, List<Integer> sub, int count) {

        if (index >= nums.length) {
            printArr(sub);
            return 1;
        }

        // PICK
        sub.add(nums[index]);
        int l = subset(index + 1, sub, count);

        // NOT PICK
        sub.remove(sub.size() - 1);
        int r = subset(index + 1, sub, count);

        return l + r;
    }

    private static void printArr(List<Integer> sub) {

        for (int n : sub) {
            System.out.print(n + " ");
        }
        System.out.println("\n-----------------\n");
    }

}
