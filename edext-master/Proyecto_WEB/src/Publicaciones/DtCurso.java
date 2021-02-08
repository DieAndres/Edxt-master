/**
 * DtCurso.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Publicaciones;

public class DtCurso  implements java.io.Serializable {
    private java.lang.Integer cantHoras;

    private java.lang.Integer creditos;

    private java.lang.String descripcion;

    private java.lang.Integer duracion;

    private java.util.Calendar fechaReg;

    private java.lang.String foto;

    private java.lang.String nombre;

    private java.lang.String URL;

    public DtCurso() {
    }

    public DtCurso(
           java.lang.Integer cantHoras,
           java.lang.Integer creditos,
           java.lang.String descripcion,
           java.lang.Integer duracion,
           java.util.Calendar fechaReg,
           java.lang.String foto,
           java.lang.String nombre,
           java.lang.String URL) {
           this.cantHoras = cantHoras;
           this.creditos = creditos;
           this.descripcion = descripcion;
           this.duracion = duracion;
           this.fechaReg = fechaReg;
           this.foto = foto;
           this.nombre = nombre;
           this.URL = URL;
    }


    /**
     * Gets the cantHoras value for this DtCurso.
     * 
     * @return cantHoras
     */
    public java.lang.Integer getCantHoras() {
        return cantHoras;
    }


    /**
     * Sets the cantHoras value for this DtCurso.
     * 
     * @param cantHoras
     */
    public void setCantHoras(java.lang.Integer cantHoras) {
        this.cantHoras = cantHoras;
    }


    /**
     * Gets the creditos value for this DtCurso.
     * 
     * @return creditos
     */
    public java.lang.Integer getCreditos() {
        return creditos;
    }


    /**
     * Sets the creditos value for this DtCurso.
     * 
     * @param creditos
     */
    public void setCreditos(java.lang.Integer creditos) {
        this.creditos = creditos;
    }


    /**
     * Gets the descripcion value for this DtCurso.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this DtCurso.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the duracion value for this DtCurso.
     * 
     * @return duracion
     */
    public java.lang.Integer getDuracion() {
        return duracion;
    }


    /**
     * Sets the duracion value for this DtCurso.
     * 
     * @param duracion
     */
    public void setDuracion(java.lang.Integer duracion) {
        this.duracion = duracion;
    }


    /**
     * Gets the fechaReg value for this DtCurso.
     * 
     * @return fechaReg
     */
    public java.util.Calendar getFechaReg() {
        return fechaReg;
    }


    /**
     * Sets the fechaReg value for this DtCurso.
     * 
     * @param fechaReg
     */
    public void setFechaReg(java.util.Calendar fechaReg) {
        this.fechaReg = fechaReg;
    }


    /**
     * Gets the foto value for this DtCurso.
     * 
     * @return foto
     */
    public java.lang.String getFoto() {
        return foto;
    }


    /**
     * Sets the foto value for this DtCurso.
     * 
     * @param foto
     */
    public void setFoto(java.lang.String foto) {
        this.foto = foto;
    }


    /**
     * Gets the nombre value for this DtCurso.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this DtCurso.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the URL value for this DtCurso.
     * 
     * @return URL
     */
    public java.lang.String getURL() {
        return URL;
    }


    /**
     * Sets the URL value for this DtCurso.
     * 
     * @param URL
     */
    public void setURL(java.lang.String URL) {
        this.URL = URL;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DtCurso)) return false;
        DtCurso other = (DtCurso) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cantHoras==null && other.getCantHoras()==null) || 
             (this.cantHoras!=null &&
              this.cantHoras.equals(other.getCantHoras()))) &&
            ((this.creditos==null && other.getCreditos()==null) || 
             (this.creditos!=null &&
              this.creditos.equals(other.getCreditos()))) &&
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            ((this.duracion==null && other.getDuracion()==null) || 
             (this.duracion!=null &&
              this.duracion.equals(other.getDuracion()))) &&
            ((this.fechaReg==null && other.getFechaReg()==null) || 
             (this.fechaReg!=null &&
              this.fechaReg.equals(other.getFechaReg()))) &&
            ((this.foto==null && other.getFoto()==null) || 
             (this.foto!=null &&
              this.foto.equals(other.getFoto()))) &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.URL==null && other.getURL()==null) || 
             (this.URL!=null &&
              this.URL.equals(other.getURL())));
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
        if (getCantHoras() != null) {
            _hashCode += getCantHoras().hashCode();
        }
        if (getCreditos() != null) {
            _hashCode += getCreditos().hashCode();
        }
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        if (getDuracion() != null) {
            _hashCode += getDuracion().hashCode();
        }
        if (getFechaReg() != null) {
            _hashCode += getFechaReg().hashCode();
        }
        if (getFoto() != null) {
            _hashCode += getFoto().hashCode();
        }
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        if (getURL() != null) {
            _hashCode += getURL().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DtCurso.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Publicaciones/", "dtCurso"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cantHoras");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cantHoras"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("creditos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "creditos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descripcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("duracion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "duracion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaReg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaReg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
        elemField.setFieldName("URL");
        elemField.setXmlName(new javax.xml.namespace.QName("", "URL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
