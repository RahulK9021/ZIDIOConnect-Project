<%-- 
    Document   : SaveInterview
    Created on : Jun 26, 2025, 1:25:27 PM
    Author     : Rahul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, requirepackage.DBConnect" %>
<%
String email = request.getParameter("email");
String date = request.getParameter("interview_date");
String time = request.getParameter("interview_time");
String mode = request.getParameter("interview_mode");
String link = request.getParameter("interview_link");

DBConnect dbc = new DBConnect();
Connection conn = dbc.getConnection();
PreparedStatement ps = null;

try {
    String sql = "UPDATE recruiter_inbox SET interview_date = ?, interview_time = ?, interview_mode = ?, interview_link = ? WHERE candidate_email = ?";
    ps = conn.prepareStatement(sql);
    ps.setString(1, date);
    ps.setString(2, time);
    ps.setString(3, mode);
    ps.setString(4, link);
    ps.setString(5, email);
    ps.executeUpdate();

    out.println("<script>alert('Interview Scheduled Successfully!'); window.location='Applicants.jsp';</script>");
} catch (Exception e) {
    out.println("Error: " + e.getMessage());
} finally {
    if (ps != null) ps.close();
    if (conn != null) conn.close();
}
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       
    </body>
</html>
