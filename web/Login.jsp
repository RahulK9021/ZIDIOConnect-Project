<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="requirepackage.DBConnect" %>
<%@page import="java.sql.*" %>
<%
// Your existing debug and connection code here
System.out.println("=== LOGIN DEBUG INFO ===");
System.out.println("Current JSP file: " + request.getRequestURI());
System.out.println("Context Path: " + request.getContextPath());
System.out.println("========================");

DBConnect dbc = new DBConnect();
String uid = request.getParameter("uid");
String pwd = request.getParameter("pwd");
String errorMessage = null;

// Only process login if form is submitted
if (uid != null && pwd != null && !uid.trim().isEmpty() && !pwd.trim().isEmpty()) {
    System.out.println("Processing login for: " + uid);
    
    try (Connection con = dbc.getConnection();
         PreparedStatement jobstmt = con.prepareStatement("SELECT * FROM jobseeker WHERE email = ? AND password = ?");
         PreparedStatement recruiterStmt = con.prepareStatement("SELECT * FROM recruiter WHERE recruiter_email = ? AND password = ?")) {

        jobstmt.setString(1, uid);
        jobstmt.setString(2, pwd);
        recruiterStmt.setString(1, uid);
        recruiterStmt.setString(2, pwd);

        // Check jobseeker login first
        try (ResultSet rs = jobstmt.executeQuery()) {
            if (rs.next()) {
                System.out.println("Jobseeker found in database");
                session.setAttribute("email", uid);
                session.setAttribute("userType", "jobseeker");
                session.setMaxInactiveInterval(30 * 60);
                System.out.println("Jobseeker login successful: " + uid);
                response.sendRedirect("Internship.jsp");
                return; // Important: stop execution here
            }
        }

        // Check recruiter login
        try (ResultSet rs = recruiterStmt.executeQuery()) {
            if (rs.next()) {
                System.out.println("Recruiter found in database");
                session.setAttribute("recruiterEmail", uid);
                session.setAttribute("userType", "recruiter");
                session.setMaxInactiveInterval(30 * 60);
                System.out.println("Recruiter login successful: " + uid);
                
                // Simple redirect - remove all the complex error handling for now
                response.sendRedirect("RecruiterDashboard.jsp");
                return; // Important: stop execution here
            }
        }
        
        // If we reach here, login failed
        System.out.println("Login failed - no matching user found");
        errorMessage = "Invalid email or password! Please try again.";

    } catch (SQLException e) {
        System.err.println("Database error during login: " + e.getMessage());
        e.printStackTrace();
        errorMessage = "System error occurred! Please try again later.";
    } catch (Exception ex) {
        System.err.println("General error during login: " + ex.getMessage());
        ex.printStackTrace();
        errorMessage = "An unexpected error occurred! Please try again.";
    }
}
%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Page</title>
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
        }
        .form-group {
            display: flex;
            flex-direction: column;
            width: 100%;
            max-width: 400px;
            margin-bottom: 1rem;
        }
        .form-group label {
            font-weight: 600;
            margin-bottom: 0.5rem;
            color: #555;
        }
        .form-group input {
            width: 100%;
            padding: 0.8rem;
            border: 1px solid #ccc;
            border-radius: 10px;
            font-size: 1rem;
            background-color: #f9f9f9;
            transition: border-color 0.3s;
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
        .error-message {
            background-color: #ffebee;
            color: #c62828;
            padding: 1rem;
            border-radius: 8px;
            margin-bottom: 1rem;
            border-left: 4px solid #f44336;
        }
        .success-message {
            background-color: #e8f5e8;
            color: #2e7d32;
            padding: 1rem;
            border-radius: 8px;
            margin-bottom: 1rem;
            border-left: 4px solid #4caf50;
        }
    </style>
</head>
<body>
    <div class="form-wrapper">
        <h1>Login</h1>
        
        <!-- Show error message if login failed -->
        <% if (errorMessage != null) { %>
            <div class="error-message">
                <%= errorMessage %>
            </div>
        <% } %>
        
        <!-- Debug: Show if user is logged in but redirect failed -->
        <% 
        String loggedInEmail = (String) session.getAttribute("email");
        if (loggedInEmail != null) { 
        %>
            <div class="success-message">
                Login successful for: <%= loggedInEmail %><br>
                User Type: <%= session.getAttribute("userType") %><br>
                <a href="RecruiterDashboard.jsp">Click here to go to Dashboard</a>
            </div>
        <% } %>
        
        <form method="POST">
            <div class="form-group">
                <label for="uid">G-mail For Login</label>
                <input type="email" name="uid" placeholder="User G-mail" value="<%= (uid != null) ? uid : "" %>" required />
            </div>

            <div class="form-group">
                <label for="pwd">Password</label>
                <input type="password" name="pwd" placeholder="Password" required />
            </div>

            <div style="text-align: center; margin-top: 2rem;">
                <input type="submit" class="submit-btn" name="btnsub" value="Login">
                <div style="margin-top: 1rem;">
                    <p>Don't have an account? <a href="Register.jsp">Register here</a></p>
                </div>
            </div>
        </form>
        
      
       
    </div>
</body>
</html>