package functions;

import org.junit.Test;

import static org.junit.Assert.*;

public class VizualizationTest {
    @Test
    public void drawDigit() throws Exception {
        Vizualization.drawDigit(1000);
        Vizualization.drawDigit(1500);
    }

}