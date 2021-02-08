package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import DataType.DtDocente;
import DataType.DtEdicion;
import DataType.DtEstudiante;
import DataType.DtInfoCurso;
import DataType.DtPrograma;
import DataType.DtPrograma2;
import DataType.DtUsuario;
import Interface.IConsulta;
import Persistencia.Conexion;

public class CConsulta implements IConsulta{
	@SuppressWarnings("unused")
	private	String nCruso;
	@SuppressWarnings("unused")
	private	String nProg;
	private	String nickname;
	@SuppressWarnings("unused")
	private	String nEdicion;
	
	public CConsulta() {
		super();
	}
	
	public void seleccionarUsuario(String nickname) {
		this.nickname =  nickname;
	}
	
	@Override
	public DtPrograma seleccionarPrograma(String nProg) {
		Manejador m = Manejador.getInstancia();
		Programa prog = m.buscarPrograma(nProg);
		DtPrograma retorno= prog.getDtPrograma();
		return retorno;
	}

	@Override
	public DtPrograma2 seleccionarPrograma2(String nProg) {
		Manejador m = Manejador.getInstancia();
		Programa prog = m.buscarPrograma(nProg);
		ArrayList<String> cursos = new ArrayList<>();
		for(Curso c : prog.getCursos()) {
			cursos.add(c.getNombre());
		}
		DtPrograma2 retorno = new DtPrograma2(prog.getNombre(), prog.getDescripcion(), prog.getfInicio(), prog.getfFin(), cursos, prog.getFoto());
		return retorno;
	}

	@Override
	public DtInfoCurso seleccionarCurso(String nCurso) {
		Manejador m = Manejador.getInstancia();
		Curso curso = m.buscarCurso(nCurso);
		ArrayList<String> progS = new ArrayList<String>(); 
		
		for(Programa p : curso.getProgramas()) {
			progS.add(p.getNombre());
		}
		
		ArrayList<String> ediS = new ArrayList<String>();
		for(Edicion e : curso.getEdiciones()) {
			ediS.add(e.getNombre());
		}
		
		return new DtInfoCurso(curso.getDtCurso(),progS,ediS);
	}
	
	public ArrayList<String> getNomPrevias(String nCurso) {
		ArrayList<String> returna = new ArrayList<String> ();
		Manejador m = Manejador.getInstancia();
		Curso curso = m.buscarCurso(nCurso);
		for(Curso c :curso.getCursos()) {
			returna.add(c.getNombre());
		}
		return returna;
	}

	@Override
	public ArrayList<String> seleccionarInstituto(String nInst) {
		Manejador m = Manejador.getInstancia();
		Instituto insti = m.buscarInstituto(nInst);
		return insti.getNomCursos();
	}
	@Override
	public DtEdicion seleccionarEdicion(String nEdicion) {
		Manejador m = Manejador.getInstancia();
		this.nEdicion = nEdicion;
		Edicion e = m.buscarEdicion(nEdicion);
		return e.getDtEdicion();
	}


	@Override
	public DtEstudiante imprimirEstudiante() {
		Manejador m = Manejador.getInstancia();
		Estudiante u = (Estudiante) m.buscarUsuario(this.nickname);
		return u.getDtEstudiante();
	}

	@Override
	public DtDocente imprimirDocente() {
		Manejador m = Manejador.getInstancia();
		Docente u = (Docente) m.buscarUsuario(this.nickname);
		return u.getDtDocente();
	}

	@Override
	public ArrayList<String> listarProgramas() {
		ArrayList<String> retorno = new ArrayList<>();
		Manejador m = Manejador.getInstancia();
		ArrayList<Programa> programas = m.getProgramas();
		for(Programa p : programas) {
			retorno.add(p.getNombre());
		}
		return retorno;
	}
	public ArrayList<String> getNomEstudiantes() {
		ArrayList<String> retorno = new ArrayList<String>();
		Manejador manejador = Manejador.getInstancia();
		for(Usuario u : manejador.getUsuarios()) {
			if(u instanceof  Estudiante) {
				retorno.add(u.getNickname());
			}
		}
		return retorno;
	}
	public ArrayList<String> getNomDocentes() {
		ArrayList<String> retorno = new ArrayList<String>();
		Manejador manejador = Manejador.getInstancia();
		for(Usuario u : manejador.getUsuarios()) {
			if(u instanceof  Docente) {
				retorno.add(u.getNickname());
			}
		}
		return retorno;
	}

	@Override
	public ArrayList<String> listarUsuarios() {
		Manejador m = Manejador.getInstancia();
		ArrayList<String> retorno = new ArrayList<>();
		for(Usuario u : m.getUsuarios()) {
			retorno.add(u.getNickname());
		}
		return retorno;
	}

	@Override
	public ArrayList<String> listarCurso() {
		ArrayList<String> retorno = new ArrayList<>();
		Manejador m = Manejador.getInstancia();
		ArrayList<Curso> cursos = m.getCursos();
		for(Curso c : cursos) {
			retorno.add(c.getNombre());
		}
		return retorno;
	}

	@Override
	public ArrayList<String> listarInstituto() {
		// TODO Auto-generated method stub
		Manejador m = Manejador.getInstancia();
		ArrayList<String> retorno = new ArrayList<>();
		for(Instituto i : m.getInstitutos()) {
			retorno.add(i.getNombre());
		}
		return retorno;
	}

	@Override
	public ArrayList<String> listarCategorias() {
		Manejador m = Manejador.getInstancia();
		ArrayList<String> retorno = new ArrayList<>();
		for(Categoria i : m.getCategoria()) {
			retorno.add(i.getNombre());
		}
		return retorno;
	}
	@Override 
	public DtUsuario imprimirUsuario(String nname) { 
		Manejador m = Manejador.getInstancia();
		Usuario u = m.buscarUsuario(nname); 
		return u.getDtUsuario(); 
	}

	@Override
	public ArrayList<String> getDocentesDeInsti(String insti) {
		Manejador m = Manejador.getInstancia();
		ArrayList<String> retorno= new ArrayList<>();
		
		for(Docente d : m.getDocentes()) {
			if(d.getInstituto().equals(insti)){
				retorno.add(d.getNickname());
			}
		}
		return retorno;
	} 
	
	@Override
	public ArrayList<String> getCursosporCat(String cate) {
		Manejador m = Manejador.getInstancia();
		ArrayList<String> retorno= new ArrayList<>();
		
		for(Curso c : m.getCursos()) {
			for(Categoria x : c.getCategoria()) {
				if(x.getNombre().equals(cate)) {
					retorno.add(c.getNombre());
				}
			}
		}
		return retorno;
	}
	
