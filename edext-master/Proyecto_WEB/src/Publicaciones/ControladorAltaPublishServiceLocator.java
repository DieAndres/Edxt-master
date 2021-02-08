/**
 * ControladorAltaPublishServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Publicaciones;

public class ControladorAltaPublishServiceLocator extends org.apache.axis.client.Service implements Publicaciones.ControladorAltaPublishService {

    public ControladorAltaPublishServiceLocator() {
    }


    public ControladorAltaPublishServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ControladorAltaPublishServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ControladorAltaPublishPort
    private java.lang.String ControladorAltaPublishPort_address = "http://127.0.0.1:1970/ControladorAltaPublish";

    public java.lang.String getControladorAltaPublishPortAddress() {
        return ControladorAltaPublishPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ControladorAltaPublishPortWSDDServiceName = "ControladorAltaPublishPort";

    public java.lang.String getControladorAltaPublishPortWSDDServiceName() {
        return ControladorAltaPublishPortWSDDServiceName;
    }

    public void setControladorAltaPublishPortWSDDServiceName(java.lang.String name) {
        ControladorAltaPublishPortWSDDServiceName = name;
    }

    public Publicaciones.ControladorAltaPublish getControladorAltaPublishPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ControladorAltaPublishPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getControladorAltaPublishPort(endpoint);
    }

    public Publicaciones.ControladorAltaPublish getControladorAltaPublishPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            Publicaciones.ControladorAltaPublishPortBindingStub _stub = new Publicaciones.ControladorAltaPublishPortBindingStub(portAddress, this);
            _stub.setPortName(getControladorAltaPublishPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setControladorAltaPublishPortEndpointAddress(java.lang.String address) {
        ControladorAltaPublishPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (Publicaciones.ControladorAltaPublish.class.isAssignableFrom(serviceEndpointInterface)) {
                Publicaciones.ControladorAltaPublishPortBindingStub _stub = new Publicaciones.ControladorAltaPublishPortBindingStub(new java.net.URL(ControladorAltaPublishPort_address), this);
                _stub.setPortName(getControladorAltaPublishPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ControladorAltaPublishPort".equals(inputPortName)) {
            return getControladorAltaPublishPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://Publicaciones/", "ControladorAltaPublishService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://Publicaciones/", "ControladorAltaPublishPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ControladorAltaPublishPort".equals(portName)) {
            setControladorAltaPublishPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
