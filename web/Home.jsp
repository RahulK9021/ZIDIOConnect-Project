<%-- 
    Document   : Homez
    Created on : May 16, 2025, 9:02:10 PM
    Author     : Rahul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        
        <link rel="stylesheet" href="css/Home.css" />
         <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;700&display=swap" rel="stylesheet">
  <style>
    body {
      margin: 0;
      font-family: 'Inter', sans-serif;
      background: #f4f7fa;
      color: #333;
    }
    header {
      background: linear-gradient(to right, #0052cc, #007fff);
      color: white;
      padding: 60px 20px;
      text-align: center;
      position: relative;
    }
    header h1 {
      font-size: 48px;
      margin-bottom: 10px;
    }
    header p {
      font-size: 20px;
    }
    .search-bar {
      margin-top: 30px;
      display: flex;
      justify-content: center;
    }
    .search-bar input {
      padding: 15px;
      font-size: 16px;
      width: 250px;
      border: none;
      border-radius: 10px 0 0 10px;
    }
    .search-bar button {
      padding: 15px;
      background: gold;
      border: none;
      border-radius: 0 10px 10px 0;
      font-weight: bold;
      cursor: pointer;
    }
    .features {
      display: flex;
      justify-content: space-around;
      padding: 50px 20px;
      background: white;
    }
    .feature-box {
      max-width: 300px;
      text-align: center;
    }
    .feature-box img {
      width: 80px;
      height: 80px;
    }
    .testimonials {
      background: #eef2f5;
      padding: 60px 20px;
      text-align: center;
    }
    .testimonial {
      max-width: 600px;
      margin: 20px auto;
      font-style: italic;
    }
    .cta-banner {
      background: #0052cc;
      color: white;
      text-align: center;
      padding: 40px 20px;
      font-size: 24px;
      font-weight: bold;
    }
    footer {
      background: #002f6c;
      color: white;
      padding: 20px;
      text-align: center;
    }
     button {
    background: #5d9592;
    color: black;
    cursor: pointer;
    margin-top: 15px;
    padding: 12px;
    font-size: 16px;
    border-radius: 5px;
    border: none;
    transition: all 0.3s ease-in-out;
}

button:hover {
    background: #0056b3;
    box-shadow: 0px 5px 10px rgba(0, 114, 255, 0.3);
}
.vl {
 border-left: 6px solid green;
  height: 500px;
  position: absolute;
  left: 50%;
  margin-left: -3px;
  top: 0;
}
a{
    text-decoration: none;
    color: black;
}
  </style>
    </head>
    <body>
   <header>
    <h1>Unleash Your Potential With ZIDIOConnect</h1>
     <b>We connect talent with opportunity — globally.</b><br>
      <b>"Opportunities Aren’t Found. They’re Created — Start Here."</b>
  </header>

  <section class="features">
    <div class="feature-box">
      <img src="https://img.icons8.com/ios-filled/100/briefcase.png" alt="Easy Search">
      <h3>Easy Search</h3>
      <p>Quickly find the jobs that match your skills and goals.</p>
    </div>
    <div class="feature-box">
      <img src="https://img.icons8.com/ios-filled/100/shield.png" alt="Verified Employers">
      <h3>Verified Employers</h3>
      <p>Apply with confidence to trusted companies.</p>
    </div>
      <div class="feature-box" style="padding-down:100px">
      <img src="images/career.jpg" alt="Career Resources" style="height: 100px;width: 100px">
      <h3>Career Resources</h3>
      <p>Access tips, guides, and tools to grow your career.</p>
    </div>
  </section>
  <section class="testimonials">
  <div class="testimonial">
      At <b>ZIDIOConnect </b>, we believe in meaningful employment. Our platform helps professionals find the right job and enables companies to discover top talent. With advanced matching algorithms and a human-centered approach, we stand as a reliable bridge between job seekers and employers.
      Provides <b>internships</b> for growing your knowledge , and also give the platform to talented candidates to search a <b>job</b>.
  </div>
  </section>
  <section class="testimonials">
    <h2>What Our Users Say</h2>
    <div class="testimonial">
      "Thanks to ZIDIOConnect, I found a job I love in just two weeks!" – <strong>Gourav Gaikwad</strong>
    </div>
    <div class="testimonial">
      "The platform is super easy to use and has tons of real opportunities." – <strong>Ashish P</strong>
    </div>
  </section>
  <form action="Register.jsp">
    <div class="cta-banner">
        Join Thousands Building Their Future  <br><button class="btn">Sign Up Today !!</button> <button><a href="Login.jsp"> Login !!</a></button>
    </div>
      
        
   
  <footer>
    &copy; 2025 ZIDIOConnect. All rights reserved.
  </footer>
</body>
</html>

    
