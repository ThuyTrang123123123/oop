public class SpringSeason {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int d = Integer.parseInt(args[1]);
        if (m == 3 && d >= 20 && d <= 31) {
            System.out.println("true");
        } else if (m == 4 && d >= 1 && d <= 30) {
            System.out.println("true");
        } else if (m == 5 && d >= 1 && d <= 31) {
            System.out.println("true");
        } else if (m == 6 && d >= 1 && d <= 20) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
