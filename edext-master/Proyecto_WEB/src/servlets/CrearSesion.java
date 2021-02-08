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
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import Interface.Fabrica;
import Interface.IConsulta;
import Logica.Estudiante;
import Logica.Manejador;
import Logica.Usuario;

/**
 * Servlet implementation class CrearSesion
 */
@WebServlet("/CrearSesion")
public class CrearSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearSesion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		HttpSession session = request.getSession(false);
//		if (session == null) {
//		       // Not created yet. Now do so yourself.
//			JOptionPane.showMessageDialog(null, "la sesion no está creada");
//		       session = request.getSession();
//		} else {
//		       // Already created.
//			JOptionPane.showMessageDialog(null, "la sesion YA estába creada");
//		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("lleguecorto2");
		Fabrica fabrica= Fabrica.getInstancia();
		IConsulta icon = fabrica.getIConsulta();
		Manejador m = Manejador.getInstancia();
		String nickname =request.getParameter("nickname");
		String pass =request.getParameter("pass");
		Usuario user= new Usuario();
		System.out.println("usuario no es null");
		user=null;
		user= m.buscarUsuario(nickname);
		response.setContentType("text/html");  
		PrintWriter out= response.getWriter();
		
		System.out.println("bandera5");
		
		if(user==null){
			//out.print("<html><body>Alert(Usuario o Password Incorrecto)</body></html>");
			request.getRequestDispatcher("Login.jsp").include(request, response);
		}
		else if(user.getNickname().equals(nickname)) {
			if(user.getPass().equals(pass)) {				
				// //vemos el tipo del usuario
		 				String tipo="D";
		 				List<String> est = new ArrayList<String>();
		 				System.out.println("llegue antes est");
		 				est= icon.getNomEstudiantes();	
		 				for(String e: est) {
		 					System.out.println("el e es" + e);
		 					System.out.println("el getN es" + user.getNickname());
		 					if(user.getNickname().equals(e)) 
		 						tipo = "E";
		 				}
		 		
		 		System.out.println("el tipo es" + tipo);
				HttpSession misession= request.getSession(true);
				misession.setAttribute("usuario",user);
				request.setAttribute("usuario",user.getNickname());
				request.setAttribute("tipo",tipo);
				request.getRequestDispatcher("index.jsp").forward(request, response);
				
			}else {
				JOptionPane.showMessageDialog(null,"Usuario o Password Incorrecto");
				//request.getRequestDispatcher("Login.jsp").include(request, response);
				//request.getRequestDispatcher("altausuario.jsp").include(request, response);
			}
			
		}else{
			System.out.println("el usuario que buscamos no existe");
			System.out.println("el getN que paso" + user.getNickname());
			System.out.println("el nickname que busca" + nickname);
			
		}
		
		
		
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("llegueeeeeeeeeeeeeePost");
		doGet(request, response);
		
	}

}
