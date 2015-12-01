package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import modelo.Usuario;


public class Main extends Application {
	private Stage formularioPrincipal;
	private Stage formularioLogin;
	
	private ControladorPrincipal controladorPrincipal;
	private ControladorLogin controladorLogin;
	
	@Override
	public void start(Stage primaryStage) {
		formularioLogin = primaryStage;
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("VistaLogin.fxml"));
			AnchorPane root = (AnchorPane)loader.load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			controladorLogin = loader.getController();
			controladorLogin.setMain(this);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void abrirFormularioPrincipal(Usuario usuario){
		if (formularioPrincipal == null){
			try {
				formularioPrincipal = new Stage();
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("VistaPrincipal.fxml"));
				AnchorPane root = (AnchorPane)loader.load();
				Scene scene = new Scene(root);
				controladorPrincipal = loader.getController();
				controladorPrincipal.setMain(this);
				controladorPrincipal.setUsuario(usuario);
				formularioPrincipal.setScene(scene);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		formularioLogin.hide();
		formularioPrincipal.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
