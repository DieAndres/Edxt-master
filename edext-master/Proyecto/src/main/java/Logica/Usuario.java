package Logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import DataType.DtUsuario;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Usuario {
	@Id	
	private String nickname;
	private String nombre;
	private String apellido;
	private String email;
	private Date fNac;
	private String pass;
	private String foto;
	
	@OneToMany(cascade = CascadeType.ALL) //mappedBy = "seguidores"??? || cascade = CascadeType.ALL??
	List<Usuario> seguidores = new ArrayList<>(); //Usuarios que me siguen a mi
	
	@OneToMany(cascade = CascadeType.ALL)//mappedBy = "sigoA"??? || cascade = CascadeType.ALL??
	List<Usuario> sigoA = new ArrayList<>(); //Usuarios que yo sigo
	
	public Usuario() {
		
	}
	//	SEGUIDORES
	public ArrayList<Usuario> getSeguidores() {		
		ArrayList<Usuario> returno = new ArrayList<Usuario>();
		for(Usuario u: seguidores) {
			returno.add(u);
		}
		
		return returno;
	}

	public void setSeguidores(ArrayList<Usuario> usuarios) {
		this.seguidores = usuarios;
	}
	
	public void addSeguidor(Usuario user) {
		seguidores.add(user);
	}
	
	// SIGO A FULANO
	
	public ArrayList<Usuario> getSigoA() {		
		ArrayList<Usuario> returno = new ArrayList<Usuario>();
		for(Usuario u: sigoA) {
			returno.add(u);
		}
		
		return returno;
	}

	public void setSeguirA(ArrayList<Usuario> usuarios) {
		this.sigoA = usuarios;
	}
	
	public void addSeguirA(Usuario user) {
		sigoA.add(user);
	}
	
	public boolean yaSigoA(String user) { //Devuelve true si existe user en "sigoA"
		for (Usuario u : sigoA) 
		{ 
			if (u.getNombre().equals(user)) {
				return true;
			}
		}
		return false;
	}
	
	public Usuario(String nickname, String nombre, String apellido, String email,Date fNac,String pass, String foto) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fNac = fNac;
		this.pass = pass;
		this.foto = foto;
	}
	
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getfNac() {
		return fNac;
	}
	public void setfNac(Date fNac) {
		this.fNac = fNac;
	}

	
	public DtUsuario getDtUsuario() {
		return new DtUsuario(nickname,nombre,apellido,email,fNac,pass,foto);
	}
	
	public void modificarUsuario(DtUsuario datos) {
		setNombre(datos.getNombre());
		setApellido(datos.getApellido());
		setfNac(datos.getFecha());
	}
}
