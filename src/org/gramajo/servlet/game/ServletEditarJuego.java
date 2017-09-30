package org.gramajo.servlet.game;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gramajo.bean.Categoria;
import org.gramajo.bean.Game;
import org.gramajo.bean.Usuario;
import org.gramajo.db.Conexion;

public class ServletEditarJuego extends HttpServlet{
	public void doGet(HttpServletRequest peticion,HttpServletResponse respuesta)throws IOException,ServletException{
		doPost(peticion,respuesta);
	}
	public void doPost(HttpServletRequest peticion,HttpServletResponse respuesta)throws IOException,ServletException{
		RequestDispatcher despachador=null;
		Categoria c=(Categoria)Conexion.getInstancia().Buscar(Categoria.class,Integer.parseInt(peticion.getParameter("txtIdCategoria")));
		Usuario usr=(Usuario)peticion.getSession().getAttribute("usuario");
		Game juego=new Game(
				Integer.parseInt(peticion.getParameter("txtIdGame")),
				peticion.getParameter("txtName"),
				Integer.parseInt(peticion.getParameter("txtPrecio")),
				peticion.getParameter("txtImagen"),
				peticion.getParameter("txtDescripcion"),
				usr,
				c);
		Conexion.getInstancia().modificar(juego);
		despachador=peticion.getRequestDispatcher("ServletListarGame.do");
		despachador.forward(peticion,respuesta);
	}
}
