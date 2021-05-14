package com.unab.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.unab.Negocio.clsLogin;
import com.unab.entidades.usuario;

/**
 * Servlet implementation class ControllerAcceso
 */
public class ControllerAcceso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAcceso() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		
			}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		//doGet(request, response);
		
				HttpSession sesion = request.getSession(true);
				
				String cerrar = request.getParameter("btncerrar");
				String iniciar = request.getParameter("btniniciar");
				
				if(cerrar != null) {
					response.sendRedirect("index.jsp");
					sesion.invalidate();
				}
				else if(iniciar != null) {
					response.sendRedirect("login.jsp");
				}
				else {
					
					String nombre = request.getParameter("user");
					String contrasena = request.getParameter("pass");
					
					clsLogin login = new clsLogin();
					usuario usu = new usuario();
					usu.setNombre(nombre);
					usu.setContrasena(contrasena);
					
					int verifica = login.VerificarUsuario(usu);
					
					if(verifica == 1) {
						response.sendRedirect("index.jsp");
						sesion.setAttribute("nombre", nombre);
					}
				}	
		
	}

}
