import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class RandomWalk {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setScale(-n - 0.5, n + 0.5);
        StdDraw.clear(StdDraw.GRAY);
        StdDraw.enableDoubleBuffering();

        int x = 0, y = 0;
        int steps = 0;

        // vẽ ô đầu tiên
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.filledSquare(x, y, 0.45);
        StdDraw.show();

        int len = 1;                         // độ dài mỗi chặng; cứ 2 chặng thì tăng 1
        outer:
        while (true) {
            // phải len
            for (int t = 0; t < len; t++) {
                StdDraw.setPenColor(StdDraw.WHITE);
                StdDraw.filledSquare(x, y, 0.45);
                x++; steps++;
                if (Math.abs(x) >= n || Math.abs(y) >= n) break outer;
                StdDraw.setPenColor(StdDraw.BLUE);
                StdDraw.filledSquare(x, y, 0.45);
                StdDraw.show(); StdDraw.pause(40);
            }
            // lên len
            for (int t = 0; t < len; t++) {
                StdDraw.setPenColor(StdDraw.WHITE);
                StdDraw.filledSquare(x, y, 0.45);
                y++; steps++;
                if (Math.abs(x) >= n || Math.abs(y) >= n) break outer;
                StdDraw.setPenColor(StdDraw.BLUE);
                StdDraw.filledSquare(x, y, 0.45);
                StdDraw.show(); StdDraw.pause(40);
            }
            len++; // sau 2 chặng tăng độ dài

            // trái len
            for (int t = 0; t < len; t++) {
                StdDraw.setPenColor(StdDraw.WHITE);
                StdDraw.filledSquare(x, y, 0.45);
                x--; steps++;
                if (Math.abs(x) >= n || Math.abs(y) >= n) break outer;
                StdDraw.setPenColor(StdDraw.BLUE);
                StdDraw.filledSquare(x, y, 0.45);
                StdDraw.show(); StdDraw.pause(40);
            }
            // xuống len
            for (int t = 0; t < len; t++) {
                StdDraw.setPenColor(StdDraw.WHITE);
                StdDraw.filledSquare(x, y, 0.45);
                y--; steps++;
                if (Math.abs(x) >= n || Math.abs(y) >= n) break outer;
                StdDraw.setPenColor(StdDraw.BLUE);
                StdDraw.filledSquare(x, y, 0.45);
                StdDraw.show(); StdDraw.pause(40);
            }
            len++; // sau 2 chặng tăng độ dài
        }

        StdOut.println("Total steps = " + steps);
    }
}
