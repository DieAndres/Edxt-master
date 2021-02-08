package Interface;

import Logica.CAlta;
import Logica.CModificacion;
import Logica.CConsulta;

public class Fabrica {
	private static Fabrica instancia = null;
	
	private Fabrica() {}
	
	public static Fabrica getInstancia() {
		if (instancia == null)
			instancia = new Fabrica();
		return instancia;
	}
	
	public IAlta getIAlta() {
		return new CAlta();
	}
	
	public IModificacion getIModificacion() {
		return new CModificacion();
	}
	
	public IConsulta getIConsulta() {
		return new CConsulta();
	}
	
}
