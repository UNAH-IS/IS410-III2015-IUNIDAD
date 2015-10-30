package application;

import javafx.fxml.FXML;

public class ControladorVista1 {
	private Main main;
	
	@FXML
	public void cambiarEscena2(){
		main.cambiarEscena2();
	}
	
	public void setMain(Main main){
		this.main = main;
	}
}
