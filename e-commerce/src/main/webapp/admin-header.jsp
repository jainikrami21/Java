
<%@page import="Dao.SellerDao"%>
<%@page import="Model.Seller"%>
<%@page import="Dao.UserDao"%>
<%@page import="Model.User"%>
<%@page import="java.util.List"%>
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
                
                <div class="col-6">
                <form class="navbar-form navbar-right">
      <input type="text" class="form-control" value="Search..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search...';}">
    </form>
    </div>
                    <nav class="main-nav">
                     
                     <!-- ***** Logo Start ***** -->
                        <a href="index.jsp" class="logo">
                            <p>E-Commerce Website</p>
                        </a>
                        <!-- ***** Logo End ***** -->
                        <!-- ***** Menu Start ***** -->
                        
                        <ul class="nav">
                    <li class="scroll-to-section"><a href="admin-home.jsp" class="active">Home</a></li>
                    <li class="scroll-to-section"><a href="#men">Men's</a></li>
                    <li class="scroll-to-section"><a href="#women">Women's</a></li>
                    <li class="scroll-to-section"><a href="#kids">Kid's</a></li>
                    <li class="submenu">
                        <a href="javascript:;">Pages</a>
                        <ul>
                            <li><a href="admin-sellers-list.jsp">Sellers</a></li>
                            <li><a href="admin-user-list.jsp">Customers</a></li>
                            <li><a href="admin-product-list.jsp">Products</a></li>                                    
                            <li><a href="total-payment-list.jsp">Payments</a></li>
                        </ul>
                     
                    </li>
 					<li><a href="admin-logout.jsp">Logout</a></li>                                               
                </ul>  
                           
                    </nav>
                </div>
            </div>
        </div>
    </header>
    
    <!-- ***** Header Area End ***** -->

  

  </body>
</html>