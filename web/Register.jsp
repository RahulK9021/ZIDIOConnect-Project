<%-- 
    Document   : Resister.html
    Created on : May 16, 2025, 7:13:08 PM
    Author     : Rahul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="requirepackage.DBConnect" %>
<%@page import="requirepackage.Registration" %>
<%@page import="requirepackage.UserController" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@page import="requirepackage.Recruiter" %>
<%--<%@page import="java.lang.Exception%>--%>
<%
            DBConnect dbc=new DBConnect();
            UserController utc=new UserController();
            if(request.getParameter("btnsub") != null){
                Registration reg=new Registration();
               
                reg.setEmail(request.getParameter("uid"));
//                 System.out.println("email " + reg.getEmail());
                reg.setPassword(request.getParameter("pwd"));
//                  System.out.println("pwd " + reg.getPassword());
                reg.setFullnm(request.getParameter("unm"));
//                  System.out.println("fnm " + reg.getFullnm());
                String phoneStr = request.getParameter("phone");
                if (phoneStr != null && phoneStr.matches("\\d{10}")) {
                    reg.setPhoneno(phoneStr);  // Store as String
                } else {
                    System.out.println("Invalid or missing phone number: " + phoneStr);
                }
//                  System.out.println("[phone " + reg.getPhoneno());
               try {
                String dateStr = request.getParameter("dob");
                if (dateStr != null && !dateStr.isEmpty()) {
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    Date utilDate = formatter.parse(dateStr); 
                    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); 
                    reg.setDate(sqlDate);
                } else {
                    System.out.println("Date parameter is missing or empty.");
                }
                } catch (Exception ex) {
                    ex.printStackTrace(); // Log the error to help debug
                }
//              System.out.println("dob " + reg.getDate());
                reg.setGender(request.getParameter("gender"));
//                  System.out.println("gender " + reg.getGender());
               boolean saved = utc.addUserRegistration(reg);
//                System.out.println("Saved: " + saved);
                if(saved) {
                    response.sendRedirect("Login.jsp");
                }
                }
                
                
                
                else if(request.getParameter("btnrecsub") != null)
                {
                    Recruiter rec=new Recruiter();
                    rec.setRecemail(request.getParameter("recid"));
                    rec.setRecpwd(request.getParameter("recpwd"));
                    rec.setRecfnm(request.getParameter("recfnm"));
                    rec.setComweb(request.getParameter("comweb"));
                    rec.setComnm(request.getParameter("comnm"));
                    rec.setJr(request.getParameter("jr"));
                    rec.setSkill(request.getParameter("skill"));
                    rec.setLoc(request.getParameter("loc"));
                   try {
                String dateStr = request.getParameter("deadline");
                if (dateStr != null && !dateStr.isEmpty()) {
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    Date utilDate = formatter.parse(dateStr); 
                    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); 
                    rec.setDeadline(sqlDate);
                } else {
                    System.out.println("Date parameter is missing or empty.");
                }
                } catch (Exception ex) {
                    ex.printStackTrace(); // Log the error to help debug
                }
                    rec.setSalary(request.getParameter("salary"));
                    rec.setExp(request.getParameter("exp"));
                    rec.setDec(request.getParameter("des"));
                    String postType = request.getParameter("post_type");
                    rec.setPostType(postType); // You will need to add this setter in your Recruiter class

                    System.out.println("email " + rec.getRecemail());
                    System.out.println("password " + rec.getRecpwd());
                   
                     System.out.println("name " + rec.getRecfnm());
                      System.out.println("website " + rec.getComweb());
                       System.out.println("comnm " + rec.getComnm());
                        System.out.println("roll " + rec.getJr());
                         System.out.println("skill " + rec.getSkill());
                          System.out.println("location " + rec.getLoc());
                           System.out.println("deadline " + rec.getDeadline());
                            System.out.println("salary " + rec.getSalary());
                             System.out.println("exp " + rec.getExp());
                              System.out.println("description " + rec.getDec());
                              System.out.println("Post Type: " + postType);
                    java.util.Enumeration paramNames = request.getParameterNames();
                    while(paramNames.hasMoreElements()) {
                        String param = (String)paramNames.nextElement();
                        System.out.println(param + " = " + request.getParameter(param));
                    }
                    boolean save=utc.addRecruiter(rec);
                    if(save == true){
                    System.out.println("Saved? " + save);
                    response.sendRedirect("Login.jsp");
                    }
            }
            else{
            System.out.println("Invalid login fromat");
    }
