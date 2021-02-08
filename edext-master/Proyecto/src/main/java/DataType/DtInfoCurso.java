package DataType;

import java.util.ArrayList;

public class DtInfoCurso {
	DtCurso curso;
	ArrayList<String> programas;
	ArrayList<String> ediciones;
	
	
	public DtInfoCurso() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DtInfoCurso(DtCurso curso, ArrayList<String> programas, ArrayList<String> ediciones) {
		super();
		this.curso = curso;
		this.programas = programas;
		this.ediciones = ediciones;
	}
	
	
	
	public void setCurso(DtCurso curso) {
		this.curso = curso;
	}

	public void setProgramas(ArrayList<String> programas) {
		this.programas = programas;
	}

	public void setEdiciones(ArrayList<String> ediciones) {
		this.ediciones = ediciones;
	}

	public DtCurso getCurso() {
		return curso;
	}
	public ArrayList<String> getProgramas() {
		return programas;
	}
	public ArrayList<String> getEdiciones() {
		return ediciones;
	}
	

}
