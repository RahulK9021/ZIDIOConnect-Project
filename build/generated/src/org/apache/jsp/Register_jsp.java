package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import requirepackage.DBConnect;
import requirepackage.Registration;
import requirepackage.UserController;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class Register_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");

            DBConnect dbc=new DBConnect();
            UserController utc=new UserController();
            if(request.getParameter("btnsub") != null){
                Registration reg=new Registration();
                reg.setEmail(request.getParameter("uid"));
                reg.setPassword(request.getParameter("pwd"));
                reg.setFullnm(request.getParameter("unm"));
                String phoneStr = request.getParameter("phone");
                if (phoneStr != null && !phoneStr.isEmpty()) {
                    try {
                        reg.setPhoneno(Integer.parseInt(phoneStr));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid phone number format: " + phoneStr);
                    }
                } else {
                    System.out.println("Phone number is missing or empty.");
                }

               try {
                String dateStr = request.getParameter("date");
                if (dateStr != null && !dateStr.isEmpty()) {
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    Date utilDate = formatter.parse(dateStr); 
                    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); 
                    reg.setDate(sqlDate);
                } else {
                    System.out.println("Date parameter is missing or empty.");
                }
            } catch (Exception ex) {
                ex.printStackTrace(); // Log the error to help debug
            }
                reg.setGender(request.getParameter("gender"));
                reg.setAddress(request.getParameter("city"));
                reg.setStatus(request.getParameter("status"));
                reg.setType(request.getParameter("type"));
                if(utc.addRegistration(reg)){
                response.sendRedirect("Login.jsp");
            }
            }
            
        
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Register</title>\n");
      out.write("        <style>\n");
      out.write("           body {\n");
      out.write("      margin: 0;\n");
      out.write("     \n");
      out.write("      display: flex;\n");
      out.write("      justify-content: center;\n");
      out.write("      align-items: center;\n");
      out.write("      min-height: 100vh;\n");
      out.write("         margin: 0;\n");
      out.write("      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;\n");
      out.write("       background-image: linear-gradient(120deg, #84fab0 0%, #8fd3f4 100%);\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .form-wrapper {\n");
      out.write("      background: #fff;\n");
      out.write("      padding: 2.5rem;\n");
      out.write("      border-radius: 20px;\n");
      out.write("      box-shadow: 0 10px 25px rgba(0, 0, 0, 0.1);\n");
      out.write("      max-width: 1000px;\n");
      out.write("      width: 100%;\n");
      out.write("      margin: 2rem;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .form-wrapper h1 {\n");
      out.write("      text-align: center;\n");
      out.write("      margin-bottom: 2rem;\n");
      out.write("      color: #333;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .form-grid {\n");
      out.write("      display: grid;\n");
      out.write("      grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));\n");
      out.write("      gap: 1.5rem;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .form-group {\n");
      out.write("      display: flex;\n");
      out.write("      flex-direction: column;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .form-group label {\n");
      out.write("      font-weight: 600;\n");
      out.write("      margin-bottom: 0.5rem;\n");
      out.write("      color: #555;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .form-group input,\n");
      out.write("    .form-group select,\n");
      out.write("    .form-group textarea {\n");
      out.write("      padding: 0.8rem;\n");
      out.write("      border: 1px solid #ccc;\n");
      out.write("      border-radius: 10px;\n");
      out.write("      font-size: 1rem;\n");
      out.write("      background-color: #f9f9f9;\n");
      out.write("      transition: border-color 0.3s;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .form-group input:focus,\n");
      out.write("    .form-group select:focus,\n");
      out.write("    .form-group textarea:focus {\n");
      out.write("      border-color: #fda085;\n");
      out.write("      background-color: #fff;\n");
      out.write("      outline: none;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .form-footer {\n");
      out.write("      text-align: center;\n");
      out.write("      margin-top: 2rem;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .submit-btn {\n");
      out.write("      background: linear-gradient(to right, #f6d365, #fda085);\n");
      out.write("      padding: 0.9rem 2rem;\n");
      out.write("      border: none;\n");
      out.write("      border-radius: 12px;\n");
      out.write("      font-size: 1rem;\n");
      out.write("      font-weight: 600;\n");
      out.write("      color: white;\n");
      out.write("      cursor: pointer;\n");
      out.write("      transition: background 0.3s ease;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .submit-btn:hover {\n");
      out.write("      background: linear-gradient(to right, #fda085, #f6d365);\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    @media (max-width: 600px) {\n");
      out.write("      .form-wrapper {\n");
      out.write("        padding: 1.5rem;\n");
      out.write("      }\n");
      out.write("    }  \n");
      out.write("        </style>\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("      <div class=\"form-wrapper\">\n");
      out.write("    <h1>Registration</h1>\n");
      out.write("    <form method=\"POST\">\n");
      out.write("      <div class=\"form-grid\">\n");
      out.write("        \n");
      out.write("        <div class=\"form-group\">\n");
      out.write("          <label for=\"uid\">E-Mail</label>\n");
      out.write("          <input type=\"email\" name=\"uid\" placeholder=\"E-Mail\" required />\n");
      out.write("        </div>\n");
      out.write("          \n");
      out.write("         <div class=\"form-group\">\n");
      out.write("          <label for=\"unm\">Password</label>\n");
      out.write("          <input type=\"password\" name=\"pwd\" placeholder=\"Password\" required />\n");
      out.write("        </div>\n");
      out.write("          \n");
      out.write("        <div class=\"form-group\">\n");
      out.write("          <label for=\"unm\">Full Name</label>\n");
      out.write("          <input type=\"text\"  name=\"unm\" placeholder=\"Full Name\" required />\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("          <label for=\"phone\">Phone</label>\n");
      out.write("          <input type=\"tel\" name=\"phone\" placeholder=\"123-456-7890\" />\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("          <label for=\"dob\">Date of Birth</label>\n");
      out.write("          <input type=\"date\" name=\"dob\" />\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("          <label for=\"gender\">Gender</label>\n");
      out.write("          <select name=\"gender\">\n");
      out.write("            <option value=\"male\">Male</option>\n");
      out.write("            <option value=\"female\">Female</option>\n");
      out.write("            <option value=\"other\">Other</option>\n");
      out.write("          </select>\n");
      out.write("        </div>       \n");
      out.write("          \n");
      out.write("        <div class=\"form-group\">\n");
      out.write("          <label for=\"City\">City</label>\n");
      out.write("           <input type=\"text\" name=\"city\" placeholder=\"City\" required />\n");
      out.write("        </div>\n");
      out.write("          \n");
      out.write("           <div class=\"form-group\">\n");
      out.write("          <label for=\"website\">Married Status</label>\n");
      out.write("          <select name=\"status\">\n");
      out.write("              <option>Single</option>\n");
      out.write("              <option>Married</option>\n");
      out.write("          </select>\n");
      out.write("        </div>\n");
      out.write("          \n");
      out.write("          <div class=\"form-group\">\n");
      out.write("          <label for=\"type\">Register as</label>\n");
      out.write("          <select name=\"type\">\n");
      out.write("              <option>Jobseeker</option>\n");
      out.write("              <option>Recruiter</option>\n");
      out.write("          </select>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("        \n");
      out.write("      <div class=\"form-footer\">\n");
      out.write("          <input type=\"submit\" class=\"submit-btn\" name=\"btnsub\" value=\"Save Profile\">\n");
      out.write("        <div class=\"register\">\n");
      out.write("        <p>Already have an account? <a href=\"Login.jsp\">Login here</a></p>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </form>\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("    </body>\n");
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
