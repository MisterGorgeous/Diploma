package functions;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vizualization {

    public static void drawDigit(int line) {
        List<String> digits = null;
        try {
           digits =  FileUtils.readLines(new File("S:\\git_rep\\Diploma\\src\\main\\resources\\semeion.txt"),"UTF8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(digits != null){
            String str = digits.get(line+1);
            Pattern p = Pattern.compile("[0-9\\.]{1,}");
            Matcher m = p.matcher(str);
            for(int i=0;i<256;++i){
                if(i%16 == 0){
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
}
