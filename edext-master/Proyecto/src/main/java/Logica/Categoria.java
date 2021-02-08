package Logica;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import DataType.DtCategoria;
import DataType.DtUsuario;

import javax.persistence.Id;
@Entity
public class Categoria {
		 @Id
		 private String nombre;
		 
		 
		
		public Categoria() {
			
			
		}
		
		public Categoria(String nombre) {
			super();
			this.nombre = nombre;
		}
		
		public String getNombre() {
			return nombre;
		}
		
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		
		public DtCategoria getCategoria() {
			return new DtCategoria(nombre);
		}
 
}
