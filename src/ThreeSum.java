import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

    public static void main(String[] args) {

        int[] arr = new int[] { -4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0 };
        // Arrays.sort(arr);
        // printArr(arr);
        List<List<Integer>> ans = threeSum(arr);

        printResult(ans);

    }

    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {

                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {

                    ans.add(Arrays.asList(nums[i], nums[l++], nums[r--]));
                    while (l < r && nums[r] == nums[r + 1])
                        r--;
                    while (l < r && nums[l] == nums[l - 1])
                        l++;

                } else if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    l++;
                }
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

    private static void printArr(int[] arr) {
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }
}
