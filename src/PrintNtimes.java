public class PrintNtimes {

    public static void main(String[] args) {

        print(3, "Hello");
    }

    private static void print(int n, String str) {

        if (n == 0) {
            System.out.println(n + " >> EOF");
            return;
        } else {
            print(n - 1, str);
            System.out.println(n + " >> " + str);
        }
    }
}
