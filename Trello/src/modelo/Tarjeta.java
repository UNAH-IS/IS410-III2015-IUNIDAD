package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class Tarjeta{
	private IntegerProperty codigoTarjeta;
	private StringProperty nombreTarjeta;
	private StringProperty descripcion;
	private Date fechaLimite;
	private Usuario usuario;
	private Prioridad prioridad;
	private Estado estado;

	public Tarjeta(int codigoTarjeta, String nombreTarjeta, String descripcion, 
Date fechaLimite, Usuario usuario, Prioridad prioridad, 
Estado estado) { 
		this.codigoTarjeta = new SimpleIntegerProperty(codigoTarjeta);
		this.nombreTarjeta = new SimpleStringProperty(nombreTarjeta);
		this.descripcion = new SimpleStringProperty(descripcion);
		this.fechaLimite = fechaLimite;
		this.usuario = usuario;
		this.prioridad = prioridad;
		this.estado = estado;
	}

	//Metodos atributo: codigoTarjeta
	public int getCodigoTarjeta() {
		return codigoTarjeta.get();
	}
	public void setCodigoTarjeta(int codigoTarjeta) {
		this.codigoTarjeta = new SimpleIntegerProperty(codigoTarjeta);
	}
	public IntegerProperty CodigoTarjetaProperty() {
		return codigoTarjeta;
	}
	//Metodos atributo: nombreTarjeta
	public String getNombreTarjeta() {
		return nombreTarjeta.get();
	}
	public void setNombreTarjeta(String nombreTarjeta) {
		this.nombreTarjeta = new SimpleStringProperty(nombreTarjeta);
	}
	public StringProperty NombreTarjetaProperty() {
		return nombreTarjeta;
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
	//Metodos atributo: fechaLimite
	public Date getFechaLimite() {
		return fechaLimite;
	}
	public void setFechaLimite(Date fechaLimite) {
		this.fechaLimite = fechaLimite;
	}
	//Metodos atributo: usuario
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	//Metodos atributo: prioridad
	public Prioridad getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(Prioridad prioridad) {
		this.prioridad = prioridad;
	}
	//Metodos atributo: estado
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public static void llenarListaTareas(
			Connection conexion,
			ObservableList<Tarjeta> lista,
			int codigoTablero,
			int codigoEstado){
		try{
			PreparedStatement instruccion = conexion.prepareStatement(
						"SELECT	a.codigo_tarjeta, a.codigo_estado, d.nombre_estado, " + 
						" 		a.codigo_usuario, b.nombre_usuario, " +
						"		a.codigo_prioridad, c.prioridad, " + 
						"		a.codigo_tablero, a.titulo_tarjeta,  " +
						"		a.descripcion, a.fecha_limite  " +
						"FROM tbl_tarjetas  a " +
						"INNER JOIN tbl_usuarios b " +
						"ON (a.codigo_usuario = b.codigo_usuario) "+
						"INNER JOIN tbl_prioridades c "+
						"ON (a.codigo_prioridad = c.codigo_prioridad)" +
						"INNER JOIN tbl_estados_tarjetas d " +
						"ON (a.codigo_estado = d.codigo_estado) " +
						"WHERE a.codigo_estado = ? " +
						"AND a.codigo_tablero = ?"
					);
			instruccion.setInt(1, codigoEstado);
			instruccion.setInt(2, codigoTablero);
			ResultSet resultado = instruccion.executeQuery();
			while (resultado.next()){
				lista.add(
						new Tarjeta(
								resultado.getInt("codigo_tarjeta"),
								resultado.getString("titulo_tarjeta"),
								resultado.getString("descripcion"),
								resultado.getDate("fecha_limite"),
								new Usuario(
									resultado.getInt("codigo_usuario"),
									resultado.getString("nombre_usuario")
								),
								new Prioridad(
									resultado.getInt("codigo_prioridad"),
									resultado.getString("prioridad")
								),
								new Estado(
									resultado.getInt("codigo_estado"),
									resultado.getString("nombre_estado")
								)
						)
				);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString(){
		return nombreTarjeta.get();
	}
}
