
package requirepackage;
import java.sql.*;
public class DBConnect {
    ResultSet rs;
    Statement stmt;
    Connection cn;
    String sql;
    DBConnect dbc;
     String url =("jdbc:mysql://localhost:3306/zidioconnect");
    
    public DBConnect(){
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           cn=DriverManager.getConnection(url,"root","9021");
           
       }catch(Exception ex){
           System.out.print(ex);
       }
    }
    public boolean addLogin(String sql)
    {
        try{
        stmt=cn.createStatement();
        stmt.executeUpdate(sql);
        }catch(Exception ex){
            System.out.println(ex);
        }
        return true;
    }
    public boolean addRegistration(String sql)
    {
        try{
        stmt=cn.createStatement();
        stmt.executeUpdate(sql);
        }catch(Exception ex){
            System.out.println(ex);
        }
        return true;
    }
    public boolean addProfile(String sql){
        try{
            stmt=cn.createStatement();
            stmt.executeUpdate(sql);
        }catch(Exception ex){
            System.out.println(ex);
        }
        return true;
    }
}
