package application;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControladorHolaMundo {
	@FXML private TextField txtNombre;
	@FXML private Label lblMensaje;
	
	@FXML
	public void eventoBoton(){
		lblMensaje.setText("Hola " + txtNombre.getText());
		
		//8 > u40
		Alert dialogo = new Alert(AlertType.INFORMATION);
		dialogo.setContentText("El nombre ingresado es: " +
				txtNombre.getText());
		dialogo.setTitle("Mensaje");
		dialogo.setHeaderText("Accion:");
		dialogo.show();	
	}
}
