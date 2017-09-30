<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Juego</title>
<link href="assets/css/StyleSheet2.css" rel="stylesheet" type="text/css" />
</head>
<body>
<form action="ServletEditarGame.do" method="POST">
			<div class=login>
			<h1 class="title">Add product</h1>
				<input type="hidden" value="${miJuego.getIdGame()}" name="txtIdGame">
				<!-- <input type="text" placeholder="Id" name="txtIdContacto" required="true"><br> -->
				<input type="text" value="${miJuego.getNombre()}" name="txtName" required="true"><br>
				<input type="text" value="${miJuego.getPrecio()}" name="txtPrecio" required="true"><br>
				<input type="file"  name="txtImagen" accept="image/*" required="true"><br>
				<select name="txtIdCategoria">
				<c:forEach var="categoria" items="${listaCategorias}">
					<c:if test="${categoria.getIdCategoria()==miCategoria.getIdCategoria()}">
						<option value="${categoria.getIdCategoria()}" selected>${categoria.getNombre()}</option>
					</c:if>
					<c:if test="${categoria.getIdCategoria()!=miCategoria.getIdCategoria()}">
						<option value="${categoria.getIdCategoria()}" >${categoria.getNombre()}</option>
					</c:if>
				</c:forEach>
			</select>
				<textarea name="txtDescripcion" class="form-control">${miJuego.getDescripcion()}</textarea>
				
				<input type="submit" name="btnAgregar" value="Submit Changes">
			</div>
		</form>
</body>
</html>