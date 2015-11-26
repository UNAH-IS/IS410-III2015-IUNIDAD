package modelo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Estado{
   private int codigoEstado;
   private StringProperty nombreEstado;


   public Estado(int codigoEstado, String nombreEstado) { 
	   this.codigoEstado = codigoEstado;
	   this.nombreEstado = new SimpleStringProperty(nombreEstado);
   }

// ++++++++Metodos codigoEstado
public int getCodigoEstado() {
	return codigoEstado;
}
public void setCodigoEstado(int codigoEstado) {
	this.codigoEstado = codigoEstado;
}
// ++++++++Metodos nombreEstado
	public String getNombreEstado() {
		return nombreEstado.get();
	}
	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = new SimpleStringProperty(nombreEstado);
	}
	public StringProperty NombreEstadoProperty() {
		return nombreEstado;
	}
	

 }