//                   
        %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
         <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;700&display=swap" rel="stylesheet">
         <link rel="stylesheet" href="css/Register.css">

        <script>
window.onload = function () {
    const internshipBtn = document.getElementById("internshipToggle");
    const jobBtn = document.getElementById("jobToggle");
    const internshipFields = document.getElementById("internshipFields");
    const jobFields = document.getElementById("jobFields");
    const postTypeField = document.getElementById("postType");

    // Hide both initially and disable all inputs
    internshipFields.classList.add("hidden");
    jobFields.classList.add("hidden");
    disableInputs(internshipFields, true);
    disableInputs(jobFields, true);

    // Jobseeker/Recruiter toggles (same as before)
    document.getElementById("jobseekerBtn").addEventListener("click", function () {
        document.getElementById("jobseekerForm").classList.add("show");
        document.getElementById("recruiterForm").classList.remove("show");
    });

    document.getElementById("recruiterBtn").addEventListener("click", function () {
        document.getElementById("recruiterForm").classList.add("show");
        document.getElementById("jobseekerForm").classList.remove("show");
    });

    // Internship button
    internshipBtn.addEventListener("click", function () {
        postTypeField.value = "internship";
        internshipFields.classList.remove("hidden");
        jobFields.classList.add("hidden");
        disableInputs(internshipFields, false);
        disableInputs(jobFields, true);
        setRequired(internshipFields, true);
        setRequired(jobFields, false);
    });

    // Job button
    jobBtn.addEventListener("click", function () {
        postTypeField.value = "job";
        jobFields.classList.remove("hidden");
        internshipFields.classList.add("hidden");
        disableInputs(jobFields, false);
        disableInputs(internshipFields, true);
        setRequired(jobFields, true);
        setRequired(internshipFields, false);
    });

    function disableInputs(container, shouldDisable) {
        container.querySelectorAll('input').forEach(input => input.disabled = shouldDisable);
    }

    function setRequired(container, required) {
        container.querySelectorAll('input').forEach(input => input.required = required);
    }
};
</script>
        <style>
             .btn-grp{
        display: flex;
        align-content: space-between;
        justify-content: center;
        margin-left: 10px;
    }
        </style>
    </head>
    
    <body>
  <div class="from-wrapper ">
   <h1>Register as :</h1>
   <div class="btn-grp">
   <button id="jobseekerBtn">Jobseeker</button>
   <button id="recruiterBtn">Recruiter</button> 
   </div>
    
   
   <div id="jobseekerForm" class="hidden">
        <form method="post">
       <div class="form-group">
           <label for="uid">E-Mail</label> 
           <input type="email" name="uid" placeholder="E-Mail" />
       </div>
       
       <div class="form-group"> 
           <label for="unm">Password</label> 
           <input type="password" name="pwd" placeholder="Password" />
       </div>
       
       <div class="form-group"> 
           <label for="unm">Full Name</label>
           <input type="text" name="unm" placeholder="Full Name" />
       </div>
       
      <div class="form-group">
          <label for="phone">Phone</label>
          <input type="tel" name="phone" placeholder="123-456-7890" />
        </div>
       
       <div class="form-group">
           <label for="dob">Date of Birth</label>
           <input type="date" name="dob" />
       </div>
       
       <div class="form-group"> 
           <label for="gender">Gender</label>
           <select name="gender"> 
               <option value="male">Male</option>
               <option value="female">Female</option>
               <option value="other">Other</option> 
           </select> 
       </div>
       
       <div class="form-footer">
          
           <input type="submit" class="submit-btn" name="btnsub" value="Save Profile">
           <div class="register"> 
               <p>Already have an account? <a href="Login.jsp">Login here</a></p>
           </div>
           </form>
       </div>
   </div>
   
   
   
   <div id="recruiterForm" class="hidden"> 
       <form method="post">
       <div class="form-group">
           <label for="cid">Recruiter E-mail :</label>
           <input type="email" name="recid" placeholder="E-mail" />
       </div> 
       
        <div class="form-group"> 
           <label for="unm">Password</label> 
           <input type="password" name="recpwd" placeholder="Password" />
       </div>
       
       <div class="form-group"> 
           <label for="unm">Recruiter Name</label>
           <input type="text" name="recfnm" placeholder="Full Name" />
       </div>
           
         <div class="form-group">
           <label for="linkedin">Company Website</label>
           <input type="url" name="comweb" placeholder="https://linkedin.com/in/username" />
        </div>
       
       <div class="form-group"> 
           <label for="unm">Company Name</label>
           <input type="text" name="comnm" placeholder="Full Name" />
       </div>

       <div class="form-group">
      <label>Select Post Type:</label><br>
    <button type="button" id="internshipToggle">Internship</button>
    <button type="button" id="jobToggle">Job</button>

      </div>

      <!-- Internship Fields -->
            <div id="internshipFields" class="toggle-section hidden">
               <div class="form-group">
                   <label for="jr">Internship Role:</label>
                   <input type="text" name="jr" placeholder="Frontend Intern" />
               </div>
               <div class="form-group">
                   <label for="skill">Required Education :</label>
                   <input type="text" name="skill" placeholder="HTML, CSS, JS" />
               </div>
               <div class="form-group">
                   <label for="loc">Location:</label>
                   <input type="text" name="loc" placeholder="Remote, Pune" />
               </div>
                
                 <div class="form-group">
                   <label for="deadline">Apply Before:</label>
                   <input type="date" name="deadline" />
               </div>
                
                <div class="form-group">
                   <label for="stipend">Stipend:</label>
                   <input type="text" name="salary" placeholder="5000 INR" />
               </div>
                
               <div class="form-group">
                   <label for="duration">Duration:</label>
                   <input type="text" name="exp" placeholder="3 Months" />
               </div>
                
                 <div class="form-group">
                   <label for="des">what'll You Learn :</label>
                   <input type="text" name="des" placeholder="what'll You Learn" />
               </div>
               
              
            </div>

            <!-- Job Fields -->
            <div id="jobFields" class="toggle-section hidden">
               <div class="form-group">
                   <label for="jr">Job Role:</label>
                   <input type="text" name="jr" placeholder="Java Full Stack" />
               </div>
               <div class="form-group">
                   <label for="skill">Skills:</label>
                   <input type="text" name="skill" placeholder="Spring Boot, React" />
               </div>
               <div class="form-group">
                   <label for="loc">Location:</label>
                   <input type="text" name="loc" placeholder="Bangalore" />
               </div>
                
                 <div class="form-group">
                <label for="deadline">Deadline </label>
                <input type="date" name="deadline" />
               </div>
              
               <div class="form-group">
                   <label for="salary">Salary:</label>
                   <input type="text" name="salary" placeholder="6-8 LPA" />
               </div>
                
                 <div class="form-group">
                   <label for="exp">Experience:</label>
                   <input type="text" name="exp" placeholder="2+ years" />
               </div>
                
               <div class="form-group">
                   <label for="des">Description:</label>
                   <input type="text" name="des" placeholder="Job Description" />
               </div>
            </div>
             <div class="form-footer"> 
                 <input type="hidden" id="postType" name="post_type" value="">
           <input type="submit" class="submit-btn" name="btnrecsub" value="Save Profile"> 
           <div class="register">
               <p>Already have an account? <a href="Login.jsp">Login here</a></p> 
           </div> 
       </div>
           </form>
   </div> 
   </div>
    </body>
</html>
