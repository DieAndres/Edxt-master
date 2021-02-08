package Interface;

import java.sql.SQLException;
import java.util.ArrayList;

import DataType.DtInfoCurso;
import DataType.DtDocente;
import DataType.DtEdicion;
import DataType.DtPrograma;
import DataType.DtPrograma2;
import DataType.DtUsuario;
import Logica.InscripcionEd;
import DataType.DtEstudiante;

public interface IConsulta {
	//public seleccionarUsuario(nickname:string):tipoUsuario
	//public DtEdicion seleccionarEdicion(String nEdicion)//Es la misma funcion que la linea 18;
	public DtPrograma seleccionarPrograma(String nProg) ;
	public DtPrograma2 seleccionarPrograma2(String nProg) ;
	public DtInfoCurso seleccionarCurso(String nCurso) ;
	public ArrayList <String> seleccionarInstituto(String nInst);
	public DtEdicion seleccionarEdicion(String nEdicion);
	public DtEstudiante imprimirEstudiante();
	public DtDocente imprimirDocente();
	public ArrayList <String> listarProgramas();
	public ArrayList <String> listarUsuarios();
	public ArrayList <String> listarCurso();
	public ArrayList <String> listarInstituto();
	public ArrayList <String> listarCategorias();
	public ArrayList<String> getNomDocentes();
	public ArrayList<String> getNomEstudiantes();
	public ArrayList<String> getNomPrevias(String nCurso);
	public DtUsuario imprimirUsuario(String nname);
	public ArrayList<String> getDocentesDeInsti(String insti);
	public ArrayList<String> getCursosporCat(String cate);
	public ArrayList<String> getDocentesEdicion(String edi);
	public ArrayList<InscripcionEd> getEstudiantesInsc(String edicion);
	public ArrayList<String> getEdicionCursoDoc(String curso, String docente) throws SQLException;
	public ArrayList<String> resultadoBusqueda(String search, String Filtro) throws SQLException;
	public ArrayList<InscripcionEd> getEstudiantesInscA(String edicion);
}
