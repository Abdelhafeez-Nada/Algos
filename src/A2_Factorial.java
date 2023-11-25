public class A2_Factorial {

    public static void main(String[] args) {

        System.out.println(paramRec(5, 1));
        System.out.println(funcRec(5));
    }

    // parametreized recursion

    private static int paramRec(int n, int f) {
        if (n == 2)
            return 2 * f;
        return paramRec(n - 1, f * n);
    }

    // functional recursion

    private static int funcRec(int n) {
        if (n == 2)
            return 2;
        return n * funcRec(n - 1);
    }
}
