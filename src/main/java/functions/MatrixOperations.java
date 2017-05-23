package functions;


import de.jungblut.math.dense.DenseDoubleMatrix;
import de.jungblut.math.dense.DenseDoubleVector;

public class MatrixOperations {

    public static DenseDoubleMatrix log(DenseDoubleMatrix matrix){
        DenseDoubleMatrix result = new DenseDoubleMatrix(matrix.toArray());
        for (int i = 0; i < matrix.getRowCount(); ++i) {
            for (int j = 0; j < matrix.getColumnCount(); ++j) {
                result.set(i, j, Math.log(matrix.get(i, j)));
            }
        }
        return result;
    }

    public static DenseDoubleVector matrixsToVector(DenseDoubleMatrix matrix1,DenseDoubleMatrix matrix2){
        int numElTheta1 = matrix1.getColumnCount()*matrix1.getRowCount();
        int numElTheta2 = matrix2.getColumnCount()*matrix2.getRowCount();

        DenseDoubleVector vector = new DenseDoubleVector( numElTheta1 + numElTheta2);

        for (int i = 0; i < matrix1.getRowCount(); ++i) {
            for (int j = 0; j < matrix1.getColumnCount(); ++j) {
                vector.set(matrix1.getColumnCount()*i + j,matrix1.get(i, j));
            }
        }

        for (int i = 0; i < matrix2.getRowCount(); ++i) {
            for (int j = 0; j < matrix2.getColumnCount(); ++j) {
                vector.set(numElTheta1 + matrix2.getColumnCount() * i + j, matrix2.get(i, j));
            }
        }
        return vector;
    }

}
