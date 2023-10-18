import java.util.ArrayList;
import java.util.List;

public class SubsetsFirstWithSpecificSum {

    private static int[] nums = new int[] { 1, 2, 1 };

    public static void main(String[] args) {
        subset(0, new ArrayList<>(), 0, 3);
    }

    private static boolean subset(int index, List<Integer> sub, int currentSum, int sum) {

        if (index >= nums.length) {
            if (sum == currentSum) {
                printArr(sub);
                return true;
            }
            return false;
        }

        // PICK
        sub.add(nums[index]);
        currentSum += sub.get(sub.size() - 1);
        if (subset(index + 1, sub, currentSum, sum))
            return true;

        // NOT PICK
        currentSum -= sub.get(sub.size() - 1);
        sub.remove(sub.size() - 1);
        if (subset(index + 1, sub, currentSum, sum))
            return true;

        return false;
    }

    private static void printArr(List<Integer> sub) {

        for (int n : sub) {
            System.out.print(n + " ");
        }
        System.out.println("\n-----------------\n");
    }

}
