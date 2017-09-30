<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online game store</title>
<link href="assets/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<h1 class="name">Welcome ${newId}</h1><br>
	<p class="logout"><a href="ServletCerrarSesion.do">Logout</a></p><br>
	<h1 class="permission">${estado}</h1>
<h1 class="title">Videogame Store</h1><br>
  <div id="wrapper">
      <div id="inner">
          <div id="header">
             <img class="ImageHeader" src="assets/img/B558E3E81.jpg" alt="Mario Wallpaper">
          </div><!-- end header -->
          <dl id="browse">
              <dt>Game Category Lists</dt>
              <dd class="first"><a href="#">Action</a></dd>
              <dd><a href="#">Adventure</a></dd>
              <dd><a href="#">Survival-Horror</a></dd>
              <dd><a href="#">Rpg</a></dd>
              <dd><a href="#">Shooter</a></dd>
              <dd><a href="#">Stealth</a></dd>	
              <dd><a href="#">Strategy</a></dd>  
              <p class="tittleCart">Cart:</p>
              <a href="ServletListarFactura.do"><img class="carrito" src="assets/img/cart.png"/></a><br>
              <c:if test="${rolUser == 1}">
              	<p class="agg"><a href="AgregarJuego.jsp">Add Game</a></p><br>
              	<p class="agg"><a href="AgregarUsuario.jsp">Add User</a></p>
             	</c:if>
              
             <!-- <dt>Search...</dt>
              <dd class="searchform">
                <form action="?" method="get">
                    <div><select name="cat">
                        <option value="-" selected="selected">CATEGORIES</option>
                        <option value="-">------------</option>
                    </select></div>
                    <div><input name="q" type="text" value="DVD TITLE" class="text" /></div>
                    <div class="softright"><input type="image" src="assets/img/btn_search.gif" /></div>
                </form>
              </dd>-->
          </dl>
          
          <div id="body">
              <div class="inner">
                  <c:forEach items="${listaJuegos}" var="juego">
                   	<div class="leftbox">
                      <h3>${juego.getNombre()}</h3>
                      <img class="cover" src="assets/img/covers/${juego.getImagen()}"/>
                      <p><b>Price: $</b> <b></b>${juego.getPrecio()}</p>
                      <p><b>Description:</b> ${juego.getDescripcion()} </p>
					  <p class="review"><a href="#">View Game</a></p>
                      <p class="readmore"><a href="ServletCarrito.do?nombre=${juego.getNombre()}&precio=${juego.getPrecio()}&idGame=${juego.getIdGame()}">Add To Cart</a></p><br>
                      <c:if test="${rolUser == 1}">
                      	<p class="review"><a href="ServletEliminarJuego.do?idGame=${juego.getIdGame()}">Delete</a></p><br>
                      	<p class="review"><a href="ServletCargarDatos.do?idGame=${juego.getIdGame()}&idCategoria=${juego.getCategoria().getIdCategoria()}">Edit</a></p>
                      </c:if>
                      <div class="clear"></div>
                  	</div>	<br>
                  	<hr>
                  </c:forEach>
                    
              </div>
          </div>         
          <div class="clear"></div>
      </div>
  </div>
</body>
</html>