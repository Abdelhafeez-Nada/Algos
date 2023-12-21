import java.util.ArrayList;
import java.util.List;

public class A8_SubSequencesWithSumK {

    private static int COUNT = 0;

    public static void main(String[] args) {

        int count = subsCountWithSumK(new int[] { 1, 2, 3, 4, 5 }, new ArrayList<>(), 0, 5);
        System.out.println("-----------");
        System.out.println(count);
    }

    private static int subsCountWithSumK(int[] seq, List<Integer> sub, int index, int sum) {
        if (index == seq.length) {
            if (sum == calcSum(sub)) {
                System.out.print("[ " + (++COUNT) + " ] , SUM >> ");
                print(sub);
                return 1;
            }
            return 0;
        }

        sub.add(seq[index]);
        int pick = subsCountWithSumK(seq, sub, index + 1, sum);

        sub.remove(sub.size() - 1);
        int notpick = subsCountWithSumK(seq, sub, index + 1, sum);
        return pick + notpick;
    }

    private static boolean subsWithSumK(int[] seq, List<Integer> sub, int index, int sum) {

        if (index == seq.length) {
            if (sum == calcSum(sub)) {
                System.out.print("[ " + (++COUNT) + " ] , SUM >> ");
                print(sub);
                return true;
            }
            return false;
        }

        // PICK
        sub.add(seq[index]);
        if (subsWithSumK(seq, sub, index + 1, sum))
            return true;

        // NOT_PICK
        sub.remove(sub.size() - 1);
        if (subsWithSumK(seq, sub, index + 1, sum))
            return true;
        return false;
    }

    private static int calcSum(List<Integer> sub) {
        int sum = 0;
        for (int n : sub)
            sum += n;
        return sum;
    }

    private static void print(List<Integer> sub) {
        for (int n : sub)
            System.out.print(n + " ");
        System.out.println();
    }
}
