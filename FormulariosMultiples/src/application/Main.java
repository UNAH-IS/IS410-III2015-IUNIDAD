package application;
	
import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	//Formularios
	private Stage formulario2;
	private Stage formulario1;
	
	//Controladores
	private Vista1Controller vista1Controller;
	private Vista2Controller vista2Controller;
	
	@Override
	public void start(Stage formulario1) {
		this.formulario1 = formulario1; 
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("Vista1.fxml"));
			AnchorPane root = (AnchorPane)loader.load();
			Scene scene = new Scene(root);
			formulario1.setScene(scene);
			vista1Controller = loader.getController();
			vista1Controller.setMain(this);
			formulario1.setTitle("F1");
			formulario1.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void abrirFormulario2(){
		if (formulario2==null){
			try {
				formulario2 = new Stage();
				formulario2.initOwner(formulario1);
				formulario2.initModality(Modality.WINDOW_MODAL);
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("Vista2.fxml"));
				AnchorPane root = (AnchorPane)loader.load();
				Scene scene = new Scene(root);
				formulario2.setScene(scene);
				vista2Controller = loader.getController();
				vista2Controller.setMain(this);
				formulario2.setTitle("F2");
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		formulario2.show();
	}
	
	public void abrirFormulario1(){
		formulario2.hide();
		formulario1.requestFocus();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
