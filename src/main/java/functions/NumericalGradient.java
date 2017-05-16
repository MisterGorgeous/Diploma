package functions;


import de.jungblut.math.dense.DenseDoubleMatrix;

public class NumericalGradient {
    private static DenseDoubleMatrix numGradientTheta1 = RandomInitialization.randInitialize(256,16,0);
    private static DenseDoubleMatrix numGradientTheta2 = RandomInitialization.randInitialize(16,10,0);
    private static double epsilon = 0.0001;
    private static double minusEpsilon;
    private static double plussEpsilon;
    private static double grad;
    private static DenseDoubleMatrix theta1 = Backpropagation.getTheta1();
    private static DenseDoubleMatrix theta2 = Backpropagation.getTheta2();

    public static DenseDoubleMatrix getNumGradientTheta1() {
        return numGradientTheta1;
    }

    public static DenseDoubleMatrix getNumGradientTheta2() {
        return numGradientTheta2;
    }

    public static void calculateNumGrad(){
        calculateTheta(theta1,numGradientTheta1);
        calculateTheta(theta2,numGradientTheta2);
    }

    private static void calculateTheta( DenseDoubleMatrix theta,DenseDoubleMatrix numGrad){

        for (int i = 0; i < numGrad.getRowCount(); ++i) {
            for (int j = 0; j < numGrad.getColumnCount(); ++j) {
                //result.set(i, j, Math.log(matrix.get(i, j)));
                theta.set(i,j,theta.get(i,j) - epsilon);
                minusEpsilon = Backpropagation.calculateCost(theta1,theta2);
                theta.set(i,j,theta.get(i,j) + 2*epsilon);
                plussEpsilon = Backpropagation.calculateCost(theta1,theta2);
                grad = (plussEpsilon - minusEpsilon)/(2*epsilon);
                numGrad.set(i,j,grad);
                theta.set(i,j,theta.get(i,j) - epsilon);
            }
        }
    }
}
