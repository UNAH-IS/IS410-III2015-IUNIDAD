package modelo;

import java.sql.Date;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Evento{
	   private IntegerProperty codigoEvento;
	   private StringProperty nombreEvento;
	   private StringProperty descripcion;
	   private StringProperty direccion;
	   private Date fecha;
	   private IntegerProperty cantidadInvitados;
	   private TipoEvento tipoEvento;
	   private Estado estado;
	   private Municipio municipio;


	   public Evento(int codigoEvento, String nombreEvento, String descripcion, 
	String direccion, Date fecha, int cantidadInvitados, 
	TipoEvento tipoEvento, Estado estado, Municipio municipio) { 
		   this.codigoEvento = new SimpleIntegerProperty(codigoEvento);
		   this.nombreEvento = new SimpleStringProperty(nombreEvento);
		   this.descripcion = new SimpleStringProperty(descripcion);
		   this.direccion = new SimpleStringProperty(direccion);
		   this.fecha = fecha;
		   this.cantidadInvitados = new SimpleIntegerProperty(cantidadInvitados);
		   this.tipoEvento = tipoEvento;
		   this.estado = estado;
		   this.municipio = municipio;
	   }

	// ++++++++Metodos codigoEvento
	 public int getcodigoEvento() {
	     return codigoEvento.get();
	 }
	 public void setcodigoEvento(int codigoEvento) {
	      this.codigoEvento = new SimpleIntegerProperty(codigoEvento);
	 }
	 public IntegerProperty codigoEventoProperty() {
	     return codigoEvento;
	 }

	// ++++++++Metodos nombreEvento
	 public String getnombreEvento() {
	     return nombreEvento.get();
	 }
	 public void setnombreEvento(String nombreEvento) {
	      this.nombreEvento = new SimpleStringProperty(nombreEvento);
	 }
	 public StringProperty nombreEventoProperty() {
	     return nombreEvento;
	 }

	// ++++++++Metodos descripcion
	 public String getdescripcion() {
	     return descripcion.get();
	 }
	 public void setdescripcion(String descripcion) {
	      this.descripcion = new SimpleStringProperty(descripcion);
	 }
	 public StringProperty descripcionProperty() {
	     return descripcion;
	 }

	// ++++++++Metodos direccion
	 public String getdireccion() {
	     return direccion.get();
	 }
	 public void setdireccion(String direccion) {
	      this.direccion = new SimpleStringProperty(direccion);
	 }
	 public StringProperty direccionProperty() {
	     return direccion;
	 }

	// ++++++++Metodos fecha
	 public Date getfecha() {
	     return fecha;
	 }
	 public void setfecha(Date fecha) {
	      this.fecha = fecha;
	 }
	// ++++++++Metodos cantidadInvitados
	 public int getcantidadInvitados() {
	     return cantidadInvitados.get();
	 }
	 public void setcantidadInvitados(int cantidadInvitados) {
	      this.cantidadInvitados = new SimpleIntegerProperty(cantidadInvitados);
	 }
	 public IntegerProperty cantidadInvitadosProperty() {
	     return cantidadInvitados;
	 }

	// ++++++++Metodos tipoEvento
	 public TipoEvento gettipoEvento() {
	     return tipoEvento;
	 }
	 public void settipoEvento(TipoEvento tipoEvento) {
	      this.tipoEvento = tipoEvento;
	 }
	// ++++++++Metodos estado
	 public Estado getestado() {
	     return estado;
	 }
	 public void setestado(Estado estado) {
	      this.estado = estado;
	 }
	// ++++++++Metodos municipio
	 public Municipio getmunicipio() {
	     return municipio;
	 }
	 public void setmunicipio(Municipio municipio) {
	      this.municipio = municipio;
	 }
}