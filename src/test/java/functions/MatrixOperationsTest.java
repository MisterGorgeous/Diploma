package functions;

import de.jungblut.math.dense.DenseDoubleMatrix;
import de.jungblut.math.dense.DenseDoubleVector;
import org.junit.Test;

import static org.junit.Assert.*;


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

    @Test
    public void matrixsToVectorTest() throws Exception {
        double[] first = {1,2,3,4,9,10};
        double[] seccond = {5,6,7,8,11,12};
        double[] result = {1,2,3,4,9,10,5,6,7,8,11,12};
        DenseDoubleMatrix firstMatrix = new DenseDoubleMatrix(3,2,first);
        DenseDoubleMatrix seccondMatrix = new DenseDoubleMatrix(2,3,seccond);
        DenseDoubleVector vector = MatrixOperations.matrixsToVector(firstMatrix,seccondMatrix);
        assertArrayEquals(result,vector.toArray(),0.0001);
    }

}