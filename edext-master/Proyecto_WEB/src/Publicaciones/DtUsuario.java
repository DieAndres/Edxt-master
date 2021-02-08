/**
 * DtUsuario.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Publicaciones;

public class DtUsuario  implements java.io.Serializable {
    private java.lang.String apellido;

    private java.lang.String email;

    private java.lang.String foto;

    private java.lang.String nickName;

    private java.lang.String nombre;

    private java.lang.String pass;

    private java.util.Calendar fNac;

    public DtUsuario() {
    }

    public DtUsuario(
           java.lang.String apellido,
           java.lang.String email,
           java.lang.String foto,
           java.lang.String nickName,
           java.lang.String nombre,
           java.lang.String pass,
           java.util.Calendar fNac) {
           this.apellido = apellido;
           this.email = email;
           this.foto = foto;
           this.nickName = nickName;
           this.nombre = nombre;
           this.pass = pass;
           this.fNac = fNac;
    }


    /**
     * Gets the apellido value for this DtUsuario.
     * 
     * @return apellido
     */
    public java.lang.String getApellido() {
        return apellido;
    }


    /**
     * Sets the apellido value for this DtUsuario.
     * 
     * @param apellido
     */
    public void setApellido(java.lang.String apellido) {
        this.apellido = apellido;
    }


    /**
     * Gets the email value for this DtUsuario.
     * 
     * @return email
     */
    public java.lang.String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this DtUsuario.
     * 
     * @param email
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }


    /**
     * Gets the foto value for this DtUsuario.
     * 
     * @return foto
     */
    public java.lang.String getFoto() {
        return foto;
    }


    /**
     * Sets the foto value for this DtUsuario.
     * 
     * @param foto
     */
    public void setFoto(java.lang.String foto) {
        this.foto = foto;
    }


    /**
     * Gets the nickName value for this DtUsuario.
     * 
     * @return nickName
     */
    public java.lang.String getNickName() {
        return nickName;
    }


    /**
     * Sets the nickName value for this DtUsuario.
     * 
     * @param nickName
     */
    public void setNickName(java.lang.String nickName) {
        this.nickName = nickName;
    }


    /**
     * Gets the nombre value for this DtUsuario.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this DtUsuario.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the pass value for this DtUsuario.
     * 
     * @return pass
     */
    public java.lang.String getPass() {
        return pass;
    }


    /**
     * Sets the pass value for this DtUsuario.
     * 
     * @param pass
     */
    public void setPass(java.lang.String pass) {
        this.pass = pass;
    }


    /**
     * Gets the fNac value for this DtUsuario.
     * 
     * @return fNac
     */
    public java.util.Calendar getFNac() {
        return fNac;
    }


    /**
     * Sets the fNac value for this DtUsuario.
     * 
     * @param fNac
     */
    public void setFNac(java.util.Calendar fNac) {
        this.fNac = fNac;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DtUsuario)) return false;
        DtUsuario other = (DtUsuario) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.apellido==null && other.getApellido()==null) || 
             (this.apellido!=null &&
              this.apellido.equals(other.getApellido()))) &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.foto==null && other.getFoto()==null) || 
             (this.foto!=null &&
              this.foto.equals(other.getFoto()))) &&
            ((this.nickName==null && other.getNickName()==null) || 
             (this.nickName!=null &&
              this.nickName.equals(other.getNickName()))) &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.pass==null && other.getPass()==null) || 
             (this.pass!=null &&
              this.pass.equals(other.getPass()))) &&
            ((this.fNac==null && other.getFNac()==null) || 
             (this.fNac!=null &&
              this.fNac.equals(other.getFNac())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getApellido() != null) {
            _hashCode += getApellido().hashCode();
        }
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getFoto() != null) {
            _hashCode += getFoto().hashCode();
        }
        if (getNickName() != null) {
            _hashCode += getNickName().hashCode();
        }
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        if (getPass() != null) {
            _hashCode += getPass().hashCode();
        }
        if (getFNac() != null) {
            _hashCode += getFNac().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DtUsuario.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Publicaciones/", "dtUsuario"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apellido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "apellido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("", "email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("foto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "foto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nickName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nickName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pass");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pass"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FNac");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fNac"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
