package data;

import de.jungblut.math.dense.DenseDoubleMatrix;
import de.jungblut.math.dense.DenseDoubleVector;
import org.junit.Test;

import static org.junit.Assert.*;


public class HandWritenDigitsTest {
    @Test
    public void getY() throws Exception {
        DenseDoubleMatrix vector = HandWritenDigits.getY();
        for (int i = 0; i < vector.getColumnCount(); ++i) {
            System.out.println(vector.get(0,i));
        }
    }

    @Test
    public void getYBinary() throws Exception {
        DenseDoubleMatrix vector;
        for (int i = 0; i < 200; ++i) {
            vector = HandWritenDigits.getYBinaryFormat(i);
            for (int j = 0; j < 10; ++j) {
                System.out.print(vector.get(0,j) + " ");
            }
            System.out.println();
        }
    }
}