public class PalindromString {

    public static void main(String[] args) {
        System.out.println(check(0, "MADxADAM"));
    }

    private static boolean check(int i, String str) {

        if (i > str.length() / 2)
            return true;
        if (str.charAt(i) == str.charAt(str.length() - i - 1)) {
            return check(i + 1, str);
        } else {
            return false;
        }
    }
}
