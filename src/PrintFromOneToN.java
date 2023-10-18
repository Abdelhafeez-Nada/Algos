public class PrintFromOneToN {

    public static void main(String[] args) {
        print(5);
    }

    private static void print(int n) {
        if (n == 0)
            return;
        print(n - 1);
        System.out.println(n);
    }
}
