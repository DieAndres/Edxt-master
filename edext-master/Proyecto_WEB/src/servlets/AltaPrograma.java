package servlets;


import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataType.DtPrograma;
import Excepciones.ProgramaRepetidoExcepcion;
import Interface.Fabrica;
import Interface.IAlta;

/**
 * Servlet implementation class AltaPrograma
 */
@WebServlet("/AltaPrograma")
public class AltaPrograma extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaPrograma() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Fabrica fabrica= Fabrica.getInstancia();
		IAlta cAlta=fabrica.getIAlta();
		String nombre= request.getParameter("nomProg");
		String descripcion= request.getParameter("descripcion");
		String fechaIni = request.getParameter("fIni");
		String fechaFin = request.getParameter("fFin");
		String imagen = request.getParameter("imgProg");
		RequestDispatcher rd;
		
		java.text.DateFormat format = new java.text.SimpleDateFormat("MM/dd/yyyy");
		try {
			java.util.Date dateI = format.parse(fechaIni);
			java.util.Date dateF = format.parse(fechaFin);
	        
			
			DtPrograma infoProg = new DtPrograma(nombre, descripcion, dateI, dateF,imagen);
			cAlta.registrarPrograma(infoProg);
	        
			request.setAttribute("mensaje", "Se ha creado el Programa correctamente ");
			rd = request.getRequestDispatcher("/notificacion.jsp");
			rd.forward(request, response);
	        
		} catch (ParseException | ProgramaRepetidoExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("mensaje", e.getMessage());
			rd = request.getRequestDispatcher("/notificacion.jsp");
			rd.forward(request, response);		        
		}
		//doGet(request, response);       
	}

}
