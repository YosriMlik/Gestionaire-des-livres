import java.sql.*;

public class JDBC {
    
    private String url="jdbc:mysql://localhost/test";
    private String user="root";
    private String password = "";
    public Connection conn = null ;
    private static JDBC instance = new JDBC();
    
    public static JDBC getInstance(){
        return instance ;
    }
    
    private JDBC(){
        if(conn==null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver O.K.");
                conn = DriverManager.getConnection(url,user,password);
            }
            catch(SQLException e){
                System.out.println(e.getMessage());
            } 
            catch (ClassNotFoundException ex){
                System.out.println(ex.getMessage());
            }
        }        
    }
}