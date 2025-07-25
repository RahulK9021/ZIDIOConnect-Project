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
        <title>SheduleInterview</title>
        <style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: #f2f6fc;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        background-image: linear-gradient(120deg, #84fab0 0%, #8fd3f4 100%);
        align-items: center;
        height: 100vh;
    }

    form {
        background-color: #ffffff;
        padding: 30px 40px;
        border-radius: 12px;
        box-shadow: 0 8px 16px rgba(0, 0, 0, 0.1);
        width: 100%;
        max-width: 400px;
    }

    h3 {
        text-align: center;
        color: #333;
        margin-bottom: 20px;
    }

    label {
        font-weight: bold;
        display: block;
        margin-top: 15px;
        color: #444;
    }

    input[type="date"],
    input[type="time"],
    input[type="text"] {
        width: 100%;
        padding: 10px 12px;
        margin-top: 5px;
        border: 1px solid #ccc;
        border-radius: 8px;
        box-sizing: border-box;
        font-size: 14px;
        background-color: #fafafa;
    }

    button {
        width: 100%;
        margin-top: 25px;
        padding: 12px;
        font-size: 16px;
        background-color: #4a90e2;
        color: #fff;
        border: none;
        border-radius: 8px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    button:hover {
        background-color: #357bd8;
    }
</style>
    </head>
    <body>
<!--        <%
String email = request.getParameter("email");
%>
<h3>Schedule Interview for <%= email %></h3><br>-->
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
