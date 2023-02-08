package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Properties;

public class Utility{

    public static String path = System.getProperty("user.dir");
    public static Properties getProperties(){
        Properties prop = new Properties();

        try {
            File file = new File("config.properties");
            InputStream inputStream = new FileInputStream(file.getAbsolutePath());
            prop.load(inputStream);
            inputStream.close();
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
        return prop;
    }

    public static String decode(String key){
        byte[] decodeBytes = Base64.getDecoder().decode(key.getBytes());
        return new String( decodeBytes  );

    }

//    public static void main(String[] args){
//        String toEncode = "roni_cost3@example.com";
//        String encoded = Base64.getEncoder().encodeToString(toEncode.getBytes());
//        System.out.println(encoded);
//    }



}
