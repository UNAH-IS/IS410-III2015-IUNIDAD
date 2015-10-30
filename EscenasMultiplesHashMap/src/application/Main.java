package application;
	
import java.util.HashMap;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {
	private Stage formularioPrincipal;
	
	//Escenas
	private HashMap<String,Scene> escenas;
	
	
	//Controladores
	private ControladorVista1 controladorVista1;
	private ControladorVista2 controladorVista2;
	
	
	@Override
	public void start(Stage primaryStage) {
		escenas = new HashMap<String,Scene>();
		this.formularioPrincipal = primaryStage;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Vista1.fxml"));
			BorderPane root = (BorderPane)loader.load();
			escenas.put("paso1", new Scene(root));
			primaryStage.setScene(escenas.get("paso1"));
			controladorVista1 = loader.getController();
			controladorVista1.setMain(this);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cambiarEscena2(){
		if (escenas.get("paso2")==null){
			try{
				FXMLLoader loader = new FXMLLoader(getClass().getResource("Vista2.fxml"));
				BorderPane root = (BorderPane)loader.load();
				escenas.put("paso2", new Scene(root));
				controladorVista2 = loader.getController();
				controladorVista2.setMain(this);
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		formularioPrincipal.setScene(escenas.get("paso2"));
	}
	
	public void cambiarEscena1(){
		formularioPrincipal.setScene(escenas.get("paso1"));
	}
	
	/*public void cambiarEscena(String vista, String llave){
		if (escenas.get(llave)==null){
			try{
				FXMLLoader loader = new FXMLLoader(getClass().getResource("Vista2.fxml"));
				BorderPane root = (BorderPane)loader.load();
				escenas.put(llave, new Scene(root));
				controladorVista2 = loader.getController();
				controladorVista2.setMain(this);
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		formularioPrincipal.setScene(escenas.get("paso2"));
	}*/
	
	public static void main(String[] args) {
		launch(args);
	}
}
