import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws IOException, SQLException {

        //Считать конфиг
        Properties prop = new Properties();
        InputStream stream = ClassLoader.getSystemResourceAsStream("SQL.properties");
        prop.load(stream);

        String url = prop.getProperty("url");
        String name = prop.getProperty("username");
        String password = prop.getProperty("password");

        String sqlQuery = "Select * from animals";

        try {
            Connection con = DriverManager.getConnection(url, name, password);
        Statement statement= con.createStatement();
        ResultSet result= statement.executeQuery(sqlQuery);
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
 
    }
}