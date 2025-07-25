<%-- 
    Document   : ViewProfile
    Created on : May 20, 2025, 5:39:39 PM
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
  String email = (String) session.getAttribute("email");
  DBConnect dbc = new DBConnect();
  UserController utc = new UserController();
  
  // Variables to hold existing profile data
  String fnm = "", file = "", profileEmail = "", education = "", phone = "";
  String address = "", gender = "", status = "", linkedin = "", github = "", personalwebsite = "";
  String jobtitle = "", excompany = "", duration = "", skills = "", responsibility = "", exsalary = "";
  String dobValue = "";
  boolean profileExists = false;
  
  // Search for existing profile data
  if (email != null && !email.isEmpty()) {
      try {
          Connection conn = dbc.getConnection();
          String query = "SELECT * FROM viewprofile WHERE email = ?";
          PreparedStatement pst = conn.prepareStatement(query);
          pst.setString(1, email);
          ResultSet rs = pst.executeQuery();
          
          if (rs.next()) {
              profileExists = true;
              
              // Use try-catch for each field to handle any column name issues
              try { fnm = rs.getString("fullname") != null ? rs.getString("fullname") : ""; } catch(Exception e) {}
              try { file = rs.getString("resume") != null ? rs.getString("resume") : ""; } catch(Exception e) {}
              try { profileEmail = rs.getString("email") != null ? rs.getString("email") : ""; } catch(Exception e) {}
              try { education = rs.getString("education") != null ? rs.getString("education") : ""; } catch(Exception e) {}
              try { phone = rs.getString("phoneno") != null ? rs.getString("phoneno") : ""; } catch(Exception e) {}
              
              // Date handling
              try {
                  java.sql.Date sqlDate = rs.getDate("dob");
                  if (sqlDate != null) {
                      dobValue = sqlDate.toString();
                  }
              } catch (Exception ex) {
                  try {
                      java.sql.Date sqlDate = rs.getDate("date"); // try alternative column name
                      if (sqlDate != null) {
                          dobValue = sqlDate.toString();
                      }
                  } catch (Exception ex2) {
                      dobValue = "";
                  }
              }
              
              try { address = rs.getString("address") != null ? rs.getString("address") : ""; } catch(Exception e) {}
              try { gender = rs.getString("type") != null ? rs.getString("type") : ""; } catch(Exception e) {}
              try { status = rs.getString("status") != null ? rs.getString("status") : ""; } catch(Exception e) {}
              try { linkedin = rs.getString("linkedin") != null ? rs.getString("linkedin") : ""; } catch(Exception e) {}
              try { github = rs.getString("github") != null ? rs.getString("github") : ""; } catch(Exception e) {}
              try { personalwebsite = rs.getString("pwebsite") != null ? rs.getString("pwebsite") : ""; } catch(Exception e) {}
              try { jobtitle = rs.getString("jobtitile") != null ? rs.getString("jobtitile") : ""; } catch(Exception e) {}
              try { excompany = rs.getString("excomapny") != null ? rs.getString("excomapny") : ""; } catch(Exception e) {}
              try { duration = rs.getString("duration") != null ? rs.getString("duration") : ""; } catch(Exception e) {}
              try { skills = rs.getString("skills") != null ? rs.getString("skills") : ""; } catch(Exception e) {}
              try { responsibility = rs.getString("responsibility") != null ? rs.getString("responsibility") : ""; } catch(Exception e) {}
              try { exsalary = rs.getString("exsalary") != null ? rs.getString("exsalary") : ""; } catch(Exception e) {}
              
          } else {
              // If no profile found, set email to session email
              profileEmail = email;
          }
          
          rs.close();
          pst.close();
          conn.close();
      } catch (Exception e) {
          e.printStackTrace();
          // If database error, at least set the email
          profileEmail = email != null ? email : "";
      }
  } else {
      // If no session email, this might be an issue
      profileEmail = "";
  }
  
  // Handle form submission
  if(request.getParameter("btnsub") != null){
    ViewProfile vp = new ViewProfile();
    vp.setFnm(request.getParameter("unm"));
    vp.setFile(request.getParameter("resume"));
    vp.setEmail(request.getParameter("email"));
    vp.setEducation(request.getParameter("education"));
    vp.setPhone(request.getParameter("phone"));
    
    try {
        String dateStr = request.getParameter("dob");
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
    
    if(profileExists) {
        // Update existing profile
        if(utc.updateProfile(vp)) {
            response.sendRedirect("Internship.jsp");
        }
    } else {
        // Add new profile
        if(utc.addProfile(vp)) {
            response.sendRedirect("Internship.jsp");
        }
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
                .btn {
                display: inline-block;
                padding: 10px 20px;
                 background: linear-gradient(to right, #f6d365, #fda085);
                color: white;
                font-size: 16px;
                border: none;
                border-radius: 8px;
                cursor: pointer;
                transition: background-color 0.3s ease;
                margin-top: 10px;
                align-items: center;
              }

              .btn:hover {
                background-color: #45a049;
              }

              .btn:focus {
                outline: none;
                box-shadow: 0 0 0 3px rgba(72, 180, 97, 0.4);
              }

        </style>
        <script>
            function toggleExperience() {
              event.preventDefault(); // Prevent form from submitting
              var expFields = document.getElementById("experienceFields");
              expFields.style.display = (expFields.style.display === "none" || expFields.style.display === "") ? "block" : "none";
            }
            
            // Show experience fields if data exists
            window.onload = function() {
                <% if (profileExists && (!jobtitle.isEmpty() || !excompany.isEmpty())) { %>
                    document.getElementById("experienceFields").style.display = "block";
                <% } %>
            };
        </script>
    </head>
    <body>
         <div class="form-wrapper"> 
             <img src="images/profile1.png" alt="profile image"> <br><br>
             
             <!-- Debug information - remove this after testing -->
             <%-- 
             <p style="background: #f0f0f0; padding: 10px; border: 1px solid #ccc;">
                 <strong>Debug Info:</strong><br>
                 Session Email: <%= email %><br>
                 Profile Exists: <%= profileExists %><br>
                 Profile Email: <%= profileEmail %><br>
                 Full Name: <%= fnm %><br>
                 Education: <%= education %><br>
                 Phone: <%= phone %>
             </p>
             --%>
             
              <form method="POST"> 
                  <div class="form-grid">
                     
                      <div class="form-group"> 
                          <label for="unm">Full Name</label> 
                          <input type="text" name="unm" placeholder="Full Name" required 
                                 value="<%= fnm %>" /> 
                      </div>
                      <div class="form-group">
                          <label for="file">Upload Resume:</label>
                          <input type="file" name="resume" />
                          <% if (!file.isEmpty()) { %>
                              <small>Current file: <%= file %></small>
                          <% } %>
                      </div> 

                      <div class="form-group"> 
                          <label for="email">Email</label>
                          <input type="email" name="email" placeholder="abc@gmail.com" required 
                                 value="<%= !profileEmail.isEmpty() ? profileEmail : (email != null ? email : "") %>" />
                      </div> 
                       <div class="form-group">
                          <label for="education">Education</label>
                          <input type="text" name="education" placeholder="Education" required
                                 value="<%= education %>"/>
                      </div> 
                      <div class="form-group">
                          <label for="phone">Phone</label>
                          <input type="tel" name="phone" placeholder="123-456-7890" required 
                                 value="<%= phone %>" />
                      </div> 
                      <div class="form-group"> 
                          <label for="dob">Date of Birth</label>
                          <%
                              String dateAttr = "";
                              if (dobValue != null && dobValue.length() > 0 && !dobValue.equals("null")) {
                                  dateAttr = "value=\"" + dobValue + "\"";
                              }
                          %>
                          <input type="date" name="dob" required <%= dateAttr %> /> 
                      </div> 
                       <div class="form-group">
                          <label for="address">Address</label>
                          <input type="text" name="address" placeholder="state, City ,colony" required
                                 value="<%= address %>"/>
                      </div>
                      <div class="form-group">
                          <label for="gender">Gender</label> 
                          <select name="gender" required>
                             <option value="male" <%= "male".equals(gender) ? "selected" : "" %>>Male</option>
                             <option value="female" <%= "female".equals(gender) ? "selected" : "" %>>Female</option>
                             <option value="other" <%= "other".equals(gender) ? "selected" : "" %>>Other</option> 
                          </select> 
                      </div>
                       <div class="form-group"> 
                          <label for="website">Married Status</label>
                          <select name="status" required> 
                              <option <%= "Single".equals(status) ? "selected" : "" %>>Single</option> 
                              <option <%= "Married".equals(status) ? "selected" : "" %>>Married</option>
                          </select>
                      </div>
                      <div class="form-group">
                          <label for="linkedin">LinkedIn</label>
                          <input type="url" name="linkedin" placeholder="https://linkedin.com/in/username" 
                                 value="<%= linkedin %>" />
                      </div>
                      <div class="form-group"> 
                          <label for="github">GitHub</label> 
                          <input type="url" name="github" placeholder="https://github.com/username" 
                                 value="<%= github %>" />
                      </div>
                      <div class="form-group"> 
                          <label for="website">Personal Website</label> 
                          <input type="url" name="pwebsite" placeholder="https://yourwebsite.com" 
                                 value="<%= personalwebsite %>" />
                      </div>
                     
                     
                  </div><br>
                  <button class="btn" onclick="toggleExperience()">+ Add Experience</button><br>
                  <div id="experienceFields" class="experience-fields" style="display: none;"><br>
                      <div class="form-group"> 
                          <label for="jobTitle">Job Title</label>
                          <input type="text" name="jobtitle" placeholder="e.g., Software Engineer" 
                                 value="<%= jobtitle %>" />
                      </div><br>
                      <div class="form-group">
                          <label for="company">Ex-Company</label>
                          <input type="text" name="excompany" placeholder="e.g., Google" 
                                 value="<%= excompany %>" />
                      </div><br>
                      <div class="form-group">
                          <label for="duration">Duration</label> 
                          <input type="text" name="duration" placeholder="e.g., 2019 - 2023" 
                                 value="<%= duration %>" />
                      </div><br>
                      <div class="form-group"> 
                          <label for="skills">Key Skills</label>
                          <input type="text" name="skills" placeholder="e.g., JavaScript, React" 
                                 value="<%= skills %>" />
                      </div> <br>
                      <div class="form-group">
                          <label for="responsibilities">Responsibilities</label>
                          <textarea name="responsibilities" rows="3" placeholder="Brief description of your role..."><%= responsibility %></textarea> 
                      </div><br>
                      <div class="form-group">
                          <label for="salary">Ex-Company Salary</label>
                          <input type="text" name="salary" placeholder="e.g.,4 - 5 LPA" 
                                 value="<%= exsalary %>" /> 
                      </div> <br>
                  </div> 
                  <div class="form-footer">
                      <input type="submit" class="submit-btn" name="btnsub" value="<%= profileExists ? "Update Profile" : "Save Profile" %>"/> 
                        <button type="submit" class="submit-btn"> <a href="Home.jsp">Back To Home</a></button> 
                  </div>
                  <div class="form-footer">
                    
                  </div>
              </form>
         </div>
   </body>
   
</html>