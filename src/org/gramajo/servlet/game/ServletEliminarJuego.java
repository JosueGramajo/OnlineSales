package org.gramajo.servlet.game;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gramajo.bean.Game;
import org.gramajo.db.Conexion;

public class ServletEliminarJuego extends HttpServlet{
	public void doGet(HttpServletRequest peticion,HttpServletResponse respuesta)throws IOException,ServletException{
		doPost(peticion,respuesta);
	}
	public void doPost(HttpServletRequest peticion,HttpServletResponse respuesta)throws IOException,ServletException{
		RequestDispatcher despachador=null;
		
		Game c=(Game)Conexion.getInstancia().Buscar(Game.class,Integer.parseInt(peticion.getParameter("idGame")));
		Conexion.getInstancia().eliminar(c);
		
		despachador=peticion.getRequestDispatcher("ServletListarGame.do");
		despachador.forward(peticion,respuesta);
	}
}
