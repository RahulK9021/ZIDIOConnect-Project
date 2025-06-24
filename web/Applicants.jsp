<%-- 
    Document   : Applicants
    Created on : Jun 23, 2025, 6:41:39 PM
    Author     : Rahul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="requirepackage.DBConnect" %>
<%@ page import="java.sql.*"%>
<%@ page import="requirepackage.UserController" %>
<%@ page import="requirepackage.Applicant" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Applicant List</title>
        <style>
            .applicants-table-container {
                margin: 20px;
                padding: 20px;
                background-color: #f9f9f9;
                border-radius: 8px;
            }
            .table-responsive {
                overflow-x: auto;
            }
            .table-applicants {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
            }
            .table-applicants th, .table-applicants td {
                border: 1px solid #ddd;
                padding: 8px;
                text-align: left;
            }
            .table-applicants th {
                background-color: #4CAF50;
                color: white;
            }
            .table-applicants tr:nth-child(even) {
                background-color: #f2f2f2;
            }
            .table-applicants a {
                color: #007bff;
                text-decoration: none;
            }
            .table-applicants a:hover {
                text-decoration: underline;
            }
            .no-applicants {
                text-align: center;
                color: #666;
                font-style: italic;
                padding: 20px;
            }
        </style>
    </head>
    <body>
        <div class="applicants-table-container">
            <h3>Applicant List</h3>
            <div class="table-responsive">
                <table class="table-applicants">
                    <thead>
                        <tr>
                            <th>Candidate Email</th>
                            <th>Full Name</th>
                            <th>Resume</th>
                            <th>Education</th>
                            <th>Phone</th>
                            <th>Gender</th>
                            <th>LinkedIn</th>
                            <th>GitHub</th>
                            <th>Portfolio</th>
                            <th>Job Title</th>
                            <th>Company</th>
                            <th>Duration</th>
                            <th>Skills</th>
                            <th>Responsibility</th>
                            <th>Expected Salary</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                        String recruiterEmail = (String) session.getAttribute("recruiterEmail");
                        PreparedStatement pstmt = null;
                        ResultSet rs = null;
                        Connection conn = null;
                        boolean hasApplicants = false;
                        
                        // Check if recruiter is logged in
                        if (recruiterEmail == null || recruiterEmail.trim().isEmpty()) {
                        %>
                            <tr>
                                <td colspan="15" class="no-applicants" style="color: red;">
                                    <strong>Error: You are not logged in. Please <a href="login.jsp">login</a> to view applicants.</strong>
                                </td>
                            </tr>
                        <%
                            return;
                        }
                        
                        try {
                            DBConnect dbc = new DBConnect();
                            conn = dbc.getConnection();
                            String postsSql = "SELECT candidate_email, fullname, resume, education, phoneno, gender, linkedin, github, pwebsite, jobtitile, excomapny, duration, skills, responsibility, exsalary FROM recruiter_inbox WHERE recruiter_email = ?";
                            pstmt = conn.prepareStatement(postsSql);
                            pstmt.setString(1, recruiterEmail);
                            rs = pstmt.executeQuery();
                            
                            while (rs.next()) {
                                hasApplicants = true;
                                String candidate_email = rs.getString("candidate_email") != null ? rs.getString("candidate_email") : "Not specified";
                                String fullname = rs.getString("fullname") != null ? rs.getString("fullname") : "Not specified";
                                String resume = rs.getString("resume") != null ? rs.getString("resume") : "";
                                String education = rs.getString("education") != null ? rs.getString("education") : "Not specified";
                                String phoneno = rs.getString("phoneno") != null ? rs.getString("phoneno") : "Not specified";
                                String gender = rs.getString("gender") != null ? rs.getString("gender") : "Not specified";
                                String linkedin = rs.getString("linkedin") != null ? rs.getString("linkedin") : "";
                                String github = rs.getString("github") != null ? rs.getString("github") : "";
                                String pwebsite = rs.getString("pwebsite") != null ? rs.getString("pwebsite") : "";
                                String jobtitile = rs.getString("jobtitile") != null ? rs.getString("jobtitile") : "Not specified";
                                String excomapny = rs.getString("excomapny") != null ? rs.getString("excomapny") : "Not specified";
                                String duration = rs.getString("duration") != null ? rs.getString("duration") : "Not specified";
                                String skills = rs.getString("skills") != null ? rs.getString("skills") : "Not specified";
                                String responsibility = rs.getString("responsibility") != null ? rs.getString("responsibility") : "Not specified";
                                String exsalary = rs.getString("exsalary") != null ? rs.getString("exsalary") : "Not specified";
                                
                                // Truncate responsibility if too long
                                if (responsibility.length() > 100) {
                                    responsibility = responsibility.substring(0, 100) + "...";
                                }
                        %>
                        <tr>
                            <td><%= candidate_email %></td>
                            <td><%= fullname %></td>
                            <td>
                                <% if (!resume.isEmpty() && !resume.equals("Not specified")) { %>
                                    <a href="<%= resume %>" target="_blank">View Resume</a>
                                <% } else { %>
                                    Not provided
                                <% } %>
                            </td>
                            <td><%= education %></td>
                            <td><%= phoneno %></td>
                            <td><%= gender %></td>
                            <td>
                                <% if (!linkedin.isEmpty() && !linkedin.equals("Not specified")) { %>
                                    <a href="<%= linkedin %>" target="_blank">Profile</a>
                                <% } else { %>
                                    Not provided
                                <% } %>
                            </td>
                            <td>
                                <% if (!github.isEmpty() && !github.equals("Not specified")) { %>
                                    <a href="<%= github %>" target="_blank">Repository</a>
                                <% } else { %>
                                    Not provided
                                <% } %>
                            </td>
                            <td>
                                <% if (!pwebsite.isEmpty() && !pwebsite.equals("Not specified")) { %>
                                    <a href="<%= pwebsite %>" target="_blank">Website</a>
                                <% } else { %>
                                    Not provided
                                <% } %>
                            </td>
                            <td><%= jobtitile %></td>
                            <td><%= excomapny %></td>
                            <td><%= duration %></td>
                            <td><%= skills %></td>
                            <td><%= responsibility %></td>
                            <td><%= exsalary %></td>
                        </tr>
                        <% 
                            }
                        } catch (SQLException e) {
                            out.println("SQL Error: " + e.getMessage());
                            e.printStackTrace();
                        } finally {
                            // Properly close resources
                            try {
                                if (rs != null) rs.close();
                                if (pstmt != null) pstmt.close();
                                if (conn != null) conn.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                        
                        // Show message if no applicants found
                        if (!hasApplicants) {
                        %>
                        <tr>
                            <td colspan="15" class="no-applicants">No applicants found for this recruiter.</td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>