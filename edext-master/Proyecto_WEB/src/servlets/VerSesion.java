package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Interface.Fabrica;
import Logica.Docente;
import Logica.Estudiante;
import Logica.Manejador;
import Logica.Usuario;

/**
 * Servlet implementation class VerSesion
 */
@WebServlet("/VerSesion")
public class VerSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerSesion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Fabrica fabrica= Fabrica.getInstancia();
		Manejador m = Manejador.getInstancia();
		String tipo="";
		List<Estudiante> est = new ArrayList<Estudiante>();
		est= m.getEstudiantes();
		
		HttpSession misession= (HttpSession) request.getSession();
		Usuario miusuario= (Usuario) misession.getAttribute("usuario");
		System.out.println(miusuario);
		System.out.println("el valor en ver session" + miusuario.getNombre());
		
		String nombre = miusuario.getNombre();
		for(Estudiante e: est) {
			
			if(miusuario.getNickname().equals(e.getNickname()) )
				tipo = "E";
			else {
				tipo = "D";
			}
		}
		
		nombre="pepe";
		System.out.println("nombre en versesion" + nombre);
		request.setAttribute("nombre",nombre);
		request.setAttribute("tipo",tipo);
		
		//request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
