<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import = " model.Customer" %>
 <%@page import = " dao.CustomerDao" %>
    
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Customer - Navbar - AutoWash - Car Wash Website Template</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Free Website Template" name="keywords">
        <meta content="Free Website Template" name="description">

        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Barlow:wght@400;500;600;700;800;900&display=swap" rel="stylesheet"> 
        
        <!-- CSS Libraries -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link href="lib/flaticon/font/flaticon.css" rel="stylesheet">
        <link href="lib/animate/animate.min.css" rel="stylesheet">
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

        <!-- Template Stylesheet -->
        <link href="css/style.css" rel="stylesheet">
    </head>

    <body>
        
        
         <% Customer s = null;
        if(session.getAttribute("data") != null){
        	s= (Customer) session.getAttribute("data");
        }
        else{
        	response.sendRedirect("customer-login.jsp");
        }
        %>

 <!-- Nav Bar Start -->
        <div class="nav-bar">
            <div class="container">
                <nav class="navbar navbar-expand-lg bg-dark navbar-dark">
                    <a href="index.jsp" class="navbar-brand">CarWash</a>
                    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                        <div class="navbar-nav mr-auto">
                        <a href="customer-home.jsp" class="nav-item nav-link active">Home</a>
                         <div class="nav-item dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Show Services</a>
                                <div class="dropdown-menu ">
                                    <a href="customer-show-service.jsp" class="dropdown-item">Show Service</a>
                                </div>
                            </div>
                            <div class="nav-item dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Booked Services</a>
                                <div class="dropdown-menu ">
                                    <a href="customer-pending-service.jsp" class="dropdown-item">Pending Service</a>
                                    <a href="customer-completed-service.jsp" class="dropdown-item">Completed Service</a>
                                    <a href="customer-rejected-service.jsp" class="dropdown-item">Rejected Service</a>
                                </div>
                            </div>
                            <div class="nav-item dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown"><%=s.getName()%></a>
                                <div class="dropdown-menu ">
                                    <a href="customer-profile.jsp" class="dropdown-item">Profile</a>
                                    <a href="customer-change-password.jsp" class="dropdown-item">Change Password</a>
                                    <a href="customer-logout.jsp" class="dropdown-item">Logout</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
        <!-- Nav Bar End -->
        
       
       

        
    </body>
</html>
