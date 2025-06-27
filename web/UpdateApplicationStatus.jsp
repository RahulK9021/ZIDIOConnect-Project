<%-- 
    Document   : UpdateApplicationStatus
    Created on : Jun 26, 2025, 1:20:44 PM
    Author     : Rahul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, requirepackage.DBConnect" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%@ page import="java.sql.*, requirepackage.DBConnect" %>
<%
String email = request.getParameter("email");
String status = request.getParameter("status");

DBConnect dbc = new DBConnect();
Connection conn = dbc.getConnection();

PreparedStatement ps = null;

try {
    String sql = "UPDATE recruiter_inbox SET application_status = ? WHERE candidate_email = ?";
    ps = conn.prepareStatement(sql);
    ps.setString(1, status);
    ps.setString(2, email);
    int updated = ps.executeUpdate();

    if ("accepted".equalsIgnoreCase(status)) {
        response.sendRedirect("ScheduleInterview.jsp?email=" + email);
    } else {
        out.println("<script>alert('Application Rejected'); window.location='Applicants.jsp';</script>");
    }

} catch (Exception e) {
    out.println("Error: " + e.getMessage());
} finally {
    if (ps != null) ps.close();
    if (conn != null) conn.close();
}
%>

    </body>
</html>
