<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your Cart</title>
<link href="assets/css/StyleSheet3.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="tableready">
				<h2 class="sub-header">FACTURA</h2>
				<div class="table-responsive">
					<table  class="table table-striped">
						<thead>
							<th>NOMBRE</th>
							<th>PRECIO</th>
						</thead>
						<tbody>
						<c:set var="salary" scope="session" value="${0}"/>
							<c:forEach items="${listaJuegosFactura}" var="fact">
								<tr>
									<td>${fact.getNombre()}</td>
									<td>${fact.getPrecio()}</td>
									<c:set var="salary" scope="session" value="${salary+fact.getPrecio()}"/>
								</tr>
							</c:forEach>
						</tbody>
					</table>
							<div class="total">
								<h1>Total: $<c:out value="${salary}"/></h1>
							</div>
							<form action="ServletFinalizar.do" method="post">
								<div class="login">
									<input type="submit" name="btnAgregar" value="Finalizar Compra">
								</div>
							</form>
				</div>
		</div>
</body>
</html>