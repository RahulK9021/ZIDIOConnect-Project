<%-- 
    Document   : Candidate
    Created on : May 16, 2025, 8:50:48 PM
    Author     : Rahul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="requirepackage.DBConnect" %>
<%@page import="requirepackage.Registration" %>
<%@page import="requirepackage.UserController" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@page  import="java.sql.*" %>
<%
  DBConnect dbc=new DBConnect();
  UserController utc=new UserController();
  ResultSet rs=dbc.getJobs("select comname,jobroll,skill,loc,deadline,salary,exp,des from recruiter where post_type ='job'");
    
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Job Portal</title>
    <style>
     :root {
      --primary: #00b894;
      --accent: #0984e3;
      --bg: #f0f2f5;
      --text: #2d3436;
      --card: #fff;
    }

       * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
    }

    body {
      font-family: 'Roboto', sans-serif;
      background: var(--bg);
      color: var(--text);
    }

    header {
      background: linear-gradient(to right, var(--primary), var(--accent));
      color: white;
      padding: 6rem 2rem;
      text-align: center;
      position: relative;
      overflow: hidden;
    }

    header h1 {
      font-size: 3rem;
      margin-bottom: 1rem;
    }

    header p {
      font-size: 1.2rem;
      max-width: 800px;
      margin: auto;
      margin-bottom: 100px;
    }

    header .wave {
      position: absolute;
      bottom: -1px;
      left: 0;
      width: 100%;
    }
    .section {
      padding: 4rem 2rem;
      max-width: 1200px;
      margin: auto;
    }

    .section h4 {
      text-align: center;
      margin-bottom: 2rem;
      font-size: 2rem;
      color: var(--primary);
    }

    .internships {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
      gap: 2rem;
    }

    .card {
      background: var(--card-bg);
      padding: 2rem;
      border-radius: 10px;
      box-shadow: 0 4px 10px rgba(0,0,0,0.05);
      transition: transform 0.3s ease;
       margin: 8px 0;
        color: #333;
        font-size: 15px;
    }

    .card:hover {
      transform: translateY(-5px);
    }

    .card p {
      font-size: 0.95rem;
      color: #555;
    }

    .apply-btn {
    display: inline-block;
    margin-top: 15px;
    background: linear-gradient(90deg, #00c6ff, #0072ff);
    color: white;
    padding: 10px 20px;
    border-radius: 30px;
    text-decoration: none;
    font-weight: bold;
    transition: background 0.3s ease;
    }

   .apply-btn:hover {
    background: linear-gradient(90deg, #0072ff, #0056d2);
    }

    .cta {
      text-align: center;
      background: #ffffff;
      padding: 2rem 1rem;
      margin-top: 4rem;
      border-radius: 12px;
      box-shadow: 0 8px 16px rgba(0,0,0,0.05);
    }

    footer {
      background: #212529;
      color: #ddd;
      text-align: center;
      padding: 2rem 1rem;
    }

    @media (max-width: 600px) {
      header h1 {
        font-size: 2rem;
      }

      nav ul {
        flex-direction: column;
        gap: 1rem;
      }
      
    }
    /* Navbar Styling */
    .navbar {
      width: 100%;
      background: linear-gradient(to right, var(--primary), var(--accent));
      position: fixed;
      top: 0;
      left: 0;
      z-index: 1000;
      /*box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);*/
      font-family: 'Poppins', sans-serif;
    }

    .nav-container {
      display: flex;
      justify-content: space-between;
      align-items: center;
      /*max-width: 1200px;*/
      padding: 0.8rem 2rem;
      margin: auto;
      margin-right: 10px;
    }

    .logo {
      color: white;
      font-weight: 600;
      font-size: 1.4rem;
      margin-right: 500px
    }

    .nav-links {
      list-style: none;
      display: flex;
      gap: 1.5rem;
    }

    .nav-links li a {
      color: white;
      text-decoration: none;
      font-weight: 500;
      transition: color 0.3s ease;
    }

    .nav-links li a:hover {
      color: #ffeb3b;
    }

    .card h3 {
      font-size: 24px;
      color: #0072ff;
      margin-bottom: 15px;
    }
    .card:hover {
      transform: translateY(-5px);
      box-shadow: 0 6px 25px rgba(0, 0, 0, 0.15);
    }
    .card p {
      margin: 8px 0;
      color: #333;
      font-size: 15px;
    }
     .btn{
        padding: 10px;
        margin: 10px;
        text-decoration: none;
        border: 1px solid black;
        color: white;
    }
    </style>
    </head>
     <header>
    <h1>"Your career, our commitment." </h1>
    <p>ZIDIOConnect Helps You To Unlock Your Career Potential !! <br> Because we believe in<i> <b> Talent Deserves Recognition</b> </i></p>
    <a href="#services" class="btn">Our Services</a>
    <svg class="wave" viewBox="0 0 1440 320"><path fill="#f4f4f9" fill-opacity="1" d="M0,160L80,154.7C160,149,320,139,480,138.7C640,139,800,149,960,165.3C1120,181,1280,203,1360,213.3L1440,224L1440,320L1360,320C1280,320,1120,320,960,320C800,320,640,320,480,320C320,320,160,320,80,320L0,320Z"></path></svg>
  </header>
<nav class="navbar">
  <div class="nav-container">
    <div class="logo">< ZIDIOConnect ></div>
    <ul class="nav-links">
      
      <li><a href="Internship.jsp">Internship Portal</a></li>
      <li><a href="ViewProfile.jsp">Update Profile</a></li>
      
    </ul>
  </div>
</nav>

<section id="internships" class="section">
  <h2>Latest Jobs For You</h2>
  <div class="internships">
       
   <%
 try {
     while (rs != null && rs.next()) {
%>
    <div class="card">
        <h3><%= rs.getString(2) %></h3>
        <p><b>🚀 Company:</b> <%= rs.getString(1) %></p>
        <p><b>🎯 Job Role:</b> <%= rs.getString(2) %></p>
        <p><b>🛠 Skills:</b> <%= rs.getString(3) %></p>
        <p><b>📍 Location:</b> <%= rs.getString(4) %></p>
        <p><b>⏳ Deadline:</b> <%= rs.getString(5) %></p>
        <p><b>💰 Salary:</b> ₹<%= rs.getString(6) %></p>
        <p><b>🕒 Experience:</b> <%= rs.getString(7) %></p>
        <p><b>💼 Description:</b> <%= rs.getString(8) %></p>
        <a href="#" class="apply-btn">Apply Now</a>
    </div>
<%
     }
 } catch (Exception e) {
     out.println("Error in ResultSet Loop: " + e.getMessage());
     e.printStackTrace(new java.io.PrintWriter(out));
 }
%>
  </div>
</section>

         <section id="apply" class="section cta">
           <h4> Post jobs and get Talented Employees.<br>Start with ZIDIOConnect Today !!!</h4>
           <a href="Register.jsp" class="btn" style="background:#6610f2; margin-left: 1rem;">Join as Company</a>
         </section>


         <footer id="contact">
           <p>📧 Email: support@zidioconnect.com | 📞 +1 (800) 123-4567</p>
           <p>© 2025 ZIDIOConnect. All rights reserved.</p>
         </footer>
    </body>
</html>
