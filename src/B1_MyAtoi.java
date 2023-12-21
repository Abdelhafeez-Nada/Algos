public class B1_MyAtoi {

    public static void main(String[] args) {

        String s = "-91283472332";
        int out = -1089159116;
        int ex = -2147483648;

        // System.out.println(Integer.MIN_VALUE - 912834723);
        // System.out.println(Integer.MIN_VALUE);

        System.out.println(myAtoi("00000-42a1234"));

    }

    public static int myAtoi(String s) {

        int minus = '-';
        int plus = '+';
        int zero = '0';
        int nine = '9';
        int sign = 1;
        int i = 0;
        // read and ignore leading white_spaces
        while (i < s.length() && (s.charAt(i) == ' ')) {
            i++;
        }
        // check if is empty string
        if (i > s.length() - 1) {
            return 0;
        }
        int decRep = s.charAt(i);
        // check if is firastAndlast char and not valid
        if (i == s.length() - 1 && (decRep < zero || decRep > nine)) {
            return 0;
        }
        // check if is minus
        if (decRep == minus || decRep == plus) {
            sign = (decRep == minus) ? -1 : 1;
            i++;
        }
        int num = 0;
        int digit;
        while (i < s.length()) {
            decRep = s.charAt(i);
            if (decRep < zero || decRep > nine)
                break;
            digit = decRep - zero;
            // Check for overflow
            if (num > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = (num * 10) + digit;
            i++;
        }
        return sign * num;
    }
}
