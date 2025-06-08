<%-- 
    Document   : Internship
    Created on : May 16, 2025, 8:57:43 PM
    Author     : Rahul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="requirepackage.DBConnect" %>
<%@page import="requirepackage.Registration" %>
<%@page import="requirepackage.UserController" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@page  import="java.sql.*" %>
<%
    DBConnect dbc=new DBConnect();
    UserController utc = new UserController();
    ResultSet rs=dbc.getInternships("SELECT comname, jobroll, skill, loc, deadline, salary, exp, des FROM recruiter WHERE post_type = 'internship'");  
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Internship</title>
        <link rel="stylesheet" href="css/Internship.css">
    
    <style>
   
    </style>
    </head>
    <body>
        <nav>
           <div class="logo">< ZIDIOConnect ></div>
           <ul>
            
             <li><a href="JobPortal.jsp">Job Portal</a></li>
             <li><a href="ViewProfile.jsp">View Profile</a></li>
           </ul>
         </nav>

         <header>
           <h1>Discover Internships Around You</h1>
           <p>Explore verified internship listings from startups to Fortune 500 companies. Get experience. Get hired.</p>
         </header>

         <section id="internships" class="section">
           <h2>Latest Internships</h2>
           <div class="internships">
               <%
                  while(rs.next())
                  {
                %>
             <div class="card">
               <h3><%=rs.getString(2) %></h3>
               <p><b>🚀 Company</b><%=rs.getString(1) %>  
                   <br>🧑‍💻 Job Role <%=rs.getString(2) %><br>
                   <b>📍 SKills </b>  <%=rs.getString(3) %> <br>
                   <b>🕒 Location</b> <%=rs.getString(4)%>  <br>      
                    <b>🕒 Deadline</b> <%=rs.getString(5)%> <br>
                     <b>🕒 Stipend</b> <%=rs.getString(6)%> <br>
                     <b>🕒 duration</b> <%=rs.getString(7)%> <br>
                     <b>💼 Description:</b><%=rs.getString(8)%></p>
                <a href="#" class="btn">Apply Now</a>
             </div>
        <%
             }
         %>
               
               
              
         </section>

         <section id="apply" class="section cta">
           <h2>For Students & Companies</h2>
           <p>🌟 Students:Apply to top internships and boost your resume.<br>
           🏢 Companies: Post internships and discover amazing talent.</p>
           <a href="#" class="btn">Join as Student</a>
           <a href="#" class="btn" style="background:#6610f2; margin-left: 1rem;">Join as Company</a>
         </section>

         <footer id="contact">
           <p>📧 Email: support@zidioconnect.com | 📞 +1 (800) 123-4567</p>
           <p>© 2025 ZIDIOConnect. All rights reserved.</p>
         </footer>
       
       </body>
       </html>

