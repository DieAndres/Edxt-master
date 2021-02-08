package servlets;


import java.text.ParseException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import DataType.DtCurso;
import DataType.DtDocente;
import DataType.DtEstudiante;
import DataType.DtUsuario;
import Interface.Fabrica;
import Interface.IAlta;

/**
 * Servlet implementation class ConsultaPrevias
 */
@WebServlet("/ConsultaPrevias")
public class ConsultaPrevias extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaPrevias() {
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
		Fabrica fabrica = Fabrica.getInstancia();
		IAlta ialta = fabrica.getIAlta();
		String instituto =request.getParameter("Instituto");
		System.out.println("el instituto es:"+instituto); 
		String nombCurso =request.getParameter("NomCurso");
		String descCurso =request.getParameter("DescCurso");
		String duracion =request.getParameter("Duracion");
		
		System.out.println("la duracion es"+duracion);  
		int numduracion = Integer.parseInt(duracion);
		String cantHoras =request.getParameter("CantHoras");
		int numCantHoras = Integer.parseInt(cantHoras);
		String cantCred =request.getParameter("CantCred");
		int numcantCred = Integer.parseInt(cantCred);
		String urlAsoc =request.getParameter("URLAsoc");
		String imagen = request.getParameter("A_foto");
		
	
		String fnac =request.getParameter("A_fnac");
		String[] previas = request.getParameterValues("previas");
		String[] categorias = request.getParameterValues("categorias");
		/*if (previas != null) {
		    for(String item: previas){
		        String keyValue[]= item.split(":");
		        System.out.println("Key: " + keyValue[0]);
		        System.out.println("Value: " + keyValue[1]);
		    }
		}*/
		//String[] cursos = request.getParameterValues("json[]");
		
		
		List<String> arrayListCategoria = new ArrayList<String>();
		if(categorias != null) {
			arrayListCategoria = new ArrayList<String>(Arrays.asList(categorias));
		}

		
		 System.out.println("La imagen es"+imagen);
		//String categorias =request.getParameter("Categorias");
	//	String Foto =request.getParameter("Foto");
		
			
		 java.text.DateFormat format = new java.text.SimpleDateFormat("MM/dd/yyyy");		
	try {
	        
	        java.util.Date da = format.parse(fnac);
	        System.out.println(da.toString());
	        System.out.println("ES o no esimagen "+imagen);
	        DtCurso dtcurso=new DtCurso(nombCurso, descCurso, urlAsoc, numduracion, numCantHoras, numcantCred,da,imagen);
	        System.out.println("Imagen"+imagen);
	        if(ialta.registroCurso(dtcurso, instituto)) {
	        	String data="Incorrecto";
 	    		
 			    response.setContentType("text/plain");
 			    response.setCharacterEncoding("UTF-8");
 			    response.getWriter().write(data);
	        	
	        }
	        else {
	        	 if(previas !=null) {
	 	        	System.out.println("ENTRA AL NULL");
	 	    		ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(previas));
	 		    		ialta.confirmarCurso(arrayList);
	 		    	if(arrayListCategoria !=null) {
	 			        for(String s :arrayListCategoria){
	 			        	System.out.println("EL nombre del curso es: "+nombCurso);
	 			        	System.out.println("EL nombre de la categoria  es: "+s);
	 			        	ialta.AgregarCategoriaCurso(dtcurso.getNombre(), s);
	 			        }
	 		    	}
	 	        }
	 	        else {
	 	        	System.out.println("NO ENTRA AL NULL");
	 	        	ArrayList<String> arrayList = null;
	 	    		ialta.confirmarCurso(arrayList);
	 	    		if(arrayListCategoria !=null) {
	 	    			for(String s :arrayListCategoria){
		 	        	System.out.println("EL nombre del curso es: "+nombCurso);
		 	        	System.out.println("EL nombre de la categoria  es: "+s);
		 	        	ialta.AgregarCategoriaCurso(dtcurso.getNombre(), s);
	 	        	}
	 	    		}
	 	    		
	 	        }
	 	       System.out.println("El cantidad de horas CURSO ES"+dtcurso.getCantHoras()+"El instituto es:"+ instituto);
	        }
	        
	       
//	       RequestDispatcher rd;
//			request.setAttribute("mensaje", "El curso fue agregado ");
//			rd = request.getRequestDispatcher("/notificacion.jsp");
//			rd.forward(request, response);
//			System.out.println("llegue aca fin2");
	       
	    } catch (ParseException ex) {
	        
	        System.out.println(ex);
	    }
		
	
}

	}


