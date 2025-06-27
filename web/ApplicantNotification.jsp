<%-- 
    Document   : CandidateNotifications
    Created on : Jun 24, 2025
    Author     : Enhanced Version
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="requirepackage.DBConnect" %>
<%@ page import="java.sql.*"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%
    // Mark notification as read if requested
    String markReadId = request.getParameter("markRead");
    if (markReadId != null) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            DBConnect dbc = new DBConnect();
            conn = dbc.getConnection();
            
            String candidateEmail = (String) session.getAttribute("candidateEmail");
            String updateSql = "UPDATE notifications SET is_read = TRUE WHERE id = ? AND candidate_email = ?";
            pstmt = conn.prepareStatement(updateSql);
            pstmt.setInt(1, Integer.parseInt(markReadId));
            pstmt.setString(2, candidateEmail);
            pstmt.executeUpdate();
            
        } catch (Exception e) {
            // Handle error silently
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
    <title>My Application Status</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
    <style>
        body {
            background-image: linear-gradient(120deg, #a8edea 0%, #fed6e3 100%);
            min-height: 100vh;
            font-family: Arial, sans-serif;
        }
        
        .main-container {
            margin: 20px auto;
            max-width: 900px;
            padding: 0 15px;
        }
        
        .header-card {
            background: white;
            border-radius: 15px;
            box-shadow: 0 5px 15px rgba(0,0,0,0.1);
            margin-bottom: 20px;
            padding: 25px;
        }
        
        .notification-card {
            background: white;
            border-radius: 15px;
            box-shadow: 0 8px 24px rgba(0,0,0,0.08);
            margin-bottom: 15px;
            padding: 20px;
            transition: transform 0.2s ease;
            border-left: 5px solid transparent;
        }
        
        .notification-card:hover {
            transform: translateY(-2px);
        }
        
        .notification-card.unread {
            border-left-color: #007bff;
            background: linear-gradient(to right, #f8f9ff, white);
        }
        
        .notification-card.read {
            border-left-color: #6c757d;
            opacity: 0.8;
        }
        
        .status-badge {
            padding: 8px 16px;
            border-radius: 20px;
            font-size: 0.85em;
            font-weight: 600;
            text-transform: uppercase;
            letter-spacing: 0.5px;
        }
        
        .status-applied {
            background: #e3f2fd;
            color: #1565c0;
        }
        
        .status-reviewed {
            background: #fff3e0;
            color: #ef6c00;
        }
        
        .status-interviewed {
            background: #f3e5f5;
            color: #7b1fa2;
        }
        
        .status-accepted {
            background: #e8f5e8;
            color: #2e7d32;
        }
        
        .status-rejected {
            background: #ffebee;
            color: #c62828;
        }
        
        .status-shortlisted {
            background: #e1f5fe;
            color: #0277bd;
        }
        
        .notification-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 15px;
        }
        
        .notification-title {
            font-weight: 600;
            color: #333;
            margin: 0;
            font-size: 1.1em;
        }
        
        .notification-date {
            color: #666;
            font-size: 0.9em;
        }
        
        .notification-content {
            color: #555;
            line-height: 1.6;
            margin-bottom: 15px;
        }
        
        .notification-footer {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        
        .mark-read-btn {
            background: none;
            border: 1px solid #007bff;
            color: #007bff;
            padding: 5px 15px;
            border-radius: 15px;
            font-size: 0.85em;
            cursor: pointer;
            transition: all 0.2s ease;
        }
        
        .mark-read-btn:hover {
            background: #007bff;
            color: white;
        }
        
        .no-notifications {
            text-align: center;
            padding: 60px 20px;
            background: white;
            border-radius: 15px;
            box-shadow: 0 5px 15px rgba(0,0,0,0.1);
        }
        
        .no-notifications i {
            font-size: 4em;
            color: #ccc;
            margin-bottom: 20px;
        }
        
        .back-btn {
            background: linear-gradient(45deg, #667eea 0%, #764ba2 100%);
            border: none;
            color: white;
            padding: 12px 25px;
            border-radius: 25px;
            text-decoration: none;
            display: inline-flex;
            align-items: center;
            gap: 8px;
            transition: transform 0.2s ease;
        }
        
        .back-btn:hover {
            transform: scale(1.05);
            color: white;
            text-decoration: none;
        }
        
        .stats-row {
            display: flex;
            gap: 15px;
            margin-bottom: 20px;
        }
        
        .stat-card {
            flex: 1;
            background: white;
            padding: 20px;
            border-radius: 10px;
            text-align: center;
            box-shadow: 0 3px 10px rgba(0,0,0,0.1);
        }
        
        .stat-number {
            font-size: 2em;
            font-weight: bold;
            color: #007bff;
        }
        
        .stat-label {
            color: #666;
            font-size: 0.9em;
            margin-top: 5px;
        }
        
        @media (max-width: 768px) {
            .stats-row {
                flex-direction: column;
            }
            
            .notification-header {
                flex-direction: column;
                align-items: flex-start;
                gap: 10px;
            }
            
            .notification-footer {
                flex-direction: column;
                align-items: flex-start;
                gap: 10px;
            }
        }
    </style>
</head>
<body>
    <div class="main-container">
        <!-- Header -->
        <div class="header-card">
            <div class="d-flex justify-content-between align-items-center">
                <div>
                    <h2 class="mb-1">
                        <i class="fas fa-bell text-primary"></i>
                        My Application Status
                    </h2>
                    <p class="text-muted mb-0">Track your job application progress</p>
                </div>
                <a href="candidateprofile.jsp" class="back-btn">
                    <i class="fas fa-arrow-left"></i>
                    Back to Dashboard
                </a>
            </div>
        </div>

        <%
            String candidateEmail = (String) session.getAttribute("candidateEmail");
            if (candidateEmail == null) {
                response.sendRedirect("candidatelogin.jsp");
                return;
            }
            
            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            
            int totalNotifications = 0;
            int unreadCount = 0;
            int readCount = 0;
            
            try {
                DBConnect dbc = new DBConnect();
                conn = dbc.getConnection();
                
                // Get notification counts
                String countSql = "SELECT COUNT(*) as total, " +
                                "SUM(CASE WHEN is_read = FALSE THEN 1 ELSE 0 END) as unread, " +
                                "SUM(CASE WHEN is_read = TRUE THEN 1 ELSE 0 END) as read " +
                                "FROM notifications WHERE candidate_email = ?";
                pstmt = conn.prepareStatement(countSql);
                pstmt.setString(1, candidateEmail);
                rs = pstmt.executeQuery();
                
                if (rs.next()) {
                    totalNotifications = rs.getInt("total");
                    unreadCount = rs.getInt("unread");
                    readCount = rs.getInt("read");
                }
                
                rs.close();
                pstmt.close();
        %>
        
        <!-- Statistics Row -->
        <div class="stats-row">
            <div class="stat-card">
                <div class="stat-number"><%= totalNotifications %></div>
                <div class="stat-label">Total Notifications</div>
            </div>
            <div class="stat-card">
                <div class="stat-number text-warning"><%= unreadCount %></div>
                <div class="stat-label">Unread</div>
            </div>
            <div class="stat-card">
                <div class="stat-number text-success"><%= readCount %></div>
                <div class="stat-label">Read</div>
            </div>
        </div>
        
        <!-- Notifications -->
        <%
                // Get all notifications for the candidate
                String sql = "SELECT * FROM notifications WHERE candidate_email = ? ORDER BY created_at DESC";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, candidateEmail);
                rs = pstmt.executeQuery();
                
                SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy 'at' hh:mm a");
                boolean hasNotifications = false;
                
                while (rs.next()) {
                    hasNotifications = true;
                    int notificationId = rs.getInt("id");
                    String title = rs.getString("title");
                    String message = rs.getString("message");
                    String status = rs.getString("status");
                    String companyName = rs.getString("company_name");
                    String jobTitle = rs.getString("job_title");
                    boolean isRead = rs.getBoolean("is_read");
                    Timestamp createdAt = rs.getTimestamp("created_at");
        %>
        
        <div class="notification-card <%= isRead ? "read" : "unread" %>">
            <div class="notification-header">
                <h5 class="notification-title">
                    <% if (!isRead) { %>
                        <i class="fas fa-circle text-primary" style="font-size: 0.5em; margin-right: 8px;"></i>
                    <% } %>
                    <%= title %>
                </h5>
                <span class="notification-date">
                    <%= sdf.format(createdAt) %>
                </span>
            </div>
            
            <div class="notification-content">
                <p class="mb-2"><%= message %></p>
                <% if (companyName != null && !companyName.trim().isEmpty()) { %>
                    <p class="mb-1"><strong>Company:</strong> <%= companyName %></p>
                <% } %>
                <% if (jobTitle != null && !jobTitle.trim().isEmpty()) { %>
                    <p class="mb-1"><strong>Position:</strong> <%= jobTitle %></p>
                <% } %>
            </div>
            
            <div class="notification-footer">
                <% if (status != null && !status.trim().isEmpty()) { %>
                    <span class="status-badge status-<%= status.toLowerCase().replace(" ", "-") %>">
                        <%= status %>
                    </span>
                <% } %>
                
                <% if (!isRead) { %>
                    <form method="post" style="display: inline;">
                        <input type="hidden" name="markRead" value="<%= notificationId %>">
                        <button type="submit" class="mark-read-btn">
                            <i class="fas fa-check"></i> Mark as Read
                        </button>
                    </form>
                <% } else { %>
                    <span class="text-muted">
                        <i class="fas fa-check-circle"></i> Read
                    </span>
                <% } %>
            </div>
        </div>
        
        <%
                }
                
                if (!hasNotifications) {
        %>
        
        <div class="no-notifications">
            <i class="fas fa-bell-slash"></i>
            <h4>No Notifications Yet</h4>
            <p class="text-muted">You haven't received any application status updates yet. Check back later!</p>
            <a href="viewjobs.jsp" class="btn btn-primary mt-3">
                <i class="fas fa-search"></i> Browse Jobs
            </a>
        </div>
        
        <%
                }
                
            } catch (Exception e) {
                out.println("<div class='alert alert-danger'>Error loading notifications: " + e.getMessage() + "</div>");
            } finally {
                try { if (rs != null) rs.close(); } catch (Exception e) {}
                try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
                try { if (conn != null) conn.close(); } catch (Exception e) {}
            }
        %>
    </div>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
    <script>
        // Auto-refresh page every 30 seconds to check for new notifications
        setTimeout(function() {
            if (!document.hidden) {
                location.reload();
            }
        }, 30000);
        
        // Show loading state when marking as read
        document.querySelectorAll('.mark-read-btn').forEach(button => {
            button.addEventListener('click', function() {
                this.innerHTML = '<i class="fas fa-spinner fa-spin"></i> Marking...';
                this.disabled = true;
            });
        });
    </script>
</body>
</html>  