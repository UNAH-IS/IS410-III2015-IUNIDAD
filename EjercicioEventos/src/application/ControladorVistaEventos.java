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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Estado;
import modelo.Evento;
import modelo.Municipio;
import modelo.TipoEvento;
import utilidades.GestorConexiones;

public class ControladorVistaEventos implements Initializable{
	private GestorConexiones gestorConexiones;
	
	@FXML private ComboBox<TipoEvento> cboTipoEvento;
	@FXML private ComboBox<Estado> cboEstado;
	@FXML private ComboBox<Municipio> cboMunicipio;
	
	@FXML private TableView<Evento> tblViewEventos;
	@FXML private TableColumn<Evento,String> clmnNombreEvento;
	@FXML private TableColumn<Evento,Number> clmnCantidadInvitados;
	@FXML private TableColumn<Evento,Date> clmnFecha;
	@FXML private TableColumn<Evento,TipoEvento> clmnTipoEvento;
	@FXML private TableColumn<Evento,Estado> clmnEstado;
	@FXML private TableColumn<Evento,Municipio> clmnMunicipio;
	
	
	private ObservableList<TipoEvento> listaTipoEventos;
	private ObservableList<Estado> listaEstados;
	private ObservableList<Municipio> listaMunicipios;
	
	private ObservableList<Evento> listaEventos;
	
	@FXML private TextField txtNombreEvento;
	@FXML private TextArea txtADescripcion;
	@FXML private TextArea txtADireccion;
	@FXML private DatePicker dtPkrfecha;
	@FXML private TextField txtCantidadInvitados;
	
	@FXML private Button bntGuardar;
	@FXML private Button bntEliminar;
	@FXML private Button bntNuevo;
	@FXML private Button bntActualizar;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		asociarColumnas();
		gestorConexiones = new GestorConexiones();
		gestorConexiones.establecerConexion();
		//Inicializar ObservableList
		listaTipoEventos = FXCollections.observableArrayList();
		listaEstados = FXCollections.observableArrayList();
		listaMunicipios = FXCollections.observableArrayList();
		listaEventos = FXCollections.observableArrayList();
		
		cboTipoEvento.setItems(listaTipoEventos);
		cboEstado.setItems(listaEstados);
		cboMunicipio.setItems(listaMunicipios);
		
		//Enlazar TableView con el ObservableList
		tblViewEventos.setItems(listaEventos);
		
		tblViewEventos.getSelectionModel().selectedItemProperty().addListener(
				new  ChangeListener<Evento>() {

					@Override
					public void changed(
							ObservableValue<? extends Evento> arg0,
							Evento valorAnterior, 
							Evento valorNuevo) {
						if (valorNuevo!=null){
							txtNombreEvento.setText(valorNuevo.getNombreEvento());
							txtADescripcion.setText(valorNuevo.getDescripcion());
							txtADireccion.setText(valorNuevo.getDireccion());
							txtCantidadInvitados.setText(String.valueOf(valorNuevo.getCantidadInvitados()));
							dtPkrfecha.setValue(valorNuevo.getFecha().toLocalDate());
							cboTipoEvento.getSelectionModel().select(valorNuevo.getTipoEvento());
							cboEstado.getSelectionModel().select(valorNuevo.getEstado());
							cboMunicipio.getSelectionModel().select(valorNuevo.getMunicipio());
							
							bntGuardar.setDisable(true);
							bntEliminar.setDisable(false);
							bntActualizar.setDisable(false);
						}
						
					}
						
				}
		);
		
		llenarInformacion();
		
		gestorConexiones.cerrarConexion();
	}
	
	@FXML
	public void limpiar(){
		txtNombreEvento.setText(null);
		txtADescripcion.setText(null);
		txtADireccion.setText(null);
		dtPkrfecha.setValue(null);
		txtCantidadInvitados.setText(null);
		cboEstado.getSelectionModel().select(null);
		cboMunicipio.getSelectionModel().select(null);
		cboTipoEvento.getSelectionModel().select(null);
		tblViewEventos.getSelectionModel().select(null);
		
		bntGuardar.setDisable(false);
		bntEliminar.setDisable(true);
		bntActualizar.setDisable(true);
	} 
	
	public void asociarColumnas(){
		clmnNombreEvento.setCellValueFactory(new PropertyValueFactory<Evento,String>("nombreEvento"));
		clmnCantidadInvitados.setCellValueFactory(new PropertyValueFactory<Evento,Number>("cantidadInvitados"));
		clmnFecha.setCellValueFactory(new PropertyValueFactory<Evento,Date>("fecha"));
		clmnTipoEvento.setCellValueFactory(new PropertyValueFactory<Evento,TipoEvento>("tipoEvento"));
		clmnEstado.setCellValueFactory(new PropertyValueFactory<Evento,Estado>("estado"));
		clmnMunicipio.setCellValueFactory(new PropertyValueFactory<Evento,Municipio>("municipio"));
	}
	
	public void llenarInformacion(){
		TipoEvento.llenarComboBoxTipoEvento(
				gestorConexiones.getConexion(),
				listaTipoEventos
		);
		Estado.llenarComboBoxEstado(
				gestorConexiones.getConexion(), 
				listaEstados
		);		
		Municipio.llenarComboBoxMunicipio(
				gestorConexiones.getConexion(),
				listaMunicipios
		);
		Evento.llenarListaEventos(
				gestorConexiones.getConexion(), 
				listaEventos
		);
	}
	
	@FXML
	public void guardarRegistro(){
		validarCampos();
		
		Evento e = 
				new Evento(
						0,
						txtNombreEvento.getText(),
						txtADescripcion.getText(),
						txtADireccion.getText(),
						Date.valueOf(dtPkrfecha.getValue()),
						Integer.valueOf(txtCantidadInvitados.getText()),
						cboTipoEvento.getSelectionModel().getSelectedItem(),
						cboEstado.getSelectionModel().getSelectedItem(),
						cboMunicipio.getSelectionModel().getSelectedItem()
				);
		gestorConexiones.establecerConexion();
		int resultado = e.guardarRegistro(gestorConexiones.getConexion());
		gestorConexiones.cerrarConexion();
		if (resultado <=0){
			Alert mensaje = new Alert(AlertType.ERROR);
			mensaje.setHeaderText("Error al guardar");
			mensaje.setContentText("No se pudo almacenar el registro");
			mensaje.setTitle("Error");
			mensaje.show();
		} else {
			listaEventos.add(e);
			Alert mensaje = new Alert(AlertType.INFORMATION);
			mensaje.setHeaderText("Exito");
			mensaje.setContentText("Registro almacenado correctamente");
			mensaje.setTitle("Exito");
			mensaje.show();
		}
	}
	
	public void validarCampos(){
		
	}
}
