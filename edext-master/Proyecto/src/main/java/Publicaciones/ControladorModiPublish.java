package Publicaciones;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import DataType.DtCurso;
import DataType.DtDocente;
import DataType.DtEdicion;
import DataType.DtEstudiante;
import DataType.DtInfoCurso;
import DataType.DtPrograma;
import DataType.DtPrograma2;
import DataType.DtUsuario;
import Excepciones.ProgramaRepetidoExcepcion;
import Interface.Fabrica;
import Interface.IModificacion;
//import Configuracion.WebServiceConfiguracion;
//import datatypes.DtClase;
//import datatypes.DtEntrenamiento;
//import datatypes.DtSocio;
//import datatypes.DtSpinning;
//import interfaces.Fabrica;
//import interfaces.IControlador;
//import datatypes.DtSocio;
import Logica.InscripcionEd;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorModiPublish {
	private Fabrica fabrica;
	private IModificacion icon;
	//private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorModiPublish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIModificacion();
		/*try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}*/
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + "127.0.0.1"+ ":" +"1970" + "/ControladorModiPublish", this);
//		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/contrControladorModiPublisholador");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	//LOS MÉTODOS QUE VAMOS A PUBLICAR
	
	@WebMethod
	public String[] consultarUsuario() {
		List<String> usr = icon.consultarUsuario();
		int i = 0;
		String[] ret = new String[usr.size()];
        for(String s : usr) {
            ret[i]=s;
            i++;
        }
        return ret;
	}
	
	@WebMethod
	public String[] listarUsuario() {
		List<String> usr = icon.listarUsuario();
		int i = 0;
		String[] ret = new String[usr.size()];
        for(String s : usr) {
            ret[i]=s;
            i++;
        }
        return ret;
	}
	
	@WebMethod
	public DtUsuario seleccionarUsuario(String nName){
		return icon.seleccionarUsuario(nName);
	}
	
	@WebMethod
	public void modificarUsuario(DtUsuario datos){
		icon.modificarUsuario(datos);
	}
	
	@WebMethod
	public String[] listarProgramas() {
		List<String> prog = icon.listarProgramas();
		int i = 0;
		String[] ret = new String[prog.size()];
        for(String s : prog) {
            ret[i]=s;
            i++;
        }
        return ret;
	}
	
	@WebMethod
	public String[] listarCursos() {
		List<String> cur = icon.listarCursos();
		int i = 0;
		String[] ret = new String[cur.size()];
        for(String s : cur) {
            ret[i]=s;
            i++;
        }
        return ret;
	}
	
	@WebMethod
	public void seleccionaPrograma(String prog){
		icon.seleccionaPrograma(prog);
	}
	
	@WebMethod
	public void seleccionaCurso(String nCurso){
		icon.seleccionaCurso(nCurso);
	}
	
	@WebMethod
	public void agregarPrograma(){
		icon.agregarPrograma();
	}
	
	@WebMethod
	public void setEstadoInst(String estado, String estudiante, String edicion){
		try {
			icon.setEstadoInst(estado,estudiante,edicion);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
