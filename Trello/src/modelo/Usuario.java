package modelo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Usuario{
   private int codigoUsuario;
   private StringProperty nombreUsuario;


   public Usuario(int codigoUsuario, String nombreUsuario) { 
	   this.codigoUsuario = codigoUsuario;
	   this.nombreUsuario = new SimpleStringProperty(nombreUsuario);
   }

// ++++++++Metodos codigoUsuario
	public int getCodigoUsuario() {
		return codigoUsuario;
	}
	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
// ++++++++Metodos nombreUsuario
	public String getNombreUsuario() {
		return nombreUsuario.get();
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = new SimpleStringProperty(nombreUsuario);
	}
	public StringProperty NombreUsuarioProperty() {
		return nombreUsuario;
	}


 }