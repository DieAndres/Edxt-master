package Logica;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import Persistencia.InscripcionProgID;
@Entity
@IdClass(InscripcionProgID.class)
public class InscripcionProg {
	@Id
	@ManyToOne
	private Programa  programa;
	
	@Id
	@ManyToOne
	private Estudiante estudianteP;
	
	@Temporal(TemporalType.DATE)
	private Date fInscripcion;
	
	public InscripcionProg() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InscripcionProg(Programa programa, Date fInscripcion) {
		super();
		this.programa = programa;
		this.fInscripcion = fInscripcion;
	}

	public Programa getPrograma() {
		return programa;
	}

	public void setPrograma(Programa programa) {
		this.programa = programa;
	}

	public Date getfInscripcion() {
		return fInscripcion;
	}

	public void setfInscripcion(Date fInscripcion) {
		this.fInscripcion = fInscripcion;
	}
	
	
}
