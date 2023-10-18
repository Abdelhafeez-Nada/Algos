public class Factorial {

    public static void main(String[] args) {
        System.out.println(fact(5));
    }

    private static double fact(int n) {
        if (n < 2)
            return 1;
        return fact(n - 1) * n;
    }
}
