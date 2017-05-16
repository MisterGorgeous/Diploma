package functions;


import de.jungblut.math.dense.DenseDoubleMatrix;

public class NumericalGradient {
    private static DenseDoubleMatrix numGradientTheta1 = RandomInitialization.randInitialize(256,16,0);
    private static DenseDoubleMatrix numGradientTheta2 = RandomInitialization.randInitialize(16,10,0);
    private static DenseDoubleMatrix epsilonMatrix1 = new DenseDoubleMatrix(16,257,0);
    private static DenseDoubleMatrix epsilonMatrix2 = new DenseDoubleMatrix(10,17,0);
    private static double epsilon = 0.0001;

    public static DenseDoubleMatrix getNumGradientTheta1() {
        return numGradientTheta1;
    }

    public static DenseDoubleMatrix getNumGradientTheta2() {
        return numGradientTheta2;
    }

    public static void calculateNumGrad(){
        double minusEpsilon;
        double plussEpsilon;
        double grad;

        for (int i = 0; i < numGradientTheta1.getRowCount(); ++i) {
            for (int j = 0; j < numGradientTheta1.getColumnCount(); ++j) {
                //result.set(i, j, Math.log(matrix.get(i, j)));
                epsilonMatrix1.set(i,j,epsilon);
                minusEpsilon = Backpropagation.calculateCost((DenseDoubleMatrix) Backpropagation.getTheta1().subtract(epsilonMatrix1),Backpropagation.getTheta2());
                plussEpsilon = Backpropagation.calculateCost((DenseDoubleMatrix) Backpropagation.getTheta1().add(epsilonMatrix1),Backpropagation.getTheta2());
                grad = (plussEpsilon - minusEpsilon)/(2*epsilon);
                numGradientTheta1.set(i,j,grad);
                epsilonMatrix1.set(i,j,0);
            }
        }

        for (int i = 0; i < numGradientTheta2.getRowCount(); ++i) {
            for (int j = 0; j < numGradientTheta2.getColumnCount(); ++j) {
                //result.set(i, j, Math.log(matrix.get(i, j)));
                epsilonMatrix2.set(i,j,epsilon);
                minusEpsilon = Backpropagation.calculateCost( Backpropagation.getTheta1(), (DenseDoubleMatrix) Backpropagation.getTheta2().subtract(epsilonMatrix2));
                plussEpsilon = Backpropagation.calculateCost( Backpropagation.getTheta1(), (DenseDoubleMatrix) Backpropagation.getTheta2().add(epsilonMatrix2));
                grad = (plussEpsilon - minusEpsilon)/(2*epsilon);
                numGradientTheta2.set(i,j,grad);
                epsilonMatrix2.set(i,j,0);
            }
        }

    }
}
