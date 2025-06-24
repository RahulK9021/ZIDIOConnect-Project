

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
//     public ArrayList<Applicant> getApplicants(int id){
//         String sql="select candidate_email,post_type,fullname,resume,education,phoneno,gender,linkedin,github,pwebsite,jobtitile,excompany,duration,skills,responsibility,exsalary from recruiter_inbox where recruiter_email=?";
//         String recruiterEmail = (String) session.getAttribute("recruiterEmail"); 
//         stmt.setString(1, recruiterEmail);
//         applist =new ArrayList<>();
//         try{
//             rs=dbc.getApplicants(sql);
//             if(rs != null){
//                 while(rs.next()){
//                     Applicant app=new Applicant();
//                     app.setCandidate_email(rs.getString(1));
//                     app.setJob_id(rs.getString(2));
//                     app.setPost_type(rs.getString(3));
//                     app.setFullname(rs.getString(4));
//                     app.setResume(rs.getString(5));
//                     app.setEducation(rs.getString(6));
//                     app.setPhoneno(rs.getString(7));
//                     app.setDate(rs.getDate(8));
//                     app.setAddress(rs.getString(9));
//                     app.setGender(rs.getString(10));
//                     app.setLinkedin(rs.getString(11));
//                     app.setGithub(rs.getString(12));
//                     app.setJobtitile(rs.getString(13));
//                     app.setExcompany(rs.getString(14));
//                     app.setDuration(rs.getString(15));
//                     app.setSkills(rs.getString(16));
//                     app.setResponsibility(rs.getString(17));
//                     app.setExsalary(rs.getString(18));
//                     applist.add(app);
//                 }
//             }
//         }catch(Exception ex){
//             System.out.println(ex);
//         }
//         return applist;
//     }
     
//     public boolean addRecruiter(Recruiter obj){
//         sql="insert into recruiter values('"+obj.getRecemail()+"','"+obj.getRecpwd()+"','"+obj.getRecfnm()+"','"+obj.getComweb()+"','"+obj.getComnm()+"','"+obj.getJr()+"','"+obj.getSkill()+"','"+obj.getLoc()+"',"+obj.getDeadline()+",'"+obj.getSalary()+"','"+obj.getExp()+"','"+obj.getDec()+"')";
//         dbc.addRecruiter(sql);
//         return true;
//     }
}
