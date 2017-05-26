package functions;

import org.junit.Test;

public class RandomInitializationTest {
    @Test
    public void randInitialize() throws Exception {
        System.out.println(Initialization.randInitialize(3, 4, 0.12));
    }

}