package Logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Persistencia.Conexion;



public class Manejador {

	private static Manejador instancia = null;

	
	private Manejador() {}

	public static Manejador getInstancia(){
		if(instancia == null)
			instancia = new Manejador();
		return instancia;
	}
	
	public void addUsuario(Usuario user) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(user);
		
		em.getTransaction().commit();
	}
	public void addCategoria(Categoria cate) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(cate);
		
		em.getTransaction().commit();
	}
	
	
	public void addEdicion(Edicion edicion) {
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(edicion);
		
		em.getTransaction().commit();
	}
	
	public void addCurso(Curso curso) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(curso);
		
		em.getTransaction().commit();
		
	}
	
	public void addPrograma(Programa prog) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(prog);
		
		em.getTransaction().commit();
	}
	
	public void addInstituto(Instituto insti) {
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(insti);
		
		em.getTransaction().commit();
	}
	
	public Usuario buscarUsuario(String nick) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		return em.find(Usuario.class, nick);
	}
	public Usuario buscarUsuarioEmail(String nick) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Usuario user = em.find(Usuario.class, nick);
		return user;
	}
	public Edicion buscarEdicion(String nombre) {

		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Edicion ed = em.find(Edicion.class, nombre);
		return ed;
	}
	public Programa buscarPrograma(String nombre) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		return em.find(Programa.class, nombre);
	}
	public Curso buscarCurso(String nombre) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		return em.find(Curso.class, nombre);
	}
	public Instituto buscarInstituto(String nombre) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		return em.find(Instituto.class, nombre);
	}
	
	public Categoria buscarCategoria(String nombreC) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		return em.find(Categoria.class, nombreC);
	}

	public ArrayList<Usuario> getUsuarios() {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
	
		Query query = em.createQuery("select u from Usuario u");
		
		ArrayList<Usuario> listUs = (ArrayList<Usuario>) query.getResultList();
		

		return listUs;
	}

	public ArrayList<Edicion> getEdiciones() {
		//return ediciones;
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
	
		Query query = em.createQuery("select e from Edicion e");
		
		ArrayList<Edicion> listEd = (ArrayList<Edicion>) query.getResultList();
		return listEd;
		}

	public ArrayList<Curso> getCursos() {
		//return cursos;
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
	
		Query query = em.createQuery("select c from Curso c");
		
		ArrayList<Curso> listCur = (ArrayList<Curso>) query.getResultList();
		

		return listCur;
	}

	public ArrayList<Programa> getProgramas() {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
	
		Query query = em.createQuery("select p from Programa p");
		
		ArrayList<Programa> listProg = (ArrayList<Programa>) query.getResultList();
		return listProg;
	}

	public ArrayList<Instituto> getInstitutos() {
//		return institutos;
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
	
		Query query = em.createQuery("select i from Instituto i");
		
		ArrayList<Instituto> listIns = (ArrayList<Instituto>) query.getResultList();
		return listIns;
	}
	
	public ArrayList<Estudiante> getEstudiantes() {
	/*	ArrayList<Estudiante> retorno = new ArrayList<Estudiante>();
		for(Usuario u : usuarios) {
			if(u instanceof  Estudiante) {
				retorno.add((Estudiante)u);
			}
		}
		return retorno;*/
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
	
		Query query = em.createQuery("select e from Usuario e where e.dtype=E");
		
		ArrayList<Estudiante> listEs = (ArrayList<Estudiante>) query.getResultList();

		return listEs;
	}
	public ArrayList<Docente> getDocentes() {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
	
		Query query = em.createQuery("select d from Docente d");
		
		ArrayList<Docente> listIns = (ArrayList<Docente>) query.getResultList();

		return listIns;
	}
	
	public ArrayList<String> getSeguidores(String nickname) {
		//return ediciones;
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
	
		Query query = em.createQuery("select u.seguidores_nickname from Usuario_Usuario u where u.usuario_nickename=nickname");
		
		ArrayList<String> listseguidores = (ArrayList<String>) query.getResultList();
		return listseguidores;
		}

	public ArrayList<String> getSigoA(String nickname) {
		//return ediciones;
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
	
		Query query = em.createQuery("select u.sigoa_nickname from Usuario_Usuario u where u.usuario_nickename=nickname");
		
		ArrayList<String> listSigoa = (ArrayList<String>) query.getResultList();
		return listSigoa;
		}
	
	public ArrayList<Categoria> getCategoria() {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
	
		Query query = em.createQuery("select i from Categoria i");
		
		ArrayList<Categoria> listCate = (ArrayList<Categoria>) query.getResultList();
		return listCate;
	}
	
}

