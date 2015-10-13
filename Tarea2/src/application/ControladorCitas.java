package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import modelo.Paciente;
import modelo.Padecimiento;

public class ControladorCitas implements Initializable{
	@FXML private ComboBox<Paciente> cboPacientes;
	
	private ObservableList<Paciente> listaPacientes;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		listaPacientes = FXCollections.observableArrayList();
		ArrayList<Padecimiento> padeciemientosJuan = new ArrayList<Padecimiento>();
		padeciemientosJuan.add(new Padecimiento("Gripe","Muchos mocos","1-Ene-2015"));
		padeciemientosJuan.add(new Padecimiento("Chikingunya","Parecido al dengue","1-Ene-2015"));
		
		
		listaPacientes.add(new Paciente(
				"Juan","Perez",20,"M",padeciemientosJuan
		));
	
		cboPacientes.setItems(listaPacientes);
	}
	
	@FXML
	public void guardarRegistro(){
		Paciente p = cboPacientes.getSelectionModel().getSelectedItem();
		System.out.println(
				"El paciente seleccionado es: " + 
				p.getNombre() + 
				", Genero: " + p.getGenero());
	}
}
