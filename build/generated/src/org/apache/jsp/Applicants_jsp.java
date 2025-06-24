package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import requirepackage.DBConnect;
import java.sql.*;
import requirepackage.UserController;
import requirepackage.Applicant;

public final class Applicants_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Applicant List</title>\n");
      out.write("        <style>\n");
      out.write("            .applicants-table-container {\n");
      out.write("                margin: 20px;\n");
      out.write("                padding: 20px;\n");
      out.write("                background-color: #f9f9f9;\n");
      out.write("                border-radius: 8px;\n");
      out.write("            }\n");
      out.write("            .table-responsive {\n");
      out.write("                overflow-x: auto;\n");
      out.write("            }\n");
      out.write("            .table-applicants {\n");
      out.write("                width: 100%;\n");
      out.write("                border-collapse: collapse;\n");
      out.write("                margin-top: 20px;\n");
      out.write("            }\n");
      out.write("            .table-applicants th, .table-applicants td {\n");
      out.write("                border: 1px solid #ddd;\n");
      out.write("                padding: 8px;\n");
      out.write("                text-align: left;\n");
      out.write("            }\n");
      out.write("            .table-applicants th {\n");
      out.write("                background-color: #4CAF50;\n");
      out.write("                color: white;\n");
      out.write("            }\n");
      out.write("            .table-applicants tr:nth-child(even) {\n");
      out.write("                background-color: #f2f2f2;\n");
      out.write("            }\n");
      out.write("            .table-applicants a {\n");
      out.write("                color: #007bff;\n");
      out.write("                text-decoration: none;\n");
      out.write("            }\n");
      out.write("            .table-applicants a:hover {\n");
      out.write("                text-decoration: underline;\n");
      out.write("            }\n");
      out.write("            .no-applicants {\n");
      out.write("                text-align: center;\n");
      out.write("                color: #666;\n");
      out.write("                font-style: italic;\n");
      out.write("                padding: 20px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"applicants-table-container\">\n");
      out.write("            <h3>Applicant List</h3>\n");
      out.write("            <div class=\"table-responsive\">\n");
      out.write("                <table class=\"table-applicants\">\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>Candidate Email</th>\n");
      out.write("                            <th>Full Name</th>\n");
      out.write("                            <th>Resume</th>\n");
      out.write("                            <th>Education</th>\n");
      out.write("                            <th>Phone</th>\n");
      out.write("                            <th>Gender</th>\n");
      out.write("                            <th>LinkedIn</th>\n");
      out.write("                            <th>GitHub</th>\n");
      out.write("                            <th>Portfolio</th>\n");
      out.write("                            <th>Job Title</th>\n");
      out.write("                            <th>Company</th>\n");
      out.write("                            <th>Duration</th>\n");
      out.write("                            <th>Skills</th>\n");
      out.write("                            <th>Responsibility</th>\n");
      out.write("                            <th>Expected Salary</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                        ");

                        String recruiterEmail = (String) session.getAttribute("recruiterEmail");
                        PreparedStatement pstmt = null;
                        ResultSet rs = null;
                        Connection conn = null;
                        boolean hasApplicants = false;
                        
                        // Check if recruiter is logged in
                        if (recruiterEmail == null || recruiterEmail.trim().isEmpty()) {
                        
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td colspan=\"15\" class=\"no-applicants\" style=\"color: red;\">\n");
      out.write("                                    <strong>Error: You are not logged in. Please <a href=\"login.jsp\">login</a> to view applicants.</strong>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                        ");

                            return;
                        }
                        
                        try {
                            DBConnect dbc = new DBConnect();
                            conn = dbc.getConnection();
                            String postsSql = "SELECT candidate_email, fullname, resume, education, phoneno, gender, linkedin, github, pwebsite, jobtitile, excomapny, duration, skills, responsibility, exsalary FROM recruiter_inbox WHERE recruiter_email = ?";
                            pstmt = conn.prepareStatement(postsSql);
                            pstmt.setString(1, recruiterEmail);
                            rs = pstmt.executeQuery();
                            
                            while (rs.next()) {
                                hasApplicants = true;
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
                                
                                // Truncate responsibility if too long
                                if (responsibility.length() > 100) {
                                    responsibility = responsibility.substring(0, 100) + "...";
                                }
                        
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td>");
      out.print( candidate_email );
      out.write("</td>\n");
      out.write("                            <td>");
      out.print( fullname );
      out.write("</td>\n");
      out.write("                            <td>\n");
      out.write("                                ");
 if (!resume.isEmpty() && !resume.equals("Not specified")) { 
      out.write("\n");
      out.write("                                    <a href=\"");
      out.print( resume );
      out.write("\" target=\"_blank\">View Resume</a>\n");
      out.write("                                ");
 } else { 
      out.write("\n");
      out.write("                                    Not provided\n");
      out.write("                                ");
 } 
      out.write("\n");
      out.write("                            </td>\n");
      out.write("                            <td>");
      out.print( education );
      out.write("</td>\n");
      out.write("                            <td>");
      out.print( phoneno );
      out.write("</td>\n");
      out.write("                            <td>");
      out.print( gender );
      out.write("</td>\n");
      out.write("                            <td>\n");
      out.write("                                ");
 if (!linkedin.isEmpty() && !linkedin.equals("Not specified")) { 
      out.write("\n");
      out.write("                                    <a href=\"");
      out.print( linkedin );
      out.write("\" target=\"_blank\">Profile</a>\n");
      out.write("                                ");
 } else { 
      out.write("\n");
      out.write("                                    Not provided\n");
      out.write("                                ");
 } 
      out.write("\n");
      out.write("                            </td>\n");
      out.write("                            <td>\n");
      out.write("                                ");
 if (!github.isEmpty() && !github.equals("Not specified")) { 
      out.write("\n");
      out.write("                                    <a href=\"");
      out.print( github );
      out.write("\" target=\"_blank\">Repository</a>\n");
      out.write("                                ");
 } else { 
      out.write("\n");
      out.write("                                    Not provided\n");
      out.write("                                ");
 } 
      out.write("\n");
      out.write("                            </td>\n");
      out.write("                            <td>\n");
      out.write("                                ");
 if (!pwebsite.isEmpty() && !pwebsite.equals("Not specified")) { 
      out.write("\n");
      out.write("                                    <a href=\"");
      out.print( pwebsite );
      out.write("\" target=\"_blank\">Website</a>\n");
      out.write("                                ");
 } else { 
      out.write("\n");
      out.write("                                    Not provided\n");
      out.write("                                ");
 } 
      out.write("\n");
      out.write("                            </td>\n");
      out.write("                            <td>");
      out.print( jobtitile );
      out.write("</td>\n");
      out.write("                            <td>");
      out.print( excomapny );
      out.write("</td>\n");
      out.write("                            <td>");
      out.print( duration );
      out.write("</td>\n");
      out.write("                            <td>");
      out.print( skills );
      out.write("</td>\n");
      out.write("                            <td>");
      out.print( responsibility );
      out.write("</td>\n");
      out.write("                            <td>");
      out.print( exsalary );
      out.write("</td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");
 
                            }
                        } catch (SQLException e) {
                            out.println("SQL Error: " + e.getMessage());
                            e.printStackTrace();
                        } finally {
                            // Properly close resources
                            try {
                                if (rs != null) rs.close();
                                if (pstmt != null) pstmt.close();
                                if (conn != null) conn.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                        
                        // Show message if no applicants found
                        if (!hasApplicants) {
                        
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td colspan=\"15\" class=\"no-applicants\">No applicants found for this recruiter.</td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");
 } 
      out.write("\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
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
