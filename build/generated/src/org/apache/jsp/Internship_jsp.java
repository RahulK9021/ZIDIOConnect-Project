package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import requirepackage.DBConnect;
import requirepackage.Registration;
import requirepackage.UserController;
import java.text.SimpleDateFormat;
import java.sql.*;

public final class Internship_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    DBConnect dbc=new DBConnect();
    UserController utc = new UserController();
    ResultSet rs=dbc.getInternships("SELECT comname, jobroll, skill, loc, deadline, salary, exp, des FROM recruiter WHERE post_type = 'internship'");  

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Internship</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/Internship.css\">\n");
      out.write("    \n");
      out.write("    <style>\n");
      out.write("   \n");
      out.write("    </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <nav>\n");
      out.write("           <div class=\"logo\">< ZIDIOConnect ></div>\n");
      out.write("           <ul>\n");
      out.write("            \n");
      out.write("             <li><a href=\"JobPortal.jsp\">Job Portal</a></li>\n");
      out.write("             <li><a href=\"ViewProfile.jsp\">View Profile</a></li>\n");
      out.write("           </ul>\n");
      out.write("         </nav>\n");
      out.write("\n");
      out.write("         <header>\n");
      out.write("           <h1>Discover Internships Around You</h1>\n");
      out.write("           <p>Explore verified internship listings from startups to Fortune 500 companies. Get experience. Get hired.</p>\n");
      out.write("         </header>\n");
      out.write("\n");
      out.write("         <section id=\"internships\" class=\"section\">\n");
      out.write("           <h2>Latest Internships</h2>\n");
      out.write("           <div class=\"internships\">\n");
      out.write("               ");

                  while(rs.next())
                  {
                
      out.write("\n");
      out.write("             <div class=\"card\">\n");
      out.write("               <h3>");
      out.print(rs.getString(2) );
      out.write("</h3>\n");
      out.write("               <p><b>🚀 Company</b>");
      out.print(rs.getString(1) );
      out.write("  \n");
      out.write("                   <br>🧑‍💻 Job Role ");
      out.print(rs.getString(2) );
      out.write("<br>\n");
      out.write("                   <b>📍 SKills </b>  ");
      out.print(rs.getString(3) );
      out.write(" <br>\n");
      out.write("                   <b>🕒 Location</b> ");
      out.print(rs.getString(4));
      out.write("  <br>      \n");
      out.write("                    <b>🕒 Deadline</b> ");
      out.print(rs.getString(5));
      out.write(" <br>\n");
      out.write("                     <b>🕒 Stipend</b> ");
      out.print(rs.getString(6));
      out.write(" <br>\n");
      out.write("                     <b>🕒 duration</b> ");
      out.print(rs.getString(7));
      out.write(" <br>\n");
      out.write("                     <b>💼 Description:</b>");
      out.print(rs.getString(8));
      out.write("</p>\n");
      out.write("                <a href=\"#\" class=\"btn\">Apply Now</a>\n");
      out.write("             </div>\n");
      out.write("        ");

             }
         
      out.write("\n");
      out.write("               \n");
      out.write("               \n");
      out.write("              \n");
      out.write("         </section>\n");
      out.write("\n");
      out.write("         <section id=\"apply\" class=\"section cta\">\n");
      out.write("           <h2>For Students & Companies</h2>\n");
      out.write("           <p>🌟 Students:Apply to top internships and boost your resume.<br>\n");
      out.write("           🏢 Companies: Post internships and discover amazing talent.</p>\n");
      out.write("           <a href=\"#\" class=\"btn\">Join as Student</a>\n");
      out.write("           <a href=\"#\" class=\"btn\" style=\"background:#6610f2; margin-left: 1rem;\">Join as Company</a>\n");
      out.write("         </section>\n");
      out.write("\n");
      out.write("         <footer id=\"contact\">\n");
      out.write("           <p>📧 Email: support@zidioconnect.com | 📞 +1 (800) 123-4567</p>\n");
      out.write("           <p>© 2025 ZIDIOConnect. All rights reserved.</p>\n");
      out.write("         </footer>\n");
      out.write("       \n");
      out.write("       </body>\n");
      out.write("       </html>\n");
      out.write("\n");
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
