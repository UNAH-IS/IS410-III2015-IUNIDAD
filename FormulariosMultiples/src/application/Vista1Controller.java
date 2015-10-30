package application;

import javafx.fxml.FXML;

public class Vista1Controller {
	private Main main;
	
	@FXML
	public void abrirFormulario2(){
		main.abrirFormulario2();
	}
	
	public void setMain(Main main){
		this.main = main;
	}
}
