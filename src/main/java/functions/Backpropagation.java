package functions;


import data.HandWritenDigits;
import de.jungblut.math.DoubleVector;
import de.jungblut.math.dense.DenseDoubleMatrix;
import de.jungblut.math.dense.DenseDoubleVector;
import de.jungblut.math.minimize.CostFunction;
import de.jungblut.math.minimize.CostGradientTuple;


public class Backpropagation implements CostFunction {
    private static DenseDoubleMatrix theta1 = Initialization.randInitialize(Initialization.INPUT_LAYER_SIZE,
            Initialization.SECCOND_LAYER_SIZE, 0.12);
    private static DenseDoubleMatrix theta2 = Initialization.randInitialize(Initialization.SECCOND_LAYER_SIZE,
            Initialization.OUTPUT_LAYER_SIZE, 0.12);
    private static DenseDoubleMatrix theta1_grad = new DenseDoubleMatrix(Initialization.INPUT_LAYER_SIZE + 1,
            Initialization.SECCOND_LAYER_SIZE, 0);
    private static DenseDoubleMatrix theta2_grad = new DenseDoubleMatrix(Initialization.SECCOND_LAYER_SIZE + 1,
            Initialization.OUTPUT_LAYER_SIZE, 0);
    private static final double lambda = 1;


    public static DenseDoubleMatrix getTheta1() {
        DenseDoubleMatrix copy = new DenseDoubleMatrix(theta1.toArray());
        return copy;
    }

    public static DenseDoubleMatrix getTheta2() {
        DenseDoubleMatrix copy = new DenseDoubleMatrix(theta2.toArray());
        return copy;
    }

    public static DenseDoubleMatrix getTheta1_grad() {
        DenseDoubleMatrix copy = new DenseDoubleMatrix(theta1_grad.toArray());
        return copy;
    }

    public static DenseDoubleMatrix getTheta2_grad() {
        DenseDoubleMatrix copy = new DenseDoubleMatrix(theta2_grad.toArray());
        return copy;
    }

    public static DenseDoubleVector getTheta1and2AsVector() {
        return MatrixOperations.matrixsToVector(getTheta1(), getTheta2());
    }

    public static boolean substractGradient(){
        theta1 = (DenseDoubleMatrix) theta1.subtract(theta1_grad.transpose());
        theta2 = (DenseDoubleMatrix) theta2.subtract(theta2_grad.transpose());
        return true;
    }

    public static boolean setTheta1and2AsVector(DenseDoubleVector vector) {
        theta1 = new DenseDoubleMatrix(Initialization.SECCOND_LAYER_SIZE, Initialization.INPUT_LAYER_SIZE + 1, vector.slice(
                (Initialization.INPUT_LAYER_SIZE + 1) * Initialization.SECCOND_LAYER_SIZE).toArray());
        theta2 = new DenseDoubleMatrix(Initialization.OUTPUT_LAYER_SIZE, Initialization.SECCOND_LAYER_SIZE + 1,
                vector.slice((Initialization.INPUT_LAYER_SIZE + 1) * Initialization.SECCOND_LAYER_SIZE, vector.getLength()).toArray());
        return true;
    }


    public static void calculate() {
        for (int i = 0; i < HandWritenDigits.X_SIZE; ++i) {
            theta1_grad = new DenseDoubleMatrix(Initialization.INPUT_LAYER_SIZE + 1,
                    Initialization.SECCOND_LAYER_SIZE, 0);
            theta2_grad = new DenseDoubleMatrix(Initialization.SECCOND_LAYER_SIZE + 1,
                    Initialization.OUTPUT_LAYER_SIZE, 0);

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

            DenseDoubleMatrix theta2_gradWithoutNorm = Normalization.dellA0AsColumn(theta2_grad.transpose()).transpose();
            DenseDoubleMatrix theta2_WithoutNorm = Normalization.dellA0AsColumn(theta2).transpose();
            theta2_gradWithoutNorm = (DenseDoubleMatrix) theta2_WithoutNorm.multiply(lambda).add(theta2_gradWithoutNorm);
            theta2_grad = (DenseDoubleMatrix) Normalization.addColumn(theta2_gradWithoutNorm.transpose(),
                    theta2_grad.getColumn(0)).divide(HandWritenDigits.X_SIZE).transpose();

            DenseDoubleMatrix theta1_gradWithoutNorm = Normalization.dellA0AsColumn(theta1_grad.transpose()).transpose();
            DenseDoubleMatrix theta1_WithoutNorm = Normalization.dellA0AsColumn(theta1).transpose();
            theta1_gradWithoutNorm = (DenseDoubleMatrix) theta1_WithoutNorm.multiply(lambda).add(theta1_gradWithoutNorm);
            theta1_grad = (DenseDoubleMatrix) Normalization.addColumn(theta1_gradWithoutNorm.transpose(),
                    theta1_grad.getColumn(0)).divide(HandWritenDigits.X_SIZE).transpose();
        }
    }

    public static double calculateCost(DenseDoubleMatrix theta1, DenseDoubleMatrix theta2) {
        double J;
        DenseDoubleMatrix x = HandWritenDigits.getX();
        x = Normalization.addA0asColumn(x);
        DenseDoubleMatrix h = (DenseDoubleMatrix) x.multiply(theta1.transpose());
        h = Sigmoid.sigmoid(h);
        h = Normalization.addA0asColumn(h);
        h = (DenseDoubleMatrix) h.multiply(theta2.transpose());
        h = Sigmoid.sigmoid(h);

        DenseDoubleMatrix y = HandWritenDigits.getYBinaryFormat();
        DenseDoubleMatrix check = (DenseDoubleMatrix) y.multiplyElementWise(MatrixOperations.log(h));
        check = check.multiply(-1);
        DenseDoubleMatrix check1 = (DenseDoubleMatrix) y.subtractBy(1).multiplyElementWise(MatrixOperations.log(h.subtractBy(1)));
        J = check.subtract(check1).sum() / HandWritenDigits.X_SIZE;
        DenseDoubleMatrix theta1FromSec = Normalization.dellA0AsColumn(theta1);
        DenseDoubleMatrix theta2FromSec = Normalization.dellA0AsColumn(theta2);
        double reg = theta1FromSec.multiplyElementWise(theta1FromSec).sum() + theta2FromSec.multiplyElementWise(theta2FromSec).sum();
        reg = reg*lambda/(2*HandWritenDigits.X_SIZE);
        return J + reg;
    }


    @Override
    public CostGradientTuple evaluateCost(DoubleVector doubleVector) {
        theta1 = new DenseDoubleMatrix(Initialization.SECCOND_LAYER_SIZE, (Initialization.INPUT_LAYER_SIZE + 1),
                doubleVector.slice((Initialization.INPUT_LAYER_SIZE + 1) * Initialization.SECCOND_LAYER_SIZE).toArray());
        theta2 = new DenseDoubleMatrix(Initialization.OUTPUT_LAYER_SIZE, Initialization.SECCOND_LAYER_SIZE + 1,
                doubleVector.slice((Initialization.INPUT_LAYER_SIZE + 1) * Initialization.SECCOND_LAYER_SIZE, doubleVector.getLength()).toArray());

        calculate();
        substractGradient();
        double cost = calculateCost(theta1, theta2);
        //double cost = calculateCost(theta1, theta2);

        /*theta1 = theta1_grad.transpose();
        theta2 = theta2_grad.transpose();*/

        return new CostGradientTuple(cost, MatrixOperations.matrixsToVector(theta1,theta2));
    }
}