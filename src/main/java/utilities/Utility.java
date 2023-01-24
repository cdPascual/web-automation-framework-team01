package utilities;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Properties;

public class Utility{
    public static Properties getProperties(){
        Properties prop = new Properties();

        try {
            InputStream inputStream = new FileInputStream("C:\\Users\\CarlosP\\OneDrive\\Desktop\\NovProject2022\\Nov2022Framework\\config.properties");
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
//        String toEncode = "XzsZaJzisuHwJ4qdoDpY";
//        String encoded = Base64.getEncoder().encodeToString(toEncode.getBytes());
//        System.out.println(encoded);
//    }

}
