<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import = " model.Admin" %>
 	<%@page import = " dao.AdminDao" %>
 	<%@page import = " model.ServiceMan" %>
 	<%@page import = " dao.ServicemanDao" %>
 	<%@page import="java.util.List"%>
 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <!--[if IE]>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <![endif]-->
    <title>Admin- Navbar- CarsWash- AutoWash</title>
    <!-- BOOTSTRAP CORE STYLE  -->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FONT AWESOME STYLE  -->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <!-- CUSTOM STYLE  -->
    <link href="assets/css/style.css" rel="stylesheet" />
    <!-- GOOGLE FONT -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />

</head>
<body>

	 <% Admin s = null;
        if(session.getAttribute("data") != null){
        	s= (Admin) session.getAttribute("data");
        }
        else{
        	response.sendRedirect("admin-login.jsp");
        }
        %>
    <div class="navbar navbar-inverse set-radius-zero" >
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="admin-home.jsp">

                    <img src="assets/img/logo.png" />
                </a>

            </div>

            <div class="right-div">
                <a href="admin-logout.jsp" class="btn btn-danger pull-right" >LOG ME OUT</a>
            </div>
        </div>
    </div>
    <!-- LOGO HEADER END-->
    <section class="menu-section">
        <div class="container">
            <div class="row ">
                <div class="col-md-12">
                    <div class="navbar-collapse collapse ">
                        <ul id="menu-top" class="nav navbar-nav navbar-right">
                            <li><a href="admin-home.jsp" class="menu-top-active"><span>DASHBOARD</span></a></li>
                            <li><a href="admin-serviceman-list.jsp" class="active"><span>ServiceMan</span></a></li>
                            <li><a href="admin-customer-list.jsp" class="active"><span>Customers</span></a></li>
                            <li>
                                <a href="#" class="dropdown-toggle" id="ddlmenuItem" data-toggle="dropdown" class="active"><span>Services</span><i class="fa fa-angle-down"></i></a>
                                <ul class="dropdown-menu" role="menu" aria-labelledby="ddlmenuItem">
                                     <li role="presentation"><a role="menuitem" tabindex="-1" href="admin-services-list.jsp" class="active"><span>Services</span></a></li>
                                    <li role="presentation"><a role="menuitem" tabindex="-1" href="admin-bookservices-list.jsp" class="active"><span>Book Services</span></a></li>
                                </ul>
                            </li>
                            <li>
                                <a href="#" class="dropdown-toggle" id="ddlmenuItem" data-toggle="dropdown" class="active"><span>Admin</span><i class="fa fa-angle-down"></i></a>
                                <ul class="dropdown-menu" role="menu" aria-labelledby="ddlmenuItem">
                                     <li role="presentation"><a role="menuitem" tabindex="-1" href="admin-profile.jsp" class="active"><span>Profile</span></a></li>
                                    <li role="presentation"><a role="menuitem" tabindex="-1" href="admin-change-password.jsp" class="active"><span>Change Password</span></a></li>
                                </ul>
                            </li>

                        </ul>
                    </div>
                </div>

            </div>
        </div>
    </section>
         
    
    
  
</body>
</html>
