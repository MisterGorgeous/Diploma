package functions;

import data.HandWritenDigits;
import de.jungblut.math.dense.DenseDoubleMatrix;
import de.jungblut.math.dense.DenseDoubleVector;
import de.jungblut.math.minimize.Fmincg;


public class LearnAndPredict {
    private static Backpropagation backpropagation = new Backpropagation();

    private static double classification(DenseDoubleMatrix weightVector){
        double max = 4.9E-324D;
        int index = -1;

        for (int j = 0; j < weightVector.getColumnCount(); ++j) {
             if(weightVector.get(0, j) > max){
                 index = j;
             }
        }
        return index;
    }

    public static Backpropagation getBackpropagation() {
        return backpropagation;
    }

    public static void learn(){
       // Fmincg fmincg = new Fmincg();
        DenseDoubleVector vector = Backpropagation.getTheta1and2AsVector();
        DenseDoubleVector result = (DenseDoubleVector) Fmincg.minimizeFunction(backpropagation,vector,50,true);
        Backpropagation.setTheta1and2AsVector(result);
    }

    public static double predict(int i) {
        DenseDoubleMatrix matrix = HandWritenDigits.getXRowMat(i);
        matrix = Normalization.addA0asColumn(matrix);
        DenseDoubleMatrix h = (DenseDoubleMatrix) matrix.multiply(Backpropagation.getTheta1().transpose());
        h = Normalization.addA0asColumn(h);
        h = (DenseDoubleMatrix) h.multiply(Backpropagation.getTheta2().transpose());
        return classification(h);
    }
}
