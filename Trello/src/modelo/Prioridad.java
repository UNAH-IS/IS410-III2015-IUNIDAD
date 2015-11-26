package modelo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Prioridad{
   private int codigoPrioridad;
   private StringProperty nombrePrioridad;


   public Prioridad(int codigoPrioridad, String nombrePrioridad) { 
	   this.codigoPrioridad = codigoPrioridad;
	   this.nombrePrioridad = new SimpleStringProperty(nombrePrioridad);
   }

// ++++++++Metodos codigoPrioridad
	public int getCodigoPrioridad() {
		return codigoPrioridad;
	}
	public void setCodigoPrioridad(int codigoPrioridad) {
		this.codigoPrioridad = codigoPrioridad;
	}
// ++++++++Metodos nombrePrioridad
	public String getNombrePrioridad() {
		return nombrePrioridad.get();
	}
	public void setNombrePrioridad(String nombrePrioridad) {
		this.nombrePrioridad = new SimpleStringProperty(nombrePrioridad);
	}
	public StringProperty NombrePrioridadProperty() {
		return nombrePrioridad;
	}


 }