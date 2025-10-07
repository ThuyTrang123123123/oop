//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

public class TetrisGrid {

    private boolean[][] grid;

    /**
     * Constructs a new instance with the given grid.
     * Does not make a copy.
     *
     * @param grid
     */
    public TetrisGrid(boolean[][] grid) {
        int width  = grid.length;        // số cột
        int height = grid[0].length;     // số hàng
        this.grid = new boolean[width][height];
        // sao chép y như input (column-major)
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                this.grid[x][y] = grid[x][y];
            }
        }
    }


    /**
     * Does row-clearing on the grid (see handout).
     */
    public void clearRows() {
        int width  = grid.length;       // cột
        int height = grid[0].length;    // hàng

        boolean[][] newGrid = new boolean[width][height];
        int newY = 0;                   // bắt đầu ở đáy (y=0)

        // duyệt các HÀNG theo y = 0 .. height-1 (từ dưới lên)
        for (int y = 0; y < height; y++) {
            boolean full = true;
            for (int x = 0; x < width; x++) {
                if (!grid[x][y]) {      // nếu có ô trống -> không đầy
                    full = false;
                    break;
                }
            }
            if (!full) {                // chỉ copy hàng KHÔNG đầy
                for (int x = 0; x < width; x++) {
                    newGrid[x][newY] = grid[x][y];   // giữ nguyên cột, hạ về newY
                }
                newY++;                 // lấp tiếp hàng đáy tiếp theo
            }
        }
        grid = newGrid;
    }


    /**
     * Returns the internal 2d grid array.
     *
     * @return 2d grid array
     */
    boolean[][] getGrid() {
        return grid; // YOUR CODE HERE
    }
}
