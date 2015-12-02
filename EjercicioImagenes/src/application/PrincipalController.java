package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import model.Perfil;
import utilidades.GestorConexiones;

public class PrincipalController implements Initializable{
	private Main main;
	@FXML
	private ListView<Perfil> lstPerfiles; 
	@FXML
	private ImageView imageView;
	
	private ObservableList<Perfil> perfiles;
	
	private GestorConexiones gestorConexiones;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		gestorConexiones = new GestorConexiones();
		perfiles = FXCollections.observableArrayList();
		lstPerfiles.setItems(perfiles);
		
		lstPerfiles.getSelectionModel().
			selectedItemProperty().
			addListener(
	        new ChangeListener<Perfil>() {
				@Override
				public void changed(ObservableValue<? extends Perfil> list,
						Perfil oldValue, Perfil newValue) {
						if(newValue!=null){
								imageView.setImage(newValue.getImagen());
						}
				}
	    });
		
		cargarPerfiles();
	}
	
	public void cargarPerfiles(){
		perfiles.clear();
		gestorConexiones.establecerConexion();
		Perfil.llenarListaPerfiles(gestorConexiones.getConexion(), perfiles);
		gestorConexiones.cerrarConexion();		
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}
	@FXML
	public void abrirStageNuevoPerfil(){
		main.abrirStageNuevoPerfil();
	}
	
}
