package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Interface.Fabrica;
import Interface.IConsulta;
import Logica.Manejador;

/**
 * Servlet implementation class ListarCursos
 */
@WebServlet("/ListarCursos")
public class ListarCursos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarCursos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Fabrica fabrica= Fabrica.getInstancia();
		IConsulta icon=fabrica.getIConsulta();

		
			List<String> listar = new ArrayList<>();
			String nominst = request.getParameter("inst");
			System.out.println("el isntituto que paso es:" + nominst);
			listar=icon.seleccionarInstituto(nominst);
		    String js = new Gson().toJson(listar);
		    System.out.println(listar);
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(js);
		
		} 
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Fabrica fabrica= Fabrica.getInstancia();
		IConsulta icon=fabrica.getIConsulta();
		String cDato = request.getParameter("instD");
		List<String> list = new ArrayList<>();
		list=icon.getDocentesDeInsti(cDato);
		String json = new Gson().toJson(list);
	    System.out.println(list);
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(json);
	}

}
