package Publicaciones;

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
import DataType.DtPrograma;
import DataType.DtUsuario;
import Excepciones.ProgramaRepetidoExcepcion;
import Interface.Fabrica;
import Interface.IAlta;
//import Configuracion.WebServiceConfiguracion;
//import datatypes.DtClase;
//import datatypes.DtEntrenamiento;
//import datatypes.DtSocio;
//import datatypes.DtSpinning;
//import interfaces.Fabrica;
//import interfaces.IControlador;
//import datatypes.DtSocio;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorAltaPublish {
	private Fabrica fabrica;
	private IAlta icon;
	//private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorAltaPublish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIAlta();
		/*try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}*/
	}

	@WebMethod(exclude = true)
	public void publicar() {
//		System.out.println(configuracion.getConfigOf("#WS_IP"));
//		System.out.println(configuracion.getConfigOf("#WS_PORT"));
		endpoint = Endpoint.publish("http://" + "127.0.0.1"+ ":" +"1970" + "/ControladorAltaPublish", this);
		//System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/ControladorAltaPublish");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	//LOS MÉTODOS QUE VAMOS A PUBLICAR
	@WebMethod
	public String[] listarCursos(String nInsti) {
		List<String> cursos = icon.listarCursos(nInsti);
		int i = 0;
		String[] ret = new String[cursos.size()];
        for(String s : cursos) {
            ret[i]=s;
            i++;
        }
        return ret;
	}
	
	@WebMethod
	public String[] selectInstituto(String nInsti) {
		List<String> insti = icon.selectInstituto(nInsti);
		int i = 0;
		String[] ret = new String[insti.size()];
        for(String s : insti) {
            ret[i]=s;
            i++;
        }
        return ret;
	}
	
	@WebMethod
	public DtEdicion seleccionarCurso(String nCurso){
		return icon.seleccionarCurso(nCurso);
	}
	
	@WebMethod
	public Boolean seleccionarCurso2(String nCurso, DtEdicion datosE){
		return icon.seleccionarCurso2(nCurso, datosE);
	}
	
	@WebMethod
	public Boolean seleccionarEstudiante(String nickname, Date fInscripcion){
		return icon.seleccionarEstudiante(nickname, fInscripcion);
	}
	
	@WebMethod
	public Boolean registroCategoria(String cat){
		return icon.registroCategoria(cat);
	}
	
	@WebMethod
	public Boolean registroUsuario(DtUsuario usr){
	return icon.registroUsuario(usr);
	}
	
	@WebMethod
	public Boolean registroUsuarioEst(DtEstudiante est){
		return icon.registroUsuarioEst(est);
	}
	
	@WebMethod
	public Boolean registroUsuarioDoc(DtDocente usr){
		return icon.registroUsuarioDoc(usr);
	}
	
	@WebMethod
	public Boolean registroInstituto(String nInst){
		return icon.registroInstituto(nInst);
	}
	
	@WebMethod
	public Boolean registroCurso(DtCurso datosC,String nInst){
		return icon.registroCurso(datosC,nInst);
	}
	
	@WebMethod
	public void registrarPrograma(DtPrograma infoProg){
		 try {
			icon.registrarPrograma(infoProg);
		} catch (ProgramaRepetidoExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@WebMethod
	public void confirmarCurso(ArrayList<String> cursos){
		 icon.confirmarCurso(cursos);
	}
	
	@WebMethod
	public void confirmarEdicion(){
		 icon.confirmarEdicion();
	}
	
	@WebMethod
	public void registrarEstEdicion(String nickname, String nomEdi,Date fInscri,String estIns){
		 icon.registrarEstEdicion(nickname,nomEdi,fInscri,estIns);
	}
	
	@WebMethod
	public void cancelar(){
		 icon.cancelar();
	}
	
	@WebMethod
	public 	void agregarPrograma(String prog, String curso){
		 icon.agregarPrograma(prog,curso);
	}
	
	@WebMethod
	public void AgregarCategoriaCurso(String curso, String categoria){
		 icon.agregarPrograma(curso,categoria);
	}
	
	@WebMethod
	public void AgregarDocentesAedicion(String edicion, String docentes){
		 icon.agregarPrograma(edicion,docentes);
	}
	
}
