
// Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

// The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the 
// frequency
//  of at least one of the chosen numbers is different.

// The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

// Example 1:

// Input: candidates = [2,3,6,7], target = 7
// Output: [[2,2,3],[7]]
// Explanation:
// 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
// 7 is a candidate, and 7 = 7.
// These are the only two combinations.
// Example 2:

// Input: candidates = [2,3,5], target = 8
// Output: [[2,2,2,2],[2,3,3],[3,5]]
// Example 3:

// Input: candidates = [2], target = 1
// Output: []

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {

        List<List<Integer>> result = combinationSum(new int[] { 2, 3, 6, 7 }, 7);
        printResult(result);

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> reslut = new ArrayList<>();

        backtrack(candidates, target, 0, new ArrayList<>(), reslut);

        return reslut;

    }

    private static void backtrack(int[] candidates, int target, int index, List<Integer> comb,
            List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(comb));
            return;
        }

        if (target < 0 || index == candidates.length) {
            return;
        }

        // PICK the current candidate in the combination
        comb.add(candidates[index]);
        backtrack(candidates, target - candidates[index], index, comb, result);

        // Backtrack to try other combinations
        comb.remove(comb.size() - 1);

        // Skip the current candidate and move to the next one
        backtrack(candidates, target, index + 1, comb, result);

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
