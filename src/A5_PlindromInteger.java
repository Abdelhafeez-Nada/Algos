public class A5_PlindromInteger {

    public static void main(String[] args) {
        System.out.println(loopPalindromInt(21412));
        System.out.println(recPlindromInt(21412, 21412, 0));
    }

    private static boolean loopPalindromInt(int num) {

        int original = num;
        int digit = 0;
        int reversed = 0;
        while (num > 0) {
            digit = num % 10;
            reversed = (reversed * 10) + digit;
            num /= 10;
        }
        return original == reversed;
    }

    private static boolean recPlindromInt(int num, int original, int reversed) {
        if (num == 0)
            return original == reversed;
        int digit = num % 10;
        return recPlindromInt(num / 10, original, reversed * 10 + digit);
    }
}
