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
    <title>Debug - My Applications</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f4f6f9;
            margin: 0;
            padding: 2rem;
        }

        h2, h3 {
            text-align: center;
            color: #2d3436;
        }

        .debug {
            background-color: #ffeaa7;
            border-left: 5px solid #fdcb6e;
            padding: 10px 15px;
            margin: 20px auto;
            width: 80%;
            font-weight: bold;
            color: #636e72;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        table {
            width: 90%;
            margin: 20px auto;
            border-collapse: collapse;
            background-color: #ffffff;
            box-shadow: 0 4px 8px rgba(0,0,0,0.05);
            border-radius: 8px;
            overflow: hidden;
        }

        th {
            background-color: #00cec9;
            color: white;
            padding: 12px 15px;
            text-transform: uppercase;
            letter-spacing: 0.05em;
            border-bottom: 2px solid #00b894;
        }

        td {
            padding: 12px 15px;
            border-bottom: 1px solid #ecf0f1;
            color: #2d3436;
        }

        tr:hover {
            background-color: #f1f2f6;
        }

        .no-data {
            text-align: center;
            color: #d63031;
            padding: 15px;
            font-weight: bold;
        }
    </style>
</head>
<body>

    <h2>My Applications</h2>
    <div class="debug">User Email: <%= userEmail %></div>

<%
    try {
        // Step 1: Check if there are any applications for this user
        ps = conn.prepareStatement("SELECT COUNT(*) as count FROM recruiter_inbox WHERE candidate_email = ?");
        ps.setString(1, userEmail);
        rs = ps.executeQuery();
        if (rs.next()) {
            int count = rs.getInt("count");
%>
            <!--<div class="debug">Total applications in recruiter_inbox: <%= count %></div>-->
<%
        }

        // Step 2 & 3: Show JOIN data
        String sql = "SELECT ri.application_status, ri.interview_date, ri.interview_time, ri.interview_mode, ri.interview_link, " +
                     "np.jobroll, r.comname, ri.job_id, ri.recruiter_email " +
                     "FROM recruiter_inbox ri " +
                     "LEFT JOIN newpost np ON ri.job_id = np.id " +
                     "LEFT JOIN recruiter r ON ri.recruiter_email = r.recruiter_email " +
                     "WHERE ri.candidate_email = ? " +
                     "ORDER BY ri.application_date DESC";

        ps = conn.prepareStatement(sql);
        ps.setString(1, userEmail);
        rs = ps.executeQuery();

        out.println("<table><tr><th>Job Role</th><th>Company name</th><th>Recruiter Email</th><th>Status</th><th>Interview Date</th><th>Interview Time</th><th>Interview Mode</th></tr>");

        boolean hasJoinData = false;
        while (rs.next()) {
            hasJoinData = true;
            out.println("<tr>");
            out.println("<td>" + (rs.getString("jobroll") != null ? rs.getString("jobroll") : "NULL") + "</td>");
            out.println("<td>" + (rs.getString("comname") != null ? rs.getString("comname") : "NULL") + "</td>");
            out.println("<td>" + rs.getString("recruiter_email") + "</td>");
            out.println("<td>" + rs.getString("application_status") + "</td>");
            out.println("<td>" + rs.getString("interview_date") + "</td>");
            out.println("<td>" + rs.getString("interview_time") + "</td>");
           out.println("<td><a href='" + rs.getString("interview_link") + "' target='_blank'>Join Interview</a></td>");
            out.println("</tr>");
        }

        if (!hasJoinData) {
            out.println("<tr><td colspan='5' class='no-data'>No data from JOIN query</td></tr>");
        }
        out.println("</table>");

    } catch(Exception e) {
        out.println("<div style='color: red; text-align:center; font-weight:bold;'>Error: " + e.getMessage() + "</div>");
        e.printStackTrace();
    } finally {
        try { if (rs != null) rs.close(); } catch (Exception e) {}
        try { if (ps != null) ps.close(); } catch (Exception e) {}
        try { if (conn != null) conn.close(); } catch (Exception e) {}
    }
%>

</body>
</html>
