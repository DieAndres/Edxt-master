package DataType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DtPrograma2 {
	private String nombre;
	private String descripcion;
	private Date fInicio;
	private Date fFin;
	private String foto;
	private List<String> cursos = new ArrayList<>();
	
	public DtPrograma2() {
		super();
	}

	public DtPrograma2(String nombre, String descripcion, Date fInicio, Date fFin, List<String> cursos, String foto) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fInicio = fInicio;
		this.fFin = fFin;
		this.cursos = cursos;
		this.foto = foto;
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

	public void setCursos(List<String> cursos) {
		this.cursos = cursos;
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

	public List<String> getCursos() {
		return cursos;
	}

	@Override
	public String toString() {
		return "DtPrograma2 [nombre=" + nombre + ", descripcion=" + descripcion + ", fInicio=" + fInicio + ", fFin="
				+ fFin + ", foto=" + foto + ", cursos=" + cursos + "]";
	}
	
}
