<%@page import="Dao.SellerDao"%>
<%@page import="Model.Seller"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@include file="admin-header.jsp" %>
    
    <div id="wrapper">
        
  <%int id = Integer.parseInt(request.getParameter("id")); %>
						<%Seller s1 = SellerDao.getSellerById(id); %>
	<div id="page-wrapper">
	<div class="col-md-12 graphs">
	  <section class="ab-info-main py-5">
		<div class="container py-3">
			<h3 class="tittle text-center">
				<span class="sub-tittle">Find Us</span> Seller Edit Product
			</h3>
			<div class="row contact-main-info mt-5">
				<div class="col-md-12 contact-right-content">
					<form id="subscribe" action="ProductController" method="post" enctype="multipart/form-data" >
	 							
	 							
                                <div class="control-group">
                                <label for="name">ID</label>
                                    <input type="number" class="form-control" id="Id" name="sid" placeholder="Seller Id" value="<%=s1.getId()%>" required="required" />
                                    <p class="help-block text-danger"></p>
                                </div>
                                <div class="control-group">
                                	<label for="name">Name</label>
                                    <input type="text" class="form-control" id="name" name="name" placeholder="Name" value="<%=s1.getName() %>" required="required" />
                                    <p class="help-block text-danger"></p>
                                </div>
                                <div class="control-group">
                                	<label for="name">Contact</label>
                                    <input type="text" class="form-control" id="contact" name="contact" placeholder="Contact" Value="<%=s1.getContact()%>" required="required" />
                                    <p class="help-block text-danger"></p>
                                </div>
                                <div class="control-group">
                                	<label for="name">Address</label>
                                    <input type="text" class="form-control" id="address" name="address" placeholder="Address" value="<%=s1.getAddress() %>" required="required" />
                                    <p class="help-block text-danger"></p>
                                </div>
                                <div class="control-group">
                                	<label for="name">Email</label>
                                    <input type="email" class="form-control" id="email" name="email" placeholder="Email" value="<%=s1.getEmail() %>" required="required" />
                                    <p class="help-block text-danger"></p>
                                </div>
                                <div class="control-group">
                                
                             
                                <div>
                                    <button class="btn btn-custom" name="action" value="update" type="submit" >Update</button>
                                </div>
                            </form>
				</div>
	

			</div>
		</div>
	</section>
	</div>
      </div>
      <!-- /#page-wrapper -->
	 </div>
    <!-- /#wrapper -->
  
   
    <div class="copy_layout">
      <p>Copyright © 2015 Modern. All Rights Reserved | Design by <a href="http://w3layouts.com/" target="_blank">W3layouts</a> </p>
  </div>
   
  
    

    
</body>
</html>