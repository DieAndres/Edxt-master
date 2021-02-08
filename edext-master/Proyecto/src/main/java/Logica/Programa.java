package Logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import DataType.DtPrograma;
@Entity
public class Programa {
	@Id
	private String nombre;
	private String descripcion;
	private Date fInicio;
	private Date fFin;
	private String foto;
	
	@ManyToMany(cascade = CascadeType.ALL)
	List <Curso> cursos = new ArrayList <Curso>();
	
	@OneToMany(mappedBy="programa",cascade=CascadeType.ALL,orphanRemoval=true)
	List <InscripcionProg> inscProg = new ArrayList <>();
	
	public Programa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Programa(String nombre, String descripcion, Date fInicio, Date fFin, String foto) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fInicio = fInicio;
		this.fFin = fFin;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	
	public DtPrograma getDtPrograma() {
		return new DtPrograma(nombre,descripcion,fInicio,fFin, foto);
	}
	
	public ArrayList<Curso> getCursos() {
		return  (ArrayList)cursos;
	}

	public ArrayList<String> getCursosNom() {
		ArrayList<String> retorno= new ArrayList<String>();
		for(Curso c : cursos) {
			retorno.add(c.getNombre());
		}
		
		return retorno;
	}
	
	public void setCursos(ArrayList<Curso> cursos) {
		this.cursos = cursos;
	}

	public void addCurso(Curso curso) {
		cursos.add(curso);
	}
	
}
