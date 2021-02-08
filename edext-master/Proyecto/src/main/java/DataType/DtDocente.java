package DataType;

import java.util.Date;

public class DtDocente extends DtUsuario {
	private String instituto;

	public DtDocente(String nickName, String nombre, String apellido, String email, Date fNac, String pass,
			String foto) {
		super(nickName, nombre, apellido, email, fNac, pass, foto);
	}

	public DtDocente(String nickname, String nombre, String apellido, String email, Date fecha, String instituto,String pass, String foto) {
		super(nickname, nombre, apellido, email, fecha, pass, foto);
		this.instituto = instituto;
	}

	public String getInstituto() {
		return instituto;
	}
	

	public void setInstituto(String instituto) {
		this.instituto = instituto;
	}

	@Override
	public String toString() {
		return "DtDocente [instituto=" + instituto + "]";
	}
}
