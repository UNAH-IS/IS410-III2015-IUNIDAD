package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import modelo.Estado;
import modelo.TipoEvento;
import utilidades.GestorConexiones;

public class ControladorVistaEventos implements Initializable{
	private GestorConexiones gestorConexiones;
	
	@FXML private ComboBox<TipoEvento> cboTipoEvento;
	@FXML private ComboBox<Estado> cboEstado;
	
	private ObservableList<TipoEvento> listaTipoEventos;
	private ObservableList<Estado> listaEstados;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		gestorConexiones = new GestorConexiones();
		gestorConexiones.establecerConexion();
		//Inicializar ObservableList
		listaTipoEventos = FXCollections.observableArrayList();
		listaEstados = FXCollections.observableArrayList();
		cboTipoEvento.setItems(listaTipoEventos);
		cboEstado.setItems(listaEstados);
		llenarComboBox();
		gestorConexiones.cerrarConexion();
	}
	
	public void llenarComboBox(){
		TipoEvento.llenarComboBoxTipoEvento(
				gestorConexiones.getConexion(),
				listaTipoEventos
		);
		Estado.llenarComboBoxEstado(
				gestorConexiones.getConexion(), 
				listaEstados);
	}	
}
