package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import requirepackage.DBConnect;

public final class SearchPosts_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("  <title>Search Results</title>\n");
      out.write("  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" />\n");
      out.write("</head>\n");
      out.write("<body class=\"bg-light\">\n");
      out.write("<div class=\"container py-5\">\n");
      out.write("  <h2 class=\"mb-4\">Search Results</h2>\n");
      out.write("\n");

String query = request.getParameter("query");
if (query == null || query.trim().isEmpty()) {

      out.write("\n");
      out.write("  <div class=\"alert alert-warning\">Please enter a search term.</div>\n");

} else {
  Connection conn = null;
  PreparedStatement pst = null;
  ResultSet rs = null;

  try {
    DBConnect dbc = new DBConnect();
    conn = dbc.getConnection();

    String sql = "SELECT * FROM newpost WHERE jobroll LIKE ? OR loc LIKE ? OR salary LIKE ?";
    pst = conn.prepareStatement(sql);
    String wildcard = "%" + query + "%";
    pst.setString(1, wildcard);
    pst.setString(2, wildcard);
    pst.setString(3, wildcard);
    rs = pst.executeQuery();

    boolean found = false;
    while (rs.next()) {
      found = true;

      out.write("\n");
      out.write("      <div class=\"card mb-3 p-3 shadow-sm\">\n");
      out.write("        <h5>");
      out.print( rs.getString("jobroll") );
      out.write(" <small class=\"text-muted\">(");
      out.print( rs.getString("post_type") );
      out.write(")</small></h5>\n");
      out.write("        <p><strong>Company:</strong> ");
      out.print( rs.getString("comname") );
      out.write("</p>\n");
      out.write("        <p><strong>Location:</strong> ");
      out.print( rs.getString("loc") );
      out.write("</p>\n");
      out.write("        <p><strong>Salary:</strong> ");
      out.print( rs.getString("salary") );
      out.write("</p>\n");
      out.write("        <p><strong>Skills:</strong> ");
      out.print( rs.getString("skill") );
      out.write("</p>\n");
      out.write("        <p><strong>Description:</strong> ");
      out.print( rs.getString("des") );
      out.write("</p>\n");
      out.write("      </div>\n");

    }
    if (!found) {

      out.write("\n");
      out.write("      <div class=\"alert alert-info\">No results found for \"");
      out.print( query );
      out.write("\"</div>\n");

    }
  } catch (Exception e) {
    out.println("<div class='alert alert-danger'>Error: " + e.getMessage() + "</div>");
  } finally {
    if (rs != null) rs.close();
    if (pst != null) pst.close();
    if (conn != null) conn.close();
  }
}

      out.write("\n");
      out.write("</div>\n");
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
