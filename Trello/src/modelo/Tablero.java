package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class Tablero{
	private IntegerProperty codigoTablero;
	private StringProperty nombreTablero;
	private Date fechaCreacion;
	private StringProperty descripcion;

	public Tablero(int codigoTablero, String nombreTablero, Date fechaCreacion, 
String descripcion) { 
		this.codigoTablero = new SimpleIntegerProperty(codigoTablero);
		this.nombreTablero = new SimpleStringProperty(nombreTablero);
		this.fechaCreacion = fechaCreacion;
		this.descripcion = new SimpleStringProperty(descripcion);
	}

	//Metodos atributo: codigoTablero
	public int getCodigoTablero() {
		return codigoTablero.get();
	}
	public void setCodigoTablero(int codigoTablero) {
		this.codigoTablero = new SimpleIntegerProperty(codigoTablero);
	}
	public IntegerProperty CodigoTableroProperty() {
		return codigoTablero;
	}
	//Metodos atributo: nombreTablero
	public String getNombreTablero() {
		return nombreTablero.get();
	}
	public void setNombreTablero(String nombreTablero) {
		this.nombreTablero = new SimpleStringProperty(nombreTablero);
	}
	public StringProperty NombreTableroProperty() {
		return nombreTablero;
	}
	//Metodos atributo: fechaCreacion
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	//Metodos atributo: descripcion
	public String getDescripcion() {
		return descripcion.get();
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = new SimpleStringProperty(descripcion);
	}
	public StringProperty DescripcionProperty() {
		return descripcion;
	}
	
	public static void llenarListaTableros(
			Connection conexion, 
			ObservableList<Tablero> lista){
		try{
			Statement instruccion = conexion.createStatement();
			ResultSet resultado = instruccion.executeQuery("SELECT codigo_tablero, titulo_tablero, descripcion, fecha_creacion FROM tbl_tableros");
			while(resultado.next()){
				lista.add(new Tablero(resultado.getInt("codigo_tablero"), 
						resultado.getString("titulo_tablero"),
						resultado.getDate("fecha_creacion"),
						resultado.getString("descripcion")						
					)
				);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}