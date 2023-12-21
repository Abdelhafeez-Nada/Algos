import java.util.List;

public class CountGoodNumbers {

    private static int[] even = new int[] { 0, 2, 4, 6, 8 };
    private static int[] prime = new int[] { 2, 3, 5, 7 };

    public static void main(String[] args) {
        // pick(2, even, 0, prime, 0, new StringBuilder());
        evenSub(even, 0, new StringBuilder());

    }

    public int countGoodNumbers(long n) {
        return 0;
    }

    private static int count = 0;

    private static void evenSub(int[] even, int index, StringBuilder s) {
        if (index >= even.length) {
            // if (s.length() == 2) {
            System.out.println(++count + " >> " + s.toString());
            // }
            return;
        }

        s.append(even[index]);
        evenSub(even, index + 1, s);

        s.deleteCharAt(s.length() - 1);
        evenSub(even, index + 1, s);
    }

    private static void pick(int n, int[] even, int evenIndex, int[] prime, int primeIndex, StringBuilder s) {

        if (evenIndex >= even.length || primeIndex >= prime.length || s.length() == n) {
            System.out.println(++count + " --> " + s.toString());
            return;
        }
        s.append(even[evenIndex]);
        s.append(prime[primeIndex]);
        pick(n, even, evenIndex, prime, primeIndex + 1, s);
        pick(n, even, evenIndex + 1, prime, primeIndex, s);
        s.deleteCharAt(s.length() - 1);
        s.deleteCharAt(s.length() - 1);

    }

    private static boolean isPrime(int x) {
        if (x <= 1 || x == 2)
            return true;
        if (x % 2 == 0)
            return false;
        for (int i = 2; i <= x / 2; i++) {
            if (x % i == 0)
                return false;
        }
        return true;
    }
}
