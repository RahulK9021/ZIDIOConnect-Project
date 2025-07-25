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
    ResultSet rs=dbc.getInternships("SELECT id, recruiter_email, comname, jobroll, skill, loc, deadline, salary, exp, des FROM recruiter WHERE post_type = 'internship'");
    ResultSet rs2=dbc.getNewinternships("SELECT id, recruiter_email, comname, jobroll, skill, loc, deadline, salary, exp, des FROM newpost WHERE post_type = 'internship'");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Internship</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/Internship.css\">\n");
      out.write("    \n");
      out.write("    <style>\n");
      out.write("        :root {\n");
      out.write("      --primary: #00b894;\n");
      out.write("      --accent: #0984e3;\n");
      out.write("      --bg: #f0f2f5;\n");
      out.write("      --text: #2d3436;\n");
      out.write("      --card: #fff;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("       * {\n");
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
      out.write("    header {\n");
      out.write("      background: linear-gradient(to right, var(--primary), var(--accent));\n");
      out.write("      color: white;\n");
      out.write("      padding: 6rem 3rem;\n");
      out.write("      text-align: center;\n");
      out.write("      position: relative;\n");
      out.write("      overflow: hidden;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    header h1 {\n");
      out.write("      font-size: 3rem;\n");
      out.write("      margin-bottom: 1rem;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    header p {\n");
      out.write("      font-size: 1.2rem;\n");
      out.write("      max-width: 800px;\n");
      out.write("      margin: auto;\n");
      out.write("      margin-bottom: 100px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    header .wave {\n");
      out.write("      position: absolute;\n");
      out.write("      bottom: -0.3px;\n");
      out.write("      left: 0;\n");
      out.write("      width: 100%;\n");
      out.write("    }\n");
      out.write("    .section {\n");
      out.write("      padding: 4rem 2rem;\n");
      out.write("      max-width: 1200px;\n");
      out.write("      margin: auto;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .section h4 {\n");
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
      out.write("      margin: 8px 0;\n");
      out.write("      color: #333;\n");
      out.write("      font-size: 15px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .card:hover {\n");
      out.write("      transform: translateY(-5px);\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .card p {\n");
      out.write("      font-size: 0.95rem;\n");
      out.write("      color: #555;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .apply-btn {\n");
      out.write("        display: inline-block;\n");
      out.write("        margin-top: 15px;\n");
      out.write("        background: linear-gradient(90deg, #00c6ff, #0072ff);\n");
      out.write("        color: white;\n");
      out.write("        padding: 10px 20px;\n");
      out.write("        border-radius: 30px;\n");
      out.write("        text-decoration: none;\n");
      out.write("        font-weight: bold;\n");
      out.write("        transition: background 0.3s ease;\n");
      out.write("      }\n");
      out.write("\n");
      out.write("         .apply-btn:hover {\n");
      out.write("        background: linear-gradient(90deg, #0072ff, #0056d2);\n");
      out.write("      }\n");
      out.write("\n");
      out.write("    .cta {\n");
      out.write("      text-align: center;\n");
      out.write("      background: #ffffff;\n");
      out.write("      padding: 4rem 2rem;\n");
      out.write("      margin-top: 4rem;\n");
      out.write("      border-radius: 12px;\n");
      out.write("      box-shadow: 0 8px 16px rgba(0,0,0,0.05);\n");
      out.write("      color: linear-gradient(to right, var(--primary), var(--accent));;\n");
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
      out.write("      \n");
      out.write("    }\n");
      out.write("    /* Navbar Styling */\n");
      out.write("    .navbar {\n");
      out.write("      width: 100%;\n");
      out.write("      background: linear-gradient(to right, var(--primary), var(--accent));\n");
      out.write("      position: fixed;\n");
      out.write("      top: 0;\n");
      out.write("      left: 0;\n");
      out.write("      z-index: 1000;\n");
      out.write("      /*box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);*/\n");
      out.write("      font-family: 'Poppins', sans-serif;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .nav-container {\n");
      out.write("      display: flex;\n");
      out.write("      justify-content: space-between;\n");
      out.write("      align-items: center;\n");
      out.write("      /*max-width: 1200px;*/\n");
      out.write("      padding: 0.8rem 2rem;\n");
      out.write("      margin: auto;\n");
      out.write("      margin-right: 10px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .logo {\n");
      out.write("      color: white;\n");
      out.write("      font-weight: 600;\n");
      out.write("      font-size: 1.4rem;\n");
      out.write("      margin-right: 500px\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .nav-links {\n");
      out.write("      list-style: none;\n");
      out.write("      display: flex;\n");
      out.write("      gap: 1.5rem;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .nav-links li a {\n");
      out.write("      color: white;\n");
      out.write("      text-decoration: none;\n");
      out.write("      font-weight: 500;\n");
      out.write("      transition: color 0.3s ease;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .nav-links li a:hover {\n");
      out.write("      color: #ffeb3b;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .card h3 {\n");
      out.write("      font-size: 24px;\n");
      out.write("      color: #0072ff;\n");
      out.write("      margin-bottom: 15px;\n");
      out.write("    }\n");
      out.write("    .card:hover {\n");
      out.write("      transform: translateY(-5px);\n");
      out.write("      box-shadow: 0 6px 25px rgba(0, 0, 0, 0.15);\n");
      out.write("    }\n");
      out.write("    .card p {\n");
      out.write("      margin: 8px 0;\n");
      out.write("      color: #333;\n");
      out.write("      font-size: 15px;\n");
      out.write("    }   \n");
      out.write("    .btn{\n");
      out.write("        padding: 10px;\n");
      out.write("        margin: 10px;\n");
      out.write("        text-decoration: none;\n");
      out.write("        border: 1px solid black;\n");
      out.write("        color: white;\n");
      out.write("    }\n");
      out.write("    </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("   <header>\n");
      out.write("    <h1>\"Your career, our commitment.\" </h1>\n");
      out.write("    <p>ZIDIOConnect Helps You To Unlock Your Career Potential !! <br> Because we believe in<i> <b> Talent Deserves Recognition</b> </i></p>\n");
      out.write("    <a href=\"#services\" class=\"btn\">Our Services</a>\n");
      out.write("    <svg class=\"wave\" viewBox=\"0 0 1440 320\"><path fill=\"#f4f4f9\" fill-opacity=\"1\" d=\"M0,160L80,154.7C160,149,320,139,480,138.7C640,139,800,149,960,165.3C1120,181,1280,203,1360,213.3L1440,224L1440,320L1360,320C1280,320,1120,320,960,320C800,320,640,320,480,320C320,320,160,320,80,320L0,320Z\"></path></svg>\n");
      out.write("  </header>\n");
      out.write("<nav class=\"navbar\">\n");
      out.write("  <div class=\"nav-container\">\n");
      out.write("    <div class=\"logo\">< ZIDIOConnect ></div>\n");
      out.write("   <ul class=\"nav-links\">\n");
      out.write("  <li><a href=\"");
      out.print( request.getContextPath() );
      out.write("/JobPortal.jsp\">Job Portal</a></li>\n");
      out.write("  <li><a href=\"Internship.jsp\">Internships</a></li>\n");
      out.write("  <li><a href=\"ViewProfile.jsp\">Update Profile</a></li>\n");
      out.write("  <li><a href=\"JobseekerDashboard.jsp\">My Applications</a></li> <!-- ✅ Added this -->\n");
      out.write("</ul>\n");
      out.write("\n");
      out.write("  </div>\n");
      out.write("</nav>\n");
      out.write("\n");
      out.write("         <section id=\"internships\" class=\"section\">\n");
      out.write("           <h2>Latest Internships</h2>\n");
      out.write("           <div class=\"internships\">\n");
      out.write("               ");

                  if(rs != null){
                  while(rs.next())
                 {
                
      out.write("\n");
      out.write("             <div class=\"card\">\n");
      out.write("                <h3> ");
      out.print( rs.getString(4) );
      out.write("</h3>\n");
      out.write("        <p><b>🚀 Company :</b> ");
      out.print( rs.getString(3) );
      out.write("</p>\n");
      out.write("        <p><b>🎯 Job Role :</b> ");
      out.print( rs.getString(4) );
      out.write("</p>\n");
      out.write("        <p><b>🛠 Skills :</b> ");
      out.print( rs.getString(5) );
      out.write("</p>\n");
      out.write("        <p><b>📍 Location :</b> ");
      out.print( rs.getString(6) );
      out.write("</p>\n");
      out.write("        <p><b>⏳ Deadline:</b> ");
      out.print( rs.getString(7) );
      out.write("</p>\n");
      out.write("        <p><b>💰 Stipend :</b> ₹");
      out.print( rs.getString(8) );
      out.write("</p>\n");
      out.write("        <p><b>🕒 Duration :</b> ");
      out.print( rs.getString(9) );
      out.write("</p>\n");
      out.write("        <p><b>💼 what Will You Learn :</b> ");
      out.print( rs.getString(10) );
      out.write("</p>\n");
      out.write("       <a href=\"Apply.jsp?job_id=");
      out.print( rs.getString("id") );
      out.write("&recruiter_email=");
      out.print( rs.getString("recruiter_email") );
      out.write("&post_type=internship\" class=\"apply-btn\">Apply Now</a>\n");
      out.write("             </div>\n");
      out.write("          ");

             }
            }
         
      out.write("\n");
      out.write("      </div>\n");
      out.write("      <div class=\"internships\">\n");
      out.write("               ");

                  if(rs2 != null){
                  while(rs2.next())
                 {
                
      out.write("\n");
      out.write("             <div class=\"card\">\n");
      out.write("                <h3> ");
      out.print( rs2.getString(4) );
      out.write("</h3>\n");
      out.write("        <p><b>🚀 Company :</b> ");
      out.print( rs2.getString(3) );
      out.write("</p>\n");
      out.write("        <p><b>🎯 Job Role :</b> ");
      out.print( rs2.getString(4) );
      out.write("</p>\n");
      out.write("        <p><b>🛠 Skills :</b> ");
      out.print( rs2.getString(5) );
      out.write("</p>\n");
      out.write("        <p><b>📍 Location :</b> ");
      out.print( rs2.getString(6) );
      out.write("</p>\n");
      out.write("        <p><b>⏳ Deadline:</b> ");
      out.print( rs2.getString(7) );
      out.write("</p>\n");
      out.write("        <p><b>💰 Stipend :</b> ₹");
      out.print( rs2.getString(8) );
      out.write("</p>\n");
      out.write("        <p><b>🕒 Duration :</b> ");
      out.print( rs2.getString(9) );
      out.write("</p>\n");
      out.write("        <p><b>💼 what Will You Learn :</b> ");
      out.print( rs2.getString(10) );
      out.write("</p>\n");
      out.write("       <a href=\"Apply.jsp?job_id=");
      out.print( rs.getString("id") );
      out.write("&recruiter_email=");
      out.print( rs.getString("recruiter_email") );
      out.write("&post_type=internship\" class=\"apply-btn\">Apply Now</a>\n");
      out.write("             </div>\n");
      out.write("          ");

             }
            }
         
      out.write("\n");
      out.write("      </div>\n");
      out.write("      </section>\n");
      out.write("\n");
      out.write("         <section id=\"apply\" class=\"section cta\">\n");
      out.write("           <h4> Post internships and discover amazing talent.<br>Start with ZIDIOConnect Today !!!</h4>\n");
      out.write("           <a href=\"Register.jsp\" class=\"btn\" style=\"background:#6610f2; margin-left: 1rem;\">Join as Company</a>\n");
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
