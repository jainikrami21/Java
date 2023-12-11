


<%@page import="Model.Seller"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    


<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900&display=swap" rel="stylesheet">

    <title> E-commerce Website</title>
	
	 <!-- Additional Bootstrap Files -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
   
    <!-- Additional CSS Files -->
    <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">

    <link rel="stylesheet" type="text/css" href="assets/css/font-awesome.css">

    <link rel="stylesheet" href="assets/css/templatemo-hexashop.css">

    <link rel="stylesheet" href="assets/css/owl-carousel.css">

    <link rel="stylesheet" href="assets/css/lightbox.css">

    </head>
    
    <body>
    
    
    
    <% Seller s = null;
        if(session.getAttribute("data") != null){
        	s = (Seller) session.getAttribute("data");
        }
        else{
        	response.sendRedirect("seller-login.jsp");
        }
        %>
    
    <!-- ***** Preloader Start ***** -->
    <div id="preloader">
        <div class="jumper">
            <div></div>
            <div></div>
            <div></div>
        </div>
    </div>  
    <!-- ***** Preloader End ***** -->
    
    
    <!-- ***** Header Area Start ***** -->
    <header class="header-area header-sticky">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav class="main-nav">
                     
                     <!-- ***** Logo Start ***** -->
                        <a href="index.jsp" class="logo">
                            <p>E-Commerce Website</p>
                        </a>
                        <!-- ***** Logo End ***** -->
                        <!-- ***** Menu Start ***** -->
                        <ul class="nav">
                            <li class="scroll-to-section"><a href="seller-index.jsp" class="active">Home</a></li>
                            <li class="scroll-to-section"><a href="#men">Men's</a></li>
                            <li class="scroll-to-section"><a href="#women">Women's</a></li>
                            <li class="scroll-to-section"><a href="#kids">Kid's</a></li>
                            <li class="submenu">
                                <a href="javascript:;">Pages</a>
                                <ul>
                                    <li><a href="about.jsp">About Us</a></li>
                                    <li><a href="contact.jsp">Contact Us</a></li>
                                </ul>
                            </li>
                             <li class="submenu">
                                <a href="javascript:;">Products</a>
                                <ul>
                                    <li><a href="seller-upload-product.jsp">Upload Products</a></li>                                    
                                    <li><a href="single-product.jsp">Single Products</a></li>
                                    <li><a href="seller-manage-product.jsp">Manage Products</a></li>
                                </ul>
                            </li>                            
                            <li class="submenu">
                                <a href="#"><%=s.getName()%></a>
                                <ul>
                                	<li class="scroll-to-section"><a href="seller-profile.jsp">Profile</a></li>
									<li class="scroll-to-section"><a href="seller-change-password.jsp">Change Password</a></li>
                                   <li class="scroll-to-section"><a href="seller-logout.jsp">Logout</a></li>
                                </ul>
                            </li>
                            
                        </ul>        
                    </nav>
                </div>
            </div>
        </div>
    </header>
    <!-- ***** Header Area End ***** -->

  

  </body>
</html>