public class SubsetSumBruteForce {

    public static void main(String[] args) {
        powerSet(new int[] { 5, 2, 1 });
    }

    private static void powerSet(int[] arr) {

        int sum;
        int temp;
        for (int num = 0; num < (1 << arr.length); num++) {
            sum = 0;
            for (int i = 0; i < arr.length; i++) {
                temp = 1 << i;
                if ((num & temp) != 0) {
                    sum += num;
                }
            }
            System.out.println(sum);
        }
    }
}
