package DataType;

import java.util.ArrayList;

public class DtDocente2 {
	DtDocente docente;
	ArrayList<String> ediciones;
	public DtDocente2() {
		super();
	}
	public DtDocente2(DtDocente docente, ArrayList<String> ediciones) {
		super();
		this.docente = docente;
		this.ediciones = ediciones;
	}
	public DtDocente getDocente() {
		return docente;
	}
	public ArrayList<String> getEdiciones() {
		return ediciones;
	}
	
	public void setDocente(DtDocente docente) {
		this.docente = docente;
	}
	public void setEdiciones(ArrayList<String> ediciones) {
		this.ediciones = ediciones;
	}
	
	
	
}
