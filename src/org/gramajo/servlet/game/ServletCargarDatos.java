package org.gramajo.servlet.game;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gramajo.bean.Categoria;
import org.gramajo.bean.Game;
import org.gramajo.db.Conexion;

public class ServletCargarDatos extends HttpServlet{
	public void doGet(HttpServletRequest peticion,HttpServletResponse respuesta)throws IOException,ServletException{
		doPost(peticion,respuesta);
	}
	public void doPost(HttpServletRequest peticion,HttpServletResponse respuesta)throws IOException,ServletException{
		RequestDispatcher despachador=null;
	
		peticion.setAttribute("miJuego", Conexion.getInstancia().Buscar(Game.class, Integer.parseInt(peticion.getParameter("idGame"))));
		peticion.setAttribute("miCategoria", Conexion.getInstancia().Buscar(Categoria.class, Integer.parseInt(peticion.getParameter("idCategoria"))));
		despachador=peticion.getRequestDispatcher("EditarJuego.jsp");

		despachador.forward(peticion,respuesta);
	}
}
