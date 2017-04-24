package functions;

import de.jungblut.math.dense.DenseDoubleMatrix;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


public class Normalization {

    public static DenseDoubleMatrix addA0asColumn(DenseDoubleMatrix matrix) {
        DenseDoubleMatrix norm = new DenseDoubleMatrix(matrix.getRowCount(), matrix.getColumnCount() + 1, 1);

        for (int i = 0; i < matrix.getRowCount(); ++i) {
            for (int j = 0; j < matrix.getColumnCount(); ++j) {
                norm.set(i, j + 1, matrix.get(i, j));
            }
        }
        return norm;
    }

    public static DenseDoubleMatrix addColumn(DenseDoubleMatrix matrix, double[] column) {
        double[][] doubMatrix = matrix.toArray();
        double[][] result = new double[matrix.getRowCount()][matrix.getColumnCount() + 1];
        for (int i = 0; i < matrix.getRowCount(); ++i) {
            result[i][0] = column[i];
        }
        for (int i = 0; i < matrix.getRowCount(); ++i) {
            for (int j = 0; j < matrix.getColumnCount(); ++j) {
                result[i][j + 1] = doubMatrix[i][j];
            }
        }
        return new DenseDoubleMatrix(result);
    }


    public static DenseDoubleMatrix dellA0AsColumn(DenseDoubleMatrix matrix) {
        if (matrix.getColumnCount() > 1) {
            DenseDoubleMatrix norm = new DenseDoubleMatrix(matrix.getRowCount(), matrix.getColumnCount() - 1, 1);

            for (int i = 0; i < matrix.getRowCount(); ++i) {
                for (int j = 1; j < matrix.getColumnCount(); ++j) {
                    norm.set(i, j - 1, matrix.get(i, j));
                }
            }

            return norm;
        } else {
            return null;
        }
    }

}

