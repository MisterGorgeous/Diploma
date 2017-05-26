package functions;

import de.jungblut.math.dense.DenseDoubleMatrix;
import org.junit.Test;

import static org.junit.Assert.*;


public class NormalizationTest {
    @Test
    public void addA0asColumn() throws Exception {
        double [][] arr = {{1,2},{3,4},{5,6}};
        double [][] res1 = {{1,1,2},{1,3,4},{1,5,6}};
        DenseDoubleMatrix matrix = new DenseDoubleMatrix(arr);
        matrix = Normalization.addA0asColumn(matrix);
        assertArrayEquals(matrix.toArray(),res1);
        double [][] arr1 = {{1,2,3,4}};
        double [][] res2 = {{1,1,2,3,4}};
        matrix = new DenseDoubleMatrix(arr1);
        matrix = Normalization.addA0asColumn(matrix);
        assertArrayEquals(matrix.toArray(),res2);

    }

    @Test
    public void addColumn() throws Exception {
        double [][] arr = {{1,2},{3,4},{5,6}};
        double[] col = {6,6,6};
        DenseDoubleMatrix matrix = new DenseDoubleMatrix(arr);
        matrix = Normalization.addColumn(matrix,col);
        double [][] res1 = {{6,1,2},{6,3,4},{6,5,6}};
        assertArrayEquals(matrix.toArray(),res1);

        double [][] arr1 = {{1,2,3,4}};
        double[] col1 = {0};
        matrix = new DenseDoubleMatrix(arr1);
        matrix = Normalization.addColumn(matrix,col1);
        double [][] res2 = {{0,1,2,3,4}};
        assertArrayEquals(matrix.toArray(),res2);
    }

    @Test
    public void delA0asColumn() throws Exception {
        double [][] arr = {{1,2},{3,4},{5,6}};
        DenseDoubleMatrix matrix = new DenseDoubleMatrix(arr);
        matrix = Normalization.dellA0AsColumn(matrix);
        double [][] res1 = {{2},{4},{6}};
        assertArrayEquals(matrix.toArray(),res1);
        double [][] arr1 = {{1,2,3,4}};
        matrix = new DenseDoubleMatrix(arr1);
        matrix = Normalization.dellA0AsColumn(matrix);
        double [][] res2 = {{2,3,4}};
        assertArrayEquals(matrix.toArray(),res2);

    }

}