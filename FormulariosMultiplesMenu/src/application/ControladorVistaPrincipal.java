package application;

import javafx.fxml.FXML;

public class ControladorVistaPrincipal {
	private Main main;
	
	public void setMain(Main main){
		this.main = main;
	}
	
	@FXML
	public void abrirFormulario1(){
		main.abrirFormulario1();
	}
	
	@FXML
	public void abrirFormulario2(){
		main.abrirFormulario2();
	}
	
	@FXML
	public void abrirFormulario3(){
		main.abrirFormulario3();
	}
}
