import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
    
    private String UserName = "root";
    private String Password = "12345";
    private String DbUrl = "jdbc:mysql://localhost:3306/bookcase?useSSL=false&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    
    public Connection getConnection() throws SQLException{   
        return DriverManager.getConnection(DbUrl, UserName, Password);
    }
    
    public void showErrorMessage(SQLException e){
        
        System.out.println("Error code : " + e.getErrorCode());
        System.out.println("Error : " + e.getMessage());
    }

}
