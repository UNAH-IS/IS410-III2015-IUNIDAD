package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class Estado{
	   private IntegerProperty codigoEstado;
	   private StringProperty nombreEstado;


	   public Estado(int codigoEstado, String nombreEstado) { 
		   this.codigoEstado = new SimpleIntegerProperty(codigoEstado);
		   this.nombreEstado = new SimpleStringProperty(nombreEstado);
	   }

	// ++++++++Metodos codigoEstado
	 public int getCodigoEstado() {
	     return codigoEstado.get();
	 }
	 public void setCodigoEstado(int codigoEstado) {
	      this.codigoEstado = new SimpleIntegerProperty(codigoEstado);
	 }
	 public IntegerProperty codigoEstadoProperty() {
	     return codigoEstado;
	 }

	// ++++++++Metodos nombreEstado
	 public String getNombreEstado() {
	     return nombreEstado.get();
	 }
	 public void setNombreEstado(String nombreEstado) {
	      this.nombreEstado = new SimpleStringProperty(nombreEstado);
	 }
	 public StringProperty nombreEstadoProperty() {
	     return nombreEstado;
	 }
	 
	 public static void llenarComboBoxEstado(Connection conexion,
			 	ObservableList<Estado> lista){
		 try {
			Statement instruccion = conexion.createStatement();
			ResultSet resultado = instruccion.executeQuery("SELECT codigo_estado, nombre_estado FROM tbl_estados ORDER BY codigo_estado ASC");
			while(resultado.next()){
				lista.add(new Estado(
							resultado.getInt("codigo_estado"),
							resultado.getString("nombre_estado")
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 }
	 
	 public String toString(){
		 return nombreEstado.get();
	 }
}