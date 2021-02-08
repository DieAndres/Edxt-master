/**
 * ControladorAltaPublish.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Publicaciones;

public interface ControladorAltaPublish extends java.rmi.Remote {
    public Publicaciones.DtEdicion seleccionarCurso(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String[] listarCursos(java.lang.String arg0) throws java.rmi.RemoteException;
    public boolean seleccionarCurso2(java.lang.String arg0, Publicaciones.DtEdicion arg1) throws java.rmi.RemoteException;
    public boolean seleccionarEstudiante(java.lang.String arg0, java.util.Calendar arg1) throws java.rmi.RemoteException;
    public boolean registroUsuarioEst(Publicaciones.DtEstudiante arg0) throws java.rmi.RemoteException;
    public boolean registroCategoria(java.lang.String arg0) throws java.rmi.RemoteException;
    public boolean registroUsuarioDoc(Publicaciones.DtDocente arg0) throws java.rmi.RemoteException;
    public boolean registroInstituto(java.lang.String arg0) throws java.rmi.RemoteException;
    public void registrarPrograma(Publicaciones.DtPrograma arg0) throws java.rmi.RemoteException;
    public void registrarEstEdicion(java.lang.String arg0, java.lang.String arg1, java.util.Calendar arg2, java.lang.String arg3) throws java.rmi.RemoteException;
    public void agregarCategoriaCurso(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public void agregarDocentesAedicion(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public java.lang.String[] selectInstituto(java.lang.String arg0) throws java.rmi.RemoteException;
    public boolean registroUsuario(Publicaciones.DtUsuario arg0) throws java.rmi.RemoteException;
    public boolean registroCurso(Publicaciones.DtCurso arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public void confirmarCurso(Publicaciones.ArrayList arg0) throws java.rmi.RemoteException;
    public void confirmarEdicion() throws java.rmi.RemoteException;
    public void cancelar() throws java.rmi.RemoteException;
    public void agregarPrograma(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
}
