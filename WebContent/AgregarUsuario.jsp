<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add User</title>
<link href="assets/css/StyleSheet2.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<form action="ServletAgregarUsuario.do" method="POST">
			<div class=login>
			<h1 class="title">Add User</h1>
				<input type="text" placeholder="Name" name="txtName" required="true"><br>
				<input type="text" placeholder="Email" name="txtEmail" required="true"><br>
				<input type="text" placeholder="Nick" name="txtNick" required="true"><br>
				<input type="password" placeholder="Password" name="txtPassword" required="true">
				<select name="txtIdRol">
					<c:forEach var="roles" items="${listaRol}">
					<option value="${roles.getIdRol()}">${roles.getNombre()}</option>
					</c:forEach>
				</select><br>
				<input type="submit" name="btnAgregar" value="Add">
			</div>
		</form>
</body>
</html>