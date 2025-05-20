<%-- 
    Document   : Resister.html
    Created on : May 16, 2025, 7:13:08 PM
    Author     : Rahul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <style>
           body {
      margin: 0;
     
      display: flex;
      justify-content: center;
      align-items: center;
      min-height: 100vh;
         margin: 0;
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
       background-image: linear-gradient(120deg, #84fab0 0%, #8fd3f4 100%);
    }

    .form-wrapper {
      background: #fff;
      padding: 2.5rem;
      border-radius: 20px;
      box-shadow: 0 10px 25px rgba(0, 0, 0, 0.1);
      max-width: 1000px;
      width: 100%;
      margin: 2rem;
    }

    .form-wrapper h1 {
      text-align: center;
      margin-bottom: 2rem;
      color: #333;
    }

    .form-grid {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
      gap: 1.5rem;
    }

    .form-group {
      display: flex;
      flex-direction: column;
    }

    .form-group label {
      font-weight: 600;
      margin-bottom: 0.5rem;
      color: #555;
    }

    .form-group input,
    .form-group select,
    .form-group textarea {
      padding: 0.8rem;
      border: 1px solid #ccc;
      border-radius: 10px;
      font-size: 1rem;
      background-color: #f9f9f9;
      transition: border-color 0.3s;
    }

    .form-group input:focus,
    .form-group select:focus,
    .form-group textarea:focus {
      border-color: #fda085;
      background-color: #fff;
      outline: none;
    }

    .form-footer {
      text-align: center;
      margin-top: 2rem;
    }

    .submit-btn {
      background: linear-gradient(to right, #f6d365, #fda085);
      padding: 0.9rem 2rem;
      border: none;
      border-radius: 12px;
      font-size: 1rem;
      font-weight: 600;
      color: white;
      cursor: pointer;
      transition: background 0.3s ease;
    }

    .submit-btn:hover {
      background: linear-gradient(to right, #fda085, #f6d365);
    }

    @media (max-width: 600px) {
      .form-wrapper {
        padding: 1.5rem;
      }
    }  
        </style>
    </head>
    <body>
      <div class="form-wrapper">
    <h1>Registration</h1>
    <form action="Internship.jsp" method="POST">
      <div class="form-grid">
        
        <div class="form-group">
          <label for="uid">User ID</label>
          <input type="text" id="uid" name="uid" placeholder="User ID" required />
        </div>
          
        <div class="form-group">
          <label for="unm">Full Name</label>
          <input type="text" id="unm" name="unm" placeholder="Full Name" required />
        </div>

        <div class="form-group">
          <label for="email">Email</label>
          <input type="email" id="email" placeholder="abc@gmail.com" required />
        </div>
        
          
        <div class="form-group">
          <label for="phone">Phone</label>
          <input type="tel" id="phone" placeholder="123-456-7890" />
        </div>

        <div class="form-group">
          <label for="dob">Date of Birth</label>
          <input type="date" id="dob" />
        </div>

        <div class="form-group">
          <label for="gender">Gender</label>
          <select id="gender">
            <option value="">Select</option>
            <option value="male">Male</option>
            <option value="female">Female</option>
            <option value="other">Other</option>
          </select>
        </div>       
          
        <div class="form-group">
          <label for="City">City</label>
           <input type="text" id="unm" name="city" placeholder="City" required />
        </div>
          
           <div class="form-group">
          <label for="website">Married Status</label>
          <select name="status">
              <option>Unmarried</option>
              <option>Married</option>
          </select>
        </div>
      </div>
        
      <div class="form-footer">
        <button type="submit" class="submit-btn">Save Profile</button>
        <div class="register">
        <p>Already have an account? <a href="Login.jsp">Login here</a></p>
        </div>
      </div>
    </form>
  </div>

    </body>
</html>
