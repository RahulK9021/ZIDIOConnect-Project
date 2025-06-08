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
        <!--<link rel="stylesheet" href="css/JobPortal.css">-->
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

    nav {
      background: var(--primary);
      padding: 1rem 2rem;
      color: white;
      display: flex;
      justify-content: space-between;
      align-items: center;
    }

    nav .logo {
      font-weight: 700;
      font-size: 1.5rem;
    }

    nav ul {
      display: flex;
      gap: 1.5rem;
      list-style: none;
    }

    nav ul li a {
      color: white;
      text-decoration: none;
      font-weight: 500;
    }

    header {
      padding: 4rem 2rem;
      text-align: center;
      background: linear-gradient(to right, var(--primary), var(--accent));
      color: white;
    }

    header h1 {
      font-size: 3rem;
      margin-bottom: 1rem;
    }

    header p {
      font-size: 1.2rem;
      max-width: 600px;
      margin: auto;
    }
    .section {
      padding: 4rem 2rem;
      max-width: 1200px;
      margin: auto;
    }

    .section h2 {
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
    }

    .card:hover {
      transform: translateY(-5px);
    }

    .card h3 {
      margin-bottom: 0.5rem;
      color: var(--secondary);
    }

    .card p {
      font-size: 0.95rem;
      color: #555;
    }

    .btn {
      display: inline-block;
      margin-top: 1rem;
      padding: 0.6rem 1.5rem;
      background: var(--primary);
      color: white;
      border-radius: 30px;
      text-decoration: none;
      font-weight: 500;
      transition: background 0.3s;
    }

    .btn:hover {
      background: var(--secondary);
    }

    .cta {
      text-align: center;
      background: #ffffff;
      padding: 4rem 2rem;
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
    </style>
    </head>
    <nav>
           <div class="logo">< ZIDIOConnect ></div>
           <ul>
            
             <li><a href="Internship.jsp">Internship Portal</a></li>
             <li><a href="ViewProfile.jsp">View Profile</a></li>
           </ul>
         </nav>

         <header>
           <h1>Discover Jobs Around You</h1>
           <p>“Professional Opportunities at Your Fingertips”</p>
         </header>
  <section id="internships" class="section">
           <h2>Latest Jobs For You</h2>
           <div class="jobs">
             <div class="card">
                 <% 
                    while (rs.next())
                 {
                 %>
                 <h3>Java Developer </h3>
                 <p><b>🚀 Company :</b><%= rs.getString(1) %><br></p>
                    <p> <b>  Job Role :</b><%=rs.getString(2) %><br></p>
                    <p>  <b>🎯 Skills : </b><%=rs.getString(3)%> <br> </p>
                    <p> <b> Location :</b> <%=rs.getString(4) %> <br></p>
                    <p>  <b> Deadline :</b> <%= rs.getString(5) %></p>
                 <p><b>  &nbsp;    ₹   Salary :</b><%=rs.getString(6)%></p>
                  <p><b>🕒 Experience :</b><%=rs.getString(7) %><br></p>
                   <p>  💼 <b> Description: :</b><%=rs.getString(8) %><br></p>
               <a href="#" class="btn">Apply Now</a>
             </div>
                 <%
                     }
                     %>
           </div>
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
