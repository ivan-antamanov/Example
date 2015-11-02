import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by iantaman on 02.11.2015.
 */
public class PosTest {
    private Connection connection;

    public void connectionToDB() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection();
            System.out.println("Succesful Add driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
    }
}
