<%-- 
    Document   : DeleteApplication
    Created on : Jun 27, 2025, 5:51:16 PM
    Author     : Rahul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="requirepackage.DBConnect" %>

<%
String email = request.getParameter("email");
if (email != null && !email.trim().isEmpty()) {
    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
        DBConnect dbc = new DBConnect();
        conn = dbc.getConnection();

        String sql = "DELETE FROM recruiter_inbox WHERE candidate_email = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, email);

        int result = pstmt.executeUpdate();

        if (result > 0) {
            response.sendRedirect("Applicants.jsp?msg=deleted");
        } else {
            response.sendRedirect("Applicants.jsp?msg=notfound");
        }
    } catch (SQLException e) {
        out.println("SQL Error: " + e.getMessage());
    } finally {
        try {
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
} else {
    out.println("Invalid candidate email.");
}
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
