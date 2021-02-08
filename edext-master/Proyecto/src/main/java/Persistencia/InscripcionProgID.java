package Persistencia;

import java.io.Serializable;

public class InscripcionProgID  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String programa;
	private String estudianteP;
	public InscripcionProgID() {
		super();
	}
	public String getPrograma() {
		return programa;
	}
	public void setPrograma(String programa) {
		this.programa = programa;
	}
	public String getEstudianteP() {
		return estudianteP;
	}
	public void setEstudianteP(String estudianteP) {
		this.estudianteP = estudianteP;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estudianteP == null) ? 0 : estudianteP.hashCode());
		result = prime * result + ((programa == null) ? 0 : programa.hashCode());
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
		InscripcionProgID other = (InscripcionProgID) obj;
		if (estudianteP == null) {
			if (other.estudianteP != null)
				return false;
		} else if (!estudianteP.equals(other.estudianteP))
			return false;
		if (programa == null) {
			if (other.programa != null)
				return false;
		} else if (!programa.equals(other.programa))
			return false;
		return true;
	}
	
	

}