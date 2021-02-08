package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import DataType.DtEdicion;
import Interface.Fabrica;
import Interface.IAlta;
import Interface.IConsulta;
import Logica.Curso;
import Logica.Estudiante;
import Logica.Manejador;

/**
 * Servlet implementation class InscripcionEdicion
 */
@WebServlet("/InscripcionEdicion")
public class InscripcionEdicion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscripcionEdicion() {
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
	
	    
		String consulta = request.getParameter("Cusuario");
		String cDato = request.getParameter("usr");
		
		if(consulta != null && consulta.equals("edicdatos")) {
			Curso c = new Curso();
			c = m.buscarCurso(cDato);
			DtEdicion dte = new DtEdicion();
			dte = c.getDtEdicionVigente();
			if(dte != null) {
				String json2 = new Gson().toJson(dte);
			    System.out.println(dte.getNombre());
			    response.setContentType("application/json");
			    response.setCharacterEncoding("UTF-8");
			    response.getWriter().write(json2);
			}
		}
		else {
			//if(consulta != null && consulta.equals("listdocentes"))
			Curso c = new Curso();
			c = m.buscarCurso(cDato);
			DtEdicion dte = new DtEdicion();
			dte = c.getDtEdicionVigente();
			if(dte != null) {
				List<String> list = new ArrayList<>();
				list=icon.getDocentesEdicion(dte.getNombre());
				System.out.println("hola2");
			    String json = new Gson().toJson(list);
			    System.out.println(list);
			    response.setContentType("application/json");
			    response.setCharacterEncoding("UTF-8");
			    response.getWriter().write(json);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Fabrica fabrica= Fabrica.getInstancia();
		IConsulta icon=fabrica.getIConsulta();
		Manejador m = Manejador.getInstancia();
		IAlta ialta=fabrica.getIAlta();
	    
		String consulta = request.getParameter("Cusuario");
		String cDato = request.getParameter("edic");
		System.out.println("C"+consulta);
		System.out.println("D"+consulta);
		Estudiante estudiante = (Estudiante) m.buscarUsuario(consulta);
		if(estudiante.isInscripto(cDato)==false) {
			 Date fPub=new Date(System.currentTimeMillis());
			 String esIns="Inscripto";
			ialta.registrarEstEdicion(consulta, cDato, fPub, esIns);
		}
		
		
	}

}
