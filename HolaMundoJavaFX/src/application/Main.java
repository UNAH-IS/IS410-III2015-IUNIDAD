package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage formulario) {
		try {			
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("VistaHolaMundo.fxml"));
			Scene scene = new Scene(root);//ancho x alto en px
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			formulario.setScene(scene);
			
			formulario.setTitle("Hola Mundo");
			//formulario.setOpacity(0.95);
			//formulario.setFullScreen(true);
			//formulario.setIconified(true);
			//formulario.setMaximized(true);
			//formulario.setResizable(false);			
			formulario.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
