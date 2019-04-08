import java.sql.*;

public class RateMyCoop {

    // host + driver
    static final String HOST = "jdbc:mysql://localhost:3306/twitter";
    static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    // creds
    static final String USER = "root";
    static final String PASSWORD = "root";


    public static void main (String[] args) {
        createConnection();
    }

    private static void createConnection() {

        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(HOST, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from followers");

            while (rs.next()) {

                System.out.println(rs.getString("followed_id"));
            }
        }

        catch (Exception e) {
            System.out.println(e);
        }


    }


}
