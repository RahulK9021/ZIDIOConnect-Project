

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package requirepackage;
import java.sql.*;
import java.util.ArrayList;

public class UserController {
   
     private ArrayList <UserLogin> userlist=new ArrayList<>();
     private ArrayList <Registration> reglist=new ArrayList<>();
     private ArrayList <ViewProfile> proflist =new ArrayList<>();
    DBConnect dbc;
    ResultSet rs;
    String sql;
    
    public UserController(){
        dbc=new DBConnect();
    }
     
     public boolean addLogin(UserLogin obj){
         sql="insert into userlogin values('"+obj.getUid()+"','"+obj.getPwd()+"')";
         dbc.addLogin(sql);
         return true;  
     }
     
     public boolean addRegistration(Registration obj){
         sql="insert into userregisterationuserregisteration values('"+obj.getEmail()+"','"+obj.getPassword()+"','"+obj.getFullnm()+"',"+obj.getPhoneno()+",'"+obj.getDate()+"','"+obj.getGender()+"','"+obj.getAddress()+"','"+obj.getStatus()+"','"+obj.getType()+"')";
         dbc.addRegistration(sql);
         return true;
     }
     public boolean addProfile(ViewProfile obj){
         sql="insert into viewprofile values('"+obj.getFnm()+"','"+obj.getFile()+"','"+obj.getEmail()+"','"+obj.getEducation()+"',"+obj.getPhone()+","+obj.getDob()+",'"+obj.getAddress()+"','"+obj.getType()+"','"+obj.getStatus()+"','"+obj.getLinkedin()+"','"+obj.getGithub()+"','"+obj.getPersonalwebsite()+"','"+obj.getJobtitle()+"','"+obj.getExcompany()+"','"+obj.getDuration()+"','"+obj.getSkills()+"','"+obj.getResponsibility()+"','"+obj.getExsalary()+"')";
         dbc.addProfile(sql);
         return true;
     }
}
