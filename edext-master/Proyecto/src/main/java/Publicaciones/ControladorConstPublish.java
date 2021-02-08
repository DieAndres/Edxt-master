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
import Interface.IConsulta;
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
public class ControladorConstPublish {
	private Fabrica fabrica;
	private IConsulta icon;
	//private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorConstPublish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIConsulta();
		/*try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}*/
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + "127.0.0.1"+ ":" +"1970" + "/ControladorConstPublish", this);
//		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/ControladorConstPublish");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	//LOS MÉTODOS QUE VAMOS A PUBLICAR
	
	@WebMethod
	public DtPrograma seleccionarPrograma(String nProg){
		return icon.seleccionarPrograma(nProg);
	}
	
	@WebMethod
	public DtPrograma2 seleccionarPrograma2(String nProg){
		return icon.seleccionarPrograma2(nProg);
	}
	
	@WebMethod
	public DtInfoCurso seleccionarCurso(String nCurso){
		return icon.seleccionarCurso(nCurso);
	}
	
	@WebMethod
	public String[] getNomPrevias(String nCurso) {
		List<String> previas = icon.getNomPrevias(nCurso);
		int i = 0;
		String[] ret = new String[previas.size()];
        for(String s : previas) {
            ret[i]=s;
            i++;
        }
        return ret;
	}
	
	@WebMethod
	public String[] seleccionarInstituto(String nInsti) {
		List<String> insti = icon.seleccionarInstituto(nInsti);
		int i = 0;
		String[] ret = new String[insti.size()];
        for(String s : insti) {
            ret[i]=s;
            i++;
        }
        return ret;
	}
	
	@WebMethod
	public DtEdicion seleccionarEdicion(String nEdicion){
		return icon.seleccionarEdicion(nEdicion);
	}
	
	@WebMethod
	public DtEstudiante imprimirEstudiante(){
		return icon.imprimirEstudiante();
	}
	
	@WebMethod
	public DtDocente imprimirDocente(){
		return icon.imprimirDocente();
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
	public String[] getNomEstudiantes() {
		List<String> estu = icon.getNomEstudiantes();
		int i = 0;
		String[] ret = new String[estu.size()];
        for(String s : estu) {
            ret[i]=s;
            i++;
        }
        return ret;
	}
	
	@WebMethod
	public String[] getNomDocentes() {
		List<String> doc = icon.getNomDocentes();
		int i = 0;
		String[] ret = new String[doc.size()];
        for(String s : doc) {
            ret[i]=s;
            i++;
        }
        return ret;
	}
	
	@WebMethod
	public String[] listarUsuarios() {
		List<String> usr = icon.listarUsuarios();
		int i = 0;
		String[] ret = new String[usr.size()];
        for(String s : usr) {
            ret[i]=s;
            i++;
        }
        return ret;
	}
	
	@WebMethod
	public String[] listarCurso() {
		List<String> cur = icon.listarCurso();
		int i = 0;
		String[] ret = new String[cur.size()];
        for(String s : cur) {
            ret[i]=s;
            i++;
        }
        return ret;
	}
	
	@WebMethod
	public String[] listarInstituto() {
		List<String> insti = icon.listarInstituto();
		int i = 0;
		String[] ret = new String[insti.size()];
        for(String s : insti) {
            ret[i]=s;
            i++;
        }
        return ret;
	}
	
	@WebMethod
	public String[] listarCategorias() {
		List<String> cate = icon.listarCategorias();
		int i = 0;
		String[] ret = new String[cate.size()];
        for(String s : cate) {
            ret[i]=s;
            i++;
        }
        return ret;
	}
	
	@WebMethod
	public DtUsuario imprimirUsuario(String nname){
		return icon.imprimirUsuario(nname);
	}
	
	@WebMethod
	public String[] getDocentesDeInsti(String insti) {
		List<String> doci = icon.getDocentesDeInsti(insti);
		int i = 0;
		String[] ret = new String[doci.size()];
        for(String s : doci) {
            ret[i]=s;
            i++;
        }
        return ret;
	}
	
	@WebMethod
	public String[] getCursosporCat(String cate)  {
		List<String> categ = icon.getCursosporCat(cate);
		int i = 0;
		String[] ret = new String[categ.size()];
        for(String s : categ) {
            ret[i]=s;
            i++;
        }
        return ret;
	}
	
	@WebMethod
	public String[] getDocentesEdicion(String edi)  {
		List<String> dedi = icon.getDocentesEdicion(edi);
		int i = 0;
		String[] ret = new String[dedi.size()];
        for(String s : dedi) {
            ret[i]=s;
            i++;
        }
        return ret;
	}
	
	@WebMethod
	public String[] resultadoBusqueda(String search, String Filtro)  {
		
		try {
			List<String> fil = icon.resultadoBusqueda(search, Filtro);
			int i = 0;
			String[] ret = new String[fil.size()];
	        for(String s : fil) {
	            ret[i]=s;
	            i++;
	        }
	        return ret;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	@WebMethod
	public InscripcionEd[] getEstudiantesInscA(String edicion) {
		List<InscripcionEd> ested = icon.getEstudiantesInscA(edicion);
		int i = 0;
		InscripcionEd[] ret = new InscripcionEd[ested.size()];
        for(InscripcionEd s : ested) {
            ret[i]=s;
            i++;
        }
        return ret;
	}
	
	@WebMethod
	public InscripcionEd[] getEstudiantesInsc(String edicion) {
		List<InscripcionEd> ested = icon.getEstudiantesInsc(edicion);
		int i = 0;
		InscripcionEd[] ret = new InscripcionEd[ested.size()];
        for(InscripcionEd s : ested) {
            ret[i]=s;
            i++;
        }
        return ret;
	}
	
	@WebMethod
	public String[] getEdicionCursoDoc(String curso, String docente){
		try {
			List<String> curdoc = icon.getEdicionCursoDoc(curso,docente);
			int i = 0;
			String[] ret = new String[curdoc.size()];
	        for(String s : curdoc) {
	            ret[i]=s;
	            i++;
	        }
	        return ret;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
}
