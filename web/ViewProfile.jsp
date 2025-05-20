<%-- 
    Document   : ViewProfile
    Created on : May 20, 2025, 5:39:39 PM
    Author     : Rahul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="css/viewProfile.css">
    </head>
    <body>
         <div class="form-wrapper"> 
             <img src="images/profile1.png" alt="profile image"> <br><br>
              <form action="Internship.jsp" method="POST"> 
                  <div class="form-grid">
                      <div class="form-group"> 
                          <label for="uid">User ID</label>
                          <input type="text" id="uid" name="uid" placeholder="User ID" required />
                      </div> 
                      <div class="form-group"> 
                          <label for="unm">Full Name</label> 
                          <input type="text" id="unm" name="unm" placeholder="Full Name" required /> 
                      </div>
                      <div class="form-group">
                          <label for="file">Upload Resume:</label>
                          <input type="file" id="file" name="userfile" />
                      </div> 
                      <div class="form-group"> 
                          <label for="email">Email</label>
                          <input type="email" id="email" placeholder="abc@gmail.com" required />
                      </div> 
                      <div class="form-group">
                          <label for="phone">Phone</label>
                          <input type="tel" id="phone" placeholder="123-456-7890" />
                      </div> 
                      <div class="form-group"> 
                          <label for="dob">Date of Birth</label>
                          <input type="date" id="dob" /> 
                      </div> 
                      <div class="form-group">
                          <label for="gender">Gender</label> 
                          <select id="gender">
                             <option value="male">Male</option>
                             <option value="female">Female</option>
                             <option value="other">Other</option> 
                          </select> 
                      </div>
                      <div class="form-group">
                          <label for="linkedin">LinkedIn</label>
                          <input type="url" id="linkedin" placeholder="https://linkedin.com/in/username" />
                      </div>
                      <div class="form-group"> 
                          <label for="github">GitHub</label> 
                          <input type="url" id="github" placeholder="https://github.com/username" />
                      </div>
                      <div class="form-group"> 
                          <label for="website">Personal Website</label> 
                          <input type="url" id="website" placeholder="https://yourwebsite.com" />
                      </div>
                      <div class="form-group">
                          <label for="address">Address</label>
                          <input type="text" id="city"  placeholder=" City" name="city" />
                      </div>
                      <div class="form-group"> 
                          <label for="website">Married Status</label>
                          <select name="status"> 
                              <option>Single</option> 
                              <option>Married</option>
                          </select>
                      </div>
                  </div><br>
                  <button class="btn" onclick="toggleExperience()">+ Add Experience</button><br>
                  <div id="experienceFields" class="experience-fields"><br>
                      <div class="form-group"> 
                          <label for="jobTitle">Job Title</label>
                          <input type="text" id="jobTitle" placeholder="e.g., Software Engineer" />
                      </div>
                      <div class="form-group">
                          <label for="company">Ex-Company</label>
                          <input type="text" id="company" placeholder="e.g., Google" />
                      </div>
                      <div class="form-group">
                          <label for="duration">Duration</label> 
                          <input type="text" id="duration" placeholder="e.g., 2019 - 2023" />
                      </div> 
                      <div class="form-group"> 
                          <label for="skills">Key Skills</label>
                          <input type="text" id="skills" placeholder="e.g., JavaScript, React" />
                      </div> 
                      <div class="form-group">
                          <label for="responsibilities">Responsibilities</label>
                          <textarea id="responsibilities" rows="3" placeholder="Brief description of your role..."></textarea> 
                      </div>
                      <div class="form-group">
                          <label for="responsibilities">Ex-Company Salary</label>
                          <input type="text" id="duration" placeholder="e.g., 2019 - 2023" /> 
                      </div> 
                  </div> 
                  <div class="form-footer">
                      <button type="submit" class="submit-btn">Save Profile</button> 
                  </div>
              </form>
         </div>
   </body>
   
</html>
