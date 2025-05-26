package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Internship</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/Internship.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("    \n");
      out.write("\n");
      out.write("<body>\n");
      out.write(" <nav>\n");
      out.write("    <div class=\"logo\">InternShipHub</div>\n");
      out.write("    <ul>\n");
      out.write("      <li><a href=\"#internships\">Internships</a></li>\n");
      out.write("      <li><a href=\"#students\">Students</a></li>\n");
      out.write("      <li><a href=\"#contact\">Contact</a></li>\n");
      out.write("    </ul>\n");
      out.write("  </nav>\n");
      out.write("\n");
      out.write("  <header>\n");
      out.write("    <h1>Discover Internships Around You</h1>\n");
      out.write("    <p>Explore verified internship listings from startups to Fortune 500 companies. Get experience. Get hired.</p>\n");
      out.write("  </header>\n");
      out.write("\n");
      out.write("  <div class=\"dashboard\">\n");
      out.write("    <h2>Available Internships</h2>\n");
      out.write("    <div class=\"card-container\">\n");
      out.write("      <div class=\"card\">\n");
      out.write("        <h3>Software Engineer Intern</h3>\n");
      out.write("        <p>Company: CodeBase</p>\n");
      out.write("        <p>Location: Remote</p>\n");
      out.write("        <a class=\"apply\" href=\"#\">Apply</a>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"card\">\n");
      out.write("        <h3>Graphic Design Intern</h3>\n");
      out.write("        <p>Company: <a href=\"PixelPoint.jsp\"> PixelPoint</a></p>\n");
      out.write("        <p>Location: Los Angeles, CA</p>\n");
      out.write("        <a class=\"apply\" href=\"#\">Apply</a>\n");
      out.write("      </div>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("         <div class=\"card\">\n");
      out.write("        <h3>Graphic Design Intern</h3>\n");
      out.write("        <p>Company: PixelPoint</p>\n");
      out.write("        <p>Location: Los Angeles, CA</p>\n");
      out.write("        \n");
      out.write("        <div class=\"extra-details\">\n");
      out.write("            <p><strong>Skills Required:</strong> Adobe Photoshop, Illustrator, UX/UI Design</p>\n");
      out.write("            <p><strong>Duration:</strong> 3 Months, Paid Internship</p>\n");
      out.write("        </div>\n");
      out.write("        <button class=\"toggle-btn\" onclick=\"toggleDetails()\">See More</button>\n");
      out.write("        <a class=\"apply\" href=\"#\">Apply</a>\n");
      out.write("    </div>\n");
      out.write("    <script>\n");
      out.write("        let isExpanded = false;\n");
      out.write("\n");
      out.write("        function toggleDetails() {\n");
      out.write("            let details = document.querySelector(\".extra-details\");\n");
      out.write("            let button = document.querySelector(\".toggle-btn\");\n");
      out.write("\n");
      out.write("            isExpanded = !isExpanded;\n");
      out.write("            \n");
      out.write("            if (isExpanded) {\n");
      out.write("                details.style.display = \"block\";\n");
      out.write("                button.textContent = \"See Less\";\n");
      out.write("            } else {\n");
      out.write("                details.style.display = \"none\";\n");
      out.write("                button.textContent = \"See More\";\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("      <div class=\"card\">\n");
      out.write("        <h3>AI Research Intern</h3>\n");
      out.write("        <p>Company: FutureAI</p>\n");
      out.write("        <p>Location: Boston, MA</p>\n");
      out.write("        <a class=\"apply\" href=\"#\">Apply</a>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("   \n");
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
