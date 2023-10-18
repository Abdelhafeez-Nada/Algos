import java.util.ArrayList;
import java.util.List;

public class SubsequenceII {

    // private static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {

        List<List<Integer>> result = backtrack(new int[] { 1, 2, 3 }, 0, new ArrayList<Integer>(), new ArrayList<>());

        for (List<Integer> l : result) {
            for (int n : l) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> backtrack(int[] nums, int index, List<Integer> sub, List<List<Integer>> result) {

        if (index >= nums.length) {
            result.add(new ArrayList<>(sub));
            return result;
        }

        sub.add(nums[index]);
        backtrack(nums, index + 1, sub, result);

        sub.remove(sub.size() - 1);
        backtrack(nums, index + 1, sub, result);

        return result;

    }
}
