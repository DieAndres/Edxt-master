package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
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
import Interface.IConsulta;

/**
 * Servlet implementation class Busqueda
 */
@WebServlet("/Busqueda")
public class Busqueda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Busqueda() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Fabrica fabrica= Fabrica.getInstancia();
		IConsulta icon=fabrica.getIConsulta();
		List<String> list = new ArrayList<>();
		String Filtro = request.getParameter("Filtro");
		
		String Search = request.getParameter("usr");
		try {
			System.out.println(Search);
			System.out.println(Filtro);
			list= icon.resultadoBusqueda(Search,Filtro);
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
		
	}

}
