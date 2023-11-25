public class A4_PalindromString {

    public static void main(String[] args) {

        System.out.println(loopPalindCheck("MADAM"));
        System.out.println(recPalindCheck(0, "MADAM"));
    }

    // loop check is palindrom
    private static boolean loopPalindCheck(String s) {
        int left = 0;

        while (left < s.length() - left - 1) {
            if (s.charAt(left) != s.charAt(s.length() - left - 1))
                return false;
            left++;
        }
        return true;
    }

    private static boolean recPalindCheck(int left, String s) {
        if (left >= s.length() - left - 1)
            return true;

        if (s.charAt(left) != s.charAt(s.length() - left - 1))
            return false;

        return recPalindCheck(left + 1, s);
    }

}
