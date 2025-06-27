<%-- 
    Document   : ScheduleInterview
    Created on : Jun 26, 2025, 1:21:40 PM
    Author     : Rahul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
String email = request.getParameter("email");
%>
<h3>Schedule Interview for <%= email %></h3>
<form action="SaveInterview.jsp" method="post">
    <input type="hidden" name="email" value="<%= email %>">
    Date: <input type="date" name="interview_date" required><br>
    Time: <input type="time" name="interview_time" required><br>
    Mode (Zoom/Google Meet): <input type="text" name="interview_mode" required><br>
    Meeting Link: <input type="text" name="interview_link" required><br>
    <button type="submit">Save & Notify</button>
</form>

    </body>
</html>
