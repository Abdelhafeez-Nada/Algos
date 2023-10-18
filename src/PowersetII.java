import java.util.ArrayList;
import java.util.List;

public class PowersetII {

    private static List<String> result = new ArrayList<>();

    public static void main(String[] args) {

        powerSet(new int[] { 1, 2, 3 });
        for (String sub : result) {
            System.out.println(sub);
        }
    }

    private static void powerSet(int[] nums) {

        int subCount = 1 << nums.length;
        for (int num = 0; num < subCount; num++) {
            StringBuilder sub = new StringBuilder();
            for (int i = 0; i < nums.length; i++) {
                int position = 1 << i;
                if ((num & position) != 0) {
                    sub.append(nums[i]);
                }
            }
            result.add(sub.toString());
        }
    }
}
