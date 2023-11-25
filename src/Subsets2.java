import java.util.ArrayList;
import java.util.List;

public class Subsets2 {

    public static void main(String[] args) {
        int[] nums = new int[] { 4, 4, 4, 1, 4 };

        List<List<Integer>> result = bactrack(nums, 0, new ArrayList<>(), new ArrayList<>());

        printResult(result);
    }

    private static List<List<Integer>> bactrack(int[] nums, int index, List<Integer> sub, List<List<Integer>> result) {

        result.add(new ArrayList<>(sub));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            sub.add(nums[i]);
            bactrack(nums, i + 1, sub, result);
            sub.remove(sub.size() - 1);
        }
        return result;
    }
    // result.add(new ArrayList<>(sub));

    // for (int i = index; i < nums.length; i++) {
    // if (i > index && nums[i] == nums[i - 1]) {
    // continue;
    // }

    // sub.add(nums[i]);
    // backtrack(nums, i + 1, sub, result);
    // sub.remove(sub.size() - 1);

    private static void printResult(List<List<Integer>> result) {
        for (List<Integer> comb : result) {
            for (int n : comb) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
