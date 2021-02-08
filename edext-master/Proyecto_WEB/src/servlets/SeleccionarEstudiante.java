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

import DataType.DtEdicion;
import Interface.Fabrica;
import Interface.IConsulta;
import Interface.IModificacion;
import Logica.InscripcionEd;
import Logica.Manejador;

/**
 * Servlet implementation class SeleccionarEstudiante
 */
@WebServlet("/SeleccionarEstudiante")
public class SeleccionarEstudiante extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeleccionarEstudiante() {
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
	
	    
		String consulta = request.getParameter("Cconsulta");
		String cDato = request.getParameter("edicion");
		
		if(consulta != null && consulta.equals("Cdatos")) {
			List<InscripcionEd> list = new ArrayList<>();
			list=icon.getEstudiantesInsc(cDato);	
			System.out.println("hola2");
			
			 List<String> listar =new ArrayList<>();
			 
			 
				Map<String, String[]> map = new HashMap<String, String[]>(); 
				
				for(InscripcionEd i: list) {
					String arry[]= new String[2];
							String var=(i.getEstudiante()).getNickname();
							  System.out.println(var);
					arry[0]=i.getEstudiante().getNickname();
					arry[1]=i.getEstadoInsc();
					// listar.add(i.getEstudiante().getNickname());
					// listar.add(i.getEstadoInsc());
					map.put(i.getEstudiante().getNickname(),arry);
					
				}
		    String json = new Gson().toJson(map);
		    
		    System.out.println(map);
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
		    
		    
		    
		}
			
		/*else if (consulta != null && consulta.equals("Edidatos")) {
				DtEdicion dte = new DtEdicion();
				dte = icon.seleccionarEdicion(cDato);
				String json2 = new Gson().toJson(dte);
			    System.out.println(dte.getNombre());
			    response.setContentType("application/json");
			    response.setCharacterEncoding("UTF-8");
			    response.getWriter().write(json2); 
			}*/	
		


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Fabrica fabrica= Fabrica.getInstancia();
		IModificacion imod= fabrica.getIModificacion();
		Manejador m = Manejador.getInstancia();
	
	    
		String consulta = request.getParameter("Cestu");
		String cDato = request.getParameter("Cestado");
		String edi = request.getParameter("Cedicion");
		System.out.println(edi);
		try {
			imod.setEstadoInst(cDato, consulta, edi);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
