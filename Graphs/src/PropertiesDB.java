import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by iantaman on 02.11.2015.
 */
public class PropertiesDB {
//    FileInputStream fis;

    String url;
    String user;
    String password;

    public String init() {
        try (FileInputStream fis = new FileInputStream("src/main/resources/config.properties")) {
            Properties property = new Properties();
            property.load(fis);

            

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void checkUrl() {

    }

    public String ckeckUser() {

        return null;
    }

    public String checkPassword() {

        return null;
    }
}
