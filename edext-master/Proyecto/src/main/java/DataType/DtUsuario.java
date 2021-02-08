package DataType;

import java.util.Date;

public class DtUsuario {
	private String nickName;
	private String nombre;
	private String apellido;
	private String email;
	private Date fNac;
	private String pass;
	private String foto;
	
	public DtUsuario(String nickName, String nombre, String apellido, String email,Date fNac,String pass, String foto) {
		super();
		this.nickName = nickName;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fNac = fNac;
		this.pass = pass;
		this.foto = foto;
	}
	public DtUsuario() {
		
	}
	
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setfNac(Date fNac) {
		this.fNac = fNac;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getFoto() {
		return foto;
	}
	
	public Date getfNac() {
		return fNac;
	}
	public String getPass() {
		return pass;
	}
	public String getNickName() {
		return nickName;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public String getEmail() {
		return email;
	}
	public Date getFecha() {
		return fNac;
	}
	
	@Override
	public String toString() {
		return "DtUsuario [nickName=" + nickName + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", fNac=" + fNac + ", pass=" + pass + ", foto=" + foto + "]";
	}	
}
