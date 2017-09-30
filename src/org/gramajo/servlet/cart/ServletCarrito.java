package org.gramajo.servlet.cart;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gramajo.bean.Factura;
import org.gramajo.bean.Game;
import org.gramajo.bean.Usuario;
import org.gramajo.db.Conexion;

public class ServletCarrito extends HttpServlet{
	public void doGet(HttpServletRequest peticion,HttpServletResponse respuesta)throws IOException,ServletException{
		doPost(peticion,respuesta);
	}
	public void doPost(HttpServletRequest peticion,HttpServletResponse respuesta)throws IOException,ServletException{
		RequestDispatcher despachador=null;
		Game c=(Game)Conexion.getInstancia().Buscar(Game.class,Integer.parseInt(peticion.getParameter("idGame")));
		Usuario usr=(Usuario)peticion.getSession().getAttribute("usuario");
		Factura fac=new Factura(
				0,
				peticion.getParameter("nombre"),
				Integer.parseInt(peticion.getParameter("precio")),
				c);
		
		Conexion.getInstancia().agregar(fac);
		despachador=peticion.getRequestDispatcher("ServletListarGame.do");
		despachador.forward(peticion,respuesta);
	}
}
