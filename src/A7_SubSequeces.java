/**
 * --- 4 2 1-----a b c _____________---4 2 1-----a b c
 * ---------------- ------------------------
 * 0= 0 0 0 --- # # #_______________7= 1 1 1 --- a b c
 * 1= 0 0 1 --- # # c_______________6= 1 1 0 --- a b #
 * 2= 0 1 0 --- # b #_______________5= 1 0 1 --- a # c
 * 3= 0 1 1 --- # b c_______________4= 1 0 0 --- a b #
 * 4= 1 0 0 --- a # #_______________3= 0 1 1 --- # b c
 * 5= 1 0 1 --- a # c_______________2= 0 1 0 --- # b #
 * 6= 1 1 0 --- a b #_______________1= 0 0 1 --- # # c
 * 7= 1 1 1 --- a b c_______________0= 0 0 0 --- # # #
 * 
 * 
 */

public class A7_SubSequeces {

    private static int COUNT = 0;

    public static void main(String[] args) {

        char[] seq = new char[] { 'A', 'B', 'C', 'D' };
        // generateSubPickNotPickAlgoRec(seq, new StringBuilder(), 0);
        // generateSubBitManipulation(seq);

        comapreBinary(seq);
    }

    private static void generateSubPickNotPickAlgoRec(char[] seq, StringBuilder sub, int index) {

        if (index == seq.length) {
            System.out.print("BASE CASE >>                    ");
            callInfO(sub.toString(), index);
            return;
        }
        sub.append(seq[index]);
        callInfO(sub.toString(), index);
        generateSubPickNotPickAlgoRec(seq, sub, index + 1);
        sub.deleteCharAt(sub.length() - 1);
        callInfO(sub.toString(), index);
        generateSubPickNotPickAlgoRec(seq, sub, index + 1);
    }

    private static void callInfO(String sub, int index) {
        System.out.println("Count: " + (++COUNT) + " , Index: " + index + " , " + sub);
    }

    /**
     * PICK_NOTPIC
     * s=index -->pick all elements at index >= s
     * s++ --> not pick all elements at index < s
     */
    private static void generateSubPickNotPickAlgoLoop(char[] seq) {
        StringBuilder sub = null;
        for (int s = 0; s < seq.length; s++) {
            sub = new StringBuilder();
            for (int i = s; i < seq.length; i++) {
                System.out.println((sub.length() == 0) ? "{}" : sub.toString());
                sub.append(seq[i]);
            }
            System.out.println(sub.toString());
        }

    }

    private static void generateSubBitManipulation(char[] seq) {
        int max = (int) Math.pow(2, seq.length);
        StringBuilder binary;
        StringBuilder sub;
        int bit;
        for (int i = 0; i < max; i++) {
            sub = new StringBuilder();
            binary = new StringBuilder();
            for (int k = seq.length - 1; k >= 0; k--) {
                bit = (i & (1 << k)) != 0 ? 1 : 0;
                System.out.print(String.format("(%s & (1 << %s)) = %s       ", i, k, bit));
                binary.append(bit);
            }
            System.out.print("    " + binary.toString() + "   ");
            for (int j = 0; j < seq.length; j++) {
                if (binary.charAt(j) == '1')
                    sub.append(seq[j]);
                else
                    sub.append("*");
            }
            System.out.println(sub.toString());
        }
    }

    private static void comapreBinary(char[] seq) {
        String binary = "0".repeat(seq.length);
        StringBuilder sub;
        for (int i = 0; i < Math.pow(2, seq.length); i++) {
            binary = Integer.toBinaryString(i);
            System.out.println("# " + i + " > " + binary);
            sub = new StringBuilder();
            for (int k = 0; k < binary.length(); k++) {
                if (binary.charAt(k) == '1') {
                    sub.append(seq[k] + " ");
                }
            }
            System.out.println(sub.toString());
        }
    }

    private static void genrateSubBinaryRep(char[] seq) {
        int max = (int) Math.pow(2, 3);
        String binary;
        StringBuilder sub;
        for (int i = 0; i < max; i++) {
            sub = new StringBuilder();
            binary = genrateBinary(i, seq.length);
            for (int k = 0; k < seq.length; k++) {
                if (binary.charAt(k) == '1')
                    sub.append(seq[k]);
                else
                    sub.append("#");
            }
            System.out.println(sub.toString());
        }
    }

    private static String genrateBinary(int decimal, int length) {
        StringBuilder binary = new StringBuilder();
        while (decimal > 0) {
            int reminder = decimal % 2;
            binary.insert(0, reminder);
            decimal /= 2;
        }
        while (binary.length() < length) {
            binary.insert(0, 0);
        }
        return binary.toString();
    }
}
