package utils;


import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class Config {
    private static final Properties properties = new Properties();


    static {
        try (InputStream input = Config.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getMail() {return properties.getProperty("mail");}
    public static List<String> getKeyword() {

        return List.of(properties.getProperty("keyword").split(","));
                }
    public static String getFilePath() {return properties.getProperty("filePath");}

    public static String getMailPassword() {
        return properties.getProperty("mailPassword");
    }
}
