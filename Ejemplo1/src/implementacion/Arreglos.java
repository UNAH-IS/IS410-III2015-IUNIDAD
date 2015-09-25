package implementacion;

import clases.Vehiculo;


public class Arreglos {
	public static void main(String[] args) {
		int arreglo[] = new int[5];
		Vehiculo vehiculos[] = new Vehiculo[3];

		arreglo[0] = 5;
		vehiculos[0] = new Vehiculo();
		vehiculos[0].setModelo("Modelo X");
		
		vehiculos[1] = new Vehiculo();
		vehiculos[1].setModelo("Modelo Y");
		
		vehiculos[2] = new Vehiculo();
		vehiculos[2].setModelo("Modelo Z");
		
		
		for (int i=0;i<vehiculos.length;i++)
			System.out.println("Elemento ["+i+"]:" + vehiculos[i].getModelo());
		
		
		//System.out.print(vehiculos[0].getModelo());
	
		
		/*Vehiculo a = new Vehiculo("Azul",
				"Honda","Grande","ABC123",
				"345345345","CRV","2006", "Gasolina");
		Vehiculo b = new Vehiculo();
		//System.out.println(a.COLOR_POR_DEFECTO);
		System.out.println(a.getColor());
		System.out.println(a.getMarca());
		System.out.println(a.getModelo());
		
		/*
		Vehiculo b = new Vehiculo(); //Intanciacion.
		b.setMarca("Honda");
		System.out.println(b.getMarca());*/
	}
}
