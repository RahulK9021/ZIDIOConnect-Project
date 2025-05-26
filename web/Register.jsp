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
<%--<%@page import="java.lang.Exception%>--%>
<!DOCTYPE html>
<%
            DBConnect dbc=new DBConnect();
            UserController utc=new UserController();
            if(request.getParameter("btnsub") != null){
                Registration reg=new Registration();
                reg.setEmail(request.getParameter("uid"));
                reg.setPassword(request.getParameter("pwd"));
                reg.setFullnm(request.getParameter("unm"));
                String phoneStr = request.getParameter("phone");
                if (phoneStr != null && !phoneStr.isEmpty()) {
                    try {
                        reg.setPhoneno(Integer.parseInt(phoneStr));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid phone number format: " + phoneStr);
                    }
                } else {
                    System.out.println("Phone number is missing or empty.");
                }

               try {
                String dateStr = request.getParameter("date");
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
                reg.setGender(request.getParameter("gender"));
                reg.setAddress(request.getParameter("city"));
                reg.setStatus(request.getParameter("status"));
                reg.setType(request.getParameter("type"));
                if(utc.addRegistration(reg)){
                response.sendRedirect("Login.jsp");
            }
            }
            
        %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <style>
           body {
      margin: 0;
     
      display: flex;
      justify-content: center;
      align-items: center;
      min-height: 100vh;
         margin: 0;
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
       background-image: linear-gradient(120deg, #84fab0 0%, #8fd3f4 100%);
    }

    .form-wrapper {
      background: #fff;
      padding: 2.5rem;
      border-radius: 20px;
      box-shadow: 0 10px 25px rgba(0, 0, 0, 0.1);
      max-width: 1000px;
      width: 100%;
      margin: 2rem;
    }

    .form-wrapper h1 {
      text-align: center;
      margin-bottom: 2rem;
      color: #333;
    }

    .form-grid {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
      gap: 1.5rem;
    }

    .form-group {
      display: flex;
      flex-direction: column;
    }

    .form-group label {
      font-weight: 600;
      margin-bottom: 0.5rem;
      color: #555;
    }

    .form-group input,
    .form-group select,
    .form-group textarea {
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
    <h1>Registration</h1>
    <form method="POST">
      <div class="form-grid">
        
        <div class="form-group">
          <label for="uid">E-Mail</label>
          <input type="email" name="uid" placeholder="E-Mail" required />
        </div>
          
         <div class="form-group">
          <label for="unm">Password</label>
          <input type="password" name="pwd" placeholder="Password" required />
        </div>
          
        <div class="form-group">
          <label for="unm">Full Name</label>
          <input type="text"  name="unm" placeholder="Full Name" required />
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
          
        <div class="form-group">
          <label for="City">City</label>
           <input type="text" name="city" placeholder="City" required />
        </div>
          
           <div class="form-group">
          <label for="website">Married Status</label>
          <select name="status">
              <option>Single</option>
              <option>Married</option>
          </select>
        </div>
          
          <div class="form-group">
          <label for="type">Register as</label>
          <select name="type">
              <option>Jobseeker</option>
              <option>Recruiter</option>
          </select>
        </div>
      </div>
        
      <div class="form-footer">
          <input type="submit" class="submit-btn" name="btnsub" value="Save Profile">
        <div class="register">
        <p>Already have an account? <a href="Login.jsp">Login here</a></p>
        </div>
      </div>
    </form>
  </div>

    </body>
</html>
