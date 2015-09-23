package implementacion;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import clases.Computadora;

public class Principal {
	private ArrayList<Computadora> computadoras;
	private int opcion = 0; 
	
	
	public Principal(){
		computadoras = new ArrayList<Computadora>();
		
		do{
			opcion = Integer.valueOf(JOptionPane.showInputDialog(
					"1. Agregar\n"
					+ "2. Modificar\n"
					+ "3. Eliminar\n"
					+ "4. Mostrar informacion\n"
					+ "0. Salir"
			));
			//JOptionPane.showMessageDialog(null, "Opcion: " + opcion);
			switch(opcion){
				case 1:
					agregar();
					break;
				case 2:
					modificar();
					break;
				case 3:
					eliminar();
					break;
				case 4:
					mostrarInformacion();
					break;
				case 0:
					JOptionPane.showMessageDialog(null, "Nos vemos");
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opcion invalida");
					break;
			}
			
		} while(opcion != 0);
	}
	
	public void agregar(){
		//Crear una instancia de computadora
		Computadora c = new Computadora();
		//Inicializar los atributos con los metodos set
		c.setMarca(JOptionPane.showInputDialog("Ingrese la marca:"));
		c.setModelo(JOptionPane.showInputDialog("Ingrese el modelo:"));
		c.setProcesador(Float.valueOf(JOptionPane.showInputDialog("Ingrese la velocidad del procesador (Ghz):")));
		c.setRam(Float.valueOf(JOptionPane.showInputDialog("Ingrese la capacidad de la RAM (Gb):")));
		c.setEspacioDisco(Float.valueOf(JOptionPane.showInputDialog("Ingrese la capacidad del disco duro (Gb):")));
		c.setVideo(Float.valueOf(JOptionPane.showInputDialog("Ingrese la capacidad de video (Mb):")));
		//Agregar la instancia al ArrayList
		computadoras.add(c);
		mostrarInformacion();
	}
	
	public void modificar(){
		int indiceModificar= 
				Integer.valueOf(
					JOptionPane.showInputDialog("Que indice desea modificar?"+
						" del 0 al " + (computadoras.size()-1))
				);
		
		//Crear una instancia de computadora
		Computadora c = computadoras.get(indiceModificar);
		//Inicializar los atributos con los metodos set
		c.setMarca(JOptionPane.showInputDialog("Ingrese la marca:", c.getMarca()));
		c.setModelo(JOptionPane.showInputDialog("Ingrese el modelo:",c.getModelo()));
		c.setProcesador(Float.valueOf(JOptionPane.showInputDialog("Ingrese la velocidad del procesador (Ghz):", c.getProcesador())));
		c.setRam(Float.valueOf(JOptionPane.showInputDialog("Ingrese la capacidad de la RAM (Gb):",c.getRam())));
		c.setEspacioDisco(Float.valueOf(JOptionPane.showInputDialog("Ingrese la capacidad del disco duro (Gb):",c.getEspacioDisco())));
		c.setVideo(Float.valueOf(JOptionPane.showInputDialog("Ingrese la capacidad de video (Mb):",c.getVideo())));
		//Agregar la instancia al ArrayList
		computadoras.set(indiceModificar, c);
		mostrarInformacion();
	} 
	
	public void eliminar(){
		int indiceEliminar = 
				Integer.valueOf(
					JOptionPane.showInputDialog("Que indice desea eliminar?"+
						" del 0 al " + (computadoras.size()-1))
				);
		computadoras.remove(indiceEliminar);
		mostrarInformacion();
	}
	
	public void mostrarInformacion(){
		System.out.println("__________________________________");
		System.out.println("Marca\t\tModelo\t\tProcesador\t\tRam\t\tEspacio Disco\t\tVideo");
		for(int i=0;i<computadoras.size();i++)
			System.out.println(computadoras.get(i).toString());
	}
	
	public static void main(String[] args) {
		new Principal();
	}

}
