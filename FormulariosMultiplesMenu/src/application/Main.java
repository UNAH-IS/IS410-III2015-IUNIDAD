package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Main extends Application {
	//Formularios
	private Stage formularioPrincipal;
	private Stage formulario1;
	private Stage formulario2;
	private Stage formulario3;
	
	//Controladores
	private ControladorVistaPrincipal controladorVistaPrincipal;
	private ControladorVistaFormulario1 controladorVistaFormulario1;
	private ControladorVistaFormulario2 controladorVistaFormulario2;
	private ControladorVistaFormulario3 controladorVistaFormulario3;
	
	@Override
	public void start(Stage formularioPrincipal) {
		this.formularioPrincipal = formularioPrincipal;
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("VistaPrincipal.fxml"));
			BorderPane root = (BorderPane)loader.load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			formularioPrincipal.setScene(scene);
			controladorVistaPrincipal = loader.getController();
			controladorVistaPrincipal.setMain(this);
			formularioPrincipal.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void abrirFormulario1(){
		if (formulario1 == null){
			try {
				formulario1 = new Stage();
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("VistaFormulario1.fxml"));
				AnchorPane root = (AnchorPane)loader.load();
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				formulario1.setScene(scene);
				controladorVistaFormulario1 = loader.getController();
				controladorVistaFormulario1.setMain(this);
				formulario1.initOwner(formularioPrincipal);
				formulario1.initModality(Modality.WINDOW_MODAL);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		formulario1.show();
	}
	
	public void abrirFormulario2(){
		if (formulario2 == null){
			try {
				formulario2 = new Stage();
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("VistaFormulario2.fxml"));
				AnchorPane root = (AnchorPane)loader.load();
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				formulario2.setScene(scene);
				controladorVistaFormulario2 = loader.getController();
				controladorVistaFormulario2.setMain(this);
				formulario2.initOwner(formularioPrincipal);
				formulario2.initModality(Modality.WINDOW_MODAL);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		formulario2.show();
	}
	
	public void abrirFormulario3(){
		if (formulario3 == null){
			try {
				formulario3 = new Stage();
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("VistaFormulario3.fxml"));
				AnchorPane root = (AnchorPane)loader.load();
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				formulario3.setScene(scene);
				controladorVistaFormulario3 = loader.getController();
				controladorVistaFormulario3.setMain(this);
				formulario3.initOwner(formularioPrincipal);
				formulario3.initModality(Modality.WINDOW_MODAL);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		formulario3.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
