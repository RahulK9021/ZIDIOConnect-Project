package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import requirepackage.DBConnect;
import requirepackage.UserController;
import requirepackage.ViewProfile;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class ViewProfile_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");

  DBConnect dbc=new DBConnect();
  UserController utc=new UserController();
  if(request.getParameter("btnsub") != null){
    ViewProfile vp=new ViewProfile();
    vp.setFnm(request.getParameter("unm"));
     vp.setFile(request.getParameter("resume"));
      vp.setEmail(request.getParameter("email"));
       vp.setEducation(request.getParameter("education"));
       vp.setPhone(request.getParameter("phone"));
        try {
                String dateStr = request.getParameter("date");
                if (dateStr != null && !dateStr.isEmpty()) {
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    Date utilDate = formatter.parse(dateStr); 
                    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); 
                    vp.setDob(sqlDate);
                } else {
                    System.out.println("Date parameter is missing or empty.");
                }
            } catch (Exception ex) {
                ex.printStackTrace(); 
            }
            vp.setAddress(request.getParameter("address"));
            vp.setType(request.getParameter("gender"));
            vp.setStatus(request.getParameter("status"));
            vp.setLinkedin(request.getParameter("linkedin"));
            vp.setGithub(request.getParameter("github"));
            vp.setPersonalwebsite(request.getParameter("pwebsite"));
            vp.setJobtitle(request.getParameter("jobtitle"));
            vp.setExcompany(request.getParameter("excompany"));
            vp.setDuration(request.getParameter("duration"));
            vp.setSkills(request.getParameter("skills"));
            vp.setResponsibility(request.getParameter("responsibilities"));
            vp.setExsalary(request.getParameter("salary"));
            if(utc.addProfile(vp))
            {
                response.sendRedirect("Internship.jsp");
            }
    }

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/viewProfile.css\">\n");
      out.write("        <style>\n");
      out.write("              a {\n");
      out.write("                color: white;\n");
      out.write("                text-decoration: none;\n");
      out.write("                }\n");
      out.write("                .btn {\n");
      out.write("                display: inline-block;\n");
      out.write("                padding: 10px 20px;\n");
      out.write("                 background: linear-gradient(to right, #f6d365, #fda085);\n");
      out.write("                color: white;\n");
      out.write("                font-size: 16px;\n");
      out.write("                border: none;\n");
      out.write("                border-radius: 8px;\n");
      out.write("                cursor: pointer;\n");
      out.write("                transition: background-color 0.3s ease;\n");
      out.write("                margin-top: 10px;\n");
      out.write("                align-items: center;\n");
      out.write("              }\n");
      out.write("\n");
      out.write("              .btn:hover {\n");
      out.write("                background-color: #45a049;\n");
      out.write("              }\n");
      out.write("\n");
      out.write("              .btn:focus {\n");
      out.write("                outline: none;\n");
      out.write("                box-shadow: 0 0 0 3px rgba(72, 180, 97, 0.4);\n");
      out.write("              }\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("        <script>\n");
      out.write("            function toggleExperience() {\n");
      out.write("              event.preventDefault(); // Prevent form from submitting\n");
      out.write("              var expFields = document.getElementById(\"experienceFields\");\n");
      out.write("              expFields.style.display = (expFields.style.display === \"none\" || expFields.style.display === \"\") ? \"block\" : \"none\";\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         <div class=\"form-wrapper\"> \n");
      out.write("             <img src=\"images/profile1.png\" alt=\"profile image\"> <br><br>\n");
      out.write("              <form method=\"POST\"> \n");
      out.write("                  <div class=\"form-grid\">\n");
      out.write("                     \n");
      out.write("                      <div class=\"form-group\"> \n");
      out.write("                          <label for=\"unm\">Full Name</label> \n");
      out.write("                          <input type=\"text\"  name=\"unm\" placeholder=\"Full Name\" required /> \n");
      out.write("                      </div>\n");
      out.write("                      <div class=\"form-group\">\n");
      out.write("                          \n");
      out.write("                          <label for=\"file\">Upload Resume:</label>\n");
      out.write("                          <input type=\"file\"  name=\"resume\" />\n");
      out.write("                          \n");
      out.write("                      </div> \n");
      out.write("\n");
      out.write("                      <div class=\"form-group\"> \n");
      out.write("                          <label for=\"email\">Email</label>\n");
      out.write("                          <input type=\"email\" name=\"email\" placeholder=\"abc@gmail.com\" required />\n");
      out.write("                      </div> \n");
      out.write("                       <div class=\"form-group\">\n");
      out.write("                          <label for=\"education\">Education</label>\n");
      out.write("                          <input type=\"text\" name=\"education\" placeholder=\"Education\" required/>\n");
      out.write("                      </div> \n");
      out.write("                      <div class=\"form-group\">\n");
      out.write("                          <label for=\"phone\">Phone</label>\n");
      out.write("                          <input type=\"tel\" name=\"phone\" placeholder=\"123-456-7890\" required />\n");
      out.write("                      </div> \n");
      out.write("                      <div class=\"form-group\"> \n");
      out.write("                          <label for=\"dob\">Date of Birth</label>\n");
      out.write("                          <input type=\"date\" name=\"dob\" required/> \n");
      out.write("                      </div> \n");
      out.write("                       <div class=\"form-group\">\n");
      out.write("                          <label for=\"address\">Address</label>\n");
      out.write("                          <input type=\"text\" name=\"address\"  placeholder=\"state, City ,colony\" required/>\n");
      out.write("                      </div>\n");
      out.write("                      <div class=\"form-group\">\n");
      out.write("                          <label for=\"gender\">Gender</label> \n");
      out.write("                          <select name=\"gender\" required>\n");
      out.write("                             <option value=\"male\">Male</option>\n");
      out.write("                             <option value=\"female\">Female</option>\n");
      out.write("                             <option value=\"other\">Other</option> \n");
      out.write("                          </select> \n");
      out.write("                      </div>\n");
      out.write("                       <div class=\"form-group\"> \n");
      out.write("                          <label for=\"website\">Married Status</label>\n");
      out.write("                          <select name=\"status\" required> \n");
      out.write("                              <option>Single</option> \n");
      out.write("                              <option>Married</option>\n");
      out.write("                          </select>\n");
      out.write("                      </div>\n");
      out.write("                      <div class=\"form-group\">\n");
      out.write("                          <label for=\"linkedin\">LinkedIn</label>\n");
      out.write("                          <input type=\"url\" name=\"linkedin\" placeholder=\"https://linkedin.com/in/username\" />\n");
      out.write("                      </div>\n");
      out.write("                      <div class=\"form-group\"> \n");
      out.write("                          <label for=\"github\">GitHub</label> \n");
      out.write("                          <input type=\"url\" name=\"github\" placeholder=\"https://github.com/username\" />\n");
      out.write("                      </div>\n");
      out.write("                      <div class=\"form-group\"> \n");
      out.write("                          <label for=\"website\">Personal Website</label> \n");
      out.write("                          <input type=\"url\" name=\"pwebsite\" placeholder=\"https://yourwebsite.com\" />\n");
      out.write("                      </div>\n");
      out.write("                     \n");
      out.write("                     \n");
      out.write("                  </div><br>\n");
      out.write("                  <button class=\"btn\" onclick=\"toggleExperience()\">+ Add Experience</button><br>\n");
      out.write("                  <div id=\"experienceFields\" class=\"experience-fields\" style=\"display: none;\"><br>\n");
      out.write("                      <div class=\"form-group\"> \n");
      out.write("                          <label for=\"jobTitle\">Job Title</label>\n");
      out.write("                          <input type=\"text\" name=\"jobtitle\" placeholder=\"e.g., Software Engineer\" />\n");
      out.write("                      </div><br>\n");
      out.write("                      <div class=\"form-group\">\n");
      out.write("                          <label for=\"company\">Ex-Company</label>\n");
      out.write("                          <input type=\"text\" name=\"excompany\" placeholder=\"e.g., Google\" />\n");
      out.write("                      </div><br>\n");
      out.write("                      <div class=\"form-group\">\n");
      out.write("                          <label for=\"duration\">Duration</label> \n");
      out.write("                          <input type=\"text\" name=\"duration\" placeholder=\"e.g., 2019 - 2023\" />\n");
      out.write("                      </div><br>\n");
      out.write("                      <div class=\"form-group\"> \n");
      out.write("                          <label for=\"skills\">Key Skills</label>\n");
      out.write("                          <input type=\"text\" name=\"skills\" placeholder=\"e.g., JavaScript, React\" />\n");
      out.write("                      </div> <br>\n");
      out.write("                      <div class=\"form-group\">\n");
      out.write("                          <label for=\"responsibilities\">Responsibilities</label>\n");
      out.write("                          <textarea name=\"responsibilities\" rows=\"3\" placeholder=\"Brief description of your role...\"></textarea> \n");
      out.write("                      </div><br>\n");
      out.write("                      <div class=\"form-group\">\n");
      out.write("                          <label for=\"salary\">Ex-Company Salary</label>\n");
      out.write("                          <input type=\"text\" name=\"salary\" placeholder=\"e.g.,4 - 5 LPA\" /> \n");
      out.write("                      </div> <br>\n");
      out.write("                  </div> \n");
      out.write("                  <div class=\"form-footer\">\n");
      out.write("                      <input type=\"submit\" class=\"submit-btn\" name=\"btnsub\" value=\"Save Profile\"/> \n");
      out.write("                        <button type=\"submit\" class=\"submit-btn\"> <a href=\"Home.jsp\">Back To Home</a></button> \n");
      out.write("                  </div>\n");
      out.write("                  <div class=\"form-footer\">\n");
      out.write("                    \n");
      out.write("                  </div>\n");
      out.write("              </form>\n");
      out.write("         </div>\n");
      out.write("   </body>\n");
      out.write("   \n");
      out.write("</html>\n");
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
