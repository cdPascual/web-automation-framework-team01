package utility;

import java.io.*;
import java.util.Properties;

public class ReadFromConfigFile {


    public static String path = System.getProperty("user.dir");
    public static Properties getProperties(){
        Properties prop = new Properties();
        try {
            InputStream inputStream = new FileInputStream(path + File.separator +"config.properties");
            prop.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop;
    }





//    Properties prop = new Properties();
//    String fileName = "app.config";
//    FileInputStream fis
//
//    {
//        try {
//            fis = new FileInputStream(fileName);
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    } {
//        prop.load(fis);
//    } catch(FileNotFoundException ex) {
//         // FileNotFoundException catch is optional and can be collapsed
//    }


}
