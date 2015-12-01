package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import modelo.Usuario;
import utilidades.GestorConexiones;

public class ControladorLogin implements Initializable{
	private Main main;
	private GestorConexiones gestorConexiones;
	
	@FXML private TextField txtUsuario;
	@FXML private PasswordField txtContrasena;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		gestorConexiones = new GestorConexiones();
		
	}
	
	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}
	
	@FXML
	public void abrirFormularioPrincipal(){
		Usuario usuario = new Usuario(txtUsuario.getText(), txtContrasena.getText());
		gestorConexiones.establecerConexion();
		if (usuario.autenticar(gestorConexiones.getConexion()))
			main.abrirFormularioPrincipal(usuario);
		else{
			Alert mensaje = new Alert(AlertType.ERROR);
			mensaje.setContentText("Usuario/Password incorrectos");
			mensaje.show();
		}
		
		gestorConexiones.cerrarConexion();
		
		/*else
			Alert*/
	}
}
