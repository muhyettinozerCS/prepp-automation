package utils;


import java.io.InputStream;
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

    public static String getMail() {
        return properties.getProperty("mail");
    }

    public static String getMailPassword() {
        return properties.getProperty("mailPassword");
    }
}
