import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    private static List<String> result = new ArrayList<>();

    public static void main(String[] args) {

        powerSet("123");
        for (String s : result) {
            if (s.isEmpty())
                s = "---";
            System.out.println(s);
        }

    }

    private static List<String> powerSet(String str) {

        for (int num = 0; num < 1 << str.length(); num++) {
            StringBuilder sub = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                int x = 1 << i;
                if ((num & x) != 0) {
                    sub.append(str.charAt(i));
                }
            }
            result.add(sub.toString());
        }
        return result;
    }
}
