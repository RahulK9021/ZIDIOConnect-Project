<%-- 
    Document   : RecruiterDashboard
    Created on : May 28, 2025, 10:24:14 PM
    Author     : Rahul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/recruiterdashboard.css">
        <title>Recruiter Dashboard</title>
    </head>
    <body>
    <header>
  <h1>< ZIDIOConnect ></h1>
 
  <nav class="top-nav">
   
      <a href="#"><h3>Job Postings</h3></a>
    <a href="#"><h3>Candidates</h3></a> 
    
     <a href="#"><h3>Messages</h3></a>
   
  </nav>
  <div class="profile">
      <img src="images/profile1.png" alt="profile image" class="profile-img"><br>
       <a href="#">View Profile</a><br><br>
  </div>
    </header><br><br>


    <main>
        <div class="dashboard-cards">
        <div class="card">
          <h3>Total Applications</h3>
          <p>1,245</p>
        </div>
        <div class="card">
          <h3>Shortlisted</h3>
          <p>320</p>
        </div>
        <div class="card">
          <h3>Interviews</h3>
          <p>145</p>
        </div>
        <div class="card">
          <h3>Hired</h3>
          <p>58</p>
        </div>
      </div>

      <div class="section">
        <h2>Recent Candidates</h2>
        <table class="table">
          <thead>
            <tr>
              <th>Name</th>
              <th>Position</th>
              <th>Status</th>
              <th>Date Applied</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>Alice Johnson</td>
              <td>UX Designer</td>
              <td>Interview Scheduled</td>
              <td>May 25, 2025</td>
            </tr>
            <tr>
              <td>Bob Smith</td>
              <td>Frontend Developer</td>
              <td>Shortlisted</td>
              <td>May 24, 2025</td>
            </tr>
            <tr>
              <td>Clara Rose</td>
              <td>Backend Developer</td>
              <td>Applied</td>
              <td>May 23, 2025</td>
            </tr>
          </tbody>
        </table>
      </div>
    </main>
</body>
</html>


