package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.*;
import requirepackage.DBConnect;
import java.sql.*;
import java.util.*;
import requirepackage.DBConnect;

public final class Apply_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"error.jsp", true, 8192, true);
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
      out.write("\n");
      out.write("\n");
      out.write("\n");

    String jobId = request.getParameter("job_id");
    String recruiterEmail = request.getParameter("recruiter_email");
    String postType = request.getParameter("post_type");
    String userEmail = (String) session.getAttribute("email");
    
    boolean isValidRequest = true;
    String errorMessage = "";
    String redirectPage = "";
    
    // Validate required parameters
    if (userEmail == null || userEmail.trim().isEmpty()) {
        isValidRequest = false;
        errorMessage = "Please login to apply!";
        redirectPage = "login.jsp";
    } else if (jobId == null || recruiterEmail == null || postType == null || 
               jobId.trim().isEmpty() || recruiterEmail.trim().isEmpty() || postType.trim().isEmpty()) {
        isValidRequest = false;
        errorMessage = "Missing required information!";
        redirectPage = "javascript:history.back()";
    }
    
    if (!isValidRequest) {

      out.write("\n");
      out.write("        <script>\n");
      out.write("            alert('");
      out.print( errorMessage );
      out.write("');\n");
      out.write("            ");
 if (redirectPage.startsWith("javascript:")) { 
      out.write("\n");
      out.write("                ");
      out.print( redirectPage.substring(11) );
      out.write(";\n");
      out.write("            ");
 } else { 
      out.write("\n");
      out.write("                location.href = '");
      out.print( redirectPage );
      out.write("';\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("        </script>\n");

    } else {
        // Your main application logic goes here
        Connection conn = null;
        PreparedStatement profileStmt = null;
        PreparedStatement checkDuplicateStmt = null;
        PreparedStatement insertStmt = null;
        ResultSet rs = null;
        ResultSet duplicateRs = null;
        
        try {
            DBConnect dbc = new DBConnect();
            conn = dbc.getConnection();
            
            // Check for duplicate application
            checkDuplicateStmt = conn.prepareStatement(
                "SELECT COUNT(*) FROM recruiter_inbox WHERE recruiter_email = ? AND candidate_email = ? AND job_id = ?"
            );
            checkDuplicateStmt.setString(1, recruiterEmail);
            checkDuplicateStmt.setString(2, userEmail);
            checkDuplicateStmt.setString(3, jobId);
            duplicateRs = checkDuplicateStmt.executeQuery();
            
            if (duplicateRs.next() && duplicateRs.getInt(1) > 0) {

      out.write("\n");
      out.write("                <script>\n");
      out.write("                    alert('You have already applied for this position!');\n");
      out.write("                    history.back();\n");
      out.write("                </script>\n");

            } else {
                // Continue with profile retrieval and application submission
                profileStmt = conn.prepareStatement(
                    "SELECT fullname, resume, education, phoneno, address, gender, " +
                    "linkedin, github, pwebsite, jobtitile, excompany, duration, " +
                    "skills, responsibility, exsalary FROM viewprofile WHERE email = ?"
                );
                profileStmt.setString(1, userEmail);
                rs = profileStmt.executeQuery();
                
                if (rs.next()) {
                    // Validate essential fields
                    String fullname = rs.getString("fullname");
                    
                    if (fullname == null || fullname.trim().isEmpty()) {

      out.write("\n");
      out.write("                        <script>\n");
      out.write("                            alert('Please complete your profile before applying!');\n");
      out.write("                            location.href = 'profile.jsp';\n");
      out.write("                        </script>\n");

                    } else {
                        // Insert application
                        insertStmt = conn.prepareStatement(
                            "INSERT INTO recruiter_inbox (recruiter_email, candidate_email, job_id, post_type, " +
                            "fullname, resume, education, phoneno, address, gender, linkedin, github, " +
                            "pwebsite, jobtitile, excompany, duration, skills, responsibility, exsalary, " +
                            "application_date, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), 'PENDING')"
                        );
                        
                        insertStmt.setString(1, recruiterEmail);
                        insertStmt.setString(2, userEmail);
                        insertStmt.setString(3, jobId);
                        insertStmt.setString(4, postType);
                        insertStmt.setString(5, rs.getString("fullname"));
                        insertStmt.setString(6, rs.getString("resume"));
                        insertStmt.setString(7, rs.getString("education"));
                        insertStmt.setString(8, rs.getString("phoneno"));
                        insertStmt.setString(9, rs.getString("address"));
                        insertStmt.setString(10, rs.getString("gender"));
                        insertStmt.setString(11, rs.getString("linkedin"));
                        insertStmt.setString(12, rs.getString("github"));
                        insertStmt.setString(13, rs.getString("pwebsite"));
                        insertStmt.setString(14, rs.getString("jobtitile"));
                        insertStmt.setString(15, rs.getString("excompany"));
                        insertStmt.setString(16, rs.getString("duration"));
                        insertStmt.setString(17, rs.getString("skills"));
                        insertStmt.setString(18, rs.getString("responsibility"));
                        insertStmt.setString(19, rs.getString("exsalary"));
                        
                        int rows = insertStmt.executeUpdate();
                        
                        if (rows > 0) {
                            String successRedirect = "internship".equalsIgnoreCase(postType) ? "Internship.jsp" : "Jobs.jsp";

      out.write("\n");
      out.write("                            <script>\n");
      out.write("                                alert('Application sent successfully! The recruiter will review your profile.');\n");
      out.write("                                location.href = '");
      out.print( successRedirect );
      out.write("';\n");
      out.write("                            </script>\n");

                        } else {

      out.write("\n");
      out.write("                            <script>\n");
      out.write("                                alert('Application failed! Please try again.');\n");
      out.write("                                history.back();\n");
      out.write("                            </script>\n");

                        }
                    }
                } else {

      out.write("\n");
      out.write("                    <script>\n");
      out.write("                        alert('User profile not found! Please create your profile first.');\n");
      out.write("                        location.href = 'createProfile.jsp';\n");
      out.write("                    </script>\n");

                }
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());

      out.write("\n");
      out.write("            <script>\n");
      out.write("                alert('System error occurred! Please try again later.');\n");
      out.write("                history.back();\n");
      out.write("            </script>\n");

        } finally {
            // Clean up resources
            try {
                if (rs != null) rs.close();
                if (duplicateRs != null) duplicateRs.close();
                if (profileStmt != null) profileStmt.close();
                if (checkDuplicateStmt != null) checkDuplicateStmt.close();
                if (insertStmt != null) insertStmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }
        }
    }

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <title>Application Processing</title>\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            font-family: Arial, sans-serif;\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: center;\n");
      out.write("            align-items: center;\n");
      out.write("            height: 100vh;\n");
      out.write("            margin: 0;\n");
      out.write("            background-color: #f5f5f5;\n");
      out.write("        }\n");
      out.write("        .processing {\n");
      out.write("            text-align: center;\n");
      out.write("            padding: 20px;\n");
      out.write("            background: white;\n");
      out.write("            border-radius: 8px;\n");
      out.write("            box-shadow: 0 2px 10px rgba(0,0,0,0.1);\n");
      out.write("        }\n");
      out.write("        .spinner {\n");
      out.write("            border: 4px solid #f3f3f3;\n");
      out.write("            border-top: 4px solid #3498db;\n");
      out.write("            border-radius: 50%;\n");
      out.write("            width: 40px;\n");
      out.write("            height: 40px;\n");
      out.write("            animation: spin 2s linear infinite;\n");
      out.write("            margin: 0 auto 20px;\n");
      out.write("        }\n");
      out.write("        @keyframes spin {\n");
      out.write("            0% { transform: rotate(0deg); }\n");
      out.write("            100% { transform: rotate(360deg); }\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"processing\">\n");
      out.write("        <div class=\"spinner\"></div>\n");
      out.write("        <h2>Processing Your Application...</h2>\n");
      out.write("        <p>Please wait while we submit your application.</p>\n");
      out.write("    </div>\n");
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
