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
        double[][] mas = {{2.0,3.0},{4.0,5.0}};
        DenseDoubleMatrix matrix = new DenseDoubleMatrix(mas);
        System.out.print(Sigmoid.sigmoid(matrix));

    }

    @Test
    public void sigmoidGradient() throws Exception {
        double[][] mas = {{2.0,3.0},{4.0,5.0}};
        DenseDoubleMatrix matrix = new DenseDoubleMatrix(mas);
        System.out.print(Sigmoid.sigmoidGradient(matrix));

    }

}