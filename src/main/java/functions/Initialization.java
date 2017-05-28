package functions;

import de.jungblut.math.dense.DenseDoubleMatrix;

import java.util.Random;

public class Initialization {
  /*  public static int INPUT_LAYER_SIZE = 36;
    public static int SECCOND_LAYER_SIZE = 6;
    public static int OUTPUT_LAYER_SIZE = 4;*/
    public static int INPUT_LAYER_SIZE = 256;
    public static int SECCOND_LAYER_SIZE = 16;
    public static int OUTPUT_LAYER_SIZE = 10;

    public static DenseDoubleMatrix randInitialize(int in, int out, double epsilon){
        DenseDoubleMatrix matrix =  new DenseDoubleMatrix(out,in + 1,new Random());
        return matrix.multiply(2*epsilon).subtract(epsilon);
    }
}
