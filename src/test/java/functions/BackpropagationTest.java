package functions;

import de.jungblut.math.dense.DenseDoubleMatrix;
import org.junit.Test;

import static org.junit.Assert.*;

public class BackpropagationTest {
    @Test
    public void calculate() throws Exception {
        Backpropagation.calculate();
        DenseDoubleMatrix matrix = Backpropagation.getTheta1_grad();
        matrix = Backpropagation.getTheta2_grad();
    }

}