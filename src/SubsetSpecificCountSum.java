import java.util.ArrayList;
import java.util.List;

public class SubsetSpecificCountSum {

    private static int[] nums = new int[] { 1, 2, 1 };

    public static void main(String[] args) {
        int count = subset(0, new ArrayList<>(), 0, 2);
        System.out.println("\nCount: " + count);
    }

    private static int subset(int index, List<Integer> sub, int currentSum, int sum) {

        if (index >= nums.length) {
            if (currentSum == sum) {
                printArr(sub);
                return 1;
            }
            return 0;
        }

        // PICK
        sub.add(nums[index]);
        currentSum += nums[index];
        int c1 = subset(index + 1, sub, currentSum, sum);

        // NOT PICK
        currentSum -= sub.get(sub.size() - 1);
        sub.remove(sub.size() - 1);
        int c2 = subset(index + 1, sub, currentSum, sum);

        return c1 + c2;
    }

    private static void printArr(List<Integer> sub) {

        for (int n : sub) {
            System.out.print(n + " ");
        }
        System.out.println("\n-----------------\n");
    }
}
