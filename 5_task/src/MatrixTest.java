import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {
    Matrix matrix = new Matrix();

    @Test
    public void makeMatrixTest() {

        int[][] a = new int[1][1];
        assertEquals(a[0][0], matrix.makeMatrix(1)[0][0]);
    }
}