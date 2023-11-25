
public class A1_SumOfFirstN {

    public static void main(String[] args) {

        System.out.println(parametrizedRec(3, 0));
        System.out.println(funcRec(3));

    }

    // parametrized recursion
    private static int parametrizedRec(int n, int sum) {

        if (n < 1)
            return sum;
        return parametrizedRec(n - 1, sum + n);
    }

    // functional recursion

    private static int funcRec(int n) {
        if (n == 1)
            return 1;
        return n + funcRec(n - 1);
    }
}