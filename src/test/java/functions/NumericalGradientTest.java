package functions;

import de.jungblut.math.dense.DenseDoubleMatrix;
import org.junit.Test;

import static org.junit.Assert.*;


public class NumericalGradientTest {

    @Test
    public void calculateNumGrad() throws Exception {
        Backpropagation.calculate();
        DenseDoubleMatrix theta1_grad = Backpropagation.getTheta1_grad();
        DenseDoubleMatrix theta2_grad = Backpropagation.getTheta2_grad();

        NumericalGradient.calculateNumGrad();
        DenseDoubleMatrix numGradientTheta1 = NumericalGradient.getNumGradientTheta1();
        DenseDoubleMatrix numGradientTheta2 = NumericalGradient.getNumGradientTheta2();


        double difference = Math.sqrt(numGradientTheta1.subtract(theta1_grad.transpose()).pow(2).sum()) / Math.sqrt(numGradientTheta1.add(theta1_grad.transpose()).pow(2).sum());
        difference += Math.sqrt(numGradientTheta2.subtract(theta2_grad.transpose()).pow(2).sum()) / Math.sqrt(numGradientTheta2.add(theta2_grad.transpose()).pow(2).sum());

        //diff = norm(numgrad-grad)/norm(numgrad+grad);
        System.out.println("Sum backpropo Gradient:" + theta1_grad.sum() + " " + theta2_grad.sum());
        System.out.println("Sum check Gradient:" + numGradientTheta1.sum() + " " + numGradientTheta2.sum());
        System.out.println("difference:" + difference);

    }

}