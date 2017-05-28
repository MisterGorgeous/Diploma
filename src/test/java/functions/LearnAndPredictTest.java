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

        J = LearnAndPredict.getBackpropagation().calculateCost(Backpropagation.getTheta1(), Backpropagation.getTheta2());
        System.out.println(J);
        LearnAndPredict.learn();
        J = LearnAndPredict.getBackpropagation().calculateCost(Backpropagation.getTheta1(), Backpropagation.getTheta2());
        System.out.println(J);

        System.out.println(LearnAndPredict.predict(0));
        System.out.println(LearnAndPredict.predict(49));
        System.out.println(LearnAndPredict.predict(27));
        System.out.println(LearnAndPredict.predict(355));
        System.out.println(LearnAndPredict.predict(122));
        System.out.println(LearnAndPredict.predict(123));
        System.out.println(LearnAndPredict.predict(124));
        System.out.println(LearnAndPredict.predict(169));
        System.out.println(LearnAndPredict.predict(543));
        System.out.println(LearnAndPredict.predict(1130));

    }
}