package Logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.persistence.EntityManager;

import DataType.DtUsuario;
import Interface.IModificacion;
import Persistencia.Conexion;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CModificacion implements IModificacion {
	private String nCurso;
	private String nProg;
	public CModificacion() {
		super();
	}
	
	@Override
	public ArrayList<String> consultarUsuario() {
		ArrayList<String> retorno = new ArrayList<>();
		Manejador m = Manejador.getInstancia();
		ArrayList<Usuario> usuarios = m.getUsuarios();
		for(Usuario u : usuarios) {
			retorno.add(u.getNombre());
		}
		return retorno;
	}
	
	@Override
	public ArrayList<String> listarUsuario() {
		ArrayList<String> retorno = new ArrayList<>();
		Manejador m = Manejador.getInstancia();
		ArrayList<Usuario> usuarios = m.getUsuarios();
		for(Usuario u : usuarios) {
			retorno.add(u.getNickname());
		}
		return retorno;
	}

	@Override
	public DtUsuario seleccionarUsuario(String nName) {
		Manejador m = Manejador.getInstancia();
		Usuario user = m.buscarUsuario(nName);
		DtUsuario retorno = user.getDtUsuario();	
		return retorno;
	}

	@Override
	public void modificarUsuario(DtUsuario datos) {
		Manejador m = Manejador.getInstancia();
		Usuario user = m.buscarUsuario(datos.getNickName());
		user.modificarUsuario(datos);
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(user);
		
		em.getTransaction().commit();
		
		
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

	@Override
	public ArrayList<String> listarCursos() {
		ArrayList<String> retorno = new ArrayList<>();
		Manejador m = Manejador.getInstancia();
		ArrayList<Curso> cursos = m.getCursos();
		for(Curso c : cursos) {
			retorno.add(c.getNombre());
		}
		return retorno;
	}

	@Override
	public void seleccionaPrograma(String nProg) {
		this.nProg = nProg;
	}

	@Override
	public void seleccionaCurso(String nCurso) {
		this.nCurso = nCurso;
		
	}

	@Override
	public void agregarPrograma() {
		Manejador m = Manejador.getInstancia();
		Programa p = m.buscarPrograma(nProg);
		Curso c = m.buscarCurso(nCurso);
		p.addCurso(c);
		c.addPrograma(p);
	}
	
	@Override
	public void setEstadoInst(String estado, String estudiante, String edicion) throws SQLException {
		System.out.println("estoy en SET_ESTADO_INST");
	    String jdbcUrl = "jdbc:postgresql://localhost:5432/labd";
	    String username = "postgres";
	    String password = "Oracle10";
	    
	    Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
	    String sql = "update inscripcioned set estadoinsc = ? where estudiantee_nickname = ? and edicion_nombre = ?";
	    PreparedStatement preparedStmt = conn.prepareStatement(sql);
	      preparedStmt.setString(1, estado);
	      preparedStmt.setString(2, estudiante);
	      preparedStmt.setString(3, edicion);

	      preparedStmt.execute();
	      System.out.println("ejecuto la consulta");
	}
}
