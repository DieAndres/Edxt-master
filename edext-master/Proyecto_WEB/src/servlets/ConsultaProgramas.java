package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import DataType.DtPrograma;
import DataType.DtPrograma2;
import Interface.Fabrica;
import Interface.IConsulta;
import Logica.Curso;
import Logica.Manejador;
import Logica.Programa;

/**
 * Servlet implementation class ConsultaProgramas
 */
@WebServlet("/ConsultaProgramas")
public class ConsultaProgramas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaProgramas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		
		String consulta = request.getParameter("Cprograma");
		String cDato = request.getParameter("prog");
		
		 System.out.println("La bandera es"+consulta);
		 System.out.println("La bandera es"+cDato);
		 response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	    if(consulta.equals("Cdatos")) {
	    	Fabrica fabrica= Fabrica.getInstancia();
			IConsulta icon=fabrica.getIConsulta();
		
			DtPrograma prog= new DtPrograma();
			prog=icon.seleccionarPrograma(cDato);
			
		    System.out.println("El nombre es"+prog.getNombre());
		   
		    String json = new Gson().toJson(prog);
		    System.out.println(prog);
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
	    	
	    }
	    else if(consulta.equals("cursos")) {
	    	Fabrica fabrica= Fabrica.getInstancia();
			IConsulta icon=fabrica.getIConsulta();
			
			Manejador m=Manejador.getInstancia();
			List<String> list = new ArrayList<>();
			System.out.println("antes");
		    Programa p= new Programa();
		    p=m.buscarPrograma(cDato);
		    
		    
		    
		    list=p.getCursosNom();
		    String json = new Gson().toJson(list);
		    System.out.println(list);
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
		  
	    }
	    
		  else{
			
			   Fabrica fabrica= Fabrica.getInstancia();
				IConsulta icon=fabrica.getIConsulta();
				List<String> list = new ArrayList<>();
				list=icon.listarProgramas();
			    System.out.println("hola2");
			    String json = new Gson().toJson(list);
			    System.out.println(list);
			    response.setContentType("application/json");
			    response.setCharacterEncoding("UTF-8");
			    response.getWriter().write(json);
		   }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
