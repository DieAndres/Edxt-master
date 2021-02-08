package DataType;

import java.util.ArrayList;

public class DtEstudiante {
	DtUsuario usuario;
	ArrayList<String> ediciones;
	ArrayList<String> programas;
	
	public DtEstudiante(DtUsuario usuario, ArrayList<String> ediciones, ArrayList<String> programas) {
		super();
		this.usuario = usuario;
		this.ediciones = ediciones;
		this.programas = programas;
	}
	
	public DtEstudiante(DtUsuario usuario) {
		super();
		this.usuario = usuario;
		
	}
	

	public DtEstudiante() {
		super();
	}

	public void setUsuario(DtUsuario usuario) {
		this.usuario = usuario;
	}

	public void setEdiciones(ArrayList<String> ediciones) {
		this.ediciones = ediciones;
	}

	public void setProgramas(ArrayList<String> programas) {
		this.programas = programas;
	}

	public DtUsuario getUsuario() {
		return usuario;
	}



	public ArrayList<String> getEdiciones() {
		return ediciones;
	}


	public ArrayList<String> getProgramas() {
		return programas;
	}


	@Override
	public String toString() {
		return "DtEstudiante [usuario=" + usuario + ", ediciones=" + ediciones + ", programas=" + programas + "]";
	}
		
}
