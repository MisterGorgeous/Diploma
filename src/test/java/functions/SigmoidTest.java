package functions;

import de.jungblut.math.dense.DenseDoubleMatrix;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Siarhei on 17.04.2017.
 */
public class SigmoidTest {
    @Test
    public void sigmoid() throws Exception {
        double[][] mas = {{0,3.0},{40000.0,-5000.0}};
        DenseDoubleMatrix matrix = new DenseDoubleMatrix(mas);
        System.out.print(Sigmoid.sigmoid(matrix));

    }

    @Test
    public void sigmoidGradient() throws Exception {
        double[][] mas = {{0,30000.0},{4.0,-50000.0}};
        DenseDoubleMatrix matrix = new DenseDoubleMatrix(mas);
        System.out.print(Sigmoid.sigmoidGradient(matrix));

    }

}