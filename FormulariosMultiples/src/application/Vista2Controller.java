package application;

import javafx.fxml.FXML;

public class Vista2Controller {
	private Main main;
	
	@FXML
	public void abrirFormulario1(){
		main.abrirFormulario1();
	}
	
	public void setMain(Main main){
		this.main = main;
	}
}
