package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

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
      out.write("        <link rel=\"stylesheet\" href=\"css/recruiterdashboard.css\">\n");
      out.write("        <title>Recruiter Dashboard</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <header>\n");
      out.write("  <h1>< ZIDIOConnect ></h1>\n");
      out.write(" \n");
      out.write("  <nav class=\"top-nav\">\n");
      out.write("   \n");
      out.write("      <a href=\"#\"><h3>Job Postings</h3></a>\n");
      out.write("    <a href=\"#\"><h3>Candidates</h3></a>\n");
      out.write("    \n");
      out.write("     <a href=\"#\"><h3>Messages</h3></a>\n");
      out.write("   \n");
      out.write("  </nav>\n");
      out.write("  <div class=\"profile\">\n");
      out.write("      <img src=\"images/profile1.png\" alt=\"profile image\" class=\"profile-img\"><br>\n");
      out.write("       <a href=\"#\">View Profile</a><br><br>\n");
      out.write("  </div>\n");
      out.write("    </header><br><br>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <main>\n");
      out.write("        <div class=\"dashboard-cards\">\n");
      out.write("        <div class=\"card\">\n");
      out.write("          <h3>Total Applications</h3>\n");
      out.write("          <p>1,245</p>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"card\">\n");
      out.write("          <h3>Shortlisted</h3>\n");
      out.write("          <p>320</p>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"card\">\n");
      out.write("          <h3>Interviews</h3>\n");
      out.write("          <p>145</p>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"card\">\n");
      out.write("          <h3>Hired</h3>\n");
      out.write("          <p>58</p>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      <div class=\"section\">\n");
      out.write("        <h2>Recent Candidates</h2>\n");
      out.write("        <table class=\"table\">\n");
      out.write("          <thead>\n");
      out.write("            <tr>\n");
      out.write("              <th>Name</th>\n");
      out.write("              <th>Position</th>\n");
      out.write("              <th>Status</th>\n");
      out.write("              <th>Date Applied</th>\n");
      out.write("            </tr>\n");
      out.write("          </thead>\n");
      out.write("          <tbody>\n");
      out.write("            <tr>\n");
      out.write("              <td>Alice Johnson</td>\n");
      out.write("              <td>UX Designer</td>\n");
      out.write("              <td>Interview Scheduled</td>\n");
      out.write("              <td>May 25, 2025</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("              <td>Bob Smith</td>\n");
      out.write("              <td>Frontend Developer</td>\n");
      out.write("              <td>Shortlisted</td>\n");
      out.write("              <td>May 24, 2025</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("              <td>Clara Rose</td>\n");
      out.write("              <td>Backend Developer</td>\n");
      out.write("              <td>Applied</td>\n");
      out.write("              <td>May 23, 2025</td>\n");
      out.write("            </tr>\n");
      out.write("          </tbody>\n");
      out.write("        </table>\n");
      out.write("      </div>\n");
      out.write("    </main>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
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
