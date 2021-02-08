package servlets;


import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import DataType.DtDocente;
import DataType.DtEstudiante;
import DataType.DtUsuario;
import Interface.Fabrica;
import Interface.IAlta;
import Publicaciones.ControladorAltaPublish;
import Publicaciones.ControladorAltaPublishService;
import Publicaciones.ControladorAltaPublishServiceLocator;

/**
 * Servlet implementation class AltaUsuario
 */
@WebServlet("/AltaUsuario")
@MultipartConfig
public class AltaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaUsuario() {
        
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


		//Fabrica fabrica = Fabrica.getInstancia();
		//IAlta ialta = fabrica.getIAlta();
		String nickname = request.getParameter("A_nick");
		String nombre = request.getParameter("A_nombre");
		String apellido = request.getParameter("A_apellido");
		String password = request.getParameter("A_pass");
		String cPassword = request.getParameter("A_confPass");
		String email = request.getParameter("A_email");
		String fnac = request.getParameter("A_fnac");
		String tipoU = request.getParameter("A_tipoUsuario");
		String foto = request.getParameter("A_fot");
		
		
		java.text.DateFormat format = new java.text.SimpleDateFormat("MM/dd/yyyy");
	    
		System.out.println(nickname);
		System.out.println(nombre);
		System.out.println(apellido);
		System.out.println(password);
		System.out.println(cPassword);
		System.out.println(email);
		System.out.println(fnac);
		System.out.println("el tipo "+tipoU);
		System.out.println("la foto es"+foto);


		try {
	        //java.util.Date d = df.parse(Date);
	        java.util.Date da = format.parse(fnac);
	        System.out.println(da.toString());
	        Calendar calendar = Calendar.getInstance();
	        calendar.setTime(da);
	        

			Publicaciones.DtUsuario dtu = null;
			Publicaciones.DtEstudiante dte = null;
			Publicaciones.DtDocente dtd = null;
	    if (tipoU.equals("Estudiante")){   
	    	System.out.println("soy estudiante");
	       // DtUsuario usr = new DtUsuario(nickname,nombre,apellido,email,da,password,foto);
	      //  DtEstudiante est = new DtEstudiante(usr);
	    	dtu = new Publicaciones.DtUsuario ();
	    	dte = new Publicaciones.DtEstudiante ();
	    	dtu.setApellido(apellido);
	    	dtu.setEmail(email);
	    	dtu.setFNac(calendar);
	    	dtu.setFoto(foto);
	    	dtu.setNickName(nickname);
	    	dtu.setNombre(nombre);
	    	dtu.setPass(cPassword);
	    	dte.setUsuario(dtu);
	        try {
				if(registroUsuarioEst(dte)) {
					RequestDispatcher rd;
					request.setAttribute("mensaje", "El Estudiante ya existe ");
					rd = request.getRequestDispatcher("/notificacion.jsp");
					rd.forward(request, response);
					
				}else {
				    RequestDispatcher rd;
					request.setAttribute("mensaje", "Se ha ingresado correctamente al Estudiante ");
					rd = request.getRequestDispatcher("/notificacion.jsp");
					rd.forward(request, response);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }else {
	    	System.out.println("soy docente");
	    	String Instituto = request.getParameter("A_Instituto");
			System.out.println("Mostrando instituto "+Instituto);
	    	//DtDocente doc = new DtDocente(nickname,nombre, apellido, email, da, Instituto, password, foto);
			dtd = new Publicaciones.DtDocente ();
			dtd.setApellido(apellido);
			dtd.setEmail(email);
			dtd.setFNac(calendar);
			dtd.setFoto(foto);
			dtd.setInstituto(Instituto);
			dtd.setNickName(nickname);
			dtd.setNombre(nombre);
			dtd.setPass(cPassword);
	    	try {
				if(registroUsuarioDoc(dtd)) {
					RequestDispatcher rd;
					request.setAttribute("mensaje", "El Docente ya existe ");
					rd = request.getRequestDispatcher("/notificacion.jsp");
					rd.forward(request, response);
				}else {
					RequestDispatcher rd;
					request.setAttribute("mensaje", "Se ha ingresado correctamente al Docente ");
					rd = request.getRequestDispatcher("/notificacion.jsp");
					rd.forward(request, response);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    }   
	    
	       
			
			
			
	    } catch (ParseException ex) {
	        //Logger.getLogger(ReserveServlet.class.getName()).log(Level.SEVERE, null, ex);
	        System.out.println(ex);
	    }
		
		
			
		
	}

	public boolean registroUsuarioDoc(Publicaciones.DtDocente dtd) throws Exception {
		ControladorAltaPublishService cps = new ControladorAltaPublishServiceLocator();
		ControladorAltaPublish port = cps.getControladorAltaPublishPort();
		return port.registroUsuarioDoc(dtd);
	}
	public boolean registroUsuarioEst(Publicaciones.DtEstudiante dte) throws Exception {
		ControladorAltaPublishService cps = new ControladorAltaPublishServiceLocator();
		ControladorAltaPublish port = cps.getControladorAltaPublishPort();
		return port.registroUsuarioEst(dte);
	}
		
		//IAlta alta = fabrica.getIAlta();
//		DtUsuario usr = new DtUsuario(nickname,nombre,apellido,email,da,password);
//		DtEstudiante est = new DtEstudiante(usr);
		
//		RequestDispatcher rd;
//		request.setAttribute("mensaje", "Se ha ingresado correctamente al socio ");
//		rd = request.getRequestDispatcher("/notificacion.jsp");
//		rd.forward(request, response);

		
		//alta.registroUsuarioEst(est);
		
	}
	
	


