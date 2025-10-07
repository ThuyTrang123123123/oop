// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

public class CharGrid {
    private char[][] grid;

    /**
     * Constructs a new CharGrid with the given grid.
     * Does not make a copy.
     * @param grid
     */
    public CharGrid(char[][] grid) {
        this.grid = grid;
    }

    /**
     * Returns the area for the given char in the grid. (see handout).
     * @param ch char to look for
     * @return area for given char
     */
    public int charArea(char ch) {
        int rows = grid.length, cols = grid[0].length;
        int minR = rows, minC = cols, maxR = -1, maxC = -1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == ch) {
                    if (i < minR) minR = i;
                    if (j < minC) minC = j;
                    if (i > maxR) maxR = i;
                    if (j > maxC) maxC = j;
                }
            }
        }
        if (maxR == -1) return 0;
        return (maxR - minR + 1) * (maxC - minC + 1); // YOUR CODE HERE
    }

    /**
     * Returns the count of '+' figures in the grid (see handout).
     * @return number of + in grid
     */
    public int countPlus() {
        int rows = grid.length, cols = grid[0].length;
        int cnt = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                char center = grid[r][c];

                // độ dài nhánh theo 4 hướng (không tính tâm)
                int up = armLen(r, c, -1, 0, center);
                int down = armLen(r, c, 1, 0, center);
                int left = armLen(r, c, 0, -1, center);
                int right = armLen(r, c, 0, 1, center);

                // mỗi nhánh >=1 (tức tổng nhánh >=2 nếu tính cả tâm) và bằng nhau
                if (up >= 1 && up == down && up == left && up == right) {
                    cnt++;
                }
            }
        }
        return cnt; // YOUR CODE HERE
    }

    // Độ dài nhánh theo hướng (dr,dc), đếm số ô liên tiếp cùng ký tự center, bắt đầu từ ô kế tiếp tâm
    private int armLen(int r, int c, int dr, int dc, char center) {
        int rows = grid.length, cols = grid[0].length;
        int len = 0;
        int nr = r + dr, nc = c + dc;
        while (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == center) {
            len++;
            nr += dr;
            nc += dc;
        }
        return len;
    }
}
