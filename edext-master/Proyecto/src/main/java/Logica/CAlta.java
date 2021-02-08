package Logica;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityManager;

import DataType.DtCurso;
import DataType.DtDocente;
import DataType.DtEdicion;
import DataType.DtEstudiante;
import DataType.DtPrograma;
import DataType.DtUsuario;
import DataType.EnumEstadoInscripcion;
import DataType.DtCategoria;
import Excepciones.ProgramaRepetidoExcepcion;
import Interface.Fabrica;
import Interface.IAlta;
import Interface.IConsulta;
import Interface.IModificacion;
import Persistencia.Conexion;



public class CAlta implements IAlta {
	private String nCurso;
	private String nInst;
	private DtCurso datosC;
	private DtEdicion datosE;
	@SuppressWarnings("unuszed")
	private String nickname;
	@SuppressWarnings("unused")
	private Date fInscripcion;	
	
	public CAlta() {
		super();
	}
	
	@Override
	public ArrayList<String> listarCursos(String nInsti) {
		Manejador m = Manejador.getInstancia();
		Instituto insti = m.buscarInstituto(nInsti);
		return insti.getNomCursos();
	}

	@Override
	public ArrayList<String> selectInstituto(String nInst) {
		this.nInst = nInst;
		Manejador m = Manejador.getInstancia();
		Instituto insti = m.buscarInstituto(nInst);
		return insti.getNomCursos();

	}

	@Override
	public DtEdicion seleccionarCurso(String nCurso) {
		this.nCurso = nCurso;
		DtEdicion retorno = new DtEdicion();
		Manejador m = Manejador.getInstancia();
		Curso curso = m.buscarCurso(nCurso);
		ArrayList<Edicion> ediciones = curso.getEdiciones();
		/*se considera edicion vigente a la edicion en curso 
		  if(fInicio <= actual && fFin >= actual)*/
		for(Edicion e: ediciones) {
			if(e.esVigente() == true) {
				retorno = e.getDtEdicion();
				//break;
				
			}
		}
		
		return retorno; //crear excepcion si no existe el DtEdicion??? que pasa si es null??
	}

	@Override
	public Boolean seleccionarCurso2(String nCurso, DtEdicion datosE) {
		this.datosE = datosE;
		this.nCurso = nCurso;
		Manejador m = Manejador.getInstancia();
		Curso curso = m.buscarCurso(nCurso);
		return m.buscarEdicion(datosE.getNombre()) != null;		
	}

	@Override	 
	//fInscripcion deberia ser fecha actual
	
	public Boolean seleccionarEstudiante(String nickname, Date fInscripcion) {
		Manejador m = Manejador.getInstancia();
		this.nickname = nickname;
		this.fInscripcion = fInscripcion;
		if(m.buscarUsuario(nickname) == null) {
			return false;
		}else {
			return true;
		}
	}
	
	@Override
	public Boolean registroCategoria(String cat) {
		Boolean existe = false;
		Manejador m = Manejador.getInstancia();
		if(m.buscarCategoria(cat) == null) {
			Categoria c = new Categoria(cat);
			m.addCategoria(c);
			return false;
		}
		return true;
		
	}
	
	

	@Override
	public Boolean registroUsuario(DtUsuario usr) {
		Boolean existe = false;
		Manejador m = Manejador.getInstancia();
		ArrayList<Usuario> usuarios = m.getUsuarios();
		for(Usuario u: usuarios) {
			if(u.getNickname().equals(usr.getNickName()) || u.getEmail().equals(usr.getEmail()))
				existe = true;
				
		}
		//SE MODIFICO LA CLASE Docente PORQUE TENIA UN OBJETO Instituto y no un string inti.
		if(existe == false) {
			Usuario user = new Usuario(usr.getNickName(),usr.getNombre(),usr.getApellido(),usr.getEmail(),usr.getFecha(),usr.getPass(),usr.getFoto());
			m.addUsuario(user);
		}	
		
		return existe;
	}
	
	@Override
	public Boolean registroUsuarioEst(DtEstudiante est){
		DtUsuario usr= est.getUsuario();
		Boolean existe = false;
		Manejador m = Manejador.getInstancia();
		ArrayList<Usuario> usuarios = m.getUsuarios();
		for(Usuario u: usuarios) {
			if(u.getNickname().equals(usr.getNickName()) || u.getEmail().equals(usr.getEmail()))
				existe = true;
				
		}
		//SE MODIFICO LA CLASE Docente PORQUE TENIA UN OBJETO Instituto y no un string inti.
		if(existe == false) {
			Estudiante user = new Estudiante(usr.getNickName(),usr.getNombre(),usr.getApellido(),usr.getEmail(),usr.getFecha(),usr.getPass(),usr.getFoto());
			m.addUsuario(user);
		}	
		
		return existe;
	}

	@Override
	public Boolean registroUsuarioDoc(DtDocente usr)  {
		Boolean existe = false;
		Manejador m = Manejador.getInstancia();
		ArrayList<Usuario> usuarios = m.getUsuarios();
		for(Usuario u: usuarios) {
			if(u.getNickname().equals(usr.getNickName()) || u.getEmail().equals(usr.getEmail()))
				existe = true;
				
		}
		if(existe == false) {
			Instituto inst = m.buscarInstituto(usr.getInstituto());
			Docente user = new Docente(usr.getNickName(),usr.getNombre(),usr.getApellido(),usr.getEmail(),usr.getFecha(),inst,usr.getPass(),usr.getFoto());
			m.addUsuario(user);
		}			
		return existe;
	}

	@Override
	public Boolean registroInstituto(String nInst) {
		Fabrica f = Fabrica.getInstancia();
		IConsulta icon = f.getIConsulta();
		Manejador m = Manejador.getInstancia();
		
		
		if(m.buscarInstituto(nInst) == null) {
			Instituto i = new Instituto(nInst);
			m.addInstituto(i);
			return false;
		}
		return true;
	}


	@Override
	public Boolean registroCurso(DtCurso datosC,String nInst) {
		Boolean retorno = true;
		Manejador m = Manejador.getInstancia();
		if(m.buscarCurso(datosC.getNombre()) == null) {
			this.nInst = nInst;
			this.datosC =datosC;
			retorno = false;
		}
		return retorno;	
		
	}
	
	@Override
	public void registrarPrograma(DtPrograma infoProg) throws ProgramaRepetidoExcepcion {
		Manejador m = Manejador.getInstancia();
		if(m.buscarPrograma(infoProg.getNombre()) != null) {
			throw new ProgramaRepetidoExcepcion("El programa de formacion " + infoProg.getNombre() + " ya existe");
		}
		Programa p = new Programa(infoProg.getNombre(),infoProg.getDescripcion(),infoProg.getfInicio(),infoProg.getfFin(), infoProg.getFoto());
		m.addPrograma(p);
	}
	
	@Override
	public void confirmarCurso(ArrayList<String> cursos) {
		Manejador m = Manejador.getInstancia();

		Curso c = new Curso(datosC.getNombre(),datosC.getDescripcion(),datosC.getURL(),datosC.getDuracion(),
				datosC.getCantHoras(),datosC.getCreditos(),datosC.getFechaReg(), datosC.getFoto());
		Instituto i = m.buscarInstituto(nInst);
		if(cursos !=null) {
		for(String previa: cursos) {
			Curso prev = m.buscarCurso(previa);
			c.addPrevia(prev);
		}
	}
		i.addCurso(c);
		m.addCurso(c);
		
	}
	@Override
	public void confirmarEdicion() {
		Edicion e = new Edicion(datosE.getNombre(),datosE.getfInicio(),datosE.getfFin(),datosE.getCupo(),datosE.getfPublicacion(), datosE.getFoto());
		Manejador m = Manejador.getInstancia();
		m.addEdicion(e);
		Curso c = m.buscarCurso(nCurso);
		c.addEdicion(e);
	}
	
	public void registrarEstEdicion(String nickname, String nomEdi,Date fInscri,String estIns) {
		Manejador manejador = Manejador.getInstancia();
		Estudiante estudiante = (Estudiante) manejador.buscarUsuario(nickname);
		Edicion edicion = manejador.buscarEdicion(nomEdi);
		estudiante.registrarse(edicion, fInscri, estIns);
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		em.persist(edicion);
		em.getTransaction().commit();
	}
	
	
	
	@Override
	public void cancelar() {
		nCurso = null;
		nInst = null;
		datosC = null;
		datosE = null;
	}
	
	public void agregarPrograma(String prog, String curso) {
		Manejador manejador = Manejador.getInstancia();
		Programa p  = manejador.buscarPrograma(prog);
		Curso c  = manejador.buscarCurso(curso); 
		c.addPrograma(p);
		p.addCurso(c);
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.persist(p);
		em.getTransaction().commit();
		
	}

	@Override
	public void AgregarCategoriaCurso(String curso, String categoria) {
		Manejador manejador = Manejador.getInstancia();
		Curso c  = manejador.buscarCurso(curso); 
		Categoria cat = manejador.buscarCategoria(categoria);
		c.addCategoria(cat);
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		
	}

	@Override
	public void AgregarDocentesAedicion(String edicion, String docentes) {
		Manejador manejador = Manejador.getInstancia();
		Edicion e = manejador.buscarEdicion(edicion);
		Docente d =(Docente)manejador.buscarUsuario(docentes);
		e.addDocente(d); 
		//d.addEdicion(e); 
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager(); 
		em.getTransaction().begin(); 
		em.persist(e);
		em.getTransaction().commit(); 
		
		/*Manejador manejador = Manejador.getInstancia();
		Edicion e  = manejador.buscarEdicion(edicion); 
		ArrayList<String> doc = docentes;
		ArrayList<Docente> listDoc = manejador.getDocentes();
		ArrayList<Docente> lDoc = new ArrayList<>();
		
		for(Docente d : listDoc) {
			for(String s : doc) {
				if(s.equals(d.getNickname())) {
					lDoc.add(d);
				}
			}
		}
		e.setDocentes(lDoc);
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();*/
	}
	
	
	

}
