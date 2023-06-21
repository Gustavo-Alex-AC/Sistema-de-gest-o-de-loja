/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snackbar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author GonçaloJ
 */
public class ConexaoDB {
     static Connection con;
    static String driver = "com.mysql.cj.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/snakebar";
    static String uname = "root";
    static String pass = "";

    public static Connection getConnection(){
        if (con ==null){
            try {
                Class.forName(driver);
                try {
                    con = DriverManager.getConnection(url,uname, pass);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }

        return con;
    }
}
