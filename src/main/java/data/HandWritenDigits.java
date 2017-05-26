package data;

import de.jungblut.math.DoubleVector;
import de.jungblut.math.dense.DenseDoubleMatrix;
import de.jungblut.math.dense.DenseDoubleVector;
import functions.Initialization;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HandWritenDigits {
    private static DenseDoubleMatrix x;
    private static DenseDoubleMatrix y;
    private static DenseDoubleMatrix y_binary_format;
    private static final String PATH = "S:\\git_rep\\Diploma\\src\\main\\resources\\semeion.txt";
    private static final String REGEXP = "[0-9\\.]{1,}";

    public static  int X_SIZE = 1590;


    public static DenseDoubleMatrix getXRowMat(int index) {
        if (x == null) {
            load();
        }
        double[][] mat = {x.getRow(index)};
        return new DenseDoubleMatrix(mat);
    }

    public static DenseDoubleMatrix getX() {
        if (x == null) {
            load();
        }
        return new DenseDoubleMatrix(x.toArray());
    }

    private static void load() {
        List<String> digits = null;
        List<DoubleVector> xVector = new ArrayList<>();
        try {
            digits = FileUtils.readLines(new File(PATH), "UTF8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (digits != null) {
            for (String str : digits) {
                Pattern p = Pattern.compile(REGEXP);
                Matcher m = p.matcher(str);

                DenseDoubleVector vector = new DenseDoubleVector(Initialization.INPUT_LAYER_SIZE);
                for (int i = 0; i < Initialization.INPUT_LAYER_SIZE; ++i) {
                    m.find();
                    double value = Double.parseDouble(m.group());
                    vector.set(i, value);
                }
                xVector.add(vector);
            }
            x = new DenseDoubleMatrix(xVector);
        }
    }

    public static DenseDoubleMatrix getY() {
        if (y == null) {
            setY();
        }
        return new DenseDoubleMatrix(y.toArray());
    }

    private static void setY() {
        y = new DenseDoubleMatrix(1, X_SIZE);
        int i;
        for (int j = 0; j < X_SIZE; ++j) {
            i = j % 200;
            y.set(0, j, Math.ceil(i / 20));
        }
    }

    public static DenseDoubleMatrix getYBinaryFormat(int index) {
        getY();
        if (y_binary_format == null) {
            setY_binary_format();
        }
        double[][] mat = {y_binary_format.getRow(index)};
        return new DenseDoubleMatrix(mat);
    }

    public static DenseDoubleMatrix getYBinaryFormat() {
        getY();
        if (y_binary_format == null) {
            setY_binary_format();
        }
        return new DenseDoubleMatrix(y_binary_format.toArray());
    }

    private static void setY_binary_format() {
        y_binary_format = new DenseDoubleMatrix(X_SIZE, Initialization.OUTPUT_LAYER_SIZE);
        for (int i = 0; i < X_SIZE; ++i) {
            if((int) y.get(0, i) < Initialization.OUTPUT_LAYER_SIZE ) {
                y_binary_format.set(i, (int) y.get(0, i), 1);
            }
        }
    }

}
