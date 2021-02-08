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

import DataType.DtCurso;
import DataType.DtEdicion;
import DataType.DtInfoCurso;
import Interface.Fabrica;
import Interface.IConsulta;
import Logica.Curso;
import Logica.Manejador;

/**
 * Servlet implementation class ConsultaEdicion
 */
@WebServlet("/ConsultaEdicion")
public class ConsultaEdicion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaEdicion() {
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
		String cEdicion = request.getParameter("Cediciones");
		
		if(consulta != null && consulta.equals("Cdatos")) {
			List<String> list = new ArrayList<>();
			list=icon.seleccionarInstituto(cDato);
			System.out.println("hola2");
		    String json = new Gson().toJson(list);
		    System.out.println(list);
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
		}
		else if(consulta != null && consulta.equals("cursosxcat")) {
			List<String> list = new ArrayList<>();
			list=icon.getCursosporCat(cDato);
			System.out.println("hola2");
		    String json = new Gson().toJson(list);
		    System.out.println(list);
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
		}
		else if (consulta != null && consulta.equals("Edidatos")) {
			DtEdicion dte = new DtEdicion();
			dte = icon.seleccionarEdicion(cDato);
			String json2 = new Gson().toJson(dte);
		    System.out.println(dte.getNombre());
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json2); 
		}
		else if (consulta != null && consulta.equals("edic")) {
			DtInfoCurso dtic = new DtInfoCurso();
			dtic = icon.seleccionarCurso(cDato);
			List<String> list = new ArrayList<>();
			list=dtic.getEdiciones();
			String json = new Gson().toJson(list);
		    System.out.println(list);
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
			
		}
		else if (consulta != null && consulta.equals("listdocentes")) {
			List<String> list = new ArrayList<>();
			list=icon.getDocentesEdicion(cDato);
			System.out.println("hola2");
		    String json = new Gson().toJson(list);
		    System.out.println(list);
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
		}
		else if (consulta != null && consulta.equals("listcategorias")){
			System.out.println("La bandera es"+consulta);
			System.out.println("La bandera es"+cDato);
			response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
			List<String> list = new ArrayList<>();
			list=icon.listarCategorias();
		    System.out.println("hola2");
		    String json = new Gson().toJson(list);
		    System.out.println(list);
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
		}
		else if (consulta != null && consulta.equals("edi")){
			Curso M = m.buscarCurso(cDato);
			response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		    DtEdicion Dte =new DtEdicion();
		    Dte = M.getDtEdicionVigente();
		    
		    String json = new Gson().toJson(Dte);
		    System.out.println(Dte);
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
		}
		else {
			System.out.println("La bandera es"+consulta);
			System.out.println("La bandera es"+cDato);
			response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
			List<String> list = new ArrayList<>();
			list=icon.listarInstituto();
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
