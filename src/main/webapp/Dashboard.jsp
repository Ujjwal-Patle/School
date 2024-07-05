<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="jakarta.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Form</title>
    <link rel="stylesheet" href="DashboardStyle.css">
    <script src="https://kit.fontawesome.com/d3cfb2a8f7.js" crossorigin="anonymous"></script>
</head>
<body>
    <header class="header">
        
            <img  src="vnps.png" alt="VNPS_Logo">
      
        <div class="headerRight">
            <h1 class="heading">VIDYA NIKETAN PUBLIC SCHOOL</h1>
            <div class="text">Play Gr., Nur., KG I-II & std Ist to std. 12th</div>
        </div>
    </header>

    <main class="main">
        <section class="body">
            <h1>Welcome <%= request.getAttribute("adminName") %> Dashboard</h1>
            <div class="mainSec">
                <div class="buttons">
                    <a href="RegForm.html" class="button">Register</a>
                    <a href="UpdateStudent.html" class="button">Update</a>
                    <a href="Delete.html" class="button">Delete</a>
                    <a href="DCertificate.html" class="button" >Certificate</a>
                </div>
                <div class="logoutSec">
                    <a href="logout"  class="logout">Logout</a>
                </div>
            </div>
        </section>
    </main>

    <footer class="footer">
        <div class="sec">
            <div class="container"><i class="fa-solid fa-location-dot"></i> Address <br><br>
                Near Bharat Driving School Kudwa,
                Gondia, Maharashtra</div>
        </div>
        <div class="sec">
            <div class="container">
                <i class="fa-solid fa-location-dot"></i> Location <br><br> <a
                    href="https://maps.app.goo.gl/KwYckvV3gGVYKY6J6" target="_blank">Click
                    here for location in Map</a>
            </div>
        </div>
        <div class="sec">
            <div class="container">
                <i class="fa-solid fa-address-book"></i> Contact <br><br> 0000000000
                <br><br>vnps.gondia@gmail.com
            </div>
        </div>
    </footer>
</body>
</html>
