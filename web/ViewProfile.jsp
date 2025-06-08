<%-- 
    Document   : ViewProfile
    Created on : May 20, 2025, 5:39:39 PM
    Author     : Rahul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="requirepackage.DBConnect"%>
<%@page import="requirepackage.UserController"%>
<%@page import="requirepackage.ViewProfile"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%
  DBConnect dbc=new DBConnect();
  UserController utc=new UserController();
  if(request.getParameter("btnsub") != null){
    ViewProfile vp=new ViewProfile();
    vp.setFnm(request.getParameter("unm"));
     vp.setFile(request.getParameter("resume"));
      vp.setEmail(request.getParameter("email"));
       vp.setEducation(request.getParameter("education"));
       vp.setPhone(request.getParameter("phone"));
        try {
                String dateStr = request.getParameter("date");
                if (dateStr != null && !dateStr.isEmpty()) {
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    Date utilDate = formatter.parse(dateStr); 
                    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); 
                    vp.setDob(sqlDate);
                } else {
                    System.out.println("Date parameter is missing or empty.");
                }
            } catch (Exception ex) {
                ex.printStackTrace(); 
            }
            vp.setAddress(request.getParameter("address"));
            vp.setType(request.getParameter("gender"));
            vp.setStatus(request.getParameter("status"));
            vp.setLinkedin(request.getParameter("linkedin"));
            vp.setGithub(request.getParameter("github"));
            vp.setPersonalwebsite(request.getParameter("pwebsite"));
            vp.setJobtitle(request.getParameter("jobtitle"));
            vp.setExcompany(request.getParameter("excompany"));
            vp.setDuration(request.getParameter("duration"));
            vp.setSkills(request.getParameter("skills"));
            vp.setResponsibility(request.getParameter("responsibilities"));
            vp.setExsalary(request.getParameter("salary"));
            if(utc.addProfile(vp))
            {
                response.sendRedirect("Internship.jsp");
            }
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="css/viewProfile.css">
        <style>
              a {
                color: white;
                text-decoration: none;
                }
        </style>
    </head>
    <body>
         <div class="form-wrapper"> 
             <img src="images/profile1.png" alt="profile image"> <br><br>
              <form method="POST"> 
                  <div class="form-grid">
                     
                      <div class="form-group"> 
                          <label for="unm">Full Name</label> 
                          <input type="text"  name="unm" placeholder="Full Name" required /> 
                      </div>
                      <div class="form-group">
                          
                          <label for="file">Upload Resume:</label>
                          <input type="file"  name="resume" />
                          
                      </div> 

                      <div class="form-group"> 
                          <label for="email">Email</label>
                          <input type="email" name="email" placeholder="abc@gmail.com" required />
                      </div> 
                       <div class="form-group">
                          <label for="education">Education</label>
                          <input type="text" name="education" placeholder="Education" required/>
                      </div> 
                      <div class="form-group">
                          <label for="phone">Phone</label>
                          <input type="tel" name="phone" placeholder="123-456-7890" required />
                      </div> 
                      <div class="form-group"> 
                          <label for="dob">Date of Birth</label>
                          <input type="date" name="dob" required/> 
                      </div> 
                       <div class="form-group">
                          <label for="address">Address</label>
                          <input type="text" name="address"  placeholder="state, City ,colony" required/>
                      </div>
                      <div class="form-group">
                          <label for="gender">Gender</label> 
                          <select name="gender" required>
                             <option value="male">Male</option>
                             <option value="female">Female</option>
                             <option value="other">Other</option> 
                          </select> 
                      </div>
                       <div class="form-group"> 
                          <label for="website">Married Status</label>
                          <select name="status" required> 
                              <option>Single</option> 
                              <option>Married</option>
                          </select>
                      </div>
                      <div class="form-group">
                          <label for="linkedin">LinkedIn</label>
                          <input type="url" name="linkedin" placeholder="https://linkedin.com/in/username" />
                      </div>
                      <div class="form-group"> 
                          <label for="github">GitHub</label> 
                          <input type="url" name="github" placeholder="https://github.com/username" />
                      </div>
                      <div class="form-group"> 
                          <label for="website">Personal Website</label> 
                          <input type="url" name="pwebsite" placeholder="https://yourwebsite.com" />
                      </div>
                     
                     
                  </div><br>
                  <button class="btn" onclick="toggleExperience()">+ Add Experience</button><br>
                  <div id="experienceFields" class="experience-fields"><br>
                      <div class="form-group"> 
                          <label for="jobTitle">Job Title</label>
                          <input type="text" name="jobtitle" placeholder="e.g., Software Engineer" />
                      </div>
                      <div class="form-group">
                          <label for="company">Ex-Company</label>
                          <input type="text" name="excompany" placeholder="e.g., Google" />
                      </div>
                      <div class="form-group">
                          <label for="duration">Duration</label> 
                          <input type="text" name="duration" placeholder="e.g., 2019 - 2023" />
                      </div> 
                      <div class="form-group"> 
                          <label for="skills">Key Skills</label>
                          <input type="text" name="skills" placeholder="e.g., JavaScript, React" />
                      </div> 
                      <div class="form-group">
                          <label for="responsibilities">Responsibilities</label>
                          <textarea name="responsibilities" rows="3" placeholder="Brief description of your role..."></textarea> 
                      </div>
                      <div class="form-group">
                          <label for="salary">Ex-Company Salary</label>
                          <input type="text" name="salary" placeholder="e.g.,4 - 5 LPA" /> 
                      </div> 
                  </div> 
                  <div class="form-footer">
                      <input type="submit" class="submit-btn" name="btnsub" value="Save Profile"/> 
                        <button type="submit" class="submit-btn"> <a href="Home.jsp">Back To Home</a></button> 
                  </div>
                  <div class="form-footer">
                    
                  </div>
              </form>
         </div>
   </body>
   
</html>
