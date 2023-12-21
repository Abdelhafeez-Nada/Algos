public class A6_Fibbonaci {

    public static void main(String[] args) {
        // System.out.println(loopFib(8));
        System.out.println(recFib(8));
    }

    // 0 1 1 2 3 5 8 13 21

    private static int recFib(int term) {
        System.out.println("TERM: " + term);
        if (term <= 1) {
            System.out.println("return " + term);
            return term;
        }

        System.out.println(String.format("return recFib(%s - 1) + recFib(%s - 2);", term, term));
        return recFib(term - 1) + recFib(term - 2);
    }

    private static int loopFib(int term) {
        int r = 0;
        int l = 1;
        int bl = 1;

        for (int i = 3; i <= term; i++) {
            r = l + bl;
            bl = l;
            l = r;
        }
        return r;

    }
}
