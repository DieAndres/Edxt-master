package Interface;

import java.util.ArrayList;
import java.util.Date;

import DataType.DtCurso;
import DataType.DtDocente;
import DataType.DtEdicion;
import DataType.DtEstudiante;
import DataType.DtPrograma;
import DataType.DtUsuario;
import DataType.EnumEstadoInscripcion;
import Excepciones.ProgramaRepetidoExcepcion;

public interface IAlta {
	public ArrayList<String> listarCursos(String nInsti);
	
	public ArrayList<String> selectInstituto(String nInst);
	
	public DtEdicion seleccionarCurso(String nCurso) ;
	
	public Boolean seleccionarCurso2(String nCurso, DtEdicion datosE) ;
	
	public Boolean seleccionarEstudiante(String nickname, Date fInscripcion);
	
	public Boolean registroUsuario(DtUsuario usr) ;
	
	public Boolean registroUsuarioEst(DtEstudiante est) ;
	
	public Boolean registroCategoria(String cate) ;
	
	public Boolean registroUsuarioDoc(DtDocente usr);
	
	public Boolean registroInstituto(String nInst);
	
	public void registrarPrograma(DtPrograma infoProg) throws ProgramaRepetidoExcepcion;
	
	public void confirmarCurso(ArrayList<String> cursos);
	
	public void confirmarEdicion();
	
	public void cancelar();

	public void agregarPrograma(String prog, String curso);
	
	public Boolean registroCurso(DtCurso datosC, String nInst);
	
	public void registrarEstEdicion(String nickname, String nomEdi,Date fInscri, String estIns);

	public void AgregarCategoriaCurso(String curso, String categoria);
	
	public void AgregarDocentesAedicion(String edicion, String docentes);
}