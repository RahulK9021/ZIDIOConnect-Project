<%-- 
    Document   : Login
    Created on : Jun 8, 2025, 11:50:33 AM
    Author     : Rahul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="requirepackage.UserLogin" %>
<%@page import="requirepackage.DBConnect" %>
<%@page import="requirepackage.UserController" %>
<%@page import="requirepackage.DBConnect" %>
<%@page import="java.sql.*" %>
<%
  DBConnect dbc = new DBConnect();
String uid = request.getParameter("uid");
String pwd = request.getParameter("pwd");

try (Connection con = dbc.getConnection();
     PreparedStatement jobstmt = con.prepareStatement("SELECT * FROM jobseeker WHERE email = ? AND password = ?");
     PreparedStatement recruiterStmt = con.prepareStatement("SELECT * FROM recruiter WHERE email = ? AND password = ?")) {

    jobstmt.setString(1, uid);
    jobstmt.setString(2, pwd);
    recruiterStmt.setString(1, uid);
    recruiterStmt.setString(2, pwd);

    try (ResultSet rs = jobstmt.executeQuery()) {
        if (rs.next()) {
            response.sendRedirect(request.getContextPath() + "/Internship.jsp");

            return;
        }
    }

    try (ResultSet rs = recruiterStmt.executeQuery()) {
        if (rs.next()) {
           response.sendRedirect(request.getContextPath() + "/RecruiterDashboard.jsp");

            return;
        }
    }

} catch (SQLException e) {
    e.printStackTrace();
} catch (Exception ex) {
    ex.printStackTrace();
}
  
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
         <link rel="stylesheet" href="css/Login.css">
         <style>
              body {
         display: flex;
         justify-content: center;
         align-items: center;
         min-height: 100vh;
         margin: 0;
         font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
         background-image: linear-gradient(120deg, #84fab0 0%, #8fd3f4 100%);
       }
            .form-wrapper {
         display: flex;
         flex-direction: column;
         justify-content: center;
         align-items: center;
         background: #fff;
         padding: 2.5rem;
         border-radius: 20px;
         box-shadow: 0 10px 25px rgba(0, 0, 0, 0.1);
         max-width: 1000px;
         width: 100%;
         text-align: center;
         justify-content:space-between ;
       }
    .form-wrapper h1 {
      text-align: center;
      margin-bottom: 2rem;
      /*color: #333;*/
    }

    .form-grid {
      /*display: grid;*/
      /*grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));*/
      gap: 1.5rem;
    }

    .form-group {
      display: flex;
  flex-direction: column;
  width: 100%;
  max-width: 400px;
    }

    .form-group label {
     font-weight: 600;
  margin-bottom: 0.5rem;
  color: #555;
    }

    .form-group input,
    .form-group select,
    .form-group textarea {
     width: 100%;
  padding: 0.8rem;
  border: 1px solid #ccc;
  border-radius: 10px;
  font-size: 1rem;
  background-color: #f9f9f9;
  transition: border-color 0.3s;
    }

    .form-group input:focus,
    .form-group select:focus,
    .form-group textarea:focus {
      border-color: #fda085;
  background-color: #fff;
  outline: none;
    }

    .form-footer {
      text-align: center;
      margin-top: 2rem;
    }

    .submit-btn {
      background: linear-gradient(to right, #f6d365, #fda085);
      padding: 0.9rem 2rem;
      border: none;
      border-radius: 12px;
      font-size: 1rem;
      font-weight: 600;
      color: white;
      cursor: pointer;
      transition: background 0.3s ease;
    }

    .submit-btn:hover {
      background: linear-gradient(to right, #fda085, #f6d365);
    }

    @media (max-width: 600px) {
      .form-wrapper {
        padding: 1.5rem;
      }
    }

             </style>
    </head>
    <body>
       <div class="form-wrapper">
    <h1>Login</h1>
    <form method="POST">
        <div class="form-grid">

            <div class="form-group">
                <label for="uid">G-mail For Login</label>
                <input type="email" name="uid" placeholder="User G-mail" required />
            </div>

            <div class="form-group">
                <label for="unm">Password</label>
                <input type="password" name="pwd" placeholder="Password" required />
            </div>

            <div class="form-footer">
                <input type="submit" class="submit-btn" name="btnsub" value="Login">
                <div class="register">
                    <p>Don't have an account? <a href="Register.jsp">Register here</a></p>
                </div>

            </div>
        </div>
    </form>
</div>
    </body>
</html>
