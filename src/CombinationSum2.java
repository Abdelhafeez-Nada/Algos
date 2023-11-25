
// Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

// Each number in candidates may only be used once in the combination.

// Note: The solution set must not contain duplicate combinations.

// Example 1:

// Input: candidates = [10,1,2,7,6,1,5], target = 8
// Output: 
// [
// [1,1,6],
// [1,2,5],
// [1,7],
// [2,6]
// ]
// Example 2:

// Input: candidates = [2,5,2,1,2], target = 5
// Output: 
// [
// [1,2,2],
// [5]
// ]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    public static void main(String[] args) {

        int[] candidates = new int[] { 1, 1, 1, 2, 2 };
        Arrays.sort(candidates);

        List<List<Integer>> result = combinationSum2(candidates, 4);

        printResult(result);

    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;

    }

    private static void backtrack(int[] candidates, int target, int index, List<Integer> comb,
            List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(comb));
            return;
        }

        if (index >= candidates.length || target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue; // Skip duplicates to avoid generating the same combination

            }
            comb.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, comb, result);
            comb.remove(comb.size() - 1);
        }

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
