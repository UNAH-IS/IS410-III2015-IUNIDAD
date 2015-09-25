package implementacion;

import java.util.ArrayList;

import clases.Vehiculo;

//Shift + Ctrl + O : Importar clases
public class Colecciones {
	//Variables y objetos globales
	private ArrayList<Vehiculo> vehiculos; 	//<Clase>Rawtype o receptaculo
	
	public Colecciones(){
		//Logica del programa
		vehiculos = new ArrayList<Vehiculo>();
		Vehiculo a = new Vehiculo("Azul",
				"Honda","Grande","ABC123",
				"345345345","CRV","2006", "Gasolina");
		vehiculos.add(a); //indice 0
		vehiculos.add(new Vehiculo("Verde",
				"Toyoya","Grande","EFG123",
				"32545454","Prado","2015", "Gasolina"));//indice 1
		vehiculos.add(new Vehiculo("Morado",
				"Susuki","Grande","ADF234",
				"423456","X","2015", "Gasolina"));//indice 2
		vehiculos.add(new Vehiculo("Verde",
				"Kia","Grande","ERT456",
				"6786789","Picanto","2010", "Gasolina"));//indice 3
		
		vehiculos.remove(2);
		vehiculos.set(1, new Vehiculo("Anaranjado",
				"Ford","Grande","FGHF45645",
				"32545454","Explorer","2015", "Diesel"));
		//vehiculos.clear();//Eliminar todos los compontentes
		for (int i=0;i<vehiculos.size();i++){
			System.out.println(vehiculos.get(i).getMarca());
		}
	}
	
	//Demas metodos
	public void metodoX(){

	}
	
	public static void main(String[] args) {
		new Colecciones(); //Crear instancia anonima
	}
}
