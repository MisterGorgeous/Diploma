package functions;

import de.jungblut.math.dense.DenseDoubleMatrix;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Siarhei on 23.04.2017.
 */
public class MatrixOperationsTest {
    @Test
    public void log() throws Exception {
        double [][] arr = {{1,2},{3,4},{5,6}};
        DenseDoubleMatrix matrix = new DenseDoubleMatrix(arr);
        matrix = MatrixOperations.log(matrix);
        System.out.print(matrix);
        System.out.println();
        double [][] arr1 = {{1,2,3,4,10}};
        matrix = new DenseDoubleMatrix(arr1);
        matrix = MatrixOperations.log(matrix);
        System.out.print(matrix);
    }

}