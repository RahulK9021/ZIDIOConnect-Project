<%-- 
    Document   : PixelPoint
    Created on : May 22, 2025, 1:19:48 PM
    Author     : Rahul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pixelpoint Company</title>
        <!--<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet"/>-->
         <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
  <style>
    :root {
      --primary: #4f46e5;
      --secondary: #9333ea;
      --light-bg: #f4f4f9;
      --text-dark: #333;
    }

    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
    }

    body {
      font-family: 'Poppins', sans-serif;
      background-color: var(--light-bg);
      color: var(--text-dark);
      line-height: 1.6;
    }

    header {
      background: linear-gradient(135deg, var(--primary), var(--secondary));
      color: white;
      padding: 5rem 2rem;
      text-align: center;
      position: relative;
      overflow: hidden;
    }

    header h1 {
      font-size: 3rem;
      margin-bottom: 1rem;
    }

    header p {
      font-size: 1.2rem;
      max-width: 800px;
      margin: auto;
      margin-bottom: 100px;
    }

    header .wave {
      position: absolute;
      bottom: -1px;
      left: 0;
      width: 100%;
    }

    nav {
      display: flex;
      justify-content: space-between;
      align-items: center;
      padding: 1.2rem 2rem;
      background: white;
      box-shadow: 0 2px 6px rgba(0,0,0,0.1);
    }

    nav .logo {
      font-weight: 600;
      font-size: 1.4rem;
      color: var(--primary);
    }

    nav ul {
      list-style: none;
      display: flex;
      gap: 1.5rem;
    }

    nav ul li a {
      text-decoration: none;
      color: #333;
      font-weight: 500;
      transition: color 0.3s;
    }

    nav ul li a:hover {
      color: var(--secondary);
    }

    .section {
      padding: 4rem 2rem;
      max-width: 1200px;
      margin: auto;
    }

    .section h2 {
      text-align: center;
      margin-bottom: 2rem;
      font-size: 2rem;
      color: var(--primary);
    }

    .cards {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
      gap: 2rem;
    }

    .card {
      background: white;
      padding: 2rem;
      border-radius: 1rem;
      box-shadow: 0 8px 20px rgba(0,0,0,0.05);
      text-align: center;
      transition: transform 0.3s;
    }

    .card:hover {
      transform: translateY(-5px);
    }

    .card img {
      width: 60px;
      margin-bottom: 1rem;
    }

    .team .card img {
      border-radius: 50%;
      width: 100px;
      height: 100px;
      object-fit: cover;
    }

    .btn {
      display: inline-block;
      padding: 0.8rem 2rem;
      margin-top: 1.5rem;
      background: var(--secondary);
      color: white;
      border: none;
      border-radius: 30px;
      font-weight: bold;
      transition: background 0.3s;
      text-decoration: none;
    }

    .btn:hover {
      background: var(--primary);
    }

    footer {
      text-align: center;
      background: #222;
      color: white;
      padding: 2rem 1rem;
    }

    @media (max-width: 600px) {
      header h1 {
        font-size: 2rem;
      }
    }
  </style>
    </head>
<body>


  

  <header>
    <h1>Innovate. Create. Elevate.</h1>
    <p>VisionaryTech helps your business grow with cutting-edge digital solutions and creative strategies.</p>
    <a href="#services" class="btn">Our Services</a>
    <svg class="wave" viewBox="0 0 1440 320"><path fill="#f4f4f9" fill-opacity="1" d="M0,160L80,154.7C160,149,320,139,480,138.7C640,139,800,149,960,165.3C1120,181,1280,203,1360,213.3L1440,224L1440,320L1360,320C1280,320,1120,320,960,320C800,320,640,320,480,320C320,320,160,320,80,320L0,320Z"></path></svg>
  </header>
    <section class="section">
         <h2>About Us</h2>
        <p>At the heart of <b> PixelPoint Inc.</b> is our mission to transform the future of technology by developing innovative solutions that address real-world challenges,
            enhancing everyday life, and expanding the realm of possibilities. Our vision propels us to be leaders in technological advancements, striving to be the primary 
            source for tech solutions globally. 
            We are driven by core values of relentless innovation, unwavering excellence, collaborative teamwork, ethical integrity, and a customer-focused approach.</p>
        
    </section>
  <section id="services" class="section">
    <h2>Our Services</h2>
    <div class="cards">
      <div class="card">
        <img src="https://img.icons8.com/fluency/48/web.png" alt="Web Development"/>
        <h3>Web Development</h3>
        <p>Beautiful, fast, and responsive websites tailored for your brand.</p>
      </div>
      <div class="card">
        <img src="https://img.icons8.com/fluency/48/android-os.png" alt="App Development"/>
        <h3>Mobile Apps</h3>
        <p>iOS and Android apps that deliver exceptional user experiences.</p>
      </div>
      <div class="card">
        <img src="https://img.icons8.com/fluency/48/cloud.png" alt="Cloud Solutions"/>
        <h3>Cloud Solutions</h3>
        <p>Scalable infrastructure to power your business globally, 24/7.</p>
      </div>
    </div>
  </section>

  <section id="team" class="section team">
    <h2>Meet the Team</h2>
    <div class="cards">
      <div class="card">
        <img src="https://randomuser.me/api/portraits/men/32.jpg" alt="CEO"/>
        <h3>Alex Johnson</h3>
        <p>CEO & Visionary</p>
      </div>
      <div class="card">
        <img src="https://randomuser.me/api/portraits/women/44.jpg" alt="CTO"/>
        <h3>Lisa Brown</h3>
        <p>CTO & Head of Engineering</p>
      </div>
      <div class="card">
        <img src="https://randomuser.me/api/portraits/men/64.jpg" alt="Designer"/>
        <h3>Michael Chen</h3>
        <p>Creative Director</p>
      </div>
    </div>
  </section>

  <footer id="contact">
    <p>📧 contact@visionarytech.com | 📞 +1 (800) 987-6543</p>
    <p>© 2025 VisionaryTech. All rights reserved.</p>
  </footer>

</body>
</html>

   
