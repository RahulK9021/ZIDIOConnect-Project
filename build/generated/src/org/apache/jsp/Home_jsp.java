package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Home</title>\n");
      out.write("        \n");
      out.write("        <link rel=\"stylesheet\" href=\"css/Home.css\" />\n");
      out.write("         <link href=\"https://fonts.googleapis.com/css2?family=Inter:wght@400;700&display=swap\" rel=\"stylesheet\">\n");
      out.write("  <style>\n");
      out.write("    body {\n");
      out.write("      margin: 0;\n");
      out.write("      font-family: 'Inter', sans-serif;\n");
      out.write("      background: #f4f7fa;\n");
      out.write("      color: #333;\n");
      out.write("    }\n");
      out.write("    header {\n");
      out.write("      background: linear-gradient(to right, #0052cc, #007fff);\n");
      out.write("      color: white;\n");
      out.write("      padding: 60px 20px;\n");
      out.write("      text-align: center;\n");
      out.write("      position: relative;\n");
      out.write("    }\n");
      out.write("    header h1 {\n");
      out.write("      font-size: 48px;\n");
      out.write("      margin-bottom: 10px;\n");
      out.write("    }\n");
      out.write("    header p {\n");
      out.write("      font-size: 20px;\n");
      out.write("    }\n");
      out.write("    .search-bar {\n");
      out.write("      margin-top: 30px;\n");
      out.write("      display: flex;\n");
      out.write("      justify-content: center;\n");
      out.write("    }\n");
      out.write("    .search-bar input {\n");
      out.write("      padding: 15px;\n");
      out.write("      font-size: 16px;\n");
      out.write("      width: 250px;\n");
      out.write("      border: none;\n");
      out.write("      border-radius: 10px 0 0 10px;\n");
      out.write("    }\n");
      out.write("    .search-bar button {\n");
      out.write("      padding: 15px;\n");
      out.write("      background: gold;\n");
      out.write("      border: none;\n");
      out.write("      border-radius: 0 10px 10px 0;\n");
      out.write("      font-weight: bold;\n");
      out.write("      cursor: pointer;\n");
      out.write("    }\n");
      out.write("    .features {\n");
      out.write("      display: flex;\n");
      out.write("      justify-content: space-around;\n");
      out.write("      padding: 50px 20px;\n");
      out.write("      background: white;\n");
      out.write("    }\n");
      out.write("    .feature-box {\n");
      out.write("      max-width: 300px;\n");
      out.write("      text-align: center;\n");
      out.write("    }\n");
      out.write("    .feature-box img {\n");
      out.write("      width: 80px;\n");
      out.write("      height: 80px;\n");
      out.write("    }\n");
      out.write("    .testimonials {\n");
      out.write("      background: #eef2f5;\n");
      out.write("      padding: 60px 20px;\n");
      out.write("      text-align: center;\n");
      out.write("    }\n");
      out.write("    .testimonial {\n");
      out.write("      max-width: 600px;\n");
      out.write("      margin: 20px auto;\n");
      out.write("      font-style: italic;\n");
      out.write("    }\n");
      out.write("    .cta-banner {\n");
      out.write("      background: #0052cc;\n");
      out.write("      color: white;\n");
      out.write("      text-align: center;\n");
      out.write("      padding: 40px 20px;\n");
      out.write("      font-size: 24px;\n");
      out.write("      font-weight: bold;\n");
      out.write("    }\n");
      out.write("    footer {\n");
      out.write("      background: #002f6c;\n");
      out.write("      color: white;\n");
      out.write("      padding: 20px;\n");
      out.write("      text-align: center;\n");
      out.write("    }\n");
      out.write("     button {\n");
      out.write("    background: #5d9592;\n");
      out.write("    color: black;\n");
      out.write("    cursor: pointer;\n");
      out.write("    margin-top: 15px;\n");
      out.write("    padding: 12px;\n");
      out.write("    font-size: 16px;\n");
      out.write("    border-radius: 5px;\n");
      out.write("    border: none;\n");
      out.write("    transition: all 0.3s ease-in-out;\n");
      out.write("}\n");
      out.write("\n");
      out.write("button:hover {\n");
      out.write("    background: #0056b3;\n");
      out.write("    box-shadow: 0px 5px 10px rgba(0, 114, 255, 0.3);\n");
      out.write("}\n");
      out.write(".vl {\n");
      out.write(" border-left: 6px solid green;\n");
      out.write("  height: 500px;\n");
      out.write("  position: absolute;\n");
      out.write("  left: 50%;\n");
      out.write("  margin-left: -3px;\n");
      out.write("  top: 0;\n");
      out.write("}\n");
      out.write("a{\n");
      out.write("    text-decoration: none;\n");
      out.write("    color: black;\n");
      out.write("}\n");
      out.write("  </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("   <header>\n");
      out.write("    <h1>Unleash Your Potential With ZIDIOConnect</h1>\n");
      out.write("     <b>We connect talent with opportunity — globally.</b><br>\n");
      out.write("      <b>\"Opportunities Aren’t Found. They’re Created — Start Here.\"</b>\n");
      out.write("  </header>\n");
      out.write("\n");
      out.write("  <section class=\"features\">\n");
      out.write("    <div class=\"feature-box\">\n");
      out.write("      <img src=\"https://img.icons8.com/ios-filled/100/briefcase.png\" alt=\"Easy Search\">\n");
      out.write("      <h3>Easy Search</h3>\n");
      out.write("      <p>Quickly find the jobs that match your skills and goals.</p>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"feature-box\">\n");
      out.write("      <img src=\"https://img.icons8.com/ios-filled/100/shield.png\" alt=\"Verified Employers\">\n");
      out.write("      <h3>Verified Employers</h3>\n");
      out.write("      <p>Apply with confidence to trusted companies.</p>\n");
      out.write("    </div>\n");
      out.write("      <div class=\"feature-box\" style=\"padding-down:100px\">\n");
      out.write("      <img src=\"images/career.jpg\" alt=\"Career Resources\" style=\"height: 100px;width: 100px\">\n");
      out.write("      <h3>Career Resources</h3>\n");
      out.write("      <p>Access tips, guides, and tools to grow your career.</p>\n");
      out.write("    </div>\n");
      out.write("  </section>\n");
      out.write("  <section class=\"testimonials\">\n");
      out.write("  <div class=\"testimonial\">\n");
      out.write("      At <b>ZIDIOConnect </b>, we believe in meaningful employment. Our platform helps professionals find the right job and enables companies to discover top talent. With advanced matching algorithms and a human-centered approach, we stand as a reliable bridge between job seekers and employers.\n");
      out.write("      Provides <b>internships</b> for growing your knowledge , and also give the platform to talented candidates to search a <b>job</b>.\n");
      out.write("  </div>\n");
      out.write("  </section>\n");
      out.write("  <section class=\"testimonials\">\n");
      out.write("    <h2>What Our Users Say</h2>\n");
      out.write("    <div class=\"testimonial\">\n");
      out.write("      \"Thanks to DreamJob, I found a job I love in just two weeks!\" – <strong>Gourav Gaikwad</strong>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"testimonial\">\n");
      out.write("      \"The platform is super easy to use and has tons of real opportunities.\" – <strong>Ashish P</strong>\n");
      out.write("    </div>\n");
      out.write("  </section>\n");
      out.write("  <form action=\"Register.jsp\">\n");
      out.write("    <div class=\"cta-banner\">\n");
      out.write("        Join Thousands Building Their Future  <br><button class=\"btn\">Sign Up Today !!</button> <button><a href=\"Login.jsp\"> Login !!</a></button>\n");
      out.write("    </div>\n");
      out.write("      \n");
      out.write("        \n");
      out.write("   \n");
      out.write("  <footer>\n");
      out.write("    &copy; 2025 ZIDIOConnect. All rights reserved.\n");
      out.write("  </footer>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("    \n");
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
