package Persistencia;

import java.io.Serializable;

public class InscripcionEdID implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String edicion;
	private String estudianteE;
	
	
	public InscripcionEdID() {
		super();
	}


	public String getEdicion() {
		return edicion;
	}


	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}


	public String getEstudianteE() {
		return estudianteE;
	}


	public void setEstudianteE(String estudianteE) {
		this.estudianteE = estudianteE;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((edicion == null) ? 0 : edicion.hashCode());
		result = prime * result + ((estudianteE == null) ? 0 : estudianteE.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InscripcionEdID other = (InscripcionEdID) obj;
		if (edicion == null) {
			if (other.edicion != null)
				return false;
		} else if (!edicion.equals(other.edicion))
			return false;
		if (estudianteE == null) {
			if (other.estudianteE != null)
				return false;
		} else if (!estudianteE.equals(other.estudianteE))
			return false;
		return true;
	}

}
