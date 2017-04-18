package functions;

import de.jungblut.math.dense.DenseDoubleMatrix;

import java.util.Random;

public class RandomInitialization {

    public static DenseDoubleMatrix randInitialize(int in, int out, double epsilon){
        DenseDoubleMatrix matrix =  new DenseDoubleMatrix(out,in + 1,new Random());
        return matrix.multiply(2*epsilon).subtract(epsilon);
    }
}
