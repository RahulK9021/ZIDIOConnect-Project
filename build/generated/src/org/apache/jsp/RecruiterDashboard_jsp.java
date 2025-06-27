package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import requirepackage.DBConnect;

public final class RecruiterDashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

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

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Recruiter Dashboard</title>\n");
      out.write("    <link href=\"https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css\" rel=\"stylesheet\">\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            background-image: linear-gradient(120deg, #84fab0 0%, #8fd3f4 100%);\n");
      out.write("            min-height: 100vh;\n");
      out.write("            font-family: Arial, sans-serif;\n");
      out.write("        }\n");
      out.write("        .dashboard-card {\n");
      out.write("            background: white;\n");
      out.write("            border-radius: 15px;\n");
      out.write("            box-shadow: 0 5px 15px rgba(0,0,0,0.1);\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("        }\n");
      out.write("        .stats-box {\n");
      out.write("/*            background: linear-gradient(135deg, #4facfe 0%, #00f2fe 100%);*/\n");
      out.write("            background: white;\n");
      out.write("            color: black;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            padding: 20px;\n");
      out.write("            text-align: center;\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("        }\n");
      out.write("        .post-card {\n");
      out.write("            border: none;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            box-shadow: 0 3px 10px rgba(0,0,0,0.1);\n");
      out.write("            margin-bottom: 15px;\n");
      out.write("        }\n");
      out.write("        .btn-custom {\n");
      out.write("            border-radius: 20px;\n");
      out.write("            padding: 8px 20px;\n");
      out.write("            font-weight: 600;\n");
      out.write("        }\n");
      out.write("        .job-badge {\n");
      out.write("            background: #007bff;\n");
      out.write("            color: white;\n");
      out.write("            padding: 3px 8px;\n");
      out.write("            border-radius: 15px;\n");
      out.write("            font-size: 0.8em;\n");
      out.write("        }\n");
      out.write("        .internship-badge {\n");
      out.write("            background: #28a745;\n");
      out.write("            color: white;\n");
      out.write("            padding: 3px 8px;\n");
      out.write("            border-radius: 15px;\n");
      out.write("            font-size: 0.8em;\n");
      out.write("        }\n");
      out.write(" .modern-job-card {\n");
      out.write("  display: flex;\n");
      out.write("  justify-content: space-between;\n");
      out.write("  background: #ffffff;\n");
      out.write("  border-radius: 16px;\n");
      out.write("  box-shadow: 0 8px 24px rgba(0, 0, 0, 0.08);\n");
      out.write("  padding: 20px;\n");
      out.write("  margin-bottom: 25px;\n");
      out.write("  transition: transform 0.2s ease;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".modern-job-card:hover {\n");
      out.write("  transform: translateY(-4px);\n");
      out.write("}\n");
      out.write("\n");
      out.write(".modern-card-content {\n");
      out.write("  flex: 1;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".card-header-row {\n");
      out.write("  display: flex;\n");
      out.write("  justify-content: space-between;\n");
      out.write("  align-items: center;\n");
      out.write("  margin-bottom: 10px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".card-header-row h4 {\n");
      out.write("  margin: 0;\n");
      out.write("  font-weight: 600;\n");
      out.write("  font-size: 1.25rem;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".badge-job {\n");
      out.write("  background: #0d6efd;\n");
      out.write("  color: white;\n");
      out.write("  padding: 4px 12px;\n");
      out.write("  border-radius: 50px;\n");
      out.write("  font-size: 0.75rem;\n");
      out.write("  font-weight: bold;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".badge-internship {\n");
      out.write("  background: #20c997;\n");
      out.write("  color: white;\n");
      out.write("  padding: 4px 12px;\n");
      out.write("  border-radius: 50px;\n");
      out.write("  font-size: 0.75rem;\n");
      out.write("  font-weight: bold;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".job-details {\n");
      out.write("  list-style: none;\n");
      out.write("  padding: 0;\n");
      out.write("  margin: 10px 0;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".job-details li {\n");
      out.write("  margin-bottom: 6px;\n");
      out.write("  color: #444;\n");
      out.write("  font-size: 0.95rem;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".job-details i {\n");
      out.write("  margin-right: 6px;\n");
      out.write("  color: #6c757d;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".description {\n");
      out.write("  color: #666;\n");
      out.write("  font-size: 0.9rem;\n");
      out.write("  margin-top: 10px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".card-actions {\n");
      out.write("  display: flex;\n");
      out.write("  flex-direction: column;\n");
      out.write("  gap: 10px;\n");
      out.write("  margin-left: 20px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".btn {\n");
      out.write("  padding: 8px 14px;\n");
      out.write("  font-size: 0.9rem;\n");
      out.write("  border: none;\n");
      out.write("  border-radius: 30px;\n");
      out.write("  cursor: pointer;\n");
      out.write("  transition: all 0.3s ease;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".btn.edit {\n");
      out.write("  background-color: #0d6efd;\n");
      out.write("  color: white;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".btn.edit:hover {\n");
      out.write("  background-color: #0b5ed7;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".btn.delete {\n");
      out.write("  background-color: #dc3545;\n");
      out.write("  color: white;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".btn.delete:hover {\n");
      out.write("  background-color: #bb2d3b;\n");
      out.write("}\n");
      out.write("\n");
      out.write("a{\n");
      out.write("    text-decoration: none;\n");
      out.write("    color: black;\n");
      out.write("}\n");
      out.write("        \n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"container mt-4\">\n");
      out.write("        <!-- Header -->\n");
      out.write("        <div class=\"dashboard-card\">\n");
      out.write("            <div class=\"card-body p-4\">\n");
      out.write("                <div class=\"row align-items-center\">\n");
      out.write("                    <div class=\"col-md-8\">\n");
      out.write("                        <h2><i class=\"fas fa-tachometer-alt text-primary me-2\"></i>Recruiter Dashboard</h2>\n");
      out.write("                        <p class=\"text-muted\">Welcome, ");
      out.print( recruiterEmail );
      out.write("</p>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md-4 text-end\">\n");
      out.write("                        <a href=\"Registration.jsp\" class=\"btn btn-success btn-custom me-2\">\n");
      out.write("                            <i class=\"fas fa-plus me-1\"></i>Add New Post\n");
      out.write("                        </a>\n");
      out.write("                        <a href=\"Login.jsp\" class=\"btn btn-outline-danger btn-custom\">\n");
      out.write("                            <i class=\"fas fa-sign-out-alt me-1\"></i>Logout\n");
      out.write("                        </a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- Statistics -->\n");
      out.write("        ");

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
        
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-md-3\">\n");
      out.write("                <div class=\"stats-box\">\n");
      out.write("                    <i class=\"fas fa-briefcase fa-2x mb-2\"></i>\n");
      out.write("                    <h4>");
      out.print( totalPosts );
      out.write("</h4>\n");
      out.write("                    <p class=\"mb-0\">Total Posts</p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-3\">\n");
      out.write("                <div class=\"stats-box\">\n");
      out.write("                    <i class=\"fas fa-user-tie fa-2x mb-2\"></i>\n");
      out.write("                    <h4>");
      out.print( totalJobs );
      out.write("</h4>\n");
      out.write("                    <p><a href=\"Applicants.jsp\"> Applicants</a></p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-3\">\n");
      out.write("                <div class=\"stats-box\">\n");
      out.write("                    <i class=\"fas fa-graduation-cap fa-2x mb-2\"></i>\n");
      out.write("                    <h4>");
      out.print( totalInternships );
      out.write("</h4>\n");
      out.write("                    <p class=\"mb-0\">Internships</p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-3\">\n");
      out.write("                <div class=\"stats-box\">\n");
      out.write("                    <i class=\"fas fa-building fa-2x mb-2\"></i>\n");
      out.write("                    <h4>1</h4>\n");
      out.write("                   <p><a href=\"");
      out.print( comwebsite );
      out.write("\"> Company</a></p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- Posts List -->\n");
      out.write("        <div class=\"dashboard-card\">\n");
      out.write("            <div class=\"card-body\">\n");
      out.write("                <h4 class=\"mb-4\">Your Posts</h4>\n");
      out.write("                \n");
      out.write("                ");

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
                
      out.write("\n");
      out.write("                \n");
      out.write("             <div class=\"modern-job-card\">\n");
      out.write("  <div class=\"modern-card-content\">\n");
      out.write(" \n");
      out.write("\n");
      out.write("    <!-- Existing HTML omitted for brevity -->\n");
 
    // inside the loop:
    if ("internship".equalsIgnoreCase(postType)) {

      out.write("\n");
      out.write("\n");
      out.write("<div class=\"modern-job-card\">\n");
      out.write("  <div class=\"modern-card-content\">\n");
      out.write("    <div class=\"card-header-row\">\n");
      out.write("      <h4>");
      out.print( jobRole );
      out.write("</h4>\n");
      out.write("      <span class=\"badge badge-internship\">");
      out.print( postType.toUpperCase() );
      out.write("</span>\n");
      out.write("    </div>\n");
      out.write("    <ul class=\"job-details\">\n");
      out.write("      <li><i class=\"fas fa-building\"></i><strong> Company:</strong> ");
      out.print( company );
      out.write("</li>\n");
      out.write("      <li><i class=\"fas fa-briefcase\"></i><strong> Job Role:</strong> ");
      out.print( jobRole );
      out.write("</li>\n");
      out.write("      <li><i class=\"fas fa-tools\"></i><strong> Skills:</strong> ");
      out.print( skills );
      out.write("</li>\n");
      out.write("      <li><i class=\"fas fa-map-marker-alt\"></i><strong> Location:</strong> ");
      out.print( location );
      out.write("</li>\n");
      out.write("      <li><i class=\"fas fa-hourglass-half\"></i><strong> Deadline:</strong> ");
      out.print( deadline != null ? new java.text.SimpleDateFormat("dd-MM-yyyy").format(deadline) : "No deadline" );
      out.write("</li>\n");
      out.write("      <li><i class=\"fas fa-money-bill-wave\"></i><strong> Stipend:</strong> ₹");
      out.print( salary );
      out.write("</li>\n");
      out.write("      <li><i class=\"fas fa-clock\"></i><strong> Duration:</strong> ");
      out.print( experience );
      out.write("</li>\n");
      out.write("      <li><i class=\"fas fa-book-reader\"></i><strong> What Will You Learn:</strong> ");
      out.print( description );
      out.write("</li>\n");
      out.write("    </ul>\n");
      out.write("  </div>\n");
      out.write("  <div class=\"card-actions\">\n");
      out.write("    <button class=\"btn edit\" onclick=\"editPost(");
      out.print( id );
      out.write(")\"><i class=\"fas fa-edit\"></i> Edit</button>\n");
      out.write("    <button class=\"btn delete\" onclick=\"deletePost(");
      out.print( id );
      out.write(", '");
      out.print( jobRole );
      out.write("')\"><i class=\"fas fa-trash\"></i> Delete</button>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\n");
 
    } else { 

      out.write("\n");
      out.write("\n");
      out.write("<div class=\"modern-job-card\">\n");
      out.write("  <div class=\"modern-card-content\">\n");
      out.write("    <div class=\"card-header-row\">\n");
      out.write("      <h4>");
      out.print( jobRole );
      out.write("</h4>\n");
      out.write("      <span class=\"badge badge-job\">");
      out.print( postType.toUpperCase() );
      out.write("</span>\n");
      out.write("    </div>\n");
      out.write("    <ul class=\"job-details\">\n");
      out.write("      <li><i class=\"fas fa-building\"></i><strong> Company:</strong> ");
      out.print( company );
      out.write("</li>\n");
      out.write("      <li><i class=\"fas fa-briefcase\"></i><strong> Job Role:</strong> ");
      out.print( jobRole );
      out.write("</li>\n");
      out.write("      <li><i class=\"fas fa-tools\"></i><strong> Skills:</strong> ");
      out.print( skills );
      out.write("</li>\n");
      out.write("      <li><i class=\"fas fa-map-marker-alt\"></i><strong> Location:</strong> ");
      out.print( location );
      out.write("</li>\n");
      out.write("      <li><i class=\"fas fa-hourglass-half\"></i><strong> Deadline:</strong> ");
      out.print( deadline != null ? new java.text.SimpleDateFormat("dd-MM-yyyy").format(deadline) : "No deadline" );
      out.write("</li>\n");
      out.write("      <li><i class=\"fas fa-money-bill-wave\"></i><strong> Salary:</strong> ₹");
      out.print( salary );
      out.write("</li>\n");
      out.write("      <li><i class=\"fas fa-briefcase\"></i><strong> Experience:</strong> ");
      out.print( experience );
      out.write("</li>\n");
      out.write("      <li><i class=\"fas fa-info-circle\"></i><strong> Description:</strong> ");
      out.print( description );
      out.write("</li>\n");
      out.write("    </ul>\n");
      out.write("  </div>\n");
      out.write("  <div class=\"card-actions\">\n");
      out.write("    <button class=\"btn edit\" onclick=\"editPost(");
      out.print( id );
      out.write(")\"><i class=\"fas fa-edit\"></i> Edit</button>\n");
      out.write("    <button class=\"btn delete\" onclick=\"deletePost(");
      out.print( id );
      out.write(", '");
      out.print( jobRole );
      out.write("')\"><i class=\"fas fa-trash\"></i> Delete</button>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\n");

    }

      out.write('\n');

                    }
                    
                    if (!hasPosts) {
                
      out.write("\n");
      out.write("                <div class=\"text-center py-5\">\n");
      out.write("                    <i class=\"fas fa-inbox fa-4x text-muted mb-3\"></i>\n");
      out.write("                    <h4 class=\"text-muted\">No Posts Yet</h4>\n");
      out.write("                    <p class=\"text-muted\">Start by creating your first job or internship post!</p>\n");
      out.write("                    <a href=\"Registration.jsp\" class=\"btn btn-success btn-custom\">\n");
      out.write("                        <i class=\"fas fa-plus me-1\"></i>Create Your First Post\n");
      out.write("                    </a>\n");
      out.write("                </div>\n");
      out.write("                ");

                    }
                    
                } catch (Exception e) {
                    out.println("<div class='alert alert-danger'>Error loading posts: " + e.getMessage() + "</div>");
                } finally {
                    try { if (rs != null) rs.close(); } catch (Exception e) {}
                    try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
                    try { if (conn != null) conn.close(); } catch (Exception e) {}
                }
                
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("    <script>\n");
      out.write("        function deletePost(id, jobTitle) {\n");
      out.write("            if (confirm('Are you sure you want to delete \"' + jobTitle + '\"?')) {\n");
      out.write("                window.location.href = 'RecruiterDashboard.jsp?deleteId=' + id;\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        function editPost(id) {\n");
      out.write("            // You can redirect to an edit page or show a modal\n");
      out.write("            alert('Edit functionality - redirect to EditPost.jsp?id=' + id);\n");
      out.write("             window.location.href = 'EditPost.jsp?id=' + id;\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
