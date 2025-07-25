<%@ page import="requirepackage.DBConnect" %>
<%@ page import="requirepackage.UserController" %>
<%@ page import="requirepackage.Internship" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%
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
%>

<!DOCTYPE html>
<html>
<head>
    <title>Post Internship or Job</title>
    <link rel="stylesheet" href="css/NewPost.css" />
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;700&display=swap" rel="stylesheet">
    <script>
  window.onload = function () {
    const internshipBtn = document.getElementById("internshipToggle");
    const jobBtn = document.getElementById("jobToggle");
    const postTypeField = document.getElementById("postType");

    internshipBtn.onclick = () => {
      postTypeField.value = "internship";
    };

    jobBtn.onclick = () => {
      postTypeField.value = "job";
    };
  };
</script>
</head>
<body>
<form method="post">
  <input type="hidden" id="postType" name="post_type" value="">

  <div class="form-group">
    <label for="recid">Recruiter Email:</label>
    <input type="email" name="recid" required />
  </div>

  <div class="form-group">
    <label for="comnm">Company Name:</label>
    <input type="text" name="comnm" required />
  </div>

  <!-- Shared Fields -->
  <div class="form-group">
    <label for="jr">Role:</label>
    <input type="text" name="jr" required />
  </div>

  <div class="form-group">
    <label for="skill">Skills / Education:</label>
    <input type="text" name="skill" required />
  </div>

  <div class="form-group">
    <label for="loc">Location:</label>
    <input type="text" name="loc" required />
  </div>

  <div class="form-group">
    <label for="deadline">Deadline:</label>
    <input type="date" name="deadline" />
  </div>

  <div class="form-group">
    <label for="salary">Salary / Stipend:</label>
    <input type="text" name="salary" />
  </div>

  <div class="form-group">
    <label for="exp">Experience / Duration:</label>
    <input type="text" name="exp" />
  </div>

  <div class="form-group">
    <label for="des">Description:</label>
    <input type="text" name="des" />
  </div>

  <div class="form-group">
    <label>Select Post Type:</label><br>
    <button type="button" id="internshipToggle">Internship</button>
    <button type="button" id="jobToggle">Job</button>
  </div>

  <div class="form-footer">
    <input type="submit" class="submit-btn" name="btnrecsub" value="Save Post">
  </div>
</form>

</body>
</html>
