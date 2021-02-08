package Publicaciones;

public class ControladorAltaPublishProxy implements Publicaciones.ControladorAltaPublish {
  private String _endpoint = null;
  private Publicaciones.ControladorAltaPublish controladorAltaPublish = null;
  
  public ControladorAltaPublishProxy() {
    _initControladorAltaPublishProxy();
  }
  
  public ControladorAltaPublishProxy(String endpoint) {
    _endpoint = endpoint;
    _initControladorAltaPublishProxy();
  }
  
  private void _initControladorAltaPublishProxy() {
    try {
      controladorAltaPublish = (new Publicaciones.ControladorAltaPublishServiceLocator()).getControladorAltaPublishPort();
      if (controladorAltaPublish != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)controladorAltaPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)controladorAltaPublish)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (controladorAltaPublish != null)
      ((javax.xml.rpc.Stub)controladorAltaPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public Publicaciones.ControladorAltaPublish getControladorAltaPublish() {
    if (controladorAltaPublish == null)
      _initControladorAltaPublishProxy();
    return controladorAltaPublish;
  }
  
  public Publicaciones.DtEdicion seleccionarCurso(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorAltaPublish == null)
      _initControladorAltaPublishProxy();
    return controladorAltaPublish.seleccionarCurso(arg0);
  }
  
  public java.lang.String[] listarCursos(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorAltaPublish == null)
      _initControladorAltaPublishProxy();
    return controladorAltaPublish.listarCursos(arg0);
  }
  
  public java.lang.String[] selectInstituto(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorAltaPublish == null)
      _initControladorAltaPublishProxy();
    return controladorAltaPublish.selectInstituto(arg0);
  }
  
  public boolean registroUsuario(Publicaciones.DtUsuario arg0) throws java.rmi.RemoteException{
    if (controladorAltaPublish == null)
      _initControladorAltaPublishProxy();
    return controladorAltaPublish.registroUsuario(arg0);
  }
  
  public boolean registroCurso(Publicaciones.DtCurso arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (controladorAltaPublish == null)
      _initControladorAltaPublishProxy();
    return controladorAltaPublish.registroCurso(arg0, arg1);
  }
  
  public void confirmarCurso(Publicaciones.ArrayList arg0) throws java.rmi.RemoteException{
    if (controladorAltaPublish == null)
      _initControladorAltaPublishProxy();
    controladorAltaPublish.confirmarCurso(arg0);
  }
  
  public void confirmarEdicion() throws java.rmi.RemoteException{
    if (controladorAltaPublish == null)
      _initControladorAltaPublishProxy();
    controladorAltaPublish.confirmarEdicion();
  }
  
  public void cancelar() throws java.rmi.RemoteException{
    if (controladorAltaPublish == null)
      _initControladorAltaPublishProxy();
    controladorAltaPublish.cancelar();
  }
  
  public void agregarPrograma(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (controladorAltaPublish == null)
      _initControladorAltaPublishProxy();
    controladorAltaPublish.agregarPrograma(arg0, arg1);
  }
  
  public boolean seleccionarCurso2(java.lang.String arg0, Publicaciones.DtEdicion arg1) throws java.rmi.RemoteException{
    if (controladorAltaPublish == null)
      _initControladorAltaPublishProxy();
    return controladorAltaPublish.seleccionarCurso2(arg0, arg1);
  }
  
  public boolean seleccionarEstudiante(java.lang.String arg0, java.util.Calendar arg1) throws java.rmi.RemoteException{
    if (controladorAltaPublish == null)
      _initControladorAltaPublishProxy();
    return controladorAltaPublish.seleccionarEstudiante(arg0, arg1);
  }
  
  public boolean registroUsuarioEst(Publicaciones.DtEstudiante arg0) throws java.rmi.RemoteException{
    if (controladorAltaPublish == null)
      _initControladorAltaPublishProxy();
    return controladorAltaPublish.registroUsuarioEst(arg0);
  }
  
  public boolean registroCategoria(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorAltaPublish == null)
      _initControladorAltaPublishProxy();
    return controladorAltaPublish.registroCategoria(arg0);
  }
  
  public boolean registroUsuarioDoc(Publicaciones.DtDocente arg0) throws java.rmi.RemoteException{
    if (controladorAltaPublish == null)
      _initControladorAltaPublishProxy();
    return controladorAltaPublish.registroUsuarioDoc(arg0);
  }
  
  public boolean registroInstituto(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorAltaPublish == null)
      _initControladorAltaPublishProxy();
    return controladorAltaPublish.registroInstituto(arg0);
  }
  
  public void registrarPrograma(Publicaciones.DtPrograma arg0) throws java.rmi.RemoteException{
    if (controladorAltaPublish == null)
      _initControladorAltaPublishProxy();
    controladorAltaPublish.registrarPrograma(arg0);
  }
  
  public void registrarEstEdicion(java.lang.String arg0, java.lang.String arg1, java.util.Calendar arg2, java.lang.String arg3) throws java.rmi.RemoteException{
    if (controladorAltaPublish == null)
      _initControladorAltaPublishProxy();
    controladorAltaPublish.registrarEstEdicion(arg0, arg1, arg2, arg3);
  }
  
  public void agregarCategoriaCurso(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (controladorAltaPublish == null)
      _initControladorAltaPublishProxy();
    controladorAltaPublish.agregarCategoriaCurso(arg0, arg1);
  }
  
  public void agregarDocentesAedicion(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (controladorAltaPublish == null)
      _initControladorAltaPublishProxy();
    controladorAltaPublish.agregarDocentesAedicion(arg0, arg1);
  }
  
  
}