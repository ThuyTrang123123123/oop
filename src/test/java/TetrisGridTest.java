import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TetrisGridTest {

    // Provided simple clearRows() test
    // width 2, height 3 grid
    @Test
    public void testClear1() {
        boolean[][] before =
                {
                        {true, true, false, },
                        {false, true, true, }
                };

        boolean[][] after =
                {
                        {true, false, false},
                        {false, true, false}
                };

        TetrisGrid tetris = new TetrisGrid(before);
        tetris.clearRows();

        assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
    }

}
