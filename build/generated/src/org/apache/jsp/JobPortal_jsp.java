package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import requirepackage.DBConnect;
import requirepackage.Registration;
import requirepackage.UserController;
import java.text.SimpleDateFormat;
import java.sql.*;

public final class JobPortal_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

  DBConnect dbc=new DBConnect();
  UserController utc=new UserController();
  ResultSet rs=dbc.getJobs("select comname,jobroll,skill,loc,deadline,salary,exp,des from recruiter where post_type ='internship'");
    

      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Job Portal</title>\n");
      out.write("        <!--<link rel=\"stylesheet\" href=\"css/JobPortal.css\">-->\n");
      out.write("         <style>\n");
      out.write("         :root {\n");
      out.write("      --primary: #00b894;\n");
      out.write("      --accent: #0984e3;\n");
      out.write("      --bg: #f0f2f5;\n");
      out.write("      --text: #2d3436;\n");
      out.write("      --card: #fff;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    * {\n");
      out.write("      margin: 0;\n");
      out.write("      padding: 0;\n");
      out.write("      box-sizing: border-box;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    body {\n");
      out.write("      font-family: 'Roboto', sans-serif;\n");
      out.write("      background: var(--bg);\n");
      out.write("      color: var(--text);\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    nav {\n");
      out.write("      background: var(--primary);\n");
      out.write("      padding: 1rem 2rem;\n");
      out.write("      color: white;\n");
      out.write("      display: flex;\n");
      out.write("      justify-content: space-between;\n");
      out.write("      align-items: center;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    nav .logo {\n");
      out.write("      font-weight: 700;\n");
      out.write("      font-size: 1.5rem;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    nav ul {\n");
      out.write("      display: flex;\n");
      out.write("      gap: 1.5rem;\n");
      out.write("      list-style: none;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    nav ul li a {\n");
      out.write("      color: white;\n");
      out.write("      text-decoration: none;\n");
      out.write("      font-weight: 500;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    header {\n");
      out.write("      padding: 4rem 2rem;\n");
      out.write("      text-align: center;\n");
      out.write("      background: linear-gradient(to right, var(--primary), var(--accent));\n");
      out.write("      color: white;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    header h1 {\n");
      out.write("      font-size: 3rem;\n");
      out.write("      margin-bottom: 1rem;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    header p {\n");
      out.write("      font-size: 1.2rem;\n");
      out.write("      max-width: 600px;\n");
      out.write("      margin: auto;\n");
      out.write("    }\n");
      out.write("    .section {\n");
      out.write("      padding: 4rem 2rem;\n");
      out.write("      max-width: 1200px;\n");
      out.write("      margin: auto;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .section h2 {\n");
      out.write("      text-align: center;\n");
      out.write("      margin-bottom: 2rem;\n");
      out.write("      font-size: 2rem;\n");
      out.write("      color: var(--primary);\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .internships {\n");
      out.write("      display: grid;\n");
      out.write("      grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));\n");
      out.write("      gap: 2rem;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .card {\n");
      out.write("      background: var(--card-bg);\n");
      out.write("      padding: 2rem;\n");
      out.write("      border-radius: 10px;\n");
      out.write("      box-shadow: 0 4px 10px rgba(0,0,0,0.05);\n");
      out.write("      transition: transform 0.3s ease;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .card:hover {\n");
      out.write("      transform: translateY(-5px);\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .card h3 {\n");
      out.write("      margin-bottom: 0.5rem;\n");
      out.write("      color: var(--secondary);\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .card p {\n");
      out.write("      font-size: 0.95rem;\n");
      out.write("      color: #555;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .btn {\n");
      out.write("      display: inline-block;\n");
      out.write("      margin-top: 1rem;\n");
      out.write("      padding: 0.6rem 1.5rem;\n");
      out.write("      background: var(--primary);\n");
      out.write("      color: white;\n");
      out.write("      border-radius: 30px;\n");
      out.write("      text-decoration: none;\n");
      out.write("      font-weight: 500;\n");
      out.write("      transition: background 0.3s;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .btn:hover {\n");
      out.write("      background: var(--secondary);\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .cta {\n");
      out.write("      text-align: center;\n");
      out.write("      background: #ffffff;\n");
      out.write("      padding: 4rem 2rem;\n");
      out.write("      margin-top: 4rem;\n");
      out.write("      border-radius: 12px;\n");
      out.write("      box-shadow: 0 8px 16px rgba(0,0,0,0.05);\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    footer {\n");
      out.write("      background: #212529;\n");
      out.write("      color: #ddd;\n");
      out.write("      text-align: center;\n");
      out.write("      padding: 2rem 1rem;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    @media (max-width: 600px) {\n");
      out.write("      header h1 {\n");
      out.write("        font-size: 2rem;\n");
      out.write("      }\n");
      out.write("\n");
      out.write("      nav ul {\n");
      out.write("        flex-direction: column;\n");
      out.write("        gap: 1rem;\n");
      out.write("      }\n");
      out.write("    }\n");
      out.write("    </style>\n");
      out.write("    </head>\n");
      out.write("    <nav>\n");
      out.write("           <div class=\"logo\">< ZIDIOConnect ></div>\n");
      out.write("           <ul>\n");
      out.write("            \n");
      out.write("             <li><a href=\"Internship.jsp\">Internship Portal</a></li>\n");
      out.write("             <li><a href=\"ViewProfile.jsp\">View Profile</a></li>\n");
      out.write("           </ul>\n");
      out.write("         </nav>\n");
      out.write("\n");
      out.write("         <header>\n");
      out.write("           <h1>Discover Jobs Around You</h1>\n");
      out.write("           <p>“Professional Opportunities at Your Fingertips”</p>\n");
      out.write("         </header>\n");
      out.write("  <section id=\"internships\" class=\"section\">\n");
      out.write("           <h2>Latest Jobs For You</h2>\n");
      out.write("           <div class=\"internships\">\n");
      out.write("             <div class=\"card\">\n");
      out.write("                 ");
 
                    while (rs.next())
                 {
                 
      out.write("\n");
      out.write("                 <h3>Java Developer </h3>\n");
      out.write("                 <p><b>🚀 Company :</b>");
      out.print( rs.getString(1) );
      out.write("<br>\n");
      out.write("                     🎯 <b>Skill :</b>");
      out.print(rs.getString(2) );
      out.write("<br>\n");
      out.write("                     <b>📍 Location: </b>");
      out.print(rs.getString(3));
      out.write(" <br> \n");
      out.write("                     &nbsp;<b>     ₹   Salary :</b> ");
      out.print(rs.getString(4) );
      out.write(" <br>\n");
      out.write("                     <b>🕒 Experience</b> ");
      out.print( rs.getString(5) );
      out.write("</p>\n");
      out.write("                 <p><b>💼 Description:</b>");
      out.print(rs.getString(6));
      out.write("</p>\n");
      out.write("               <a href=\"#\" class=\"btn\">Apply Now</a>\n");
      out.write("             </div>\n");
      out.write("                 ");

                     }
                     
      out.write("\n");
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
