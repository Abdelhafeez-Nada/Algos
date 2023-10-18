import java.util.ArrayList;
import java.util.List;

public class SubsetsAllWithSpecificSum {

    private static int[] nums = new int[] { 1, 2, 1 };

    public static void main(String[] args) {

        subset(0, new ArrayList<>(), 0, 3);
    }

    private static void subset(int index, List<Integer> sub, int currentSum, int sum) {

        if (index >= nums.length) {
            if (currentSum == sum) {
                printArr(sub);
            }
            return;
        }

        // PICK
        sub.add(nums[index]);
        currentSum += nums[index];

        subset(index + 1, sub, currentSum, sum);

        // NOT PICK
        currentSum -= sub.get(sub.size() - 1);
        sub.remove(sub.size() - 1);
        subset(index + 1, sub, currentSum, sum);

    }

    private static void printArr(List<Integer> sub) {

        for (int n : sub) {
            System.out.print(n + " ");
        }
        System.out.println("\n-----------------\n");
    }

}
