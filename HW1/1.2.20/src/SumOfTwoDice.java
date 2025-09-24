public class SumOfTwoDice {
    public static void main(String[] args) {
        int sides = 6;
        int a = 1 + (int) (Math.random() * sides);
        int b = 1 + (int) (Math.random() * sides);
        int sum = a + b;
        System.out.println(sum);
    }
}
