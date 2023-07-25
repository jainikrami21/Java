<%@page import="dao.ServiceDao"%>
<%@page import="model.Serviceman_Services"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<meta name="description" content="" />
<meta name="author" content="" />
<!--[if IE]>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <![endif]-->
<title>Admin- Serviceman-Edit-List- CarsWash- AutoWash</title>
<!-- BOOTSTRAP CORE STYLE  -->
<link href="assets/css/bootstrap.css" rel="stylesheet" />
<!-- FONT AWESOME STYLE  -->
<link href="assets/css/font-awesome.css" rel="stylesheet" />
<!-- CUSTOM STYLE  -->
<link href="assets/css/style.css" rel="stylesheet" />
<!-- GOOGLE FONT -->
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />

</head>
<body>

	<%@include file="admin-navbar.jsp"%>



	<!-- MENU SECTION END-->
	<div class="content-wrapper">
		<div class="container">
			<div class="row pad-botm">
				<div class="col-md-12">
					<h4 class="header-line">Services Edit List</h4>

				</div>

			</div>
        <%int id=Integer.parseInt(request.getParameter("id")); %>
        <%Serviceman_Services s1 = ServiceDao.getSingleServiceman_ServicesBySid(id); %>
                
                     <div class="col-md-7">
                        <div class="contact-form">
                            <div id="success"></div>
                            <form action="ServiceController" method="post" >
                                <div class="control-group">
                                	<label for="name">Services Id</label>
                                    <input type="text" class="form-control" id="name" name="id" value="<%=s1.getSid()%>" required="required" />
                                    <p class="help-block text-danger"></p>
                                </div>
                                <div class="control-group">
                                	<label for="name">Stype</label>
                                    <input type="text" class="form-control" id="name" name="stype"  value="<%=s1.getStype()%>" required="required" />
                                    <p class="help-block text-danger"></p>
                                </div>
                                <div class="control-group">
                                	<label for="name">Car Model</label>
                                    <input type="text" class="form-control" id="name" name="cmodel"  value="<%=s1.getCar_model()%>" required="required" />
                                    <p class="help-block text-danger"></p>
                                </div>
                                <div class="control-group">
                                	<label for="email">Price</label>
                                    <input type="number" class="form-control" id="email" name="sprice" value="<%=s1.getSprice()%>" required="required" />
                                    <p class="help-block text-danger"></p>
                                </div>
                                <div class="control-group">
                                	<label for="name">Duration</label>
                                    <input type="text" class="form-control" id="name" name="duration"  value="<%=s1.getDuration()%>" required="required" />
                                    <p class="help-block text-danger"></p>
                                </div>
                                <div>
                                    <button class="btn btn-custom" name="action" value="edit" type="submit" >Update</button>
                                </div>
                            </form>
                        </div>
                    </div>
                    
                </div>
            </div>
        <!-- Contact End -->
			

		



	<section class="footer-section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					&copy; 2014 Yourdomain.com |<a href="http://www.binarytheme.com/"
						target="_blank"> Designed by : binarytheme.com</a>
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