
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

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
    <title>Admin-Index- CarsWash- AutoWash</title>
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
   
   	<%@include file="admin-navbar.jsp" %>
    
  
     <!-- MENU SECTION END-->
    <div class="content-wrapper">
         <div class="container"> 
            <div class="row">
   
                <div class="col-12">
                     <div class="panel panel-info">
                        <div class="panel-heading">
                            <p>// Admin-Change-Password //</p>
                    		<h2>Admin-Change-Password</h2>
                        </div>
                        
                        <% String msg = (String)request.getAttribute("msg"); %>
		                <%if (msg!=null){ %>
		                <div class="section-header text-center">
		                    <h4><%out.print(msg);%></h4>
		                </div>
		                <%} %>
		                
		                
		                <% String msg1 = (String)request.getAttribute("msg1"); %>
		                <%if (msg1!=null){ %>
		                <div class="section-header text-center">
		                    <h4><%out.print(msg1);%></h4>
		                </div>
		                <%} %>
                        
                        <div class="panel-body">
                            <form action="AdminController" method="post">
								 <div class="form-group">
                                    <input type="hidden" class="form-control" id="email" name="email" placeholder="Your Email" value="<%=s.getEmail() %>" required="required" />
                                    <p class="help-block text-danger"></p>
                                </div>                                  
								 <div class="form-group">
                                	<label for="name">Your Old Password</label>
                                    <input type="password" class="form-control" id="password" name="op" placeholder="Your Old Password" required="required" />
                                    <p class="help-block text-danger"></p>
                                </div>                                  
								 <div class="form-group">
                                	<label for="name">Your New Password</label>
                                    <input type="password" class="form-control" id="password" name="np" placeholder="Your New Password" required="required" />
                                    <p class="help-block text-danger"></p>
                                </div>                                  
								 <div class="form-group">
                                	<label for="name">Confirm New Password</label>
                                    <input type="password" class="form-control" id="password" name="cnp" placeholder="Confirm New Password" required="required" />
                                    <p class="help-block text-danger"></p>
                                </div>                                  
								                             
									<div>
                                    <button class="btn btn-custom" type="submit" name="action" value="change password" >Change Password</button>
                                </div>
									
                                    </form>
                            </div>
                        </div>
                </div>

            </div>

   		 </div>
    </div>
     <!-- CONTENT-WRAPPER SECTION END-->
     
    <section class="footer-section">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                   &copy; 2014 Yourdomain.com |<a href="http://www.binarytheme.com/" target="_blank"  > Designed by : binarytheme.com</a> 
                </div>

            </div>
        </div>
    </section>
      <!-- FOOTER SECTION END-->
     
    
    <!-- JAVASCRIPT FILES PLACED AT THE BOTTOM TO REDUCE THE LOADING TIME  -->
    <!-- CORE JQUERY  -->
    <script src="assets/js/jquery-1.10.2.js"></script>
    <!-- BOOTSTRAP SCRIPTS  -->
    <script src="assets/js/bootstrap.js"></script>
      <!-- CUSTOM SCRIPTS  -->
    <script src="assets/js/custom.js"></script>
  
</body>
</html>

