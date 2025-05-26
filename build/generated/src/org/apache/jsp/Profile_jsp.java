package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Profile_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>View Profile</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/Profile.css\" >\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT\" crossorigin=\"anonymous\">\n");
      out.write("  \n");
      out.write("     <script>\n");
      out.write("   function toggleExperience() {\n");
      out.write("      const experienceDiv = document.getElementById(\"experienceFields\");\n");
      out.write("      experienceDiv.classList.toggle(\"active\");\n");
      out.write("    }\n");
      out.write("  </script>\n");
      out.write("  <style>\n");
      out.write("       body {\n");
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
      out.write("  </style>\n");
      out.write("  \n");
      out.write("    </head>   \n");
      out.write("<body>\n");
      out.write("   <body>\n");
      out.write("       <div class=\"form-wrapper\">\n");
      out.write("    <h1>Registration</h1>\n");
      out.write("    <form action=\"Internship.jsp\" method=\"POST\">\n");
      out.write("      <div class=\"form-grid\">\n");
      out.write("        \n");
      out.write("        <div class=\"form-group\">\n");
      out.write("          <label for=\"uid\">User ID</label>\n");
      out.write("          <input type=\"text\" id=\"uid\" name=\"uid\" placeholder=\"User ID\" required />\n");
      out.write("        </div>\n");
      out.write("          \n");
      out.write("        <div class=\"form-group\">\n");
      out.write("          <label for=\"unm\">Full Name</label>\n");
      out.write("          <input type=\"text\" id=\"unm\" name=\"unm\" placeholder=\"Full Name\" required />\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("          <label for=\"email\">Email</label>\n");
      out.write("          <input type=\"email\" id=\"email\" placeholder=\"abc@gmail.com\" required />\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("          \n");
      out.write("        <div class=\"form-group\">\n");
      out.write("          <label for=\"phone\">Phone</label>\n");
      out.write("          <input type=\"tel\" id=\"phone\" placeholder=\"123-456-7890\" />\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("          <label for=\"dob\">Date of Birth</label>\n");
      out.write("          <input type=\"date\" id=\"dob\" />\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("          <label for=\"gender\">Gender</label>\n");
      out.write("          <select id=\"gender\">\n");
      out.write("            <option value=\"\">Select</option>\n");
      out.write("            <option value=\"male\">Male</option>\n");
      out.write("            <option value=\"female\">Female</option>\n");
      out.write("            <option value=\"other\">Other</option>\n");
      out.write("          </select>\n");
      out.write("        </div>       \n");
      out.write("          \n");
      out.write("        <div class=\"form-group\">\n");
      out.write("          <label for=\"City\">City</label>\n");
      out.write("           <input type=\"text\" id=\"unm\" name=\"city\" placeholder=\"City\" required />\n");
      out.write("        </div>\n");
      out.write("          \n");
      out.write("           <div class=\"form-group\">\n");
      out.write("          <label for=\"website\">Married Status</label>\n");
      out.write("          <select name=\"status\">\n");
      out.write("              <option>Unmarried</option>\n");
      out.write("              <option>Married</option>\n");
      out.write("          </select>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("        \n");
      out.write("      <div class=\"form-footer\">\n");
      out.write("        <button type=\"submit\" class=\"submit-btn\">Save Profile</button>\n");
      out.write("        <div class=\"register\">\n");
      out.write("        <p>Already have an account? <a href=\"Login.jsp\">Login here</a></p>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </form>\n");
      out.write("  </div>\n");
      out.write("   </body>\n");
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
