package Interface;

import java.sql.SQLException;
import java.util.ArrayList;

import DataType.DtUsuario;

public interface IModificacion {

public ArrayList<String> consultarUsuario();
public ArrayList<String> listarUsuario();
public DtUsuario seleccionarUsuario(String nName);
public	void modificarUsuario(DtUsuario datos);
public	ArrayList<String> listarProgramas();
public	ArrayList<String> listarCursos();
public	void seleccionaPrograma(String nProg);
public	void seleccionaCurso(String nCurso);
public	void agregarPrograma();
void setEstadoInst(String estado, String estudiante, String edicion) throws SQLException;
	
}
