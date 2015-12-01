package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Usuario{
	private IntegerProperty codigoUsuario;
	private StringProperty nombreUsuario;
	private StringProperty contrasena;
	private IntegerProperty tipoUsuario;

	public Usuario(int codigoUsuario, String nombreUsuario, String contrasena, 
int tipoUsuario) { 
		this.codigoUsuario = new SimpleIntegerProperty(codigoUsuario);
		this.nombreUsuario = new SimpleStringProperty(nombreUsuario);
		this.contrasena = new SimpleStringProperty(contrasena);
		this.tipoUsuario = new SimpleIntegerProperty(tipoUsuario);
	}
	
	public Usuario(String nombreUsuario, String contrasena) { 
					this.nombreUsuario = new SimpleStringProperty(nombreUsuario);
					this.contrasena = new SimpleStringProperty(contrasena);
				}

	//Metodos atributo: codigoUsuario
	public int getCodigoUsuario() {
		return codigoUsuario.get();
	}
	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = new SimpleIntegerProperty(codigoUsuario);
	}
	public IntegerProperty CodigoUsuarioProperty() {
		return codigoUsuario;
	}
	//Metodos atributo: nombreUsuario
	public String getNombreUsuario() {
		return nombreUsuario.get();
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = new SimpleStringProperty(nombreUsuario);
	}
	public StringProperty NombreUsuarioProperty() {
		return nombreUsuario;
	}
	//Metodos atributo: contrasena
	public String getContrasena() {
		return contrasena.get();
	}
	public void setContrasena(String contrasena) {
		this.contrasena = new SimpleStringProperty(contrasena);
	}
	public StringProperty ContrasenaProperty() {
		return contrasena;
	}
	//Metodos atributo: tipoUsuario
	public int getTipoUsuario() {
		return tipoUsuario.get();
	}
	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = new SimpleIntegerProperty(tipoUsuario);
	}
	public IntegerProperty TipoUsuarioProperty() {
		return tipoUsuario;
	}
	
	public boolean autenticar(Connection conexion){
		try {
			PreparedStatement instruccion = 
					conexion.prepareStatement(
							"SELECT codigo_usuario, " +
									"usuario, " +
									"tipo_usuario " +
							"FROM tbl_usuarios " +
							"WHERE usuario = ? " +
							"AND contrasena = sha1(?)"
			);
			instruccion.setString(1, nombreUsuario.get());
			instruccion.setString(2, contrasena.get());
			ResultSet resultado = instruccion.executeQuery();
			if (resultado.first()){
				codigoUsuario = new SimpleIntegerProperty(resultado.getInt("codigo_usuario"));
				tipoUsuario = new SimpleIntegerProperty(resultado.getInt("tipo_usuario"));
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}