<%@page import="com.controller.User"%>
<%@page import="java.util.List"%>
<%@page import="com.controller.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Hello Home Page

${list}

<!-- MENU SECTION END-->
	<div class="content-wrapper">
		<div class="container">
			<div class="row pad-botm">
				<div class="col-md-12">
					<h4 class="header-line">User</h4>

				</div>

			</div>
			<div class="row">
				<div class="col-md-12">
					<!--   Basic Table  -->
					<div class="panel panel-default">
						<div class="panel-heading">User Table</div>
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table">
									<thead>
										<tr>
											<th>ID</th>
											<th>NAME</th>
											<th>CONTACT</th>
											<th>ADDRESS</th>
											<th>EMAIL</th>
											<th>PASSWORD</th>
											<th>EDIT</th>
											<th>DELETE</th>
										</tr>
									</thead>
									<tbody>
									
										<% List<User> list =  %>
										<%for(User s1: list){ %>
										<tr>
											<td>${id}</td>
											<td></td>
											<td><%=s1.getContact()%></td>
											<td><%=s1.getAddress()%></td>
											<td><%=s1.getEmail()%></td>
											<td><%=s1.getPassword()%></td>
											<td><a href="#">Edit</a></td>
											<td><a href="#">Delete</a></td>
											
										</tr>
										<%} %>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<!-- End  Basic Table  -->
					
					
				</div>
			</div>

		</div>

	</div>

</body>
</html>