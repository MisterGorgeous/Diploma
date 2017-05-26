package functions;

import de.jungblut.math.DoubleVector;
import de.jungblut.math.dense.DenseDoubleMatrix;

public class Sigmoid {

    public static DenseDoubleMatrix sigmoid(DenseDoubleMatrix matrix){
        DoubleVector[] vectors = new DoubleVector[ matrix.getRowCount()];
        for(int i=0; i < matrix.getRowCount(); ++i ){
            vectors[i] =  matrix.getRowVector(i).multiply(-1).exp().add(1).divideFrom(1);
        }
        DenseDoubleMatrix copy = new DenseDoubleMatrix(vectors);
        return copy;
    }

    public static DenseDoubleMatrix sigmoidGradient(DenseDoubleMatrix matrix){
        DenseDoubleMatrix gz = sigmoid(matrix);
        DoubleVector[] vectors = new DoubleVector[ gz.getRowCount()];
        for(int i=0; i < gz.getRowCount(); ++i ){
            vectors[i] =  gz.getRowVector(i).multiply(gz.getRowVector(i).subtractFrom(1));
        }
        DenseDoubleMatrix copy = new DenseDoubleMatrix(vectors);
        return copy;
    }

}
