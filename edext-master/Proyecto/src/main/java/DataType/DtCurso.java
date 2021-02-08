package DataType;

import java.util.Date;

import Tools.Herramienta;

public class DtCurso {
	String nombre;
	String descripcion;
	String URL;
	Integer duracion;
	Integer cantHoras;
	Integer creditos;
	Date fechaReg;
	String foto;
	
	public DtCurso() {
		// TODO Auto-generated constructor stub
	}
	public DtCurso(String nombre, String descripcion, String uRL, Integer duracion, Integer cantHoras, Integer creditos,
			Date fechaReg, String foto) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		URL = uRL;
		this.duracion = duracion;
		this.cantHoras = cantHoras;
		this.creditos = creditos;
		this.fechaReg = fechaReg;
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
	public String getURL() {
		return URL;
	}
	public Integer getDuracion() {
		return duracion;
	}
	public Integer getCantHoras() {
		return cantHoras;
	}
	public Integer getCreditos() {
		return creditos;
	}
	public Date getFechaReg() {
		return fechaReg;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}
	public void setCantHoras(Integer cantHoras) {
		this.cantHoras = cantHoras;
	}
	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}
	public void setFechaReg(Date fechaReg) {
		this.fechaReg = fechaReg;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
	
}
