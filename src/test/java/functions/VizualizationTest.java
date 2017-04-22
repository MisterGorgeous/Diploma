package functions;

import org.junit.Test;

import static org.junit.Assert.*;

public class VizualizationTest {
    @Test
    public void drawDigit() throws Exception {
        for(int i=1500;i<1573;i++) {
            Vizualization.drawDigit(i);
            System.out.println();
        }
        //Vizualization.drawDigit(1500);
    }

}