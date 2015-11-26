package application;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Tablero;
import modelo.Tarjeta;
import utilidades.GestorConexiones;

public class ControladorVistaTableros implements Initializable{
	private final static int TAREAS_PENDIENTES = 1;
	private final static int TAREAS_PROCESO = 2;
	private final static int TAREAS_FINALIZADAS = 3;
	private GestorConexiones gestorConexiones;
	private ObservableList<Tablero> informacion;
	private ObservableList<Tarjeta> tareasPendientes;
	private ObservableList<Tarjeta> tareasProceso;
	private ObservableList<Tarjeta> tareasFinalizadas;
	
	@FXML private ListView<Tarjeta> lstVwTarjetasPendientes;
	@FXML private ListView<Tarjeta> lstVwTarjetasProceso;
	@FXML private ListView<Tarjeta> lstVwTarjetasFinalizadas;
	@FXML private TableView<Tablero> tblInformacion;
	
	@FXML private TableColumn<Tablero,String> clmnnombreTablero;
	@FXML private TableColumn<Tablero,Date> clmnfechaCreacion;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		informacion = FXCollections.observableArrayList();
		tareasPendientes = FXCollections.observableArrayList();
		tareasProceso = FXCollections.observableArrayList();
		tareasFinalizadas = FXCollections.observableArrayList();
		lstVwTarjetasPendientes.setItems(tareasPendientes);
		lstVwTarjetasProceso.setItems(tareasProceso);
		lstVwTarjetasFinalizadas.setItems(tareasFinalizadas);
		gestorConexiones = new GestorConexiones();
		gestorConexiones.establecerConexion();
		inicializarTablaTableros();
		gestorConexiones.cerrarConexion();
	}
	
	public void inicializarTablaTableros(){
		clmnnombreTablero.setCellValueFactory(
		 new PropertyValueFactory<Tablero,String>("nombreTablero")
		);
		clmnfechaCreacion.setCellValueFactory(
		 new PropertyValueFactory<Tablero,Date>("fechaCreacion")
		);
		
		tblInformacion.setItems(informacion);
		
		tblInformacion.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<Tablero>() {
					@Override
					public void changed(
							ObservableValue<? extends Tablero> arg0,
							Tablero valorAnterior, 
							Tablero valorNuevo) {
						if (valorNuevo!=null){
							System.out.println(valorNuevo.getNombreTablero());
							gestorConexiones.establecerConexion();
							tareasPendientes.clear();
							tareasProceso.clear();
							tareasFinalizadas.clear();
							Tarjeta.llenarListaTareas(
									gestorConexiones.getConexion(),
									tareasPendientes,
									valorNuevo.getCodigoTablero(),
									TAREAS_PENDIENTES
							);
							Tarjeta.llenarListaTareas(
									gestorConexiones.getConexion(),
									tareasProceso,
									valorNuevo.getCodigoTablero(),
									TAREAS_PROCESO
							);
							Tarjeta.llenarListaTareas(
									gestorConexiones.getConexion(),
									tareasFinalizadas,
									valorNuevo.getCodigoTablero(),
									TAREAS_FINALIZADAS
							);
							gestorConexiones.cerrarConexion();
						}
					}
				}
		);
		
		Tablero.llenarListaTableros(gestorConexiones.getConexion(), informacion);
	}
	
}
