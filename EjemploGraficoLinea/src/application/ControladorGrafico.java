package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import modelo.Evento;
import utilidades.GestorConexiones;

public class ControladorGrafico implements Initializable{
	private GestorConexiones gestorConexiones;
	@FXML LineChart<String, Integer> graficoLinea;
	@FXML PieChart graficoTorta;
	
	private ObservableList<PieChart.Data> listaTiposEventos;
	

	private ObservableList<XYChart.Data<String, Integer>> listaEventos;
	private Series<String, Integer> serieEventos;
	
	/*private ObservableList<Data<String, Float>> listaVentas2012;
	private Series<String, Float> ventas2012;*/
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		gestorConexiones = new GestorConexiones();
		gestorConexiones.establecerConexion();
		//Informacion para la primera serie
		listaEventos = FXCollections.observableArrayList();
		listaTiposEventos = FXCollections.observableArrayList();
		
		listaTiposEventos.add(new PieChart.Data("Cumpleaños",15.0));
		listaTiposEventos.add(new PieChart.Data("Despedidas",15.0));
		listaTiposEventos.add(new PieChart.Data("Bodas",30.0));
		listaTiposEventos.add(new PieChart.Data("Quinceaños",40.0));
		graficoTorta.getData().addAll(listaTiposEventos);
		
		
		Evento.llenarInformacionGrafico(gestorConexiones.getConexion(), listaEventos);
		
		/*/Informacion para la segunda serie
		listaVentas2012 = FXCollections.observableArrayList();
		listaVentas2012.add(new Data<String,Float>("Enero",900.12f));
		listaVentas2012.add(new Data<String,Float>("Febrero",1200.12f));
		listaVentas2012.add(new Data<String,Float>("Marzo",1500.12f));
		listaVentas2012.add(new Data<String,Float>("Abril",950.12f));
		listaVentas2012.add(new Data<String,Float>("Mayo",800.12f));
		listaVentas2012.add(new Data<String,Float>("Junio",700.12f));
		listaVentas2012.add(new Data<String,Float>("Julio",650.12f));
		*/
		
		serieEventos = new Series<String, Integer>();
		serieEventos.setName("Eventos diarios");
		serieEventos.setData(listaEventos);
		
		/*ventas2012 = new Series<String, Float>();
		ventas2012.setName("Ventas 2012");
		ventas2012.setData(listaVentas2012);*/
		
		graficoLinea.getData().add(serieEventos);
		//graficoLinea.getData().add(ventas2012);
		
		
		
		
		
		gestorConexiones.cerrarConexion();
	}
	
	
}
