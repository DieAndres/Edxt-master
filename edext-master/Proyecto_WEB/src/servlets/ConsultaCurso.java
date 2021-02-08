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
import DataType.DtPrograma;
import Interface.Fabrica;
import Interface.IConsulta;
import Logica.Categoria;
import Logica.Curso;
import Logica.Instituto;
import Logica.Manejador;

/**
 * Servlet implementation class ConsultaCurso
 */
@WebServlet("/ConsultaCurso")
public class ConsultaCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaCurso() {
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
		String cDato2 = request.getParameter("tipo");
		
		if(consulta != null && consulta.equals("Cdatos")) {
			//Instituto insti = new Instituto();
			//insti = m.buscarInstituto(cDato);
			List<String> list = new ArrayList<>();
			list=icon.seleccionarInstituto(cDato);
			System.out.println("hola2");
		    String json = new Gson().toJson(list);
		    System.out.println(list);
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
		}
		else if (consulta != null && consulta.equals("Cursodatos")) {
			DtCurso dtc = new DtCurso();
			dtc = icon.seleccionarCurso(cDato).getCurso();
			String json2 = new Gson().toJson(dtc);
		    System.out.println(dtc.getNombre());
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json2); 
		}
		else if (consulta != null && consulta.equals("prev")) {
			List<String> list = new ArrayList<>();
			list = icon.getNomPrevias(cDato);
			String json = new Gson().toJson(list);
		    System.out.println(list);
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
		}
		else if (consulta != null && consulta.equals("cate")) {
			Curso c = m.buscarCurso(cDato);
			List<Categoria> list = new ArrayList<>();
			list = c.getCategoria();
			List<String> ret = new ArrayList<>();
			for(Categoria cat : list) {
				ret.add(cat.getNombre());
			}
			String json = new Gson().toJson(ret);
		    System.out.println(ret);
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
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
		else if (consulta != null && consulta.equals("prog")) {
			DtInfoCurso dtic = new DtInfoCurso();
			dtic = icon.seleccionarCurso(cDato);
			List<String> list = new ArrayList<>();
			list=dtic.getProgramas();
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
		else if (consulta != null && consulta.equals("Progdatos")) {
			DtPrograma dtp = new DtPrograma();
			dtp = icon.seleccionarPrograma(cDato);
			String json2 = new Gson().toJson(dtp);
		    System.out.println(dtp.getNombre());
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json2); 
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
