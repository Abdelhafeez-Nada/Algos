public class B4_MyPowRec {

    public static void main(String[] args) {

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
        return backtrack(x, exp, 1);
    }

    public static double backtrack(double x, long exp, double result) {
        if (exp <= 0)
            return result;
        if (exp % 2 != 0)
            result *= x;
        return backtrack(x * x, exp / 2, result);
    }
}
