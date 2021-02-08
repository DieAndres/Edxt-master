package Logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import DataType.DtEdicion;
@Entity
public class Edicion {
	@Id
	private String nombre;
	private Date fInicio;
	private Date fFin;
	private Integer cupo;
	private Date fPublicacion;
	private String foto;
	
	@ManyToMany(cascade = CascadeType.ALL)
	List<Docente> docentes = new ArrayList<>();
	
	/*@ManyToMany(cascade = CascadeType.ALL)
	List<Estudiante> estudiantes = new ArrayList<>();*/
	
	@OneToMany(mappedBy="edicion",cascade=CascadeType.ALL,orphanRemoval=true)
	List<InscripcionEd> InscEd = new ArrayList<>();
	
	public List<Docente> getDocentes() {
		return docentes;
	}
	public void setDocentes(List<Docente> docentes) {
		this.docentes = docentes;
	}
	/*public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}
	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}*/
	public List<InscripcionEd> getInscEd() {
		return InscEd;
	}
	public void setInscEd(List<InscripcionEd> inscEd) {
		InscEd = inscEd;
	}
	public Edicion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Edicion(String nombre, Date fInicio, Date fFin, Integer cupo, Date fPublicacion, String foto) {
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
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getfInicio() {
		return fInicio;
	}
	public void setfInicio(Date fInicio) {
		this.fInicio = fInicio;
	}
	public Date getfFin() {
		return fFin;
	}
	public void setfFin(Date fFin) {
		this.fFin = fFin;
	}
	public Integer getCupo() {
		return cupo;
	}
	public void setCupo(Integer cupo) {
		this.cupo = cupo;
	}
	public Date getfPublicacion() {
		return fPublicacion;
	}
	public void setfPublicacion(Date fPublicacion) {
		this.fPublicacion = fPublicacion;
	}
	public DtEdicion getDtEdicion() {
		//Crea un DT con los datos basicos de edicion
		return new DtEdicion(nombre, fInicio, fFin, cupo, fPublicacion, foto);
	}
	public boolean esVigente() {
		//La funcion comprueba si dentro del intervalo de fechas est� la fecha actual 
		Date date= new java.util.Date();
		return date.after(fInicio) && date.before(fFin);
	}
	
	/*public void addEstudiante(Estudiante e) {
		estudiantes.add(e);
	}*/
	public void addDocente(Docente doc) { 
		docentes.add(doc);
	} 
	
}
