package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Interface.Fabrica;
import Interface.IConsulta;
import Interface.IModificacion;
import Logica.InscripcionEd;
import Logica.Manejador;

/**
 * Servlet implementation class ListarAceptados
 */
@WebServlet("/ListarAceptados")
public class ListarAceptados extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarAceptados() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Fabrica fabrica= Fabrica.getInstancia();
		IConsulta icon=fabrica.getIConsulta();
		Manejador m = Manejador.getInstancia();
		
	    
		String curso = request.getParameter("cur");
		String cDato = request.getParameter("Cdoc");
		try {
			
			List<String> list = new ArrayList<>();
			list=icon.getEdicionCursoDoc(curso, cDato);
		    System.out.println("hola2");
		    String json = new Gson().toJson(list);
		    System.out.println(list);
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Fabrica fabrica= Fabrica.getInstancia();
		IConsulta icon=fabrica.getIConsulta();
		Manejador m = Manejador.getInstancia();
		String consulta = request.getParameter("Cconsulta");
		String cDato = request.getParameter("edicion");
		
		if(consulta != null && consulta.equals("Cdatos")) {
			List<InscripcionEd> list = new ArrayList<>();
			list=icon.getEstudiantesInscA(cDato);
			System.out.println("hola2");
			
			 List<String> listar =new ArrayList<>();
			 
			 
				
				
				for(InscripcionEd i: list) {
					
					listar.add(i.getEstudiante().getNickname());
					
				}
		    String json = new Gson().toJson(listar);
		    
		    System.out.println(listar);
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
		    
		    
		    
		}
	}

}
