<%@ page import="java.sql.*" %>
<%@ page import="requirepackage.DBConnect" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Search Results</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body class="bg-light">
<div class="container py-5">
  <h2 class="mb-4">Search Results</h2>

<%
String query = request.getParameter("query");
if (query == null || query.trim().isEmpty()) {
%>
  <div class="alert alert-warning">Please enter a search term.</div>
<%
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
%>
      <div class="card mb-3 p-3 shadow-sm">
        <h5><%= rs.getString("jobroll") %> <small class="text-muted">(<%= rs.getString("post_type") %>)</small></h5>
        <p><strong>Company:</strong> <%= rs.getString("comname") %></p>
        <p><strong>Location:</strong> <%= rs.getString("loc") %></p>
        <p><strong>Salary:</strong> <%= rs.getString("salary") %></p>
        <p><strong>Skills:</strong> <%= rs.getString("skill") %></p>
        <p><strong>Description:</strong> <%= rs.getString("des") %></p>
      </div>
<%
    }
    if (!found) {
%>
      <div class="alert alert-info">No results found for "<%= query %>"</div>
<%
    }
  } catch (Exception e) {
    out.println("<div class='alert alert-danger'>Error: " + e.getMessage() + "</div>");
  } finally {
    if (rs != null) rs.close();
    if (pst != null) pst.close();
    if (conn != null) conn.close();
  }
}
%>
</div>
</body>
</html>
