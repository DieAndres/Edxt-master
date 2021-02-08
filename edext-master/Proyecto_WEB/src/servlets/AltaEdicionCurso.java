package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import DataType.DtCurso;
import DataType.DtEdicion;
import Interface.Fabrica;
import Interface.IAlta;
import Interface.IConsulta;
import Logica.Edicion;
import Logica.Manejador;

/**
 * Servlet implementation class AltaEdicionCurso
 */
@WebServlet("/AltaEdicionCurso")
public class AltaEdicionCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaEdicionCurso() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	   
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Fabrica fabrica = Fabrica.getInstancia();
		IAlta ialta = fabrica.getIAlta();
		String instituto =request.getParameter("Instituto");
		System.out.println("el instituto es:"+instituto); 
		String cursos =request.getParameter("cursos");
		String edicion =request.getParameter("A_Edicion");
		
	
		String fIni =request.getParameter("A_fini");
		String fFin =request.getParameter("A_ffin");
		String cupo =request.getParameter("A_cupo");
		 int numCupo = Integer.parseInt(cupo);
		String[] docentes = request.getParameterValues("docentes");
		
		String foto =request.getParameter("A_foto");
		ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(docentes));
		
		 System.out.println(arrayList);
		
	
		
		 java.text.DateFormat format = new java.text.SimpleDateFormat("MM/dd/yyyy");		
	try {
	        
	        java.util.Date da = format.parse(fIni);
	        java.util.Date fin = format.parse(fFin);
	        System.out.println(da.toString());
	        Date fPub=new Date(System.currentTimeMillis());
	        DtEdicion dted=new DtEdicion(edicion, da, fin, numCupo,fPub,foto);
	        
	      ialta.seleccionarCurso2(cursos, dted);
	      ialta.confirmarEdicion();
	      for(String s :arrayList){
	        	System.out.println("EL nombre del curso es: "+edicion);
	        	System.out.println("EL nombre de la categoria  es: "+s);
	        	ialta.AgregarDocentesAedicion(edicion, s);
	        }
	     
	       
	        
			
			
			
	    } catch (ParseException ex) {
	        
	        System.out.println(ex);
	    }
		
	

		
	}

}
