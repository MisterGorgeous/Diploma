package functions;

import de.jungblut.math.dense.DenseDoubleMatrix;
import de.jungblut.math.dense.DenseDoubleVector;
import de.jungblut.math.minimize.CostGradientTuple;
import org.junit.Test;

import static org.junit.Assert.*;

public class BackpropagationTest {

    @Test
    public void calculate() throws Exception {
        Backpropagation.calculate();
        DenseDoubleMatrix matrix = Backpropagation.getTheta1_grad();
        matrix = Backpropagation.getTheta2_grad();
    }

    @Test
    public void calculateCost() throws Exception {
        double J = Backpropagation.calculateCost(Backpropagation.getTheta1(),Backpropagation.getTheta2());
        System.out.print(J);
    }

    @Test
    public void evaluateCost() throws Exception {
        Backpropagation backpropagation = new Backpropagation();
        //double cost = Backpropagation.calculateCost(Backpropagation.getTheta1(),Backpropagation.getTheta2())
        DenseDoubleVector vector = MatrixOperations.matrixsToVector(Backpropagation.getTheta1(),Backpropagation.getTheta2());
        CostGradientTuple costGradientTuple = backpropagation.evaluateCost(vector);
        System.out.print(costGradientTuple.getCost());
    }

}