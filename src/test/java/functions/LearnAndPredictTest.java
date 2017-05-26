package functions;

import org.junit.Test;

import static org.junit.Assert.*;

public class LearnAndPredictTest {

    @Test
    public void learn() throws Exception {
        LearnAndPredict.learn();
        double J = LearnAndPredict.getBackpropagation().calculateCost(Backpropagation.getTheta1(), Backpropagation.getTheta2());
        System.out.print(J);
    }

    @Test
    public void predict() throws Exception {
        double J;


        LearnAndPredict.learn();
        J = LearnAndPredict.getBackpropagation().calculateCost(Backpropagation.getTheta1(), Backpropagation.getTheta2());
        System.out.println(J);

        System.out.println(LearnAndPredict.predict(0));
        System.out.println(LearnAndPredict.predict(1));
        System.out.println(LearnAndPredict.predict(2));
        System.out.println(LearnAndPredict.predict(3));
    }
}