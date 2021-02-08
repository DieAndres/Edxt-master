package servlets;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Logica.Docente;
import Logica.Estudiante;
import Logica.Manejador;
import Logica.Usuario;

import com.google.gson.Gson;

import DataType.DtEstudiante;
import DataType.DtPrograma;
import DataType.DtUsuario;
import Interface.Fabrica;
import Interface.IConsulta;

/**
 * Servlet implementation class ConsultaUsuario
 */
@WebServlet("/ConsultaUsuario")
public class ConsultaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Fabrica fabrica= Fabrica.getInstancia();
		IConsulta icon=fabrica.getIConsulta();
		Manejador m = Manejador.getInstancia();
	
	    
		String consulta = request.getParameter("Cusuario");
		String cDato = request.getParameter("usr");
		
		System.out.println("La bandera es"+consulta);
		System.out.println("La bandera es"+cDato);
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    
	    if(consulta != null && consulta.equals("Cdatos")) {
		
			Usuario user = new Usuario();
			user = m.buscarUsuario(cDato);
			
			if(user instanceof Estudiante) {
				//DtEstudiante est = new DtEstudiante();
				DtUsuario est = new DtUsuario();
				est = icon.imprimirUsuario(user.getNickname());
				System.out.println("El nombre es"+est.getNombre());
				   
			    String json2 = new Gson().toJson(est);
			    System.out.println(est);
			    response.setContentType("application/json");
			    response.setCharacterEncoding("UTF-8");
			    response.getWriter().write(json2); 
			}
			else if (user instanceof Docente) {
				DtUsuario doc = new DtUsuario();
				doc = icon.imprimirUsuario(user.getNickname());
				System.out.println("El nombre es"+doc.getNombre());
				   
			    String json2 = new Gson().toJson(doc);
			    System.out.println(doc);
			    response.setContentType("application/json");
			    response.setCharacterEncoding("UTF-8");
			    response.getWriter().write(json2); 
			}
			
		       
	    }

	    else {
	    	System.out.println("La bandera es"+consulta);
			System.out.println("La bandera es"+cDato);
			response.setContentType("text/html");
			List<String> list = new ArrayList<>();
			list=icon.listarUsuarios();
		    System.out.println("hola2");
		    String json = new Gson().toJson(list);
		    System.out.println(list);
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
	    }
/*
	    List<String> list = new ArrayList<>();
		list=icon.listarUsuarios();
	    System.out.println("hola2");
	    String json = new Gson().toJson(list);
	    System.out.println(list);
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(json);*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
