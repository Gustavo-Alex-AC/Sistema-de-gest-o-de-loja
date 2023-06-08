import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoDB {
    static Connection con;
    static String driver = "com.mysql.cj.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/snakebar3";
    static String uname = "root";
    static String pass = "";

    public static Connection getConnection(){
        if (con ==null){
            try {
                Class.forName(driver);
                try {
                    con = DriverManager.getConnection(url,uname, pass);
                } catch (SQLException ex) {
                    Logger.getLogger(ConexaoDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConexaoDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return con;
    }
}
