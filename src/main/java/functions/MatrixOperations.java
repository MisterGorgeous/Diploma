package functions;


import de.jungblut.math.dense.DenseDoubleMatrix;

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
}
