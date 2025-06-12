package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import requirepackage.DBConnect;
import requirepackage.Registration;
import requirepackage.UserController;
import java.text.SimpleDateFormat;
import java.util.Date;
import requirepackage.Recruiter;

public final class Register_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write('\n');

            DBConnect dbc=new DBConnect();
            UserController utc=new UserController();
            if(request.getParameter("btnsub") != null){
                Registration reg=new Registration();
               
                reg.setEmail(request.getParameter("uid"));
//                 System.out.println("email " + reg.getEmail());
                reg.setPassword(request.getParameter("pwd"));
//                  System.out.println("pwd " + reg.getPassword());
                reg.setFullnm(request.getParameter("unm"));
//                  System.out.println("fnm " + reg.getFullnm());
                String phoneStr = request.getParameter("phone");
                if (phoneStr != null && phoneStr.matches("\\d{10}")) {
                    reg.setPhoneno(phoneStr);  // Store as String
                } else {
                    System.out.println("Invalid or missing phone number: " + phoneStr);
                }
//                  System.out.println("[phone " + reg.getPhoneno());
               try {
                String dateStr = request.getParameter("dob");
                if (dateStr != null && !dateStr.isEmpty()) {
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    Date utilDate = formatter.parse(dateStr); 
                    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); 
                    reg.setDate(sqlDate);
                } else {
                    System.out.println("Date parameter is missing or empty.");
                }
                } catch (Exception ex) {
                    ex.printStackTrace(); // Log the error to help debug
                }
//              System.out.println("dob " + reg.getDate());
                reg.setGender(request.getParameter("gender"));
//                  System.out.println("gender " + reg.getGender());
               boolean saved = utc.addUserRegistration(reg);
//                System.out.println("Saved: " + saved);
                if(saved) {
                    response.sendRedirect("Login.jsp");
                }
                }
                
                
                
                else if(request.getParameter("btnrecsub") != null)
                {
                    Recruiter rec=new Recruiter();
                    rec.setRecemail(request.getParameter("recid"));
                    rec.setRecpwd(request.getParameter("recpwd"));
                    rec.setRecfnm(request.getParameter("recfnm"));
                    rec.setComweb(request.getParameter("comweb"));
                    rec.setComnm(request.getParameter("comnm"));
                    rec.setJr(request.getParameter("jr"));
                    rec.setSkill(request.getParameter("skill"));
                    rec.setLoc(request.getParameter("loc"));
                   try {
                String dateStr = request.getParameter("deadline");
                if (dateStr != null && !dateStr.isEmpty()) {
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    Date utilDate = formatter.parse(dateStr); 
                    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); 
                    rec.setDeadline(sqlDate);
                } else {
                    System.out.println("Date parameter is missing or empty.");
                }
                } catch (Exception ex) {
                    ex.printStackTrace(); // Log the error to help debug
                }
                    rec.setSalary(request.getParameter("salary"));
                    rec.setExp(request.getParameter("exp"));
                    rec.setDec(request.getParameter("des"));
                    String postType = request.getParameter("post_type");
                    rec.setPostType(postType); // You will need to add this setter in your Recruiter class

                    System.out.println("email " + rec.getRecemail());
                    System.out.println("password " + rec.getRecpwd());
                   
                     System.out.println("name " + rec.getRecfnm());
                      System.out.println("website " + rec.getComweb());
                       System.out.println("comnm " + rec.getComnm());
                        System.out.println("roll " + rec.getJr());
                         System.out.println("skill " + rec.getSkill());
                          System.out.println("location " + rec.getLoc());
                           System.out.println("deadline " + rec.getDeadline());
                            System.out.println("salary " + rec.getSalary());
                             System.out.println("exp " + rec.getExp());
                              System.out.println("description " + rec.getDec());
                              System.out.println("Post Type: " + postType);
                    java.util.Enumeration paramNames = request.getParameterNames();
                    while(paramNames.hasMoreElements()) {
                        String param = (String)paramNames.nextElement();
                        System.out.println(param + " = " + request.getParameter(param));
                    }
                    boolean save=utc.addRecruiter(rec);
                    if(save == true){
                    System.out.println("Saved? " + save);
                    response.sendRedirect("Login.jsp");
                    }
            }
            else{
            System.out.println("Invalid login fromat");
    }
