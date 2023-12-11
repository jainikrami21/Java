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
    
    <div id="page-wrapper">
        <div class="col-md-12 graphs">
	   <div class="xs">
  	 <h3>Basic Tables</h3>
  	<div class="bs-example4" data-example-id="contextual-table">
    <table class="table">
      <thead>
        <tr>
          <th>Id</th>
          <th>Name</th>
          <th>Contact</th>
          <th>Address</th>
          <th>Email</th>
          <th>Edit</th>
          <th>Delete</th>
        </tr>
      </thead>
      <tbody>
      <%List<Seller> list = SellerDao.getAllSellers(); %>
      <%for(Seller s1:list){ %>
        <tr class="active">
          <th scope="row"><%=s1.getId() %></th>
          <td><%=s1.getName() %></td>
          <td><%=s1.getContact() %></td>
          <td><%=s1.getAddress() %></td>
          <td><%=s1.getEmail() %></td>
          <td><a href="admin-seller-edit.jsp?id=<%=s1.getId()%>">Edit</a></td>
          <td><a href="admin-seller-delete.jsp?id=<%=s1.getId()%>">Delete</a></td>
        </tr>
       <%} %>
      </tbody>
    </table>
   </div>
	
  </div>
  <div class="copy_layout">
      <p>Copyright © 2015 Modern. All Rights Reserved | Design by <a href="http://w3layouts.com/" target="_blank">W3layouts</a> </p>
  </div>
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