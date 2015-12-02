package application;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.util.ResourceBundle;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;

import model.Perfil;
import utilidades.GestorConexiones;

public class NuevoPerfilController implements Initializable{
	private Main main;
	private File archivoActual;
	
	private GestorConexiones gestorConexiones;
	
	@FXML
	private ImageView imgPerfil;
	@FXML
	private TextField txtNombre;
	@FXML
	private DatePicker txtDtPckrFecha;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		gestorConexiones = new GestorConexiones();	
	}
	
	@FXML
	public void abrirImagen(ActionEvent event) {
	    FileChooser fileChooser = new FileChooser();
	    
	    //Definir filtros para que solo se puedan abrir imagenes
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
        archivoActual = fileChooser.showOpenDialog(main.getStgNuevoPerfil());
        if (archivoActual!=null){
		    System.out.println(archivoActual.getAbsolutePath());
		    try {
	            BufferedImage bufferedImage = ImageIO.read(archivoActual);
	            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
	            imgPerfil.setImage(image);
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
        }
	}

	@FXML
	public void guardarPerfil(){
		System.out.println("Guardando...");
		
		gestorConexiones.establecerConexion();
		
		Perfil p = new Perfil(0,txtNombre.getText(),null,Date.valueOf(txtDtPckrFecha.getValue()));
		if (p.guardarRegistro(gestorConexiones.getConexion(), archivoActual)==1){
			Alert mensaje = new Alert(AlertType.INFORMATION);
			mensaje.setTitle("Tarea finalizada");
			mensaje.setHeaderText("Registro almacenado");
			mensaje.setContentText("El registro ha sido almacenado satisfactoriamente");
			mensaje.show();
		}
		gestorConexiones.cerrarConexion();
	}
	
	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}
}
