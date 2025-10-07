public class FunctionGrowth {
    public static void main(String[] args) {
        // tiêu đề cột (độ rộng cố định)
        System.out.printf("%6s%6s%10s%12s%15s%n",
                "log n", "n", "n log n", "n^2", "n^3");

        for (int n = 2; n <= 2048; n *= 2) {
            int logn = (int) Math.log(n);          // log tự nhiên
            int nlogn = (int) (n * Math.log(n));   // n ln n
            long n2 = 1L * n * n;                  // dùng long để an toàn
            long n3 = 1L * n * n * n;              // 2048^3 > int

            System.out.printf("%6d%6d%10d%12d%15d%n",
                    logn, n, nlogn, n2, n3);
        }
    }
}
