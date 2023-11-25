import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPermutations {

    public static void main(String[] args) {

        int[] nums = new int[] { 3, 3, 0, 3 };

        List<List<Integer>> ans = permute(nums);
        System.out.println("SIZE: " + ans.size());

        printResult(ans);

    }

    private static List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        boolean[] map = new boolean[nums.length];
        List<List<Integer>> ans = new ArrayList<>();
        return backtrack(nums, map, new ArrayList<>(), ans);
    }

    private static List<List<Integer>> backtrack(int[] nums, boolean[] map, List<Integer> perm,
            List<List<Integer>> ans) {

        if (perm.size() == nums.length) {
            ans.add(new ArrayList<>(perm));
            return ans;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!map[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && !map[i - 1]) {
                    // Skip duplicate elements to ensure uniqueness
                    continue;
                }
                perm.add(nums[i]);
                map[i] = true;
                backtrack(nums, map, perm, ans);

                perm.remove(perm.size() - 1);
                map[i] = false;
            }
        }

        return ans;

    }

    private static void printResult(List<List<Integer>> result) {
        for (List<Integer> comb : result) {
            for (int n : comb) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
