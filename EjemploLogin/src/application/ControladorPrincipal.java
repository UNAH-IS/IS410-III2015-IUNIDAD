package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import modelo.Usuario;

public class ControladorPrincipal {
	private Main main;
	private Usuario usuario;
	
	@FXML
	private Label lblMensaje;

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
		lblMensaje.setText("Bienvenid@ "+usuario.getNombreUsuario());
	}
}