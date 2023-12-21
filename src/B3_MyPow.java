public class B3_MyPow {

    public static void main(String[] args) {
        // System.out.println(Integer.MIN_VALUE - 1 % 2);
        System.out.println(Integer.MAX_VALUE);
        double x = 1.0000000000001;
        int n = -2147483648;
        double r = myPow(x, n);
    }

    public static double myPow(double x, int n) {
        if (x == 1)
            return 1;
        if (x == -1)
            return n % 2 == 0 ? 1 : -1;
        long exp = n;
        if (exp < 0) {
            x = 1 / x;
            exp *= -1;
        }
        double result = 1.0;
        while (exp > 0) {
            if (exp % 2 != 0) {
                result *= x;
            }
            x *= x;
            exp /= 2;
        }
        return result;
    }

    // public static double myPow(double x, int n) {
    // if (x == 1)
    // return 1;
    // if (x == -1)
    // return n % 2 == 0 ? 1 : -1;
    // long exp = n;
    // if (exp < 0) {
    // x = 1 / x;
    // exp *= -1;
    // }
    // double result = 1.0;

    // while (exp > 0) {
    // if (exp % 2 != 0) {
    // result *= x;
    // }
    // x *= x;
    // exp /= 2;
    // }
    // return result;
    // }
}
