package application;

import java.net.URL;
import java.util.Optional;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import modelo.Computadora;

public class ControladorRegistroComputadoras implements Initializable{
	@FXML private ComboBox<String> cboMarcas;
	@FXML private ComboBox<String> cboModelos;
	@FXML private ListView<Computadora> lstViewComputadoras;
	
	@FXML private TextField txtProcesador;
	@FXML private TextField txtRAM;
	@FXML private TextField txtVideo;
	@FXML private TextField txtDiscoDuro;
	
	@FXML private Button btnGuardar;
	@FXML private Button btnActualizar;
	@FXML private Button btnEliminar;
	
	private ObservableList<String> listaMarcas;//Notifica a la GUI cuando se agregan, modifican o eliminan elementos de la coleccion
	private ObservableList<String> listaModelos;//Notifica a la GUI cuando se agregan, modifican o eliminan elementos de la coleccion
	private ObservableList<Computadora> listaComputadoras;
	
	public ControladorRegistroComputadoras(){
		//No se pueden llenar los ComboBox desde el constructor	
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//En este punto ya estan instanciados todos los componentes de la GUI
		listaMarcas = FXCollections.observableArrayList();
		listaMarcas.add("ASUS");
		listaMarcas.add("Apple");
		listaMarcas.add("Dell");
		listaMarcas.add("Compaq");
		cboMarcas.setItems(listaMarcas);
		
		listaModelos = FXCollections.observableArrayList();
		listaModelos.add("Macbook pro");
		listaModelos.add("NVJ46");
		listaModelos.add("Dell X");
		cboModelos.setItems(listaModelos);	
		
		listaComputadoras = FXCollections.observableArrayList();
		lstViewComputadoras.setItems(listaComputadoras);
		
		lstViewComputadoras.getSelectionModel().
				selectedItemProperty().
				addListener(new ChangeListener<Computadora>() {
					@Override
					public void changed(
							ObservableValue<? extends Computadora> arg0,
							Computadora valorAnterior, 
							Computadora valorSeleccionado) {
						//Habilitar, Deshabilitar botones
						btnGuardar.setDisable(true);
						btnActualizar.setDisable(false);
						btnEliminar.setDisable(false);
						if (valorSeleccionado!=null){
							//Llenar la informacion de los componentes
							txtProcesador.setText(String.valueOf(valorSeleccionado.getProcesador()));
							txtRAM.setText(String.valueOf(valorSeleccionado.getRam()));
							txtDiscoDuro.setText(String.valueOf(valorSeleccionado.getEspacioDisco()));
							txtVideo.setText(String.valueOf(valorSeleccionado.getVideo()));
							cboMarcas.getSelectionModel().select(valorSeleccionado.getMarca());
							cboModelos.getSelectionModel().select(valorSeleccionado.getModelo());
						}
					}
					
				}
		);
	}
	
	@FXML
	public void guardarRegistro(){
		listaComputadoras.add(
				new Computadora(
						cboMarcas.getSelectionModel().getSelectedItem(),
						cboModelos.getSelectionModel().getSelectedItem(),
						Float.valueOf(txtProcesador.getText()),
						Float.valueOf(txtRAM.getText()),
						Float.valueOf(txtDiscoDuro.getText()),
						Float.valueOf(txtVideo.getText())
						)
				);
	}
	
	@FXML
	public void salir(){
		System.exit(0);
	}
	
	@FXML
	public void limpiarComponentes(){
		txtProcesador.setText(null);
		txtRAM.setText(null);
		txtDiscoDuro.setText(null);
		txtVideo.setText(null);
		cboMarcas.getSelectionModel().select(null);
		cboModelos.getSelectionModel().select(null);
		lstViewComputadoras.getSelectionModel().select(null);
		
		//Habilitar, Deshabilitar botones
		btnGuardar.setDisable(false);
		btnActualizar.setDisable(true);
		btnEliminar.setDisable(true);
	}
	
	@FXML
	public void eliminarRegistro(){
		int indice = lstViewComputadoras.getSelectionModel().getSelectedIndex();
		if (indice<0){
			Alert mensaje = new Alert(AlertType.ERROR);
			mensaje.setContentText("Necesita seleccionar un elemento para eliminar");
			mensaje.setHeaderText("Error al eliminar");
			mensaje.setTitle("Error");
			mensaje.show();
		}
		else{
			Alert mensaje = new Alert(AlertType.CONFIRMATION);
			mensaje.setTitle("Eliminar registro");
			mensaje.setContentText("¿Desea eliminar este registro?");
			mensaje.setHeaderText("Eliminar");
			Optional<ButtonType> opcion = mensaje.showAndWait();
			if (opcion.get() == ButtonType.OK){
				listaComputadoras.remove(indice);
				limpiarComponentes();	
			}
		}			
	}
	
	@FXML
	public void actualizarRegistro(){
		listaComputadoras.set(
				lstViewComputadoras.getSelectionModel().getSelectedIndex(),
				new Computadora(
					cboMarcas.getSelectionModel().getSelectedItem(),
					cboModelos.getSelectionModel().getSelectedItem(),
					Float.valueOf(txtProcesador.getText()),
					Float.valueOf(txtRAM.getText()),
					Float.valueOf(txtDiscoDuro.getText()),
					Float.valueOf(txtVideo.getText())
					)
				);
		Alert mensaje = new Alert(AlertType.INFORMATION);
		mensaje.setTitle("Exito");
		mensaje.setContentText("El registro fue modificado con exito");
		mensaje.setHeaderText("Actualizacion exito");
		mensaje.show();
	}
	
}
