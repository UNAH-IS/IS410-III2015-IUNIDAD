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

//Propiedades->Properties
public class TipoEvento {
	private IntegerProperty codigoTipoEvento;
	private StringProperty tipoEvento;
	
	//El constructor debe recibir los tipos de datos normales
	//y hacer las respectivas conversiones.
	public TipoEvento(int codigoTipoEvento, String tipoEvento) {
		this.codigoTipoEvento = new SimpleIntegerProperty(codigoTipoEvento);
		this.tipoEvento = new SimpleStringProperty(tipoEvento);
	}
	
	// ++++++++Metodos codigoTipoEvento
	public int getcodigoTipoEvento() {
	     return codigoTipoEvento.get();
	}
	public void setcodigoTipoEvento(int codigoTipoEvento) {
	      this.codigoTipoEvento = new SimpleIntegerProperty(codigoTipoEvento);
	}
	public IntegerProperty codigoTipoEventoProperty() {
	     return codigoTipoEvento;
	}
	
	 //++++++++Metodos tipoEvento
	public String gettipoEvento() {
	     return tipoEvento.get();
	}
	public void settipoEvento(String tipoEvento) {
	      this.tipoEvento = new SimpleStringProperty(tipoEvento);
	}
	public StringProperty tipoEventoProperty() {
	     return tipoEvento;
	}
	public static void llenarComboBoxTipoEvento(
			Connection conexion, 
			ObservableList<TipoEvento> lista){
		//Hacer la consulta a la BD y llenar el ComboBox
		try {
			Statement instruccion = conexion.createStatement();
			ResultSet resultado = instruccion.executeQuery("SELECT codigo_tipo_evento, nombre_tipo_evento FROM tbl_tipos_eventos");
			while(resultado.next()){
				lista.add(new TipoEvento(
						resultado.getInt("codigo_tipo_evento"), 
						resultado.getString("nombre_tipo_evento"))
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public String toString(){
		return tipoEvento.get();
	}
}
