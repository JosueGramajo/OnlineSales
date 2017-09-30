<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nuevo juego</title>
<link href="assets/css/StyleSheet2.css" rel="stylesheet" type="text/css" />
</head>
<body>
		<form action="ServletAgregarGame.do" method="POST">
			<div class=login>
			<h1 class="title">Add product</h1>
				<!-- <input type="text" placeholder="Id" name="txtIdContacto" required="true"><br> -->
				<input type="text" placeholder="Name" name="txtName" required="true"><br>
				<input type="number" placeholder="Precio ($ USD)" name="txtPrecio" required="true"><br>
				<input type="file" placeholder="Imagen" name="txtImagen" accept="image/*" required="true"><br>
				<select name="txtIdCategoria">
					<c:forEach var="categoria" items="${listaCategorias}">
						<option value="${categoria.getIdCategoria()}">${categoria.getNombre()}</option>
					</c:forEach>
				</select>
				<textarea name="txtDescripcion" class="form-control" placeholder="Descripcion"></textarea>
				<input type="submit" name="btnAgregar" value="Add">
			</div>
		</form>
</body>
</html>