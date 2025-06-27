
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page import="java.sql.*, java.util.*" %>
<%@ page import="requirepackage.DBConnect" %>
<%@ page import="java.sql.*, java.util.*" %>
<%@ page import="requirepackage.DBConnect" %>
<%@ page errorPage="error.jsp" %>

<%
    String jobId = request.getParameter("job_id");
    String recruiterEmail = request.getParameter("recruiter_email");
    String postType = request.getParameter("post_type");
    String userEmail = (String) session.getAttribute("email");
    
    boolean isValidRequest = true;
    String errorMessage = "";
    String redirectPage = "";
    
    // Validate required parameters
    if (userEmail == null || userEmail.trim().isEmpty()) {
        isValidRequest = false;
        errorMessage = "Please login to apply!";
        redirectPage = "login.jsp";
    } else if (jobId == null || recruiterEmail == null || postType == null || 
               jobId.trim().isEmpty() || recruiterEmail.trim().isEmpty() || postType.trim().isEmpty()) {
        isValidRequest = false;
        errorMessage = "Missing required information!";
        redirectPage = "javascript:history.back()";
    }
    
    if (!isValidRequest) {
%>
        <script>
            alert('<%= errorMessage %>');
            <% if (redirectPage.startsWith("javascript:")) { %>
                <%= redirectPage.substring(11) %>;
            <% } else { %>
                location.href = '<%= redirectPage %>';
            <% } %>
        </script>
<%
    } else {
        // Your main application logic goes here
        Connection conn = null;
        PreparedStatement profileStmt = null;
        PreparedStatement checkDuplicateStmt = null;
        PreparedStatement insertStmt = null;
        ResultSet rs = null;
        ResultSet duplicateRs = null;
        
        try {
            DBConnect dbc = new DBConnect();
            conn = dbc.getConnection();
            
            // Check for duplicate application
            checkDuplicateStmt = conn.prepareStatement(
                "SELECT COUNT(*) FROM recruiter_inbox WHERE recruiter_email = ? AND candidate_email = ? AND job_id = ?"
            );
            checkDuplicateStmt.setString(1, recruiterEmail);
            checkDuplicateStmt.setString(2, userEmail);
            checkDuplicateStmt.setString(3, jobId);
            duplicateRs = checkDuplicateStmt.executeQuery();
            
            if (duplicateRs.next() && duplicateRs.getInt(1) > 0) {
%>
                <script>
                    alert('You have already applied for this position!');
                    history.back();
                </script>
<%
            } else {
                // Continue with profile retrieval and application submission
                profileStmt = conn.prepareStatement(
                    "SELECT fullname, resume, education, phoneno, address, gender, " +
                    "linkedin, github, pwebsite, jobtitile, excomapny, duration, " +
                    "skills, responsibility, exsalary FROM viewprofile WHERE email = ?"
                );
                profileStmt.setString(1, userEmail);
                rs = profileStmt.executeQuery();
                
                if (rs.next()) {
                    // Validate essential fields
                    String fullname = rs.getString("fullname");
                    
                    if (fullname == null || fullname.trim().isEmpty()) {
%>
                        <script>
                            alert('Please complete your profile before applying!');
                            location.href = 'ViewProfile.jsp';
                        </script>
<%
                    } else {
                        // Insert application
                        insertStmt = conn.prepareStatement(
                            "INSERT INTO recruiter_inbox (recruiter_email, candidate_email, job_id, post_type, " +
                            "fullname, resume, education, phoneno, address, gender, linkedin, github, " +
                            "pwebsite, jobtitile, excomapny, duration, skills, responsibility, exsalary, " +
                            "application_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW())"
                        );
                        
                        insertStmt.setString(1, recruiterEmail);
                        insertStmt.setString(2, userEmail);
                        insertStmt.setString(3, jobId);
                        insertStmt.setString(4, postType);
                        insertStmt.setString(5, rs.getString("fullname"));
                        insertStmt.setString(6, rs.getString("resume"));
                        insertStmt.setString(7, rs.getString("education"));
                        insertStmt.setString(8, rs.getString("phoneno"));
                        insertStmt.setString(9, rs.getString("address"));
                        insertStmt.setString(10, rs.getString("gender"));
                        insertStmt.setString(11, rs.getString("linkedin"));
                        insertStmt.setString(12, rs.getString("github"));
                        insertStmt.setString(13, rs.getString("pwebsite"));
                        insertStmt.setString(14, rs.getString("jobtitile"));
                        insertStmt.setString(15, rs.getString("excomapny"));
                        insertStmt.setString(16, rs.getString("duration"));
                        insertStmt.setString(17, rs.getString("skills"));
                        insertStmt.setString(18, rs.getString("responsibility"));
                        insertStmt.setString(19, rs.getString("exsalary"));
                        
                        int rows = insertStmt.executeUpdate();
                        
                        if (rows > 0) {
                            String successRedirect = "internship".equalsIgnoreCase(postType) ? "Internship.jsp" : "JobPortal.jsp";
%>
                            <script>
                                alert('Application sent successfully! The recruiter will review your profile.');
                                location.href = '<%= successRedirect %>';
                            </script>
<%
                        } else {
%>
                            <script>
                                alert('Application failed! Please try again.');
                                history.back();
                            </script>
<%
                        }
                    }
                } else {
%>
                    <script>
                        alert('User profile not found! Please create your profile first.');
                        location.href = 'ViewProfile.jsp';
                    </script>
<%
                }
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
%>
            <script>
                alert('System error occurred! Please try again later.');
                history.back();
            </script>
<%
        } finally {
            // Clean up resources
            try {
                if (rs != null) rs.close();
                if (duplicateRs != null) duplicateRs.close();
                if (profileStmt != null) profileStmt.close();
                if (checkDuplicateStmt != null) checkDuplicateStmt.close();
                if (insertStmt != null) insertStmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }
        }
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Application Processing</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #f5f5f5;
        }
        .processing {
            text-align: center;
            padding: 20px;
            background: white;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        }
        .spinner {
            border: 4px solid #f3f3f3;
            border-top: 4px solid #3498db;
            border-radius: 50%;
            width: 40px;
            height: 40px;
            animation: spin 2s linear infinite;
            margin: 0 auto 20px;
        }
        @keyframes spin {
            0% { transform: rotate(0deg); }
            100% { transform: rotate(360deg); }
        }
    </style>
</head>
<body>
    <div class="processing">
        <div class="spinner"></div>
        <h2>Processing Your Application...</h2>
        <p>Please wait while we submit your application.</p>
    </div>
</body>
</html>
