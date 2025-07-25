
package requirepackage;
import java.sql.*;
public class DBConnect {
    ResultSet rs;
    Statement stmt;
    Connection cn;
    String sql;
    DBConnect dbc;
    String url =("jdbc:mysql://localhost:3306/zidioconnect?useSSL=false");
    
    public DBConnect(){
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           cn=DriverManager.getConnection(url,"root","9021");
           
       }catch(Exception ex){
           System.out.print(ex);
       }
    }
     public Connection getConnection() {
        return cn;
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
    public boolean addUserRegistration(String sql)
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
    
    public boolean addRecruiter(String sql){
        try{
            stmt=cn.createStatement();
            stmt.executeUpdate(sql);
        }catch(Exception ex){
            System.out.println(ex);
        }
         return true;
    }
    
    
    public ResultSet getInternships(String sql){
        try{
        stmt=cn.createStatement();
        rs=stmt.executeQuery(sql);
    }catch(Exception ex){
            System.out.println(ex);
            }
        return rs;
    }
    
    public ResultSet getJobs(String sql){
        try{
            stmt=cn.createStatement();
            rs=stmt.executeQuery(sql);
        }catch(Exception ex){
            System.out.println(ex);
        }
        return rs;
    }
    public ResultSet getApplicants(String sql){
        try{
            stmt=cn.createStatement();
            rs=stmt.executeQuery(sql);
        }catch(Exception ex){
            System.out.println(ex);
        }
        return rs;
    }
    public boolean addPost(String sql){
        try{
            stmt=cn.createStatement();
            stmt.executeUpdate(sql);
        }catch(Exception ex){
            System.out.println(ex);
        }
         return true;
    }
     public ResultSet getNewinternships(String sql){
        try{
        stmt=cn.createStatement();
        rs=stmt.executeQuery(sql);
    }catch(Exception ex){
            System.out.println(ex);
            }
        return rs;
    }
    
    public ResultSet getNewjobs(String sql){
        try{
            stmt=cn.createStatement();
            rs=stmt.executeQuery(sql);
        }catch(Exception ex){
            System.out.println(ex);
        }
        return rs;
    }
    
}
