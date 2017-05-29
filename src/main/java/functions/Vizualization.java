package functions;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vizualization {
    private  static final String STR = "[0-9\\.]{1,}";
    private static int[] pixelsArray = new int [256];

    public static void drawDigit(int line) {
        List<String> digits = null;
        try {
           digits =  FileUtils.readLines(new File("S:\\git_rep\\Diploma\\src\\main\\resources\\semeion.txt"),"UTF8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(digits != null){
           drawDigit( digits.get(line+1));

        }
    }

    public static void reDrawDigit(float x, float y){
        int indexX = (int) x;
        int indexY = (int) y;

        pixelsArray[indexX * 16 + indexY] = 1;
        drawDigit(pixelsArray.toString());
    }


    private static void drawDigit(String str){
        Pattern p = Pattern.compile(STR);
        Matcher m = p.matcher(str);
        for(int i = 0; i< Initialization.INPUT_LAYER_SIZE; ++i){
            if(i% Initialization.SECCOND_LAYER_SIZE == 0){
                System.out.println();
            }
            m.find();
            double value = Double.parseDouble(m.group());
            if(value>0){
                System.out.print("*");
            }else {
                System.out.print(" ");
            }

        }
    }
}
