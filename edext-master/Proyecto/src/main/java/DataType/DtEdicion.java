package DataType;

import java.util.Date;

public class DtEdicion {
	String nombre;
	Date fInicio;
	Date fFin;
	Integer cupo;
	Date fPublicacion;
	String foto;
	
	public DtEdicion() {
		super();
	}
	
	public DtEdicion(String nombre, Date fInicio, Date fFin, Integer cupo, Date fPublicacion, String foto) {
		super();
		this.nombre = nombre;
		this.fInicio = fInicio;
		this.fFin = fFin;
		this.cupo = cupo;
		this.fPublicacion = fPublicacion;
		this.foto = foto;
	}
	

	public String getFoto() {
		return foto;
	}
	public String getNombre() {
		return nombre;
	}
	public Date getfInicio() {
		return fInicio;
	}
	public Date getfFin() {
		return fFin;
	}
	public Integer getCupo() {
		return cupo;
	}
	public Date getfPublicacion() {
		return fPublicacion;
	}
	
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setfInicio(Date fInicio) {
		this.fInicio = fInicio;
	}

	public void setfFin(Date fFin) {
		this.fFin = fFin;
	}

	public void setCupo(Integer cupo) {
		this.cupo = cupo;
	}

	public void setfPublicacion(Date fPublicacion) {
		this.fPublicacion = fPublicacion;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "DtEdicion [nombre=" + nombre + ", fInicio=" + fInicio + ", fFin=" + fFin + ", cupo=" + cupo
				+ ", fPublicacion=" + fPublicacion + ", foto=" + foto + "]";
	}
		
}
