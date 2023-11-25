import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSum {

    public static void main(String[] args) {
        int[] arr = new int[] { 3, 1, 2 };
        Arrays.sort(arr);

        List<Integer> result = subsetsSum(arr, 0, 0, new ArrayList<>());

        Arrays.sort(result.toArray());

        for (int n : result) {
            System.out.println(n);
        }
    }

    private static List<Integer> subsetsSum(int[] arr, int index, int sum, List<Integer> result) {

        if (index >= arr.length) {
            result.add(sum);
            return result;
        }

        sum += arr[index];
        subsetsSum(arr, index + 1, sum, result);

        sum -= arr[index];
        subsetsSum(arr, index + 1, sum, result);

        return result;
    }
}
