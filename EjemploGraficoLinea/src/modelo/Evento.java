package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart.Data;

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
	 public int getCodigoEvento() {
	     return codigoEvento.get();
	 }
	 public void setCodigoEvento(int codigoEvento) {
	      this.codigoEvento = new SimpleIntegerProperty(codigoEvento);
	 }
	 public IntegerProperty codigoEventoProperty() {
	     return codigoEvento;
	 }

	// ++++++++Metodos nombreEvento
	 public String getNombreEvento() {
	     return nombreEvento.get();
	 }
	 public void setNombreEvento(String nombreEvento) {
	      this.nombreEvento = new SimpleStringProperty(nombreEvento);
	 }
	 public StringProperty nombreEventoProperty() {
	     return nombreEvento;
	 }

	// ++++++++Metodos descripcion
	 public String getDescripcion() {
	     return descripcion.get();
	 }
	 public void setDescripcion(String descripcion) {
	      this.descripcion = new SimpleStringProperty(descripcion);
	 }
	 public StringProperty descripcionProperty() {
	     return descripcion;
	 }

	// ++++++++Metodos direccion
	 public String getDireccion() {
	     return direccion.get();
	 }
	 public void setDireccion(String direccion) {
	      this.direccion = new SimpleStringProperty(direccion);
	 }
	 public StringProperty direccionProperty() {
	     return direccion;
	 }

	// ++++++++Metodos fecha
	 public Date getFecha() {
	     return fecha;
	 }
	 public void setFecha(Date fecha) {
	      this.fecha = fecha;
	 }
	// ++++++++Metodos cantidadInvitados
	 public int getCantidadInvitados() {
	     return cantidadInvitados.get();
	 }
	 public void setCantidadInvitados(int cantidadInvitados) {
	      this.cantidadInvitados = new SimpleIntegerProperty(cantidadInvitados);
	 }
	 public IntegerProperty cantidadInvitadosProperty() {
	     return cantidadInvitados;
	 }

	// ++++++++Metodos tipoEvento
	 public TipoEvento getTipoEvento() {
	     return tipoEvento;
	 }
	 public void setTipoEvento(TipoEvento tipoEvento) {
	      this.tipoEvento = tipoEvento;
	 }
	// ++++++++Metodos estado
	 public Estado getEstado() {
	     return estado;
	 }
	 public void setEstado(Estado estado) {
	      this.estado = estado;
	 }
	// ++++++++Metodos municipio
	 public Municipio getMunicipio() {
	     return municipio;
	 }
	 public void setMunicipio(Municipio municipio) {
	      this.municipio = municipio;
	 }
	 
	 public static void llenarListaEventos(
			 Connection conexion,
			 ObservableList<Evento> lista
	){
		try {
			Statement instruccion = conexion.createStatement();
			ResultSet resultado = instruccion.executeQuery(
				"SELECT A.codigo_evento, A.nombre_evento, "+
				"A.descripcion, A.direccion, "+
		        "A.fecha, A.cantidad_invitados, "+
		        "A.codigo_tipo_evento, B.nombre_tipo_evento, "+
		        "A.codigo_estado, C.nombre_estado, "+
		        "A.codigo_municipio, D.nombre_municipio, D.codigo_departamento "+
				"FROM tbl_eventos A "+
				"INNER JOIN tbl_tipos_eventos B "+
				"ON (A.codigo_tipo_evento = B.codigo_tipo_evento) "+
				"INNER JOIN tbl_estados C "+
				"ON (A.codigo_estado = C.codigo_estado) "+
				"INNER JOIN tbl_municipios D "+
				"ON (A.codigo_municipio = D.codigo_municipio)"
			);
			
			while(resultado.next()){
				lista.add(new Evento(
							resultado.getInt("codigo_evento"),
							resultado.getString("nombre_evento"),
							resultado.getString("descripcion"),
							resultado.getString("direccion"),
							resultado.getDate("fecha"),
							resultado.getInt("cantidad_invitados"),
							new TipoEvento(
									resultado.getInt("codigo_tipo_evento"),
									resultado.getString("nombre_tipo_evento")
							),
							new Estado(
									resultado.getInt("codigo_estado"),
									resultado.getString("nombre_estado")
							),
							new Municipio(
									resultado.getInt("codigo_municipio"),
									resultado.getString("nombre_municipio"),
									resultado.getInt("codigo_departamento")
							)
						)
				);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
	 }
	 
	 public int guardarRegistro(Connection conexion){
		 //Se utiliza este tipo de dato para parametrizar informacion
		 //y evitar inyeccion SQL
		 try {
			PreparedStatement instruccion = 
					conexion.prepareStatement(
						"INSERT INTO tbl_eventos ( " +
						"nombre_evento,  " +
						"descripcion, direccion, " + 
						"fecha, cantidad_invitados, " +
						"codigo_tipo_evento, codigo_estado, " +
						"codigo_municipio " +
						") VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
					);
			instruccion.setString(1, nombreEvento.get());
			instruccion.setString(2, descripcion.get());
			instruccion.setString(3, direccion.get());
			instruccion.setDate(4, fecha);
			instruccion.setInt(5, cantidadInvitados.get());
			instruccion.setInt(6, tipoEvento.getCodigoTipoEvento());
			instruccion.setInt(7, estado.getCodigoEstado());
			instruccion.setInt(8, municipio.getCodigoMunicipio());
			
			
			int resultado = instruccion.executeUpdate();
			if (resultado>0){
				Statement instruccionId = 
						conexion.createStatement();
				ResultSet resultadoId = instruccionId.executeQuery("SELECT last_insert_id() as codigoEvento");
				resultadoId.first();
				//codigoEvento = new SimpleIntegerProperty(resultadoId.getInt("codigoEvento"));
				setCodigoEvento(resultadoId.getInt("codigoEvento"));
			}
			return resultado;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	 }
	 
	 public int actualizarRegistro(Connection conexion){
		 try {
			PreparedStatement instruccion = 
					conexion.prepareStatement(
						"UPDATE tbl_eventos " +
						"SET nombre_evento = ?, " + 
						"	descripcion = ?, " +
						"	direccion = ?, " +
						"	fecha = ?, " +
						"	cantidad_invitados = ?, " + 
						"	codigo_tipo_evento = ?, " +
						"	codigo_estado = ?, " +
						"	codigo_municipio = ? " +
						"WHERE codigo_evento = ?"
					);
			instruccion.setString(1, nombreEvento.get());
			instruccion.setString(2, descripcion.get());
			instruccion.setString(3, direccion.get());
			instruccion.setDate(4, fecha);
			instruccion.setInt(5, cantidadInvitados.get());
			instruccion.setInt(6, tipoEvento.getCodigoTipoEvento());
			instruccion.setInt(7, estado.getCodigoEstado());
			instruccion.setInt(8, municipio.getCodigoMunicipio());
			instruccion.setInt(9, codigoEvento.get());
			return instruccion.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	 }
	 
	 public int eliminarRegistro(Connection conexion){
		 try {
			PreparedStatement instruccionEliminarInvitados =
					conexion.prepareStatement(
						"DELETE FROM tbl_invitados_x_evento "+
						"WHERE codigo_evento = ?");
			
			instruccionEliminarInvitados.setInt(1, codigoEvento.get());
			System.out.println(
					"Se eliminaron: " +
					instruccionEliminarInvitados.executeUpdate()
			);
			 
			PreparedStatement instruccionEliminarEvento = conexion.prepareStatement(
					"DELETE FROM tbl_eventos " + 
					"WHERE codigo_evento = ?"
			 );
			instruccionEliminarEvento.setInt(1, codigoEvento.get());
			return instruccionEliminarEvento.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	 }
	 
	public static void llenarInformacionGrafico(
			 Connection conexion,
			 ObservableList<Data<String, Integer>> lista
	){		
		try {
			Statement instruccion = conexion.createStatement();
			ResultSet resultado = instruccion.executeQuery(
				"SELECT FECHA, COUNT(*) AS CANTIDAD_EVENTOS "+ 
				"FROM TBL_EVENTOS " +
				"GROUP BY FECHA " +
				"ORDER BY FECHA"
			);
			while (resultado.next()){
				lista.add(new Data<String,Integer>(
						resultado.getDate("FECHA").toString(),
						resultado.getInt("CANTIDAD_EVENTOS")
				));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}