import java.util.HashSet;
import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {

    /**
     * Given a string, returns the length of the largest run.
     * A a run is a series of adajcent chars that are the same.
     * @param str
     * @return max run length
     */
    public static int maxRun(String str) {
        if (str == null || str.isEmpty()) return 0;

        int best = 1, cur = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i-1)) {
                cur++;
            } else {
                best =  Math.max(best, cur);
                cur = 1;
            }
        }
        return Math.max(best, cur); // YOUR CODE HERE
    }


    /**
     * Given a string, for each digit in the original string,
     * replaces the digit with that many occurrences of the character
     * following. So the string "a3tx2z" yields "attttxzzz".
     * @param str
     * @return blown up string
     */
    public static String blowup(String str) {
        if (str == null || str.isEmpty()) return "";

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (Character.isDigit(c) && i+1 < str.length()) {
                int num = c - '0';
                char next = str.charAt(i+1);
                for (int j = 0; j < num; j++) {
                    result.append(next);
                }
            } else if (i != str.length() - 1) {
                result.append(c);
            } else if (!Character.isDigit(c)) {
                result.append(c);
            }
        }
        return result.toString(); // YOUR CODE HERE
    }

    /**
     * Given 2 strings, consider all the substrings within them
     * of length len. Returns true if there are any such substrings
     * which appear in both strings.
     * Compute this in linear time using a HashSet. Len will be 1 or more.
     */
    public static boolean stringIntersect(String a, String b, int len) {
        if (a == null || b == null || len <= 0) return false;

        if (len > a.length() || len > b.length()) return false;

        // Put all substrings of 'a' with length 'len' into a set
        HashSet<String> seen = new HashSet<>();
        for (int i = 0; i + len <= a.length(); i++) {
            seen.add(a.substring(i, i + len));
        }
        // Check any substring of 'b' exists in the set
        for (int j = 0; j + len <= b.length(); j++) {
            if (seen.contains(b.substring(j, j + len))) return true;
        }

        return false; // YOUR CODE HERE
    }
}
