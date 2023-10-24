package loginform;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class My_CNX {
    
    private static String servername = "localhost";
    private static String username = "root";
    private static String dbname = "users_db";
    private static int portnumber = 3306;
    private static String password = "";
    
    public static Connection getConnection()
    {
        Connection cnx = null;
        
        MysqlDataSource datasource = new MysqlDataSource();

        datasource.setServerName(servername);
        datasource.setUser(username);
        datasource.setPassword(password);
        datasource.setDatabaseName(dbname);
        datasource.setPortNumber(portnumber);
        
        try {
            cnx = datasource.getConnection();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(My_CNX.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
         
        return cnx;
    }
}