package Logica;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import DataType.EnumEstadoInscripcion;
import Persistencia.InscripcionEdID;
@Entity
@IdClass(InscripcionEdID.class)
public class InscripcionEd {
	@Id
	@ManyToOne
	private Edicion edicion;
	
	@Id
	@ManyToOne
    private Estudiante estudianteE;
	
	@Temporal(TemporalType.DATE)
	private Date fInscripcion;
	
	private String estadoInsc;
	
	public InscripcionEd() {
		super();
	}

	public InscripcionEd(Edicion edicion,Estudiante estudianteE, Date fInscripcion, String estadoI) {
		super();
		this.edicion = edicion;
		this.fInscripcion = fInscripcion;
		this.estudianteE = estudianteE;
		this.estadoInsc=estadoI;
		
	}
	public Edicion getEdicion() {
		return edicion;
	}

	public void setEdicion(Edicion edicion) {
		this.edicion = edicion;
	}

	public Date getfInscripcion() {
		return fInscripcion;
	}

	public void setfInscripcion(Date fInscripcion) {
		this.fInscripcion = fInscripcion;
	}

	public String getEstadoInsc() {
		return estadoInsc;
	}

	public void setEstadoInsc(String estadoInsc) {
		this.estadoInsc = estadoInsc;
	}
	public Estudiante getEstudiante() {
		return estudianteE;
	}


}
