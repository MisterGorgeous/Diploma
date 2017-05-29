package functions;


import de.jungblut.math.dense.DenseDoubleMatrix;

public class NumericalGradient {
    private static DenseDoubleMatrix numGradientTheta1 = Initialization.randInitialize(Initialization.INPUT_LAYER_SIZE , Initialization.SECCOND_LAYER_SIZE,0);
    private static DenseDoubleMatrix numGradientTheta2 = Initialization.randInitialize(Initialization.SECCOND_LAYER_SIZE, Initialization.OUTPUT_LAYER_SIZE,0);
    private static double epsilon = 0.0001;
    private static double minusEpsilon;
    private static double plussEpsilon;
    private static double grad;
    private static DenseDoubleMatrix theta1;
    private static DenseDoubleMatrix theta2;

    public static DenseDoubleMatrix getNumGradientTheta1() {
        DenseDoubleMatrix copy = new DenseDoubleMatrix(numGradientTheta1.toArray());
        return copy;
    }

    public static DenseDoubleMatrix getNumGradientTheta2() {
        DenseDoubleMatrix copy = new DenseDoubleMatrix(numGradientTheta2.toArray());
        return copy;
    }

    public static void calculateNumGrad(){
        theta1 = Backpropagation.getTheta1();
        theta2 = Backpropagation.getTheta2();
        calculateTheta();
    }

    private static void calculateTheta( ){

        for (int i = 0; i < numGradientTheta1.getRowCount(); ++i) {
            for (int j = 0; j < numGradientTheta1.getColumnCount(); ++j) {
                //result.set(i, j, Math.log(matrix.get(i, j)));
                theta1.set(i,j,theta1.get(i,j) - epsilon);
                minusEpsilon = Backpropagation.calculateCost(theta1,theta2);
                theta1.set(i,j,theta1.get(i,j) + 2*epsilon);
                plussEpsilon = Backpropagation.calculateCost(theta1,theta2);
                grad = (plussEpsilon - minusEpsilon)/(2*epsilon);
                numGradientTheta1.set(i,j,grad);
                theta1.set(i,j,theta1.get(i,j) - epsilon);
            }
        }

        for (int i = 0; i < numGradientTheta2.getRowCount(); ++i) {
            for (int j = 0; j < numGradientTheta2.getColumnCount(); ++j) {
                //result.set(i, j, Math.log(matrix.get(i, j)));
                theta2.set(i,j,theta2.get(i,j) - epsilon);
                minusEpsilon = Backpropagation.calculateCost(theta1,theta2);
                theta2.set(i,j,theta2.get(i,j) + 2*epsilon);
                plussEpsilon = Backpropagation.calculateCost(theta1,theta2);
                grad = (plussEpsilon - minusEpsilon)/(2*epsilon);
                numGradientTheta2.set(i,j,grad);
                theta2.set(i,j,theta2.get(i,j) - epsilon);
            }
        }


    }


}