//                   
        
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Register</title>\n");
      out.write("         <link href=\"https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;700&display=swap\" rel=\"stylesheet\">\n");
      out.write("         <link rel=\"stylesheet\" href=\"css/Register.css\">\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("window.onload = function () {\n");
      out.write("    const internshipBtn = document.getElementById(\"internshipToggle\");\n");
      out.write("    const jobBtn = document.getElementById(\"jobToggle\");\n");
      out.write("    const internshipFields = document.getElementById(\"internshipFields\");\n");
      out.write("    const jobFields = document.getElementById(\"jobFields\");\n");
      out.write("    const postTypeField = document.getElementById(\"postType\");\n");
      out.write("\n");
      out.write("    // Hide both initially and disable all inputs\n");
      out.write("    internshipFields.classList.add(\"hidden\");\n");
      out.write("    jobFields.classList.add(\"hidden\");\n");
      out.write("    disableInputs(internshipFields, true);\n");
      out.write("    disableInputs(jobFields, true);\n");
      out.write("\n");
      out.write("    // Jobseeker/Recruiter toggles (same as before)\n");
      out.write("    document.getElementById(\"jobseekerBtn\").addEventListener(\"click\", function () {\n");
      out.write("        document.getElementById(\"jobseekerForm\").classList.add(\"show\");\n");
      out.write("        document.getElementById(\"recruiterForm\").classList.remove(\"show\");\n");
      out.write("    });\n");
      out.write("\n");
      out.write("    document.getElementById(\"recruiterBtn\").addEventListener(\"click\", function () {\n");
      out.write("        document.getElementById(\"recruiterForm\").classList.add(\"show\");\n");
      out.write("        document.getElementById(\"jobseekerForm\").classList.remove(\"show\");\n");
      out.write("    });\n");
      out.write("\n");
      out.write("    // Internship button\n");
      out.write("    internshipBtn.addEventListener(\"click\", function () {\n");
      out.write("        postTypeField.value = \"internship\";\n");
      out.write("        internshipFields.classList.remove(\"hidden\");\n");
      out.write("        jobFields.classList.add(\"hidden\");\n");
      out.write("        disableInputs(internshipFields, false);\n");
      out.write("        disableInputs(jobFields, true);\n");
      out.write("        setRequired(internshipFields, true);\n");
      out.write("        setRequired(jobFields, false);\n");
      out.write("    });\n");
      out.write("\n");
      out.write("    // Job button\n");
      out.write("    jobBtn.addEventListener(\"click\", function () {\n");
      out.write("        postTypeField.value = \"job\";\n");
      out.write("        jobFields.classList.remove(\"hidden\");\n");
      out.write("        internshipFields.classList.add(\"hidden\");\n");
      out.write("        disableInputs(jobFields, false);\n");
      out.write("        disableInputs(internshipFields, true);\n");
      out.write("        setRequired(jobFields, true);\n");
      out.write("        setRequired(internshipFields, false);\n");
      out.write("    });\n");
      out.write("\n");
      out.write("    function disableInputs(container, shouldDisable) {\n");
      out.write("        container.querySelectorAll('input').forEach(input => input.disabled = shouldDisable);\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    function setRequired(container, required) {\n");
      out.write("        container.querySelectorAll('input').forEach(input => input.required = required);\n");
      out.write("    }\n");
      out.write("};\n");
      out.write("</script>\n");
      out.write("        <style>\n");
      out.write("             .btn-grp{\n");
      out.write("        display: flex;\n");
      out.write("        align-content: space-between;\n");
      out.write("        justify-content: center;\n");
      out.write("        margin-left: 10px;\n");
      out.write("    }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("  <div class=\"from-wrapper \">\n");
      out.write("   <h1>Register as :</h1>\n");
      out.write("   <div class=\"btn-grp\">\n");
      out.write("   <button id=\"jobseekerBtn\">Jobseeker</button>\n");
      out.write("   <button id=\"recruiterBtn\">Recruiter</button> \n");
      out.write("   </div>\n");
      out.write("    \n");
      out.write("   \n");
      out.write("   <div id=\"jobseekerForm\" class=\"hidden\">\n");
      out.write("        <form method=\"post\">\n");
      out.write("       <div class=\"form-group\">\n");
      out.write("           <label for=\"uid\">E-Mail</label> \n");
      out.write("           <input type=\"email\" name=\"uid\" placeholder=\"E-Mail\" />\n");
      out.write("       </div>\n");
      out.write("       \n");
      out.write("       <div class=\"form-group\"> \n");
      out.write("           <label for=\"unm\">Password</label> \n");
      out.write("           <input type=\"password\" name=\"pwd\" placeholder=\"Password\" />\n");
      out.write("       </div>\n");
      out.write("       \n");
      out.write("       <div class=\"form-group\"> \n");
      out.write("           <label for=\"unm\">Full Name</label>\n");
      out.write("           <input type=\"text\" name=\"unm\" placeholder=\"Full Name\" />\n");
      out.write("       </div>\n");
      out.write("       \n");
      out.write("      <div class=\"form-group\">\n");
      out.write("          <label for=\"phone\">Phone</label>\n");
      out.write("          <input type=\"tel\" name=\"phone\" placeholder=\"123-456-7890\" />\n");
      out.write("        </div>\n");
      out.write("       \n");
      out.write("       <div class=\"form-group\">\n");
      out.write("           <label for=\"dob\">Date of Birth</label>\n");
      out.write("           <input type=\"date\" name=\"dob\" />\n");
      out.write("       </div>\n");
      out.write("       \n");
      out.write("       <div class=\"form-group\"> \n");
      out.write("           <label for=\"gender\">Gender</label>\n");
      out.write("           <select name=\"gender\"> \n");
      out.write("               <option value=\"male\">Male</option>\n");
      out.write("               <option value=\"female\">Female</option>\n");
      out.write("               <option value=\"other\">Other</option> \n");
      out.write("           </select> \n");
      out.write("       </div>\n");
      out.write("       \n");
      out.write("       <div class=\"form-footer\">\n");
      out.write("          \n");
      out.write("           <input type=\"submit\" class=\"submit-btn\" name=\"btnsub\" value=\"Save Profile\">\n");
      out.write("           <div class=\"register\"> \n");
      out.write("               <p>Already have an account? <a href=\"Login.jsp\">Login here</a></p>\n");
      out.write("           </div>\n");
      out.write("           </form>\n");
      out.write("       </div>\n");
      out.write("   </div>\n");
      out.write("   \n");
      out.write("   \n");
      out.write("   \n");
      out.write("   <div id=\"recruiterForm\" class=\"hidden\"> \n");
      out.write("       <form method=\"post\">\n");
      out.write("       <div class=\"form-group\">\n");
      out.write("           <label for=\"cid\">Recruiter E-mail :</label>\n");
      out.write("           <input type=\"email\" name=\"recid\" placeholder=\"E-mail\" />\n");
      out.write("       </div> \n");
      out.write("       \n");
      out.write("        <div class=\"form-group\"> \n");
      out.write("           <label for=\"unm\">Password</label> \n");
      out.write("           <input type=\"password\" name=\"recpwd\" placeholder=\"Password\" />\n");
      out.write("       </div>\n");
      out.write("       \n");
      out.write("       <div class=\"form-group\"> \n");
      out.write("           <label for=\"unm\">Recruiter Name</label>\n");
      out.write("           <input type=\"text\" name=\"recfnm\" placeholder=\"Full Name\" />\n");
      out.write("       </div>\n");
      out.write("           \n");
      out.write("         <div class=\"form-group\">\n");
      out.write("           <label for=\"linkedin\">Company Website</label>\n");
      out.write("           <input type=\"url\" name=\"comweb\" placeholder=\"https://linkedin.com/in/username\" />\n");
      out.write("        </div>\n");
      out.write("       \n");
      out.write("       <div class=\"form-group\"> \n");
      out.write("           <label for=\"unm\">Company Name</label>\n");
      out.write("           <input type=\"text\" name=\"comnm\" placeholder=\"Full Name\" />\n");
      out.write("       </div>\n");
      out.write("\n");
      out.write("       <div class=\"form-group\">\n");
      out.write("      <label>Select Post Type:</label><br>\n");
      out.write("    <button type=\"button\" id=\"internshipToggle\">Internship</button>\n");
      out.write("    <button type=\"button\" id=\"jobToggle\">Job</button>\n");
      out.write("\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      <!-- Internship Fields -->\n");
      out.write("            <div id=\"internshipFields\" class=\"toggle-section hidden\">\n");
      out.write("               <div class=\"form-group\">\n");
      out.write("                   <label for=\"jr\">Internship Role:</label>\n");
      out.write("                   <input type=\"text\" name=\"jr\" placeholder=\"Frontend Intern\" />\n");
      out.write("               </div>\n");
      out.write("               <div class=\"form-group\">\n");
      out.write("                   <label for=\"skill\">Required Education :</label>\n");
      out.write("                   <input type=\"text\" name=\"skill\" placeholder=\"HTML, CSS, JS\" />\n");
      out.write("               </div>\n");
      out.write("               <div class=\"form-group\">\n");
      out.write("                   <label for=\"loc\">Location:</label>\n");
      out.write("                   <input type=\"text\" name=\"loc\" placeholder=\"Remote, Pune\" />\n");
      out.write("               </div>\n");
      out.write("                \n");
      out.write("                 <div class=\"form-group\">\n");
      out.write("                   <label for=\"deadline\">Apply Before:</label>\n");
      out.write("                   <input type=\"date\" name=\"deadline\" />\n");
      out.write("               </div>\n");
      out.write("                \n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                   <label for=\"stipend\">Stipend:</label>\n");
      out.write("                   <input type=\"text\" name=\"salary\" placeholder=\"5000 INR\" />\n");
      out.write("               </div>\n");
      out.write("                \n");
      out.write("               <div class=\"form-group\">\n");
      out.write("                   <label for=\"duration\">Duration:</label>\n");
      out.write("                   <input type=\"text\" name=\"exp\" placeholder=\"3 Months\" />\n");
      out.write("               </div>\n");
      out.write("                \n");
      out.write("                 <div class=\"form-group\">\n");
      out.write("                   <label for=\"des\">what'll You Learn :</label>\n");
      out.write("                   <input type=\"text\" name=\"des\" placeholder=\"what'll You Learn\" />\n");
      out.write("               </div>\n");
      out.write("               \n");
      out.write("              \n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!-- Job Fields -->\n");
      out.write("            <div id=\"jobFields\" class=\"toggle-section hidden\">\n");
      out.write("               <div class=\"form-group\">\n");
      out.write("                   <label for=\"jr\">Job Role:</label>\n");
      out.write("                   <input type=\"text\" name=\"jr\" placeholder=\"Java Full Stack\" />\n");
      out.write("               </div>\n");
      out.write("               <div class=\"form-group\">\n");
      out.write("                   <label for=\"skill\">Skills:</label>\n");
      out.write("                   <input type=\"text\" name=\"skill\" placeholder=\"Spring Boot, React\" />\n");
      out.write("               </div>\n");
      out.write("               <div class=\"form-group\">\n");
      out.write("                   <label for=\"loc\">Location:</label>\n");
      out.write("                   <input type=\"text\" name=\"loc\" placeholder=\"Bangalore\" />\n");
      out.write("               </div>\n");
      out.write("                \n");
      out.write("                 <div class=\"form-group\">\n");
      out.write("                <label for=\"deadline\">Deadline </label>\n");
      out.write("                <input type=\"date\" name=\"deadline\" />\n");
      out.write("               </div>\n");
      out.write("              \n");
      out.write("               <div class=\"form-group\">\n");
      out.write("                   <label for=\"salary\">Salary:</label>\n");
      out.write("                   <input type=\"text\" name=\"salary\" placeholder=\"6-8 LPA\" />\n");
      out.write("               </div>\n");
      out.write("                \n");
      out.write("                 <div class=\"form-group\">\n");
      out.write("                   <label for=\"exp\">Experience:</label>\n");
      out.write("                   <input type=\"text\" name=\"exp\" placeholder=\"2+ years\" />\n");
      out.write("               </div>\n");
      out.write("                \n");
      out.write("               <div class=\"form-group\">\n");
      out.write("                   <label for=\"des\">Description:</label>\n");
      out.write("                   <input type=\"text\" name=\"des\" placeholder=\"Job Description\" />\n");
      out.write("               </div>\n");
      out.write("            </div>\n");
      out.write("             <div class=\"form-footer\"> \n");
      out.write("                 <input type=\"hidden\" id=\"postType\" name=\"post_type\" value=\"\">\n");
      out.write("           <input type=\"submit\" class=\"submit-btn\" name=\"btnrecsub\" value=\"Save Profile\"> \n");
      out.write("           <div class=\"register\">\n");
      out.write("               <p>Already have an account? <a href=\"Login.jsp\">Login here</a></p> \n");
      out.write("           </div> \n");
      out.write("       </div>\n");
      out.write("           </form>\n");
      out.write("   </div> \n");
      out.write("   </div>\n");
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
