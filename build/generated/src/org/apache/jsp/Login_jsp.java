package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import requirepackage.UserLogin;
import requirepackage.DBConnect;
import requirepackage.UserController;
import requirepackage.DBConnect;
import java.sql.*;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
  String uid=request.getParameter("uid");
  String pwd=request.getParameter("pwd");
  try{
    Connection con=dbc.getConnection();
    String jobseekerQuery="select * from jobseeker where email = ? and password = ?";
    String recruiterQuery="select * from recruiter where email = ? and password = ?";
    
    
     try (PreparedStatement jobstmt = con.prepareStatement(jobseekerQuery);
         PreparedStatement recruiterStmt = con.prepareStatement(recruiterQuery))
         {
         jobstmt.setString(1, uid);
         jobstmt.setString(2, pwd);
         recruiterStmt.setString(1, uid);
         recruiterStmt.setString(2, pwd);
         try(ResultSet rs=jobstmt.executeQuery()){
         if(rs.next()){
         response.sendRedirect("Internship.jsp");
         return;
            }
        }
         try(ResultSet rs=recruiterStmt.executeQuery())
         {
         if(rs.next()){
         response.sendRedirect("RecruiterDashboard.jsp");
         return ;
             }
        }
        response.sendRedirect("login.jsp?error=Invalid+Username+or+Password");
        con.close();
        }catch (SQLException e) {
        e.printStackTrace();
        response.sendRedirect("error.jsp"); // Handle database errors
         }}catch(Exception ex){
        System.out.println("ex");
        }  

      out.write("\n");
      out.write("\n");
      out.write("    \n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Login</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/Login.css\">\n");
      out.write("         <link href=\"https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;700&display=swap\" rel=\"stylesheet\">\n");
      out.write("         <style>\n");
      out.write("         \n");
      out.write("            body {\n");
      out.write("         display: flex;\n");
      out.write("         justify-content: center;\n");
      out.write("         align-items: center;\n");
      out.write("         min-height: 100vh;\n");
      out.write("         margin: 0;\n");
      out.write("         font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;\n");
      out.write("         background-image: linear-gradient(120deg, #84fab0 0%, #8fd3f4 100%);\n");
      out.write("       }\n");
      out.write("            .form-wrapper {\n");
      out.write("         display: flex;\n");
      out.write("         flex-direction: column;\n");
      out.write("         justify-content: center;\n");
      out.write("         align-items: center;\n");
      out.write("         background: #fff;\n");
      out.write("         padding: 2.5rem;\n");
      out.write("         border-radius: 20px;\n");
      out.write("         box-shadow: 0 10px 25px rgba(0, 0, 0, 0.1);\n");
      out.write("         max-width: 1000px;\n");
      out.write("         width: 100%;\n");
      out.write("         text-align: center;\n");
      out.write("         justify-content:space-between ;\n");
      out.write("       }\n");
      out.write("    .form-wrapper h1 {\n");
      out.write("      text-align: center;\n");
      out.write("      margin-bottom: 2rem;\n");
      out.write("      /*color: #333;*/\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .form-grid {\n");
      out.write("      /*display: grid;*/\n");
      out.write("      /*grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));*/\n");
      out.write("      gap: 1.5rem;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .form-group {\n");
      out.write("      display: flex;\n");
      out.write("  flex-direction: column;\n");
      out.write("  width: 100%;\n");
      out.write("  max-width: 400px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .form-group label {\n");
      out.write("     font-weight: 600;\n");
      out.write("  margin-bottom: 0.5rem;\n");
      out.write("  color: #555;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .form-group input,\n");
      out.write("    .form-group select,\n");
      out.write("    .form-group textarea {\n");
      out.write("     width: 100%;\n");
      out.write("  padding: 0.8rem;\n");
      out.write("  border: 1px solid #ccc;\n");
      out.write("  border-radius: 10px;\n");
      out.write("  font-size: 1rem;\n");
      out.write("  background-color: #f9f9f9;\n");
      out.write("  transition: border-color 0.3s;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .form-group input:focus,\n");
      out.write("    .form-group select:focus,\n");
      out.write("    .form-group textarea:focus {\n");
      out.write("      border-color: #fda085;\n");
      out.write("  background-color: #fff;\n");
      out.write("  outline: none;\n");
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
      out.write("    }\n");
      out.write("    </style>\n");
      out.write("    </head>\n");
      out.write("<body>\n");
      out.write("     <div class=\"form-wrapper\">\n");
      out.write("    <h1>Login</h1>\n");
      out.write("    <form  method=\"POST\">\n");
      out.write("      <div class=\"form-grid\">\n");
      out.write("        \n");
      out.write("        <div class=\"form-group\">\n");
      out.write("          <label for=\"uid\">G-mail For Login</label>\n");
      out.write("          <input type=\"email\" name=\"uid\" placeholder=\"User G-mail\" required />\n");
      out.write("        </div>\n");
      out.write("          \n");
      out.write("        <div class=\"form-group\">\n");
      out.write("          <label for=\"unm\">Password</label>\n");
      out.write("          <input type=\"password\" name=\"pwd\" placeholder=\"Password\" required />\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"form-footer\">\n");
      out.write("            <input type=\"submit\" class=\"submit-btn\" name=\"btnsub\" value=\"Login\">\n");
      out.write("         <div class=\"register\">\n");
      out.write("        <p>Don't have an account? <a href=\"Register.jsp\">Register here</a></p>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("      </div>\n");
      out.write("      </div>\n");
      out.write("    </form>\n");
      out.write("     </div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("   \n");
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
