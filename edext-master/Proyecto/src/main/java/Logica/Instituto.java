package Logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Instituto {
	@Id
	private String nombre;
	
	@OneToMany(cascade = CascadeType.ALL)
	List<Curso> cursos = new ArrayList<Curso>();
	
	
	public Instituto() {
		// TODO Auto-generated constructor stub
	}
	public Instituto(String nombre) {
		super();
		this.nombre = nombre;
	}
	public Instituto(String nombre, ArrayList<Curso> cursos) {
		super();
		this.nombre = nombre;
		this.cursos = cursos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Curso> getCursos() {
		return (ArrayList)cursos;
	}
	public void addCurso(Curso curso) {
		this.cursos.add(curso);
	}
	
	public void setCursos(ArrayList<Curso> cursos) {
		this.cursos = cursos;
	}
	public ArrayList<String> getNomCursos(){
		ArrayList<String> nombres = new ArrayList<String>();
		if(cursos.size() != 0) {
			for(Curso c : cursos) {
				nombres.add(c.getNombre());
			}
		}
		return nombres;
	}
}
