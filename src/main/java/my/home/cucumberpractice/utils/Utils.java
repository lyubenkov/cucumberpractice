package my.home.cucumberpractice.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utils {
    public static Properties readProperties(String filename) {
        Properties prop = new Properties();
        InputStream input = null;

        try {
            input = Utils.class.getClassLoader().getResourceAsStream(filename);
            if(input==null){
                throw new IllegalArgumentException("Sorry, unable to find " + filename);
            }
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally{
            if(input!=null){
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return prop;
    }
}
