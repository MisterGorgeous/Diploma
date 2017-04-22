package functions;


import data.HandWritenDigits;
import de.jungblut.math.dense.DenseDoubleMatrix;
import de.jungblut.math.dense.DenseDoubleVector;

import java.util.ArrayList;
import java.util.List;

public class Backpropagation {
    private static DenseDoubleMatrix theta1;
    private static DenseDoubleMatrix theta2;
    private static DenseDoubleMatrix theta1_grad;
    private static DenseDoubleMatrix theta2_grad;
    private static double J;


    public static void calculate(){
        theta1 = RandomInitialization.randInitialize(256,16,0.12);
        theta2 = RandomInitialization.randInitialize(16,10,0.12);
        theta1_grad = new DenseDoubleMatrix(256,16,0);
        theta2_grad = new DenseDoubleMatrix(16,10,0);

        for(int i=0; i< HandWritenDigits.X_SIZE; ++i){
            DenseDoubleMatrix a1 = Normalization.addA0asColumn(HandWritenDigits.getXRowMat(i));
            DenseDoubleMatrix z2 = (DenseDoubleMatrix) a1.multiply(theta1.transpose());
            DenseDoubleMatrix sigZ2 = Sigmoid.sigmoid(z2);
            DenseDoubleMatrix a2 = Normalization.addA0asColumn(sigZ2);
            DenseDoubleMatrix z3 = (DenseDoubleMatrix) a2.multiply(theta2.transpose());
            DenseDoubleMatrix h = Sigmoid.sigmoid(z3);

            DenseDoubleMatrix q3 = (DenseDoubleMatrix) h.subtract(HandWritenDigits.getYBinaryFormat(i));
            z2 = Normalization.addA0asColumn(z2);
            DenseDoubleMatrix q2 = (DenseDoubleMatrix) q3.multiply(theta2);
            z2 = Sigmoid.sigmoidGradient(z2);
            q2 = (DenseDoubleMatrix) q2.multiplyElementWise(z2);

            q2 = Normalization.dellA0AsColumn(q2);
            theta2_grad = (DenseDoubleMatrix) theta2_grad.add(q3.transpose().multiply(a2));
            theta1_grad = (DenseDoubleMatrix) theta1_grad.add(q2.transpose().multiply(a1));

        }
    }

    public static DenseDoubleMatrix getTheta1() {
        return theta1;
    }

    public static DenseDoubleMatrix getTheta2() {
        return theta2;
    }

    public static DenseDoubleMatrix getTheta1_grad() {
        return theta1_grad;
    }

    public static DenseDoubleMatrix getTheta2_grad() {
        return theta2_grad;
    }

    public static double getJ() {
        return J;
    }
}
