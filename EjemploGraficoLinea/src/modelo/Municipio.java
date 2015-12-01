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

public class Municipio{
	   private IntegerProperty codigoMunicipio;
	   private StringProperty nombreMunicipio;
	   private IntegerProperty codigoDepartamento;


	   public Municipio(int codigoMunicipio, String nombreMunicipio, int codigoDepartamento) { 
		   this.codigoMunicipio = new SimpleIntegerProperty(codigoMunicipio);
		   this.nombreMunicipio = new SimpleStringProperty(nombreMunicipio);
		   this.codigoDepartamento = new SimpleIntegerProperty(codigoDepartamento);
	   }

	// ++++++++Metodos codigoMunicipio
	 public int getCodigoMunicipio() {
	     return codigoMunicipio.get();
	 }
	 public void setCodigoMunicipio(int codigoMunicipio) {
	      this.codigoMunicipio = new SimpleIntegerProperty(codigoMunicipio);
	 }
	 public IntegerProperty codigoMunicipioProperty() {
	     return codigoMunicipio;
	 }

	// ++++++++Metodos nombreMunicipio
	 public String getNombreMunicipio() {
	     return nombreMunicipio.get();
	 }
	 public void setNombreMunicipio(String nombreMunicipio) {
	      this.nombreMunicipio = new SimpleStringProperty(nombreMunicipio);
	 }
	 public StringProperty nombreMunicipioProperty() {
	     return nombreMunicipio;
	 }

	// ++++++++Metodos codigoDepartamento
	 public int getCodigoDepartamento() {
	     return codigoDepartamento.get();
	 }
	 public void setCodigoDepartamento(int codigoDepartamento) {
	      this.codigoDepartamento = new SimpleIntegerProperty(codigoDepartamento);
	 }
	 public IntegerProperty codigoDepartamentoProperty() {
	     return codigoDepartamento;
	 }
	 
	 public static void llenarComboBoxMunicipio(
			 Connection conexion,
			 ObservableList<Municipio> lista){
		 try {
			Statement instruccion = conexion.createStatement();
			ResultSet resultado = instruccion.executeQuery(
					"SELECT codigo_municipio, nombre_municipio, "
					+ " codigo_departamento "
					+ " FROM tbl_municipios");
			while(resultado.next()){
				lista.add(new Municipio(
							resultado.getInt("codigo_municipio"),
							resultado.getString("nombre_municipio"),
							resultado.getInt("codigo_departamento")
						)
				);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 @Override
	 public String toString(){
		 return nombreMunicipio.get();
	 }
}