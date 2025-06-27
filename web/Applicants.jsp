<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="requirepackage.DBConnect" %>
<%@ page import="java.sql.*" %>

<%
    String recruiterEmail = (String) session.getAttribute("recruiterEmail");
    if (recruiterEmail == null || recruiterEmail.trim().isEmpty()) {
        response.sendRedirect("Login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Applicant List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" rel="stylesheet" />
    <style>
        body {
            background-color: #f0f2f5;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        .applicant-card {
            background-color: #fff;
            border-radius: 12px;
            padding: 24px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.06);
            margin-bottom: 24px;
        }
        .applicant-card h5 {
            font-weight: 600;
            color: #2c3e50;
        }
        .badge {
            font-size: 12px;
            padding: 5px 10px;
            text-transform: uppercase;
        }
        .btn-sm {
            font-size: 13px;
        }
        .info-links a {
            margin-right: 8px;
        }
    </style>
</head>
<body class="bg-light">
    <div class="container py-5">
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h2 class="text-primary"><i class="fas fa-users me-2"></i>Applicant List</h2>
            <a href="RecruiterDashboard.jsp" class="btn btn-outline-primary"><i class="fas fa-arrow-left me-1"></i> Back</a>
        </div>

        <%
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            Connection conn = null;
            boolean hasApplicants = false;

            try {
                DBConnect dbc = new DBConnect();
                conn = dbc.getConnection();
                String postsSql ="SELECT r.comname, r.jobroll, ri.candidate_email, ri.post_type, ri.fullname, ri.resume, ri.education, ri.phoneno, ri.gender, ri.linkedin, ri.github, ri.pwebsite, ri.jobtitile, ri.excomapny, ri.duration, ri.skills, ri.responsibility, ri.exsalary, ri.application_status FROM recruiter r JOIN recruiter_inbox ri ON r.recruiter_email = ri.recruiter_email WHERE r.recruiter_email = ?";

                pstmt = conn.prepareStatement(postsSql);
                pstmt.setString(1, recruiterEmail);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    hasApplicants = true;

                    String comname = rs.getString("comname");
                    String jobroll = rs.getString("jobroll");
                    String candidate_email = rs.getString("candidate_email");
                    String post_type = rs.getString("post_type");
                    String fullname = rs.getString("fullname");
                    String resume = rs.getString("resume");
                    String education = rs.getString("education");
                    String phoneno = rs.getString("phoneno");
                    String gender = rs.getString("gender");
                    String linkedin = rs.getString("linkedin");
                    String github = rs.getString("github");
                    String pwebsite = rs.getString("pwebsite");
                    String jobtitle = rs.getString("jobtitile");
                    String excompany = rs.getString("excomapny");
                    String duration = rs.getString("duration");
                    String skills = rs.getString("skills");
                    String responsibility = rs.getString("responsibility");
                    String exsalary = rs.getString("exsalary");
                    String application_status = rs.getString("application_status");

                    if (responsibility.length() > 100) {
                        responsibility = responsibility.substring(0, 100) + "...";
                    }
        %>

        <div class="applicant-card">
            <div class="d-flex justify-content-between mb-3">
                <div>
                    <h5 class="mb-1"><%= fullname %></h5>
                    <p class="mb-0 text-muted"><i class="fas fa-building me-1"></i> <%= comname %></p>
                    <small class="text-muted"><i class="fas fa-briefcase me-1"></i> <%= jobroll %></small>
                </div>
                <span class="badge bg-<%= post_type.equals("internship") ? "info" : "success" %>">
                    <%= post_type.toUpperCase() %>
                </span>
            </div>

            <p class="mb-1"><strong>Education:</strong> <%= education %></p> 
            <p class="mb-1"><strong>Phone No:</strong> <%= phoneno %></p>
            <p class="mb-1"><strong>Gender:</strong> <%= gender %></p>
           <% if (jobtitle != null && !jobtitle.trim().isEmpty()) { %>
            <p class="mb-1"><strong>Experience:</strong> <%= jobtitle %> at <%= excompany %> — <%= duration %></p>
            <p class="mb-1"><strong>Skills:</strong> <%= skills %></p>
            <p class="mb-1"><strong>Responsibilities:</strong> <%= responsibility %></p>
            <p class="mb-1"><strong>Previous Salary:</strong> ₹<%= exsalary %></p>
          <% } %>

            <div class="info-links mb-3">
                <% if (!linkedin.isEmpty()) { %>
                    <a href="<%= linkedin %>" class="btn btn-outline-primary btn-sm" target="_blank"><i class="fab fa-linkedin me-1"></i>LinkedIn</a>
                <% } %>
                <% if (!github.isEmpty()) { %>
                    <a href="<%= github %>" class="btn btn-outline-dark btn-sm" target="_blank"><i class="fab fa-github me-1"></i>GitHub</a>
                <% } %>
                <% if (!pwebsite.isEmpty()) { %>
                    <a href="<%= pwebsite %>" class="btn btn-outline-info btn-sm" target="_blank"><i class="fas fa-globe me-1"></i>Website</a>
                <% } %>
                <% if (!resume.isEmpty()) { %>
                    <a href="<%= resume %>" class="btn btn-outline-success btn-sm" target="_blank"><i class="fas fa-file-alt me-1"></i>Resume</a>
                <% } %>
            </div>

            <div class="d-flex justify-content-between align-items-center">
                <div class="text-muted small"><i class="fas fa-envelope me-1"></i><%= candidate_email %> | <i class="fas fa-phone me-1"></i><%= phoneno %></div>

                <% if (!"accepted".equalsIgnoreCase(application_status)) { %>
                    <form action="UpdateApplicationStatus.jsp" method="post" class="d-inline">
                        <input type="hidden" name="email" value="<%= candidate_email %>">
                        <input type="hidden" name="status" value="accepted">
                        <button class="btn btn-success btn-sm me-2">Accept</button>
                    </form>
                    <form action="DeleteApplication.jsp" method="post" class="d-inline">
                        <input type="hidden" name="email" value="<%= candidate_email %>">
                        <button class="btn btn-danger btn-sm">Reject</button>
                    </form>

                <% } else { %>
                    <span class="badge bg-success px-3 py-2">Accepted</span>
                <% } %>
            </div>
        </div>

        <% 
                } // end while
            } catch (SQLException e) {
                out.println("SQL Error: " + e.getMessage());
            } finally {
                try {
                    if (rs != null) rs.close();
                    if (pstmt != null) pstmt.close();
                    if (conn != null) conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (!hasApplicants) {
        %>
        <div class="alert alert-warning text-center mt-4">
            No applicants found for this recruiter.
        </div>
        <% } %>
    </div>
</body>
</html>
