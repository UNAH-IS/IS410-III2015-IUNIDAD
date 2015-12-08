package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;

public class Controlador implements Initializable{
	@FXML ProgressBar progressBar1;
	@FXML ProgressIndicator progressIndicator1;
	@FXML Label etiqueta1;
	@FXML Label etiqueta2;
	
	int i=0;
	int j=0;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		Task<String> tarea1 = new Task<String>(){
			@Override
			protected String call() throws Exception {
				//Cuerpo del tarea
				for(i=0;i<100;i++){
					//Solo se puede modificar la GUI utilizando Platform.runLater
					Platform.runLater(new Runnable(){
						@Override
						public void run() {
							//Escribir las instrucciones que modifican la GUI
							etiqueta1.setText("Porcentaje: "+(Double.valueOf(i)/100.0));
							progressBar1.setProgress((Double.valueOf(i)/100.0));
						}
					});
					Thread.sleep(100);
				}
				System.out.println("Tarea 1 finalizada");
				return "Tarea 1 finalizada";
			}
		};
		
		Task<String> tarea2 = new Task<String>(){
			@Override
			protected String call() throws Exception {
				//Cuerpo del tarea
				for(j=0;j<1000;j++){
					Platform.runLater(new Runnable(){
						@Override
						public void run() {
							etiqueta2.setText("Porcentaje: "+(Double.valueOf(j)/1000.0));
							progressIndicator1.setProgress(Double.valueOf(j)/1000.0);		
						}						
					});
					Thread.sleep(900);
				}
				//Aqui termino la tarea
				System.out.println("Tarea 2 finalizada");
				return "Tarea 2 finalizada";
			}
		};
		
		//tarea1.getValue();
		
		Thread hilo1 = new Thread(tarea1);
		Thread hilo2 = new Thread(tarea2);
		//Establecer en true para que terminen los hilos al cerrar la aplicacion.
		hilo1.setDaemon(true);
		hilo2.setDaemon(true);
		System.out.println("Iniciar hilo 1");
		hilo1.start();
		System.out.println("Iniciar hilo 2");
		hilo2.start();
	}
	
}
