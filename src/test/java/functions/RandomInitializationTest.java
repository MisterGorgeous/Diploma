package functions;

import org.junit.Test;

import static org.junit.Assert.*;

public class RandomInitializationTest {
    @Test
    public void randInitialize() throws Exception {
        System.out.println(RandomInitialization.randInitialize(3, 4, 0.12));
    }

}