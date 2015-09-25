package implementacion;

import java.util.HashMap;

import clases.Vehiculo;

public class ColeccionHashMap {
	private HashMap<Integer, Vehiculo> vehiculos;
	
	public ColeccionHashMap(){
		vehiculos = new HashMap<Integer,Vehiculo>();
		vehiculos.put(0, 
				new Vehiculo("Verde",
						"Kia","Grande","ERT456",
						"6786789","Picanto","2010", "Gasolina"));
		vehiculos.put(1, 
				new Vehiculo("Anaranjado",
						"Ford","Grande","FGHF45645",
						"32545454","Explorer","2015", "Diesel"));
		
		System.out.println(vehiculos.get(0).getMarca());
		System.out.println(vehiculos.get(1).getMarca());
	}
	public static void main(String[] args) {
		new ColeccionHashMap();
	}

}
