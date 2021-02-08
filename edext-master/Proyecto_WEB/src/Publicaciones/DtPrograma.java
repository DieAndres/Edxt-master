/**
 * DtPrograma.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Publicaciones;

public class DtPrograma  implements java.io.Serializable {
    private java.lang.String descripcion;

    private java.lang.String foto;

    private java.lang.String nombre;

    private java.util.Calendar fFin;

    private java.util.Calendar fInicio;

    public DtPrograma() {
    }

    public DtPrograma(
           java.lang.String descripcion,
           java.lang.String foto,
           java.lang.String nombre,
           java.util.Calendar fFin,
           java.util.Calendar fInicio) {
           this.descripcion = descripcion;
           this.foto = foto;
           this.nombre = nombre;
           this.fFin = fFin;
           this.fInicio = fInicio;
    }


    /**
     * Gets the descripcion value for this DtPrograma.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this DtPrograma.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the foto value for this DtPrograma.
     * 
     * @return foto
     */
    public java.lang.String getFoto() {
        return foto;
    }


    /**
     * Sets the foto value for this DtPrograma.
     * 
     * @param foto
     */
    public void setFoto(java.lang.String foto) {
        this.foto = foto;
    }


    /**
     * Gets the nombre value for this DtPrograma.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this DtPrograma.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the fFin value for this DtPrograma.
     * 
     * @return fFin
     */
    public java.util.Calendar getFFin() {
        return fFin;
    }


    /**
     * Sets the fFin value for this DtPrograma.
     * 
     * @param fFin
     */
    public void setFFin(java.util.Calendar fFin) {
        this.fFin = fFin;
    }


    /**
     * Gets the fInicio value for this DtPrograma.
     * 
     * @return fInicio
     */
    public java.util.Calendar getFInicio() {
        return fInicio;
    }


    /**
     * Sets the fInicio value for this DtPrograma.
     * 
     * @param fInicio
     */
    public void setFInicio(java.util.Calendar fInicio) {
        this.fInicio = fInicio;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DtPrograma)) return false;
        DtPrograma other = (DtPrograma) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            ((this.foto==null && other.getFoto()==null) || 
             (this.foto!=null &&
              this.foto.equals(other.getFoto()))) &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.fFin==null && other.getFFin()==null) || 
             (this.fFin!=null &&
              this.fFin.equals(other.getFFin()))) &&
            ((this.fInicio==null && other.getFInicio()==null) || 
             (this.fInicio!=null &&
              this.fInicio.equals(other.getFInicio())));
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
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        if (getFoto() != null) {
            _hashCode += getFoto().hashCode();
        }
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        if (getFFin() != null) {
            _hashCode += getFFin().hashCode();
        }
        if (getFInicio() != null) {
            _hashCode += getFInicio().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DtPrograma.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Publicaciones/", "dtPrograma"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descripcion"));
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
        elemField.setFieldName("nombre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FFin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fFin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FInicio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fInicio"));
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
