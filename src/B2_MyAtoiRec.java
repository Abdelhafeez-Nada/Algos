public class B2_MyAtoiRec {

    private static int minus = '-';
    private static int plus = '+';
    private static int zero = '0';
    private static int nine = '9';

    public static void main(String[] args) {
        System.out.println(myAtoi("-+6485917"));
    }

    private static int myAtoi(String s) {
        return backtrack(s, 0, 1, 0, false);
    }

    private static int backtrack(String s, int index, int sign, int result, boolean isDigitStart) {

        if (index >= s.length())
            return sign * result;
        // read and ignore leading white_spaces
        if (s.charAt(index) == ' ')
            return backtrack(s, index + 1, sign, result, isDigitStart);
        int decRep = s.charAt(index);
        if (!isDigitStart && (decRep == minus || decRep == plus)) {
            sign = decRep == minus ? -1 : 1;
            return backtrack(s, index + 1, sign, result, true);
        }
        if (decRep < zero || decRep > nine)
            return sign * result;
        int digit = decRep - zero;
        if (result > (Integer.MAX_VALUE - digit) / 10)
            return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        result = (result * 10) + digit;
        return backtrack(s, index + 1, sign, result, true);
    }
}
