package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	private Stage formularioPrincipal;
	
	//Escenas
	private Scene escena1;
	private Scene escena2;
	
	//Controladores
	private ControladorVista1 controladorVista1;
	private ControladorVista2 controladorVista2;
	
	
	@Override
	public void start(Stage primaryStage) {
		this.formularioPrincipal = primaryStage;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Vista1.fxml"));
			BorderPane root = (BorderPane)loader.load();
			escena1 = new Scene(root);
			primaryStage.setScene(escena1);
			controladorVista1 = loader.getController();
			controladorVista1.setMain(this);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cambiarEscena2(){
		if (escena2==null){
			try{
				FXMLLoader loader = new FXMLLoader(getClass().getResource("Vista2.fxml"));
				BorderPane root = (BorderPane)loader.load();
				escena2 = new Scene(root);
				controladorVista2 = loader.getController();
				controladorVista2.setMain(this);
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		formularioPrincipal.setScene(escena2);
	}
	
	public void cambiarEscena1(){
		formularioPrincipal.setScene(escena1);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
