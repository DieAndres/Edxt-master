package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Interface.Fabrica;
import Interface.IAlta;
import Interface.IConsulta;
import DataType.DtCurso;
import DataType.DtUsuario;

/**
 * Servlet implementation class AltaCurso
 */
@WebServlet("/AltaCurso")
public class AltaCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaCurso() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Fabrica fabrica= Fabrica.getInstancia();
		IConsulta icon=fabrica.getIConsulta();
		List<String> list = new ArrayList<>();
		list=icon.listarCurso();
	    System.out.println("hola2");
	    String json = new Gson().toJson(list);
	    System.out.println(list);
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(json);
//
//	    
////			

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		Fabrica fabrica= Fabrica.getInstancia();
		IAlta icon=fabrica.getIAlta();
		String instituto =request.getParameter("Instituto");
		String nombCurso =request.getParameter("NomCurso");
		String descCurso =request.getParameter("DescCurso");
		String duracion =request.getParameter("Duracion");
		String cantHoras =request.getParameter("CantHoras");
		String cantCred =request.getParameter("CantCred");
		String urlAsoc =request.getParameter("URLAsoc");
		String previas =request.getParameter("Previas");
		String categorias =request.getParameter("Categorias");
		String Foto =request.getParameter("Foto");
		
		
		RequestDispatcher rd;
		//DtCurso cur = new DtCurso(nickname,nombre,apellido,email,da,password);
		//try {
		//	icon.confirmarCurso(cur);
		//}catch (ParseException e) {
		//}
		//}
		
		
	}

}
