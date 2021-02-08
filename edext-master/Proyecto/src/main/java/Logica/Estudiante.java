package Logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import DataType.DtEstudiante;
import DataType.EnumEstadoInscripcion;
@Entity
@DiscriminatorValue("E")
public class Estudiante extends Usuario {

	@OneToMany(mappedBy="estudianteE",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<InscripcionEd> inscripcionesEd = new ArrayList<InscripcionEd>();
	
	@OneToMany(mappedBy="estudianteP",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<InscripcionProg> inscripcionesProg = new ArrayList<InscripcionProg>();
	
	
	public Estudiante(String nickname, String nombre, String apellido, String email,Date fNac,String pass, String foto) {
		super(nickname, nombre, apellido, email,fNac,pass, foto);
	}
	
	
	public Estudiante() {
		super();
	}
	public DtEstudiante getDtEstudiante() {
		ArrayList<String> ediciones = new ArrayList<String>();
		ArrayList<String> programas = new ArrayList<String>();
		
		for(InscripcionEd ied : inscripcionesEd) {
			ediciones.add(ied.getEdicion().getNombre());
		}
		
		for(InscripcionProg ipg : inscripcionesProg) {
			programas.add(ipg.getPrograma().getNombre());
		}
		return new DtEstudiante(this.getDtUsuario(), ediciones, programas);
	}
	
	public void registrarse(Edicion e, Date fInscripcion, String insEd) {
		InscripcionEd ie = new InscripcionEd(e,this, fInscripcion, insEd); 
		inscripcionesEd.add(ie);
		
		e.getInscEd().add(ie);

	}
	
	public Boolean isInscripto(String edicion) {
		for(InscripcionEd ed :inscripcionesEd) {
			if(ed.getEdicion().getNombre().equals(edicion)) {
				return true;
			}
		}
		return false;
	}
	public ArrayList<String> getNomEd() {
		ArrayList<String> retorno = new ArrayList<String>();
		for(InscripcionEd ed :inscripcionesEd) {
			retorno.add(ed.getEdicion().getNombre());
		}
		return retorno;
	}
	public ArrayList<String> getNomPr() {
		ArrayList<String> retorno = new ArrayList<String>();
		for(InscripcionProg pr :inscripcionesProg) {
			retorno.add(pr.getPrograma().getNombre());
		}
		return retorno;
	}
	
}
