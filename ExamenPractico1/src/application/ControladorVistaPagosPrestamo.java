package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class ControladorVistaPagosPrestamo implements Initializable{

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
			/*Para agregar el evento del listview (Cuando el usuario selecciona un registro) descomente el codigo
			 * que se muestra a continuacion y sustituya los datos correspondientes para nombreListView y TipoDato

			    nombreListView.getSelectionModel().
				selectedItemProperty().
				addListener(new ChangeListener<TipoDato>() {
					@Override
					public void changed(
							ObservableValue<? extends TipoDato> arg0,
							TipoDato valorAnterior, 
							TipoDato valorSeleccionado) {
						
					}
				}); */
	}
	
	@FXML
	public void guardarRegistro(){
		
	}
	
	@FXML
	public void actualizarRegistro(){
		
	}
	
	@FXML
	public void eliminarRegistro(){
		
	}
}
