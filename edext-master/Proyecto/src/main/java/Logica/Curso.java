package Logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import DataType.DtCurso;
import DataType.DtEdicion;
import DataType.DtInfoCurso;
import DataType.DtPrograma;
@Entity
public class Curso {
	
	@Id
	private String nombre;
	private String descripcion;
	private String URL;
	private Integer duracion;
	private Integer cantHoras;
	private Integer creditos;
	@Temporal(TemporalType.DATE)
	private Date fechaReg;
	private String foto;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	List<Edicion> ediciones = new ArrayList<>();
	
	@ManyToMany(mappedBy = "cursos")
	List<Programa> programas = new ArrayList<Programa>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	List<Curso> cursos = new ArrayList<>();

	@ManyToMany(cascade = CascadeType.ALL)
	List<Categoria> categoria = new ArrayList<>();
	
	public Curso() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Curso(String nombre, String descripcion, String uRL, Integer duracion, Integer cantHoras, Integer creditos,
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
	
	@Override
	public String toString() {
		return "Curso [nombre=" + nombre + ", descripcion=" + descripcion + ", URL=" + URL + ", duracion=" + duracion
				+ ", cantHoras=" + cantHoras + ", creditos=" + creditos + ", fechaReg=" + fechaReg + ", foto=" + foto
				+ ", ediciones=" + ediciones + ", programas=" + programas + ", cursos=" + cursos + ", categoria="
				+ categoria + "]";
	}
	
	public ArrayList<Categoria> getCategoria() {		
		ArrayList<Categoria> returno = new ArrayList<Categoria>();
		for(Categoria c: categoria) {
			returno.add(c);
		}
		
		return returno;
	}
	
	public void setCategoria(ArrayList<Categoria> cat) {
		this.categoria = cat;
	}
	
	public void addCategoria(Categoria cat) {
		categoria.add(cat);
	}
	
	public ArrayList<Curso> getCursos() {		
		ArrayList<Curso> returno = new ArrayList<Curso>();
		for(Curso c: cursos) {
			returno.add(c);
		}
		
		return returno;
	}
	
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}

	public void setCursos(ArrayList<Curso> cursos) {
		this.cursos = cursos;
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
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public Integer getDuracion() {
		return duracion;
	}
	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}
	public Integer getCantHoras() {
		return cantHoras;
	}
	public void setCantHoras(Integer cantHoras) {
		this.cantHoras = cantHoras;
	}
	public Integer getCreditos() {
		return creditos;
	}
	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}
	public Date getFechaReg() {
		return fechaReg;
	}
	public void setFechaReg(Date fechaReg) {
		this.fechaReg = fechaReg;
	}

	public DtCurso getDtCurso() {
		return new DtCurso(nombre,descripcion,URL,duracion,cantHoras,creditos,fechaReg, foto);
	}
	public void addEdicion(Edicion e) {
		//Agrega la edicion a la lista 
		ediciones.add(e);
	}
	public void addPrograma(Programa p) {
		//Agrega el programa a la lista 
		programas.add(p);
	}
	public DtEdicion getDtEdicion(String nEdicion) {
		Edicion resultado = new Edicion();
		for (Edicion e : ediciones) 
		{ 
			if (e.getNombre() == nEdicion ) {
				resultado = e;
			}
		}
		return resultado.getDtEdicion();
	}
	public DtPrograma getDtPrograma(String nPrograma) {
		Programa resultado = new Programa();
		for (Programa p : programas) 
		{ 
			if (p.getNombre() == nPrograma ) {
				resultado = p;
				break;
			}
		}
		return resultado.getDtPrograma();
	}
	public boolean existeEdicion(String nEdicion) {
		for (Edicion e : ediciones) 
		{ 
			if (e.getNombre().equals(nEdicion)) {
				return true;
			}
		}
		return false;
	}
	
	public DtInfoCurso getDtInfoCurso() {
		DtCurso dtCurso = this.getDtCurso();
		ArrayList<String> edi = new ArrayList<String>();
		ArrayList<String> prog = new ArrayList<String>();
		for(Edicion e : ediciones) {
			edi.add(e.getNombre());
		}
		for(Programa p : programas) {
			prog.add(p.getNombre());
		}
		
		return new DtInfoCurso(dtCurso,prog,edi);
	}

	public ArrayList<Edicion> getEdiciones() {
		ArrayList<Edicion> returno = new ArrayList<Edicion>();
		for(Edicion c: ediciones) {
			returno.add(c);
		}
		
		return returno;
	}

	public void addPrevia(Curso c) {
		cursos.add(c);
	}
	
	public ArrayList<Programa> getProgramas() {
		ArrayList<Programa> returno = new ArrayList<Programa>();
		for(Programa c: programas) {
			returno.add(c);
		}
		
		return returno;
	}
	public DtEdicion getDtEdicionVigente() {
		for(Edicion e: ediciones) {
			if(e.esVigente() == true)
				return e.getDtEdicion();
		}
		return null;
	}
	
}
