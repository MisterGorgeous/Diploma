package functions;

import de.jungblut.math.dense.DenseDoubleMatrix;
import org.junit.Test;

import static org.junit.Assert.*;


public class NormalizationTest {
    @Test
    public void addA0asColumn() throws Exception {
        double [][] arr = {{1,2},{3,4},{5,6}};
        DenseDoubleMatrix matrix = new DenseDoubleMatrix(arr);
        matrix = Normalization.addA0asColumn(matrix);
        System.out.print(matrix);
        System.out.println();
        double [][] arr1 = {{1,2,3,4}};
        matrix = new DenseDoubleMatrix(arr1);
        matrix = Normalization.addA0asColumn(matrix);
        System.out.print(matrix);

    }

    @Test
    public void addColumn() throws Exception {
        double [][] arr = {{1,2},{3,4},{5,6}};
        double[] col = {6,6,6};
        DenseDoubleMatrix matrix = new DenseDoubleMatrix(arr);
        matrix = Normalization.addColumn(matrix,col);
        System.out.print(matrix);
        System.out.println();
        double [][] arr1 = {{1,2,3,4}};
        double[] col1 = {0};
        matrix = new DenseDoubleMatrix(arr1);
        matrix = Normalization.addColumn(matrix,col1);
        System.out.print(matrix);

    }

    @Test
    public void delA0asColumn() throws Exception {
        double [][] arr = {{1,2},{3,4},{5,6}};
        DenseDoubleMatrix matrix = new DenseDoubleMatrix(arr);
        matrix = Normalization.dellA0AsColumn(matrix);
        System.out.print(matrix);
        System.out.println();
        double [][] arr1 = {{1,2,3,4}};
        matrix = new DenseDoubleMatrix(arr1);
        matrix = Normalization.dellA0AsColumn(matrix);
        System.out.print(matrix);

    }

}