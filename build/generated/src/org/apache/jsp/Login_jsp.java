package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import requirepackage.DBConnect;
import java.sql.*;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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

// Your existing debug and connection code here
System.out.println("=== LOGIN DEBUG INFO ===");
System.out.println("Current JSP file: " + request.getRequestURI());
System.out.println("Context Path: " + request.getContextPath());
System.out.println("========================");

DBConnect dbc = new DBConnect();
String uid = request.getParameter("uid");
String pwd = request.getParameter("pwd");
String errorMessage = null;

// Only process login if form is submitted
if (uid != null && pwd != null && !uid.trim().isEmpty() && !pwd.trim().isEmpty()) {
    System.out.println("Processing login for: " + uid);
    
    try (Connection con = dbc.getConnection();
         PreparedStatement jobstmt = con.prepareStatement("SELECT * FROM jobseeker WHERE email = ? AND password = ?");
         PreparedStatement recruiterStmt = con.prepareStatement("SELECT * FROM recruiter WHERE recruiter_email = ? AND password = ?")) {

        jobstmt.setString(1, uid);
        jobstmt.setString(2, pwd);
        recruiterStmt.setString(1, uid);
        recruiterStmt.setString(2, pwd);

        // Check jobseeker login first
        try (ResultSet rs = jobstmt.executeQuery()) {
            if (rs.next()) {
                System.out.println("Jobseeker found in database");
                session.setAttribute("email", uid);
                session.setAttribute("userType", "jobseeker");
                session.setMaxInactiveInterval(30 * 60);
                System.out.println("Jobseeker login successful: " + uid);
                response.sendRedirect("Internship.jsp");
                return; // Important: stop execution here
            }
        }

        // Check recruiter login
        try (ResultSet rs = recruiterStmt.executeQuery()) {
            if (rs.next()) {
                System.out.println("Recruiter found in database");
                session.setAttribute("recruiterEmail", uid);
                session.setAttribute("userType", "recruiter");
                session.setMaxInactiveInterval(30 * 60);
                System.out.println("Recruiter login successful: " + uid);
                
                // Simple redirect - remove all the complex error handling for now
                response.sendRedirect("RecruiterDashboard.jsp");
                return; // Important: stop execution here
            }
        }
        
        // If we reach here, login failed
        System.out.println("Login failed - no matching user found");
        errorMessage = "Invalid email or password! Please try again.";

    } catch (SQLException e) {
        System.err.println("Database error during login: " + e.getMessage());
        e.printStackTrace();
        errorMessage = "System error occurred! Please try again later.";
    } catch (Exception ex) {
        System.err.println("General error during login: " + ex.getMessage());
        ex.printStackTrace();
        errorMessage = "An unexpected error occurred! Please try again.";
    }
}

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <title>Login Page</title>\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: center;\n");
      out.write("            align-items: center;\n");
      out.write("            min-height: 100vh;\n");
      out.write("            margin: 0;\n");
      out.write("            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;\n");
      out.write("            background-image: linear-gradient(120deg, #84fab0 0%, #8fd3f4 100%);\n");
      out.write("        }\n");
      out.write("        .form-wrapper {\n");
      out.write("            display: flex;\n");
      out.write("            flex-direction: column;\n");
      out.write("            justify-content: center;\n");
      out.write("            align-items: center;\n");
      out.write("            background: #fff;\n");
      out.write("            padding: 2.5rem;\n");
      out.write("            border-radius: 20px;\n");
      out.write("            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.1);\n");
      out.write("            max-width: 1000px;\n");
      out.write("            width: 100%;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("        .form-group {\n");
      out.write("            display: flex;\n");
      out.write("            flex-direction: column;\n");
      out.write("            width: 100%;\n");
      out.write("            max-width: 400px;\n");
      out.write("            margin-bottom: 1rem;\n");
      out.write("        }\n");
      out.write("        .form-group label {\n");
      out.write("            font-weight: 600;\n");
      out.write("            margin-bottom: 0.5rem;\n");
      out.write("            color: #555;\n");
      out.write("        }\n");
      out.write("        .form-group input {\n");
      out.write("            width: 100%;\n");
      out.write("            padding: 0.8rem;\n");
      out.write("            border: 1px solid #ccc;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            font-size: 1rem;\n");
      out.write("            background-color: #f9f9f9;\n");
      out.write("            transition: border-color 0.3s;\n");
      out.write("        }\n");
      out.write("        .submit-btn {\n");
      out.write("            background: linear-gradient(to right, #f6d365, #fda085);\n");
      out.write("            padding: 0.9rem 2rem;\n");
      out.write("            border: none;\n");
      out.write("            border-radius: 12px;\n");
      out.write("            font-size: 1rem;\n");
      out.write("            font-weight: 600;\n");
      out.write("            color: white;\n");
      out.write("            cursor: pointer;\n");
      out.write("            transition: background 0.3s ease;\n");
      out.write("        }\n");
      out.write("        .error-message {\n");
      out.write("            background-color: #ffebee;\n");
      out.write("            color: #c62828;\n");
      out.write("            padding: 1rem;\n");
      out.write("            border-radius: 8px;\n");
      out.write("            margin-bottom: 1rem;\n");
      out.write("            border-left: 4px solid #f44336;\n");
      out.write("        }\n");
      out.write("        .success-message {\n");
      out.write("            background-color: #e8f5e8;\n");
      out.write("            color: #2e7d32;\n");
      out.write("            padding: 1rem;\n");
      out.write("            border-radius: 8px;\n");
      out.write("            margin-bottom: 1rem;\n");
      out.write("            border-left: 4px solid #4caf50;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"form-wrapper\">\n");
      out.write("        <h1>Login</h1>\n");
      out.write("        \n");
      out.write("        <!-- Show error message if login failed -->\n");
      out.write("        ");
 if (errorMessage != null) { 
      out.write("\n");
      out.write("            <div class=\"error-message\">\n");
      out.write("                ");
      out.print( errorMessage );
      out.write("\n");
      out.write("            </div>\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("        \n");
      out.write("        <!-- Debug: Show if user is logged in but redirect failed -->\n");
      out.write("        ");
 
        String loggedInEmail = (String) session.getAttribute("email");
        if (loggedInEmail != null) { 
        
      out.write("\n");
      out.write("            <div class=\"success-message\">\n");
      out.write("                Login successful for: ");
      out.print( loggedInEmail );
      out.write("<br>\n");
      out.write("                User Type: ");
      out.print( session.getAttribute("userType") );
      out.write("<br>\n");
      out.write("                <a href=\"RecruiterDashboard.jsp\">Click here to go to Dashboard</a>\n");
      out.write("            </div>\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("        \n");
      out.write("        <form method=\"POST\">\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <label for=\"uid\">G-mail For Login</label>\n");
      out.write("                <input type=\"email\" name=\"uid\" placeholder=\"User G-mail\" value=\"");
      out.print( (uid != null) ? uid : "" );
      out.write("\" required />\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <label for=\"pwd\">Password</label>\n");
      out.write("                <input type=\"password\" name=\"pwd\" placeholder=\"Password\" required />\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div style=\"text-align: center; margin-top: 2rem;\">\n");
      out.write("                <input type=\"submit\" class=\"submit-btn\" name=\"btnsub\" value=\"Login\">\n");
      out.write("                <div style=\"margin-top: 1rem;\">\n");
      out.write("                    <p>Don't have an account? <a href=\"Register.jsp\">Register here</a></p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("      \n");
      out.write("       \n");
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
