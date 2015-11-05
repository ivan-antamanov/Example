package graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by iantaman on 02.11.2015.
 */
public class PropertiesDB {

    private String url;
    private String user;
    private String password;

    public PropertiesDB() {
        init();
    }

    public void init() {
        try (FileInputStream fis = new FileInputStream("src/main/resources/config.properties")) {
            Properties property = new Properties();
            property.load(fis);

            url = property.getProperty("url");
            user = property.getProperty("user");
            password = property.getProperty("password");

        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
        } catch (IOException e) {
            System.out.println("File reading error");
        }

    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }
}