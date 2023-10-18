public class Counter {

    public static void main(String[] args) {
        count(0, 5);
    }

    private static void count(int c, int end) {
        if (c > end)
            return;
        System.out.println(c);
        c++;
        count(c, end);
    }
}
