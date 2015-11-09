package modelo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

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
	 public int getcodigoMunicipio() {
	     return codigoMunicipio.get();
	 }
	 public void setcodigoMunicipio(int codigoMunicipio) {
	      this.codigoMunicipio = new SimpleIntegerProperty(codigoMunicipio);
	 }
	 public IntegerProperty codigoMunicipioProperty() {
	     return codigoMunicipio;
	 }

	// ++++++++Metodos nombreMunicipio
	 public String getnombreMunicipio() {
	     return nombreMunicipio.get();
	 }
	 public void setnombreMunicipio(String nombreMunicipio) {
	      this.nombreMunicipio = new SimpleStringProperty(nombreMunicipio);
	 }
	 public StringProperty nombreMunicipioProperty() {
	     return nombreMunicipio;
	 }

	// ++++++++Metodos codigoDepartamento
	 public int getcodigoDepartamento() {
	     return codigoDepartamento.get();
	 }
	 public void setcodigoDepartamento(int codigoDepartamento) {
	      this.codigoDepartamento = new SimpleIntegerProperty(codigoDepartamento);
	 }
	 public IntegerProperty codigoDepartamentoProperty() {
	     return codigoDepartamento;
	 }
}