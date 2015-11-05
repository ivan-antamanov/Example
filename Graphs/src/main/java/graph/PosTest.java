package graph;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by iantaman on 02.11.2015.
 */
public class PosTest {
    private Connection connection;
    private PropertiesDB propertiesDB;


    public void connectionToDB() {
        try {
            propertiesDB = new PropertiesDB();

            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(propertiesDB.getUrl(),propertiesDB.getUser(), propertiesDB.getPassword());
            System.out.println("Successful connection");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
        } catch (SQLException e) {
//            System.out.println("SQLException");
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        PosTest posTest = new PosTest();
        posTest.connectionToDB();
    }
}
