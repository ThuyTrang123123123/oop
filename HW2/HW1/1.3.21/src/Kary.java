public class Kary {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        if (k < 2 || k > 16) {
            System.out.println("Base must be between 2 and 16");
            return;
        }

        if (n < 1) {
            System.out.println(0);
            return;
        }

        char[] digits = "0123456789ABCDEF".toCharArray();
        String result = "";

        while (n > 0) {
            int remainder = n % k;
            result = digits[remainder] + result;
            n /= k;
        }

        System.out.println(result);
    }
}
