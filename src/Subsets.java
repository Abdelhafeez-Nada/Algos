import java.util.ArrayList;
import java.util.List;

public class Subsets {

    private static int[] nums;

    private static List<List<Integer>> subsets = new ArrayList<>();

    public static void generateSubsets() {
        backtrack(new ArrayList<>(), 0);
    }

    private static void backtrack(List<Integer> subset, int index) {
        if (index == nums.length) {
            subsets.add(new ArrayList<>(subset));
            return;
        }
        // Include the current element
        subset.add(nums[index]);
        backtrack(subset, index + 1);
        // Exclude the current element
        subset.remove(subset.size() - 1);
        backtrack(subset, index + 1);
    }

    public static void main(String[] args) {
        nums = new int[] { 1, 2, 3 };
        generateSubsets();
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
