<%-- 
    Document   : Enhanced Applicants Management
    Created on : Jun 24, 2025
    Author     : Enhanced Version
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="requirepackage.DBConnect" %>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%
    // Handle Accept/Reject Actions
    String action = request.getParameter("action");
    String applicationId = request.getParameter("applicationId");
    String candidateEmail = request.getParameter("candidateEmail");
    String message = "";
    String messageType = "";
    
    if (action != null && applicationId != null && candidateEmail != null) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            DBConnect dbc = new DBConnect();
            conn = dbc.getConnection();
            
            String status = action.equals("accept") ? "accepted" : "rejected";
            String recruiterEmail = (String) session.getAttribute("recruiterEmail");
            
            // Update application status
            String updateSql = "UPDATE recruiter_inbox SET status = ?, updated_at = NOW() WHERE id = ? AND recruiter_email = ?";
            pstmt = conn.prepareStatement(updateSql);
            pstmt.setString(1, status);
            pstmt.setInt(2, Integer.parseInt(applicationId));
            pstmt.setString(3, recruiterEmail);
            
            int updated = pstmt.executeUpdate();
            
            if (updated > 0) {
                // Insert notification for candidate
                String notificationSql = "INSERT INTO notifications (candidate_email, recruiter_email, message, status, created_at) VALUES (?, ?, ?, ?, NOW())";
                pstmt.close();
                pstmt = conn.prepareStatement(notificationSql);
                pstmt.setString(1, candidateEmail);
                pstmt.setString(2, recruiterEmail);
                
                String notificationMessage = status.equals("accepted") ? 
                    "Congratulations! Your application has been accepted. The recruiter will contact you soon." :
                    "Thank you for your application. Unfortunately, we have decided to move forward with other candidates.";
                    
                pstmt.setString(3, notificationMessage);
                pstmt.setString(4, status);
                pstmt.executeUpdate();
                
                message = "Application " + status + " successfully and candidate notified!";
                messageType = "success";
            } else {
                message = "Failed to update application status.";
                messageType = "danger";
            }
            
        } catch (Exception e) {
            message = "Error: " + e.getMessage();
            messageType = "danger";
        } finally {
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Application Management</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
    <style>
        body {
            background-image: linear-gradient(120deg, #84fab0 0%, #8fd3f4 100%);
            min-height: 100vh;
            font-family: Arial, sans-serif;
        }
        
        .main-container {
            margin: 20px auto;
            max-width: 1400px;
            padding: 0 15px;
        }
        
        .header-card {
            background: white;
            border-radius: 15px;
            box-shadow: 0 5px 15px rgba(0,0,0,0.1);
            margin-bottom: 20px;
            padding: 25px;
        }
        
        .applicant-card {
            background: white;
            border-radius: 15px;
            box-shadow: 0 8px 24px rgba(0,0,0,0.08);
            margin-bottom: 20px;
            padding: 25px;
            transition: transform 0.2s ease;
        }
        
        .applicant-card:hover {
            transform: translateY(-3px);
        }
        
        .applicant-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 20px;
            padding-bottom: 15px;
            border-bottom: 2px solid #f0f0f0;
        }
        
        .applicant-info h4 {
            font-size: 1.4rem;
            font-weight: 600;
            color: #2c3e50;
            margin: 0;
        }
        
        .applicant-email {
            color: #7f8c8d;
            font-size: 0.9rem;
        }
        
        .status-badge {
            padding: 6px 12px;
            border-radius: 20px;
            font-size: 0.8rem;
            font-weight: bold;
            text-transform: uppercase;
        }
        
        .status-pending {
            background: #fff3cd;
            color: #856404;
        }
        
        .status-accepted {
            background: #d4edda;
            color: #155724;
        }
        
        .status-rejected {
            background: #f8d7da;
            color: #721c24;
        }
        
        .info-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
            gap: 15px;
            margin-bottom: 20px;
        }
        
        .info-item {
            padding: 12px;
            background: #f8f9fa;
            border-radius: 8px;
            border-left: 4px solid #007bff;
        }
        
        .info-label {
            font-weight: 600;
            color: #495057;
            font-size: 0.85rem;
            margin-bottom: 4px;
        }
        
        .info-value {
            color: #212529;
            font-size: 0.95rem;
        }
        
        .action-buttons {
            display: flex;
            gap: 10px;
            margin-top: 15px;
        }
        
        .btn-accept {
            background: linear-gradient(135deg, #28a745, #20c997);
            border: none;
            color: white;
            padding: 8px 20px;
            border-radius: 25px;
            font-weight: 600;
            transition: all 0.3s ease;
        }
        
        .btn-accept:hover {
            transform: translateY(-2px);
            box-shadow: 0 4px 12px rgba(40, 167, 69, 0.4);
            color: white;
        }
        
        .btn-reject {
            background: linear-gradient(135deg, #dc3545, #c82333);
            border: none;
            color: white;
            padding: 8px 20px;
            border-radius: 25px;
            font-weight: 600;
            transition: all 0.3s ease;
        }
        
        .btn-reject:hover {
            transform: translateY(-2px);
            box-shadow: 0 4px 12px rgba(220, 53, 69, 0.4);
            color: white;
        }
        
        .btn-back {
            background: linear-gradient(135deg, #6c757d, #495057);
            border: none;
            color: white;
            padding: 10px 20px;
            border-radius: 25px;
            font-weight: 600;
            text-decoration: none;
            display: inline-block;
            transition: all 0.3s ease;
        }
        
        .btn-back:hover {
            transform: translateY(-2px);
            color: white;
            text-decoration: none;
        }
        
        .link-item {
            color: #007bff;
            text-decoration: none;
        }
        
        .link-item:hover {
            text-decoration: underline;
        }
        
        .no-applications {
            text-align: center;
            padding: 60px 20px;
            color: #6c757d;
        }
        
        .no-applications i {
            font-size: 4rem;
            margin-bottom: 20px;
            color: #dee2e6;
        }
        
        .filters {
            display: flex;
            gap: 10px;
            margin-bottom: 20px;
            flex-wrap: wrap;
        }
        
        .filter-btn {
            padding: 8px 16px;
            border: 2px solid #dee2e6;
            background: white;
            border-radius: 20px;
            cursor: pointer;
            transition: all 0.3s ease;
        }
        
        .filter-btn.active {
            background: #007bff;
            color: white;
            border-color: #007bff;
        }
    </style>
</head>
<body>
    <div class="main-container">
        <!-- Header -->
        <div class="header-card">
            <div class="d-flex justify-content-between align-items-center">
                <div>
                    <h2><i class="fas fa-users text-primary me-2"></i>Application Management</h2>
                    <p class="text-muted mb-0">Review and manage job applications</p>
                </div>
                <div>
                    <a href="RecruiterDashboard.jsp" class="btn-back">
                        <i class="fas fa-arrow-left me-2"></i>Back to Dashboard
                    </a>
                </div>
            </div>
            
            <!-- Success/Error Messages -->
            <% if (!message.isEmpty()) { %>
            <div class="alert alert-<%= messageType %> alert-dismissible fade show mt-3" role="alert">
                <i class="fas fa-<%= messageType.equals("success") ? "check-circle" : "exclamation-triangle" %> me-2"></i>
                <%= message %>
                <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
            </div>
            <% } %>
            
            <!-- Filters -->
            <div class="filters mt-3">
                <button class="filter-btn active" onclick="filterApplications('all')">All Applications</button>
                <button class="filter-btn" onclick="filterApplications('pending')">Pending</button>
                <button class="filter-btn" onclick="filterApplications('accepted')">Accepted</button>
                <button class="filter-btn" onclick="filterApplications('rejected')">Rejected</button>
            </div>
        </div>

        <!-- Applications List -->
        <div id="applicationsContainer">
            <%
            String recruiterEmail = (String) session.getAttribute("recruiterEmail");
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            Connection conn = null;
            boolean hasApplicants = false;
            
            // Check if recruiter is logged in
            if (recruiterEmail == null || recruiterEmail.trim().isEmpty()) {
            %>
                <div class="applicant-card">
                    <div class="alert alert-danger text-center">
                        <i class="fas fa-exclamation-triangle fa-2x mb-3"></i>
                        <h4>Access Denied</h4>
                        <p>You are not logged in. Please <a href="Login.jsp">login</a> to view applications.</p>
                    </div>
                </div>
            <%
                return;
            }
            
            try {
                DBConnect dbc = new DBConnect();
                conn = dbc.getConnection();
                
                // Updated query to include id and status
                String postsSql = "SELECT id, candidate_email, fullname, resume, education, phoneno, gender, linkedin, github, pwebsite, jobtitile, excomapny, duration, skills, responsibility, exsalary, COALESCE(status, 'pending') as status FROM recruiter_inbox WHERE recruiter_email = ? ORDER BY id DESC";
                pstmt = conn.prepareStatement(postsSql);
                pstmt.setString(1, recruiterEmail);
                rs = pstmt.executeQuery();
                
                while (rs.next()) {
                    hasApplicants = true;
                    int id = rs.getInt("id");
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
                    String status = rs.getString("status") != null ? rs.getString("status") : "pending";
                    
                    // Truncate long text
                    String shortResponsibility = responsibility.length() > 150 ? responsibility.substring(0, 150) + "..." : responsibility;
            %>
            
            <div class="applicant-card" data-status="<%= status %>">
                <!-- Header -->
                <div class="applicant-header">
                    <div class="applicant-info">
                        <h4><%= fullname %></h4>
                        <div class="applicant-email"><%= candidate_email %></div>
                    </div>
                    <div>
                        <span class="status-badge status-<%= status %>">
                            <i class="fas fa-<%= status.equals("accepted") ? "check" : status.equals("rejected") ? "times" : "clock" %>"></i>
                            <%= status %>
                        </span>
                    </div>
                </div>
                
                <!-- Application Details -->
                <div class="info-grid">
                    <div class="info-item">
                        <div class="info-label"><i class="fas fa-briefcase me-1"></i>Applied Position</div>
                        <div class="info-value"><%= jobtitile %></div>
                    </div>
                    <div class="info-item">
                        <div class="info-label"><i class="fas fa-graduation-cap me-1"></i>Education</div>
                        <div class="info-value"><%= education %></div>
                    </div>
                    <div class="info-item">
                        <div class="info-label"><i class="fas fa-phone me-1"></i>Phone</div>
                        <div class="info-value"><%= phoneno %></div>
                    </div>
                    <div class="info-item">
                        <div class="info-label"><i class="fas fa-venus-mars me-1"></i>Gender</div>
                        <div class="info-value"><%= gender %></div>
                    </div>
                    <div class="info-item">
                        <div class="info-label"><i class="fas fa-building me-1"></i>Previous Company</div>
                        <div class="info-value"><%= excomapny %></div>
                    </div>
                    <div class="info-item">
                        <div class="info-label"><i class="fas fa-clock me-1"></i>Experience Duration</div>
                        <div class="info-value"><%= duration %></div>
                    </div>
                    <div class="info-item">
                        <div class="info-label"><i class="fas fa-tools me-1"></i>Skills</div>
                        <div class="info-value"><%= skills %></div>
                    </div>
                    <div class="info-item">
                        <div class="info-label"><i class="fas fa-money-bill-wave me-1"></i>Expected Salary</div>
                        <div class="info-value">₹<%= exsalary %></div>
                    </div>
                </div>
                
                <!-- Links Section -->
                <div class="info-grid">
                    <div class="info-item">
                        <div class="info-label"><i class="fas fa-file-pdf me-1"></i>Resume</div>
                        <div class="info-value">
                            <% if (!resume.isEmpty() && !resume.equals("Not specified")) { %>
                                <a href="<%= resume %>" target="_blank" class="link-item">
                                    <i class="fas fa-external-link-alt me-1"></i>View Resume
                                </a>
                            <% } else { %>
                                Not provided
                            <% } %>
                        </div>
                    </div>
                    <div class="info-item">
                        <div class="info-label"><i class="fab fa-linkedin me-1"></i>LinkedIn</div>
                        <div class="info-value">
                            <% if (!linkedin.isEmpty() && !linkedin.equals("Not specified")) { %>
                                <a href="<%= linkedin %>" target="_blank" class="link-item">
                                    <i class="fas fa-external-link-alt me-1"></i>View Profile
                                </a>
                            <% } else { %>
                                Not provided
                            <% } %>
                        </div>
                    </div>
                    <div class="info-item">
                        <div class="info-label"><i class="fab fa-github me-1"></i>GitHub</div>
                        <div class="info-value">
                            <% if (!github.isEmpty() && !github.equals("Not specified")) { %>
                                <a href="<%= github %>" target="_blank" class="link-item">
                                    <i class="fas fa-external-link-alt me-1"></i>View Repository
                                </a>
                            <% } else { %>
                                Not provided
                            <% } %>
                        </div>
                    </div>
                    <div class="info-item">
                        <div class="info-label"><i class="fas fa-globe me-1"></i>Portfolio</div>
                        <div class="info-value">
                            <% if (!pwebsite.isEmpty() && !pwebsite.equals("Not specified")) { %>
                                <a href="<%= pwebsite %>" target="_blank" class="link-item">
                                    <i class="fas fa-external-link-alt me-1"></i>View Website
                                </a>
                            <% } else { %>
                                Not provided
                            <% } %>
                        </div>
                    </div>
                </div>
                
                <!-- Responsibilities -->
                <div class="info-item mt-3">
                    <div class="info-label"><i class="fas fa-tasks me-1"></i>Previous Responsibilities</div>
                    <div class="info-value"><%= shortResponsibility %></div>
                </div>
                
                <!-- Action Buttons -->
                <% if ("pending".equals(status)) { %>
                <div class="action-buttons">
                    <button class="btn btn-accept" onclick="handleApplication('accept', <%= id %>, '<%= candidate_email %>', '<%= fullname %>')">
                        <i class="fas fa-check me-2"></i>Accept Application
                    </button>
                    <button class="btn btn-reject" onclick="handleApplication('reject', <%= id %>, '<%= candidate_email %>', '<%= fullname %>')">
                        <i class="fas fa-times me-2"></i>Reject Application
                    </button>
                </div>
                <% } else { %>
                <div class="mt-3">
                    <small class="text-muted">
                        <i class="fas fa-info-circle me-1"></i>
                        This application has been <%= status %> and the candidate has been notified.
                    </small>
                </div>
                <% } %>
            </div>
            
            <% 
                }
            } catch (SQLException e) {
                out.println("<div class='applicant-card'><div class='alert alert-danger'>SQL Error: " + e.getMessage() + "</div></div>");
                e.printStackTrace();
            } finally {
                try {
                    if (rs != null) rs.close();
                    if (pstmt != null) pstmt.close();
                    if (conn != null) conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            
            if (!hasApplicants) {
            %>
            <div class="no-applications">
                <i class="fas fa-inbox"></i>
                <h4>No Applications Found</h4>
                <p>You haven't received any applications yet. Applications will appear here once candidates apply to your job postings.</p>
            </div>
            <% } %>
        </div>
    </div>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
    <script>
        function handleApplication(action, applicationId, candidateEmail, candidateName) {
            const actionText = action === 'accept' ? 'accept' : 'reject';
            const confirmMessage = `Are you sure you want to ${actionText} ${candidateName}'s application?`;
            
            if (confirm(confirmMessage)) {
                // Show loading state
                const buttons = event.target.parentElement.querySelectorAll('button');
                buttons.forEach(btn => {
                    btn.disabled = true;
                    btn.innerHTML = '<i class="fas fa-spinner fa-spin me-2"></i>Processing...';
                });
                
                // Redirect to handle the action
                window.location.href = `Applicants.jsp?action=${action}&applicationId=${applicationId}&candidateEmail=${encodeURIComponent(candidateEmail)}`;
            }
        }
        
        function filterApplications(status) {
            // Update active filter button
            document.querySelectorAll('.filter-btn').forEach(btn => btn.classList.remove('active'));
            event.target.classList.add('active');
            
            // Show/hide applications based on status
            const cards = document.querySelectorAll('.applicant-card');
            cards.forEach(card => {
                const cardStatus = card.getAttribute('data-status');
                if (status === 'all' || cardStatus === status) {
                    card.style.display = 'block';
                } else {
                    card.style.display = 'none';
                }
            });
        }
        
        // Auto-dismiss alerts after 5 seconds
        setTimeout(function() {
            const alerts = document.querySelectorAll('.alert');
            alerts.forEach(alert => {
                const bsAlert = new bootstrap.Alert(alert);
                bsAlert.close();
            });
        }, 5000);
    </script>
</body>
</html>