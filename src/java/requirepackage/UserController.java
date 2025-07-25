

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
     private ArrayList <Recruiter> reclist=new ArrayList<>();
     private ArrayList<Applicant>applist=new ArrayList<>();
     private ArrayList<Internship>postlist=new ArrayList<>();
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
     
    public boolean addUserRegistration(Registration obj) {
    String sql = "INSERT INTO jobseeker (email, password, full_name, phone, dob, gender) VALUES (?, ?, ?, ?, ?, ?)";
    try (Connection con = dbc.getConnection();
     PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setString(1, obj.getEmail());
        ps.setString(2, obj.getPassword());
        ps.setString(3, obj.getFullnm());
        ps.setString(4, obj.getPhoneno());
        ps.setDate(5, obj.getDate());   // java.sql.Date directly here
        ps.setString(6, obj.getGender());

        int rows = ps.executeUpdate();
        System.out.println("Rows inserted: " + rows);
        return rows > 0;
       
    } catch (SQLException e) {
        e.printStackTrace();
       
    }
     return false;
    }

     public boolean addProfile(ViewProfile obj){
         sql="insert into viewprofile values('"+obj.getFnm()+"','"+obj.getFile()+"','"+obj.getEmail()+"','"+obj.getEducation()+"',"+obj.getPhone()+","+obj.getDob()+",'"+obj.getAddress()+"','"+obj.getType()+"','"+obj.getStatus()+"','"+obj.getLinkedin()+"','"+obj.getGithub()+"','"+obj.getPersonalwebsite()+"','"+obj.getJobtitle()+"','"+obj.getExcompany()+"','"+obj.getDuration()+"','"+obj.getSkills()+"','"+obj.getResponsibility()+"','"+obj.getExsalary()+"')";
         dbc.addProfile(sql);
         return true;
     }
     
     public boolean addRecruiter(Recruiter obj){
        String sql = "INSERT INTO recruiter (recruiter_email, password, full_name, comwebsite, comname, jobroll, skill, loc, deadline, salary, exp, des, post_type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
 try{
             Connection con=dbc.getConnection();
             PreparedStatement ps=con.prepareStatement(sql);
             ps.setString(1, obj.getRecemail());
             ps.setString(2, obj.getRecpwd());
             ps.setString(3, obj.getRecfnm());
             ps.setString(4, obj.getComweb());
              ps.setString(5, obj.getComnm());
              ps.setString(6, obj.getJr());
             ps.setString(7, obj.getSkill());
             ps.setString(8, obj.getLoc());
             ps.setDate(9, obj.getDeadline());
             ps.setString(10, obj.getSalary());
             ps.setString(11, obj.getExp());
             ps.setString(12, obj.getDec());
             ps.setString(13, obj.getPostType());
             int row=ps.executeUpdate();
             System.out.println("rows inserted"+row);
             return row>0;
            }catch(Exception ex){
                System.out.println(ex);
            }
         return false;
    }
     
     public ArrayList <Recruiter> getRecordsByPost(Recruiter obj){
         String sql = "SELECT comname, jobroll, skill, loc, deadline, salary, exp, des FROM recruiter WHERE post_type = 'internship'";

         reclist=new ArrayList <>();
         try{
         rs=dbc.getInternships(sql);
        while(rs.next()){
             Recruiter rec=new Recruiter();
             rec.setComnm(rs.getString(1));
             rec.setJr(rs.getString(2));
             rec.setSkill(rs.getString(3));
             rec.setLoc(rs.getString(4));
             rec.setDeadline(rs.getDate(5));
             rec.setSalary(rs.getString(6));
             rec.setExp(rs.getString(7));
             rec.setDec(rs.getString(8));
             reclist.add(rec);            
         }
         }catch(Exception ex){
             System.out.println(ex );
         }
         return reclist;
     }
     
     public ArrayList<Recruiter> getJobs(){
         String sql="select comname,jobroll,skill,loc,deadline,salary,exp,des from recruiter where post_type ='job'";
         reclist=new ArrayList<>();
         try{
         rs=dbc.getJobs(sql);
         while(rs.next()){
             Recruiter rec=new Recruiter();
             rec.setComnm(rs.getString(1));
             rec.setJr(rs.getString(2));
             rec.setSkill(rs.getString(3));
             rec.setLoc(rs.getString(4));
             rec.setDeadline(rs.getDate(5));
             rec.setSalary(rs.getString(6));
             rec.setExp(rs.getString(7));
             rec.setDec(rs.getString(8));
             reclist.add(rec);
         }
         }catch(Exception ex){
             System.out.println(ex);
         }
         return reclist;
     }
    
public boolean addPost(Internship post) {
    boolean flag = false;
    try {
        Connection con = dbc.getConnection();
        String query = "INSERT INTO newpost (recruiter_email, comname, jobroll, skill, loc, deadline, salary, exp, des, post_type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, post.getRecemail());
        pst.setString(2, post.getComnm());
        pst.setString(3, post.getJr());
        pst.setString(4, post.getSkill());
        pst.setString(5, post.getLoc());
        pst.setDate(6, post.getDeadline());
        pst.setString(7, post.getSalary());
        pst.setString(8, post.getExp());
        pst.setString(9, post.getDec());
        pst.setString(10, post.getPostType());

        int rows = pst.executeUpdate();
        if (rows > 0) flag = true;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return flag;
}
     public ArrayList <Internship> getNewinternships(Internship obj){
         String sql = "SELECT comname, jobroll, skill, loc, deadline, salary, exp, des FROM newpost WHERE post_type = 'internship'";

         postlist=new ArrayList <>();
         try{
         rs=dbc.getNewinternships(sql);
        while(rs.next()){
             Internship rec=new Internship();
             rec.setComnm(rs.getString(1));
             rec.setJr(rs.getString(2));
             rec.setSkill(rs.getString(3));
             rec.setLoc(rs.getString(4));
             rec.setDeadline(rs.getDate(5));
             rec.setSalary(rs.getString(6));
             rec.setExp(rs.getString(7));
             rec.setDec(rs.getString(8));
             postlist.add(rec);            
         }
         }catch(Exception ex){
             System.out.println(ex );
         }
         return postlist;
     }
     
     public ArrayList<Internship> getNewjobs(){
         String sql="select comname,jobroll,skill,loc,deadline,salary,exp,des from newpost where post_type ='job'";
         postlist=new ArrayList<>();
         try{
         rs=dbc.getNewjobs(sql);
         while(rs.next()){
             Internship rec=new Internship();
             rec.setComnm(rs.getString(1));
             rec.setJr(rs.getString(2));
             rec.setSkill(rs.getString(3));
             rec.setLoc(rs.getString(4));
             rec.setDeadline(rs.getDate(5));
             rec.setSalary(rs.getString(6));
             rec.setExp(rs.getString(7));
             rec.setDec(rs.getString(8));
             postlist.add(rec);
         }
         }catch(Exception ex){
             System.out.println(ex);
         }
         return postlist;
     }
     
   public boolean updateProfile(ViewProfile vp) {
    try {
        Connection conn = dbc.getConnection();
        String query = "UPDATE viewprofile SET fnm=?, file=?, education=?, phone=?, dob=?, address=?, type=?, status=?, linkedin=?, github=?, personalwebsite=?, jobtitle=?, excompany=?, duration=?, skills=?, responsibility=?, exsalary=? WHERE email=?";
        PreparedStatement pst = conn.prepareStatement(query);
        // Set parameters...
        pst.setString(1, vp.getFnm());
        pst.setString(2, vp.getFile());
        pst.setString(3, vp.getEducation());
        pst.setString(4, vp.getPhone());
        pst.setDate(5, vp.getDob());
        pst.setString(6, vp.getAddress());
        pst.setString(7, vp.getType());
        pst.setString(8, vp.getStatus());
        pst.setString(9, vp.getLinkedin());
        pst.setString(10, vp.getGithub());
        pst.setString(11, vp.getPersonalwebsite());
        pst.setString(12, vp.getJobtitle());
        pst.setString(13, vp.getExcompany());
        pst.setString(14, vp.getDuration());
        pst.setString(15, vp.getSkills());
        pst.setString(16, vp.getResponsibility());
        pst.setString(17, vp.getExsalary());
        pst.setString(18, vp.getEmail());
        
        int result = pst.executeUpdate();
        conn.close();
        return result > 0;
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}

}
