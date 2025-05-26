package org.apache.jsp.Companies;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class PixelPoint_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Pixelpoint Company</title>\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap\" rel=\"stylesheet\"/>\n");
      out.write("        <style>\n");
      out.write("    * {\n");
      out.write("      margin: 0;\n");
      out.write("      padding: 0;\n");
      out.write("      box-sizing: border-box;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    body {\n");
      out.write("      font-family: 'Roboto', sans-serif;\n");
      out.write("      line-height: 1.6;\n");
      out.write("      background-color: white;\n");
      out.write("      color: #333;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    header {\n");
      out.write("      background: url(\"\");\n");
      out.write("      height: 100vh;\n");
      out.write("      color: black;\n");
      out.write("      display: flex;\n");
      out.write("      flex-direction: column;\n");
      out.write("      justify-content: center;\n");
      out.write("      align-items: center;\n");
      out.write("      text-align: center;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    header h1 {\n");
      out.write("      font-size: 4rem;\n");
      out.write("      margin-bottom: 1rem;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    header p {\n");
      out.write("      font-size: 1.5rem;\n");
      out.write("      max-width: 600px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    nav {\n");
      out.write("      background-color: #111;\n");
      out.write("      color: white;\n");
      out.write("      padding: 1rem 2rem;\n");
      out.write("      display: flex;\n");
      out.write("      justify-content: space-between;\n");
      out.write("      align-items: center;\n");
      out.write("      position: sticky;\n");
      out.write("      top: 0;\n");
      out.write("      z-index: 1000;\n");
      out.write("    }\n");
      out.write("    section {\n");
      out.write("      padding: 4rem 2rem;\n");
      out.write("      max-width: 1200px;\n");
      out.write("      margin: auto;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .about, .services, .team {\n");
      out.write("      text-align: center;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .about img {\n");
      out.write("      width: 100%;\n");
      out.write("      max-width: 600px;\n");
      out.write("      border-radius: 10px;\n");
      out.write("      margin-top: 2rem;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .services .cards, .team .cards {\n");
      out.write("      display: grid;\n");
      out.write("      grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));\n");
      out.write("      gap: 2rem;\n");
      out.write("      margin-top: 2rem;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .card {\n");
      out.write("      background: white;\n");
      out.write("      padding: 2rem;\n");
      out.write("      border-radius: 10px;\n");
      out.write("      box-shadow: 0 4px 10px rgba(0,0,0,0.1);\n");
      out.write("      transition: transform 0.3s;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .card:hover {\n");
      out.write("      transform: translateY(-5px);\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .card img {\n");
      out.write("      width: 100%;\n");
      out.write("      height: 150px;\n");
      out.write("      object-fit: cover;\n");
      out.write("      border-radius: 8px;\n");
      out.write("      margin-bottom: 1rem;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    footer {\n");
      out.write("      background-color: #111;\n");
      out.write("      color: white;\n");
      out.write("      padding: 2rem;\n");
      out.write("      text-align: center;\n");
      out.write("    }\n");
      out.write("  </style>\n");
      out.write("    </head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("\n");
      out.write("  <header>\n");
      out.write("    <h1>Welcome To PixelPoint</h1>\n");
      out.write("    <p>We deliver innovative tech solutions to help your business grow and thrive in the digital world.\n");
      out.write("        \n");
      out.write("  </header>\n");
      out.write("\n");
      out.write("  <section id=\"about\" class=\"about\">\n");
      out.write("    <h2>About Us</h2>\n");
      out.write("    <p>We are a passionate team of professionals committed to building smart, scalable, and cutting-edge software solutions\n");
      out.write("        <b>PixelPoint</b>is committed to providing exquisite photography services to clients looking to freeze their precious moments in time.\n");
      out.write("    Whether it’s the joy of a newlywed couple, the laughter of a family gathering, or the thrill of a corporate event,\n");
      out.write("  we specialize in creating memorable images that tell each unique story.\n");
      out.write("    Our artistic approach combines technical expertise with an eye for detail, ensuring every shot is a work of art.</p>.</p>\n");
      out.write("    <img src=\"images\\PixelPoint1.avif\" alt=\"Our Team\">\n");
      out.write("  </section>\n");
      out.write("\n");
      out.write("  <section id=\"services\" class=\"services\">\n");
      out.write("    <h2>Our Services</h2>\n");
      out.write("    <div class=\"cards\">\n");
      out.write("      <div class=\"card\">\n");
      out.write("        <img src=\"https://source.unsplash.com/300x150/?code\" alt=\"Web Development\">\n");
      out.write("        <h3>Web Development</h3>\n");
      out.write("        <p>Modern and responsive web applications tailored to your needs.</p>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"card\">\n");
      out.write("        <img src=\"https://source.unsplash.com/300x150/?mobile,app\" alt=\"App Development\">\n");
      out.write("        <h3>App Development</h3>\n");
      out.write("        <p>Native and cross-platform mobile apps to reach your audience everywhere.</p>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"card\">\n");
      out.write("        <img src=\"https://source.unsplash.com/300x150/?cloud,technology\" alt=\"Cloud Services\">\n");
      out.write("        <h3>Cloud Solutions</h3>\n");
      out.write("        <p>Scalable cloud infrastructure to power your business 24/7.</p>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </section>\n");
      out.write("\n");
      out.write("  <section id=\"team\" class=\"team\">\n");
      out.write("    <h2>Meet the Team</h2>\n");
      out.write("    <div class=\"cards\">\n");
      out.write("      <div class=\"card\">\n");
      out.write("        <img src=\"https://source.unsplash.com/300x150/?person,man\" alt=\"CEO\">\n");
      out.write("        <h3>John Smith</h3>\n");
      out.write("        <p>CEO & Visionary</p>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"card\">\n");
      out.write("        <img src=\"https://source.unsplash.com/300x150/?woman,person\" alt=\"CTO\">\n");
      out.write("        <h3>Jane Doe</h3>\n");
      out.write("        <p>CTO & Lead Developer</p>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"card\">\n");
      out.write("        <img src=\"https://source.unsplash.com/300x150/?business,person\" alt=\"Designer\">\n");
      out.write("        <h3>Mark Lee</h3>\n");
      out.write("        <p>UI/UX Designer</p>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </section>\n");
      out.write("\n");
      out.write("  <footer id=\"contact\">\n");
      out.write("    <p>Contact us: info@awesomecompany.com | +1 (555) 123-4567</p>\n");
      out.write("    <p>© 2025 Awesome Company. All rights reserved.</p>\n");
      out.write("  </footer>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
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
