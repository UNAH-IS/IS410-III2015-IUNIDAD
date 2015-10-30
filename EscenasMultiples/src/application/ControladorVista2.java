package application;

import javafx.fxml.FXML;

public class ControladorVista2 {
	private Main main;
	
	@FXML
	public void cambiarEscena1(){
		main.cambiarEscena1();
	}
	
	public void setMain(Main main){
		this.main = main;
	}
}
