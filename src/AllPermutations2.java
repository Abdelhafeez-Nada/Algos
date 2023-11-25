import java.util.ArrayList;
import java.util.List;

public class AllPermutations2 {

    public static void main(String[] args) {

        List<List<Integer>> ans = permuteUnique(new int[] { 1, 2, 3 });
        System.out.println("SIZE: " + ans.size());
        printResult(ans);
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        return bactrack(nums, 0, new ArrayList<>());
    }

    public static List<List<Integer>> bactrack(int[] nums, int index, List<List<Integer>> ans) {

        List<Integer> perm = null;
        if (index >= nums.length) {
            perm = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                perm.add(nums[i]);
            }
            ans.add(perm);
            return ans;
        }

        for (int i = index; i < nums.length; i++) {
            swap(i, index, nums);
            bactrack(nums, index + 1, ans);
            swap(i, index, nums);
        }

        return ans;
    }

    private static void swap(int i, int j, int[] nums) {
        if (i == j || nums[i] == nums[j])
            return;
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
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
