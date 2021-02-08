package DataType;

import java.util.Date;

public class DtPrograma {
	private String nombre;
	private String descripcion;
	private Date fInicio;
	private Date fFin;
	private String foto;
	
	public DtPrograma(String nombre, String descripcion, Date fInicio, Date fFin, String foto) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fInicio = fInicio;
		this.fFin = fFin;
		this.foto = foto;
	}
	
	public DtPrograma() {
		super();
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setfInicio(Date fInicio) {
		this.fInicio = fInicio;
	}

	public void setfFin(Date fFin) {
		this.fFin = fFin;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getFoto() {
		return foto;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Date getfInicio() {
		return fInicio;
	}

	public Date getfFin() {
		return fFin;
	}

	@Override
	public String toString() {
		return "DtPrograma [nombre=" + nombre + ", descripcion=" + descripcion + ", fInicio=" + fInicio + ", fFin="
				+ fFin + ", foto=" + foto + "]";
	}
		
}
