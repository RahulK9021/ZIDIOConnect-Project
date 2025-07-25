package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import requirepackage.DBConnect;
import requirepackage.UserController;
import requirepackage.Internship;
import java.sql.Date;
import java.text.SimpleDateFormat;

public final class NewPost_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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

  DBConnect dbc = new DBConnect();
  UserController utc = new UserController();

  if (request.getParameter("btnrecsub") != null) {
    Internship post = new Internship();
    post.setRecemail(request.getParameter("recid"));
    post.setComnm(request.getParameter("comnm"));
    post.setJr(request.getParameter("jr"));
    post.setSkill(request.getParameter("skill"));
    post.setLoc(request.getParameter("loc"));
    post.setSalary(request.getParameter("salary"));
    post.setExp(request.getParameter("exp"));
    post.setDec(request.getParameter("des"));
    post.setPostType(request.getParameter("post_type"));

    try {
      String dateStr = request.getParameter("deadline");
      if (dateStr != null && !dateStr.isEmpty()) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = sdf.parse(dateStr);
        post.setDeadline(new java.sql.Date(utilDate.getTime()));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    boolean saved = utc.addPost(post);
    if (saved) {
      response.sendRedirect("RecruiterDashboard.jsp?msg=success");
    } else {
      out.println("<div style='color:red;'>Failed to save post.</div>");
    }
  }

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Post Internship or Job</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/NewPost.css\" />\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;700&display=swap\" rel=\"stylesheet\">\n");
      out.write("    \n");
      out.write("    <script>\n");
      out.write("<script>\n");
      out.write("window.onload = function () {\n");
      out.write("  const internshipBtn = document.getElementById(\"internshipToggle\");\n");
      out.write("  const jobBtn = document.getElementById(\"jobToggle\");\n");
      out.write("  const postTypeField = document.getElementById(\"postType\");\n");
      out.write("\n");
      out.write("  // Add active class for styling\n");
      out.write("  function setActive(button) {\n");
      out.write("    internshipBtn.classList.remove(\"active-post-type\");\n");
      out.write("    jobBtn.classList.remove(\"active-post-type\");\n");
      out.write("    button.classList.add(\"active-post-type\");\n");
      out.write("  }\n");
      out.write("\n");
      out.write("  // Set default post type (optional, default to internship)\n");
      out.write("  postTypeField.value = \"internship\";\n");
      out.write("  setActive(internshipBtn);\n");
      out.write("\n");
      out.write("  internshipBtn.onclick = () => {\n");
      out.write("    postTypeField.value = \"internship\";\n");
      out.write("    setActive(internshipBtn);\n");
      out.write("  };\n");
      out.write("\n");
      out.write("  jobBtn.onclick = () => {\n");
      out.write("    postTypeField.value = \"job\";\n");
      out.write("    setActive(jobBtn);\n");
      out.write("  };\n");
      out.write("};\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<form method=\"post\">\n");
      out.write("  <input type=\"hidden\" id=\"postType\" name=\"post_type\" value=\"\">\n");
      out.write("\n");
      out.write("  <div class=\"form-group\">\n");
      out.write("    <label for=\"recid\">Recruiter Email:</label>\n");
      out.write("    <input type=\"email\" name=\"recid\" required />\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("  <div class=\"form-group\">\n");
      out.write("    <label for=\"comnm\">Company Name:</label>\n");
      out.write("    <input type=\"text\" name=\"comnm\" required />\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("  <!-- Shared Fields -->\n");
      out.write("  <div class=\"form-group\">\n");
      out.write("    <label for=\"jr\">Role:</label>\n");
      out.write("    <input type=\"text\" name=\"jr\" required />\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("  <div class=\"form-group\">\n");
      out.write("    <label for=\"skill\">Skills / Education:</label>\n");
      out.write("    <input type=\"text\" name=\"skill\" required />\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("  <div class=\"form-group\">\n");
      out.write("    <label for=\"loc\">Location:</label>\n");
      out.write("    <input type=\"text\" name=\"loc\" required />\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("  <div class=\"form-group\">\n");
      out.write("    <label for=\"deadline\">Deadline:</label>\n");
      out.write("    <input type=\"date\" name=\"deadline\" />\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("  <div class=\"form-group\">\n");
      out.write("    <label for=\"salary\">Salary / Stipend:</label>\n");
      out.write("    <input type=\"text\" name=\"salary\" />\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("  <div class=\"form-group\">\n");
      out.write("    <label for=\"exp\">Experience / Duration:</label>\n");
      out.write("    <input type=\"text\" name=\"exp\" />\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("  <div class=\"form-group\">\n");
      out.write("    <label for=\"des\">Description:</label>\n");
      out.write("    <input type=\"text\" name=\"des\" />\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("  <div class=\"form-group\">\n");
      out.write("    <label>Select Post Type:</label><br>\n");
      out.write("    <button type=\"button\" id=\"internshipToggle\">Internship</button>\n");
      out.write("    <button type=\"button\" id=\"jobToggle\">Job</button>\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("  <div class=\"form-footer\">\n");
      out.write("    <input type=\"submit\" class=\"submit-btn\" name=\"btnrecsub\" value=\"Save Post\">\n");
      out.write("  </div>\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("</body>\n");
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
