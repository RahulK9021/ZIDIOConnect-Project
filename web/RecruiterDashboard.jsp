<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@page import="requirepackage.DBConnect" %>
<%
    // Check if recruiter is logged in
    String recruiterEmail = (String) session.getAttribute("recruiterEmail");
    if (recruiterEmail == null) {
        response.sendRedirect("Login.jsp");
        return;
    }    
    
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    DBConnect dbc=new DBConnect();
    Connection conn=dbc.getConnection();
    String recruiterName = "";
    String companyName = "";
    int totalPosts = 0;
    int totalJobs = 0;
    int totalInternships = 0;
    String comwebsite="";
    
    // Handle delete operation
    String deleteId = request.getParameter("deleteId");
    if (deleteId != null) {
        try {
            
            String deleteSql = "DELETE FROM recruiter WHERE id = ? AND recruiter_email = ?";
            pstmt = conn.prepareStatement(deleteSql);
            pstmt.setInt(1, Integer.parseInt(deleteId));
            pstmt.setString(2, recruiterEmail);
            int deleted = pstmt.executeUpdate();
            
            if (deleted > 0) {
                out.println("<script>alert('Post deleted successfully!'); window.location.href='RecruiterDashboard.jsp';</script>");
            }
        } catch (Exception e) {
            out.println("<script>alert('Error: " + e.getMessage() + "');</script>");
        } finally {
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Recruiter Dashboard</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
    <style>
        body {
            background-image: linear-gradient(120deg, #84fab0 0%, #8fd3f4 100%);
            min-height: 100vh;
            font-family: Arial, sans-serif;
        }
        .dashboard-card {
            background: white;
            border-radius: 15px;
            box-shadow: 0 5px 15px rgba(0,0,0,0.1);
            margin-bottom: 20px;
        }
        .stats-box {
/*            background: linear-gradient(135deg, #4facfe 0%, #00f2fe 100%);*/
            background: white;
            color: black;
            border-radius: 10px;
            padding: 20px;
            text-align: center;
            margin-bottom: 20px;
        }
        .post-card {
            border: none;
            border-radius: 10px;
            box-shadow: 0 3px 10px rgba(0,0,0,0.1);
            margin-bottom: 15px;
        }
        .btn-custom {
            border-radius: 20px;
            padding: 8px 20px;
            font-weight: 600;
        }
        .job-badge {
            background: #007bff;
            color: white;
            padding: 3px 8px;
            border-radius: 15px;
            font-size: 0.8em;
        }
        .internship-badge {
            background: #28a745;
            color: white;
            padding: 3px 8px;
            border-radius: 15px;
            font-size: 0.8em;
        }
 .modern-job-card {
  display: flex;
  justify-content: space-between;
  background: #ffffff;
  border-radius: 16px;
  box-shadow: 0 8px 24px rgba(0, 0, 0, 0.08);
  padding: 20px;
  margin-bottom: 25px;
  transition: transform 0.2s ease;
}

.modern-job-card:hover {
  transform: translateY(-4px);
}

.modern-card-content {
  flex: 1;
}

.card-header-row {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 10px;
}

.card-header-row h4 {
  margin: 0;
  font-weight: 600;
  font-size: 1.25rem;
}

.badge-job {
  background: #0d6efd;
  color: white;
  padding: 4px 12px;
  border-radius: 50px;
  font-size: 0.75rem;
  font-weight: bold;
}

.badge-internship {
  background: #20c997;
  color: white;
  padding: 4px 12px;
  border-radius: 50px;
  font-size: 0.75rem;
  font-weight: bold;
}

.job-details {
  list-style: none;
  padding: 0;
  margin: 10px 0;
}

.job-details li {
  margin-bottom: 6px;
  color: #444;
  font-size: 0.95rem;
}

.job-details i {
  margin-right: 6px;
  color: #6c757d;
}

.description {
  color: #666;
  font-size: 0.9rem;
  margin-top: 10px;
}

.card-actions {
  display: flex;
  flex-direction: column;
  gap: 10px;
  margin-left: 20px;
}

.btn {
  padding: 8px 14px;
  font-size: 0.9rem;
  border: none;
  border-radius: 30px;
  cursor: pointer;
  transition: all 0.3s ease;
}

.btn.edit {
  background-color: #0d6efd;
  color: white;
}

.btn.edit:hover {
  background-color: #0b5ed7;
}

.btn.delete {
  background-color: #dc3545;
  color: white;
}

.btn.delete:hover {
  background-color: #bb2d3b;
}

a{
    text-decoration: none;
    color: black;
}
        
    </style>
</head>
<body>
    <div class="container mt-4">
        <!-- Header -->
        <div class="dashboard-card">
            <div class="card-body p-4">
                <div class="row align-items-center">
                    <div class="col-md-8">
                        <h2><i class="fas fa-tachometer-alt text-primary me-2"></i>Recruiter Dashboard</h2>
                        <p class="text-muted">Welcome, <%= recruiterEmail %></p>
                    </div>
                    <div class="col-md-4 text-end">
                        <a href="Registration.jsp" class="btn btn-success btn-custom me-2">
                            <i class="fas fa-plus me-1"></i>Add New Post
                        </a>
                        <a href="Login.jsp" class="btn btn-outline-danger btn-custom">
                            <i class="fas fa-sign-out-alt me-1"></i>Logout
                        </a>
                    </div>
                </div>
            </div>
        </div>

        <!-- Statistics -->
        <%
        try {
           
            
            // Get recruiter info and stats
            String statsSql = "SELECT full_name,comwebsite, comname, post_type FROM recruiter WHERE recruiter_email = ?";
            pstmt = conn.prepareStatement(statsSql);
            pstmt.setString(1, recruiterEmail);
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                if (recruiterName.isEmpty()) {
                    recruiterName = rs.getString("full_name") != null ? rs.getString("full_name") : "Recruiter";
                    companyName = rs.getString("comname") != null ? rs.getString("comname") : "Your Company";
                   comwebsite = rs.getString("comwebsite") != null ? rs.getString("comwebsite") : "Your Company Website";
                }
                totalPosts++;
                String postType = rs.getString("post_type");
                if ("job".equals(postType)) {
                    totalJobs++;
                } else if ("internship".equals(postType)) {
                    totalInternships++;
                }
            }
        } catch (Exception e) {
            out.println("<!-- Error getting stats: " + e.getMessage() + " -->");
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
            
        }
        %>

        <div class="row">
            <div class="col-md-3">
                <div class="stats-box">
                    <i class="fas fa-briefcase fa-2x mb-2"></i>
                    <h4><%= totalPosts %></h4>
                    <p class="mb-0">Total Posts</p>
                </div>
            </div>
            <div class="col-md-3">
                <div class="stats-box">
                    <i class="fas fa-user-tie fa-2x mb-2"></i>
                    <h4><%= totalJobs %></h4>
                    <p><a href="Applicants.jsp"> Applicants</a></p>
                </div>
            </div>
            <div class="col-md-3">
                <div class="stats-box">
                    <i class="fas fa-graduation-cap fa-2x mb-2"></i>
                    <h4><%= totalInternships %></h4>
                    <p class="mb-0">Internships</p>
                </div>
            </div>
            <div class="col-md-3">
                <div class="stats-box">
                    <i class="fas fa-building fa-2x mb-2"></i>
                    <h4>1</h4>
                   <p><a href="<%= comwebsite %>"> Company</a></p>
                </div>
            </div>
        </div>

        <!-- Posts List -->
        <div class="dashboard-card">
            <div class="card-body">
                <h4 class="mb-4">Your Posts</h4>
                
                <%
                try {
                   
                    
                    String postsSql = "SELECT * FROM recruiter WHERE recruiter_email = ? ORDER BY id DESC";
                    pstmt = conn.prepareStatement(postsSql);
                    pstmt.setString(1, recruiterEmail);
                    rs = pstmt.executeQuery();
                    
                    boolean hasPosts = false;
                    while (rs.next()) {
                        hasPosts = true;
                        int id = rs.getInt("id");
                         String company = rs.getString("comname") != null ? rs.getString("comname") : "Company";
                        String jobRole = rs.getString("jobroll") != null ? rs.getString("jobroll") : "Not specified";
                        String skills = rs.getString("skill") != null ? rs.getString("skill") : "Not specified";
                        String location = rs.getString("loc") != null ? rs.getString("loc") : "Not specified";
                        Date deadline = rs.getDate("deadline");
                        String salary = rs.getString("salary") != null ? rs.getString("salary") : "Not specified";
                         String experience = rs.getString("exp") != null ? rs.getString("exp") : "No description";
                        String description = rs.getString("des") != null ? rs.getString("des") : "No description";
                        String postType = rs.getString("post_type") != null ? rs.getString("post_type") : "No description";
                       
                       
                        
                        // Truncate description if too long
                        if (description.length() > 100) {
                            description = description.substring(0, 100) + "...";
                        }
                %>
                
             <div class="modern-job-card">
  <div class="modern-card-content">
 

    <!-- Existing HTML omitted for brevity -->
<% 
    // inside the loop:
    if ("internship".equalsIgnoreCase(postType)) {
%>

<div class="modern-job-card">
  <div class="modern-card-content">
    <div class="card-header-row">
      <h4><%= jobRole %></h4>
      <span class="badge badge-internship"><%= postType.toUpperCase() %></span>
    </div>
    <ul class="job-details">
      <li><i class="fas fa-building"></i><strong> Company:</strong> <%= company %></li>
      <li><i class="fas fa-briefcase"></i><strong> Job Role:</strong> <%= jobRole %></li>
      <li><i class="fas fa-tools"></i><strong> Skills:</strong> <%= skills %></li>
      <li><i class="fas fa-map-marker-alt"></i><strong> Location:</strong> <%= location %></li>
      <li><i class="fas fa-hourglass-half"></i><strong> Deadline:</strong> <%= deadline != null ? new java.text.SimpleDateFormat("dd-MM-yyyy").format(deadline) : "No deadline" %></li>
      <li><i class="fas fa-money-bill-wave"></i><strong> Stipend:</strong> ₹<%= salary %></li>
      <li><i class="fas fa-clock"></i><strong> Duration:</strong> <%= experience %></li>
      <li><i class="fas fa-book-reader"></i><strong> What Will You Learn:</strong> <%= description %></li>
    </ul>
  </div>
  <div class="card-actions">
    <button class="btn edit" onclick="editPost(<%= id %>)"><i class="fas fa-edit"></i> Edit</button>
    <button class="btn delete" onclick="deletePost(<%= id %>, '<%= jobRole %>')"><i class="fas fa-trash"></i> Delete</button>
  </div>
</div>

<% 
    } else { 
%>

<div class="modern-job-card">
  <div class="modern-card-content">
    <div class="card-header-row">
      <h4><%= jobRole %></h4>
      <span class="badge badge-job"><%= postType.toUpperCase() %></span>
    </div>
    <ul class="job-details">
      <li><i class="fas fa-building"></i><strong> Company:</strong> <%= company %></li>
      <li><i class="fas fa-briefcase"></i><strong> Job Role:</strong> <%= jobRole %></li>
      <li><i class="fas fa-tools"></i><strong> Skills:</strong> <%= skills %></li>
      <li><i class="fas fa-map-marker-alt"></i><strong> Location:</strong> <%= location %></li>
      <li><i class="fas fa-hourglass-half"></i><strong> Deadline:</strong> <%= deadline != null ? new java.text.SimpleDateFormat("dd-MM-yyyy").format(deadline) : "No deadline" %></li>
      <li><i class="fas fa-money-bill-wave"></i><strong> Salary:</strong> ₹<%= salary %></li>
      <li><i class="fas fa-briefcase"></i><strong> Experience:</strong> <%= experience %></li>
      <li><i class="fas fa-info-circle"></i><strong> Description:</strong> <%= description %></li>
    </ul>
  </div>
  <div class="card-actions">
    <button class="btn edit" onclick="editPost(<%= id %>)"><i class="fas fa-edit"></i> Edit</button>
    <button class="btn delete" onclick="deletePost(<%= id %>, '<%= jobRole %>')"><i class="fas fa-trash"></i> Delete</button>
  </div>
</div>

<%
    }
%>



                
                <%
                    }
                    
                    if (!hasPosts) {
                %>
                <div class="text-center py-5">
                    <i class="fas fa-inbox fa-4x text-muted mb-3"></i>
                    <h4 class="text-muted">No Posts Yet</h4>
                    <p class="text-muted">Start by creating your first job or internship post!</p>
                    <a href="Registration.jsp" class="btn btn-success btn-custom">
                        <i class="fas fa-plus me-1"></i>Create Your First Post
                    </a>
                </div>
                <%
                    }
                    
                } catch (Exception e) {
                    out.println("<div class='alert alert-danger'>Error loading posts: " + e.getMessage() + "</div>");
                } finally {
                    try { if (rs != null) rs.close(); } catch (Exception e) {}
                    try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
                    try { if (conn != null) conn.close(); } catch (Exception e) {}
                }
                %>
            </div>
        </div>
    </div>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
    <script>
        function deletePost(id, jobTitle) {
            if (confirm('Are you sure you want to delete "' + jobTitle + '"?')) {
                window.location.href = 'RecruiterDashboard.jsp?deleteId=' + id;
            }
        }
        
        function editPost(id) {
            // You can redirect to an edit page or show a modal
            alert('Edit functionality - redirect to EditPost.jsp?id=' + id);
            // window.location.href = 'EditPost.jsp?id=' + id;
        }
    </script>
</body>
</html>