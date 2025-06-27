<%-- 
    Document   : JobseekerDashboard
    Created on : Jun 26, 2025, 1:40:05 PM
    Author     : Rahul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="requirepackage.DBConnect"%>
<%@page import="java.sql.*"%>
<%
    String userEmail = (String) session.getAttribute("email");
    if (userEmail == null) {
        response.sendRedirect("Login.jsp");
        return;
    }

    DBConnect dbc = new DBConnect();
    Connection conn = dbc.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
%>
<!DOCTYPE html>
<html>
<head>
    <title>My Applications</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f0f2f5; padding: 2rem; }
        h2 { text-align: center; color: #2d3436; }
        table { width: 100%; border-collapse: collapse; background: #fff; box-shadow: 0 2px 8px rgba(0,0,0,0.1); margin-top: 2rem; }
        th, td { padding: 12px 16px; text-align: left; border-bottom: 1px solid #ddd; }
        th { background: #00b894; color: white; }
        .badge { padding: 5px 10px; border-radius: 5px; font-size: 0.9rem; color: white; }
        .accepted { background: #27ae60; }
        .rejected { background: #e74c3c; }
        .pending { background: #f39c12; }
        .interview { background: #0984e3; margin-top: 10px; padding: 8px; border-radius: 5px; color: white; }
    </style>
</head>
<body>
    <h2>My Applications</h2>
    <table>
        <tr>
            <th>Job Title</th>
            <th>Company</th>
            <th>Status</th>
            <th>Interview Info</th>
        </tr>
<%
    try {
        String sql = "SELECT jobtitile, excomapny, application_status, interview_date, interview_time, interview_mode, interview_link FROM recruiter_inbox WHERE candidate_email = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, userEmail);
        rs = ps.executeQuery();

        while (rs.next()) {
            String title = rs.getString("jobtitile");
            String company = rs.getString("excomapny");
            String status = rs.getString("application_status");
            String date = rs.getString("interview_date");
            String time = rs.getString("interview_time");
            String mode = rs.getString("interview_mode");
            String link = rs.getString("interview_link");
%>
        <tr>
            <td><%= title %></td>
            <td><%= company %></td>
            <td>
                <% if ("accepted".equalsIgnoreCase(status)) { %>
                    <span class="badge accepted">Accepted</span>
                <% } else if ("rejected".equalsIgnoreCase(status)) { %>
                    <span class="badge rejected">Rejected</span>
                <% } else { %>
                    <span class="badge pending">Pending</span>
                <% } %>
            </td>
            <td>
                <% if ("accepted".equalsIgnoreCase(status) && date != null) { %>
                    <div class="interview">
                        📅 <b>Date:</b> <%= date %><br>
                        🕒 <b>Time:</b> <%= time %><br>
                        💬 <b>Mode:</b> <%= mode %><br>
                        🔗 <a href="<%= link %>" style="color: white;" target="_blank">Join Meeting</a>
                    </div>
                <% } else { %>
                    -
                <% } %>
            </td>
        </tr>
<%
        }
    } catch(Exception e) {
        out.println("<tr><td colspan='4'>Error: " + e.getMessage() + "</td></tr>");
    } finally {
        try { if (rs != null) rs.close(); } catch (Exception e) {}
        try { if (ps != null) ps.close(); } catch (Exception e) {}
        try { if (conn != null) conn.close(); } catch (Exception e) {}
    }
%>
    </table>
</body>
</html>