	@Override
	public ArrayList<String> getDocentesEdicion(String edi) {
		Manejador m = Manejador.getInstancia();
		Edicion e = m.buscarEdicion(edi);
		ArrayList<String> retorno= new ArrayList<>();
		String nom_ap;
		
		for(Docente d : e.getDocentes()) {
			nom_ap = d.getNombre() + " " + d.getApellido();
			retorno.add(nom_ap);
		}
		return retorno;
	}
	
	
	public ArrayList<String> resultadoBusqueda(String search, String Filtro) throws SQLException {
		Manejador m = Manejador.getInstancia();
		ArrayList<String> retorno= new ArrayList<>();
		
		 String jdbcUrl = "jdbc:postgresql://localhost:5432/labd";
		 String username = "postgres";
		 String password = "Oracle10";
		 try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
		
		 System.out.println("elfiltro que entra: "+ Filtro);
		
		if(Filtro.equals("asc")){
			//String sql = "SELECT nombre FROM Curso";
			String sql = "SELECT nombre, descripcion FROM Curso WHERE nombre like CONCAT( '%',?,'%') UNION (SELECT nombre, descripcion FROM Curso WHERE descripcion like CONCAT( '%',?,'%') ) ORDER BY nombre asc ";
			//String sql = "SELECT nombre FROM  Curso WHERE nombre like CONCAT( '%',?,'%')  ORDER BY nombre asc   ";
			 PreparedStatement preparedStmt = conn.prepareStatement(sql);
		      preparedStmt.setString(1,search);
		     preparedStmt.setString(2, search);
		      ResultSet rs = preparedStmt.executeQuery();
		      if(rs==null) {
		    	  System.out.println("rs es null");
		      }
		      else {
		    	 
		    	  while(rs.next()){
			        	
			            retorno.add("CURSO : "+rs.getString("nombre")+" // DESCRIPCION: "+rs.getString("descripcion"));
			        }
		      }
		       
		}else if(Filtro.equals("desc")){
			String sql2 = "SELECT tabla1.nombre,tabla1.descripcion  FROM (SELECT nombre,fechareg, descripcion  FROM Curso WHERE nombre LIKE CONCAT( '%',?,'%')  UNION (SELECT nombre,fechareg, descripcion  FROM Curso WHERE descripcion LIKE CONCAT( '%',?,'%') ) ORDER BY fechareg desc)AS tabla1 ";
			PreparedStatement preparedStmt = conn.prepareStatement(sql2);
		      preparedStmt.setString(1, search);
		      preparedStmt.setString(2, search);
		      ResultSet rs = preparedStmt.executeQuery();
		        while(rs.next()){
		            retorno.add("CURSO : "+rs.getString("nombre")+" // DESCRIPCION: "+rs.getString("descripcion"));
		        }
		}else {
			String sql3 = "SELECT nombre, descripcion FROM Curso WHERE nombre LIKE CONCAT( '%',?,'%') UNION (SELECT nombre, descripcion  FROM Curso WHERE descripcion LIKE CONCAT( '%',?,'%')) ";
			PreparedStatement preparedStmt = conn.prepareStatement(sql3);
		      preparedStmt.setString(1, search);
		      preparedStmt.setString(2, search);
		      ResultSet rs = preparedStmt.executeQuery();
		        while(rs.next()){
		            retorno.add("CURSO : "+rs.getString("nombre")+" // DESCRIPCION: "+rs.getString("descripcion"));
		        }
		}
		System.out.println("el valor que retorna es: " + retorno);
		return retorno;
	}
	@Override 
	public ArrayList<InscripcionEd> getEstudiantesInscA(String edicion){
		Manejador m=Manejador.getInstancia();
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		//Query query = em.createQuery("Select i  From InscripcionEd i where edicion_nombre=edicion");
		//Where i.edicion_nombre=edicion
		Query nativeQuery = em.createQuery("SELECT i FROM InscripcionEd i where estadoinsc='Aceptado'");
		 
		ArrayList<InscripcionEd> listEstuIns = (ArrayList<InscripcionEd>) nativeQuery.getResultList();
		
		ArrayList<InscripcionEd> retorno = new ArrayList<>();
		for(InscripcionEd  i:listEstuIns) {
			if((i.getEdicion()).getNombre().equals(edicion)) {
			retorno.add(i);
			}
		}
		return retorno;
	}
	
	@Override 
	public ArrayList<InscripcionEd> getEstudiantesInsc(String edicion){
		Manejador m=Manejador.getInstancia();
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		//Query query = em.createQuery("Select i  From InscripcionEd i where edicion_nombre=edicion");
		//Where i.edicion_nombre=edicion
		Query nativeQuery = em.createQuery("SELECT i FROM InscripcionEd i");
      
		ArrayList<InscripcionEd> listEstuIns = (ArrayList<InscripcionEd>) nativeQuery.getResultList();
		
		ArrayList<InscripcionEd> retorno = new ArrayList<>();
		for(InscripcionEd  i:listEstuIns) {
			if((i.getEdicion()).getNombre().equals(edicion)) {
			retorno.add(i);
			}
		}
		return retorno;
	}
	
	public ArrayList<String> getEdicionCursoDoc(String curso, String docente) throws SQLException {
		System.out.println("estoy en SET_ESTADO_INST");
	    String jdbcUrl = "jdbc:postgresql://localhost:5432/labd";
	    String username = "postgres";
	    String password = "Oracle10";
	    
	    Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
	
	    String sql = "select eu.ediciones_nombre from edicion_usuario eu JOIN curso_edicion ce ON eu.ediciones_nombre = ce.ediciones_nombre where ce.curso_nombre = ? and eu.docentes_nickname = ?";
	    
	    PreparedStatement preparedStmt = conn.prepareStatement(sql);
	      preparedStmt.setString(1, curso);
	      preparedStmt.setString(2, docente);
	      ArrayList<String> list = new ArrayList<String>();
	      ResultSet rs = preparedStmt.executeQuery();
          while(rs.next()){
              list.add(rs.getString(1));
          }
          System.out.println("estoy ");
	     // preparedStmt.execute();
          return list;
	    //  System.out.println("ejecuto la consulta");
	}
	
	


}
