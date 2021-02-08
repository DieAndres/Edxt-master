package Excepciones;

public class EdicionRepetidaEnCursoExcepcion extends Exception {
	private static final long serialVersionUID = 1L;
	
	public EdicionRepetidaEnCursoExcepcion (String string) {
		super(string);
	}
	
}
