package Logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import DataType.DtDocente;

@Entity
@DiscriminatorValue("D")
public class Docente  extends Usuario {
	@ManyToMany(mappedBy = "docentes")
	 List <Edicion> ediciones = new ArrayList <Edicion>();
	
	@ManyToOne
	@JoinColumn
	 Instituto insti;
	
	
	public Docente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Docente(String nickname, String nombre, String apellido, String email,Date fNac,Instituto insti, String pass, String foto) {
		super(nickname, nombre, apellido, email,fNac,pass, foto);
		this.insti = insti;
	}

	public DtDocente getDtDocente() {
		return new DtDocente(this.getNickname(), this.getNombre(), this.getApellido(), this.getEmail(), this.getfNac(), this.insti.getNombre(),this.getPass(), this.getFoto());
	}	
	
	public ArrayList<String> getNomEd() {
		ArrayList<String> retorno = new ArrayList<String>();
		for(Edicion ed :ediciones) {
			retorno.add(ed.getNombre());
		}
		return retorno;
	}
	public String getInstituto() {
		return this.insti.getNombre();
	}
	
}
