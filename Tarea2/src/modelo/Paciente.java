package modelo;

import java.util.ArrayList;

public class Paciente extends Persona {
	private ArrayList<Padecimiento> padecimientos;
	
	public Paciente(String nombre, String apellido, 
					int edad, String genero, 
					ArrayList<Padecimiento> padecimientos) {
		super(nombre, apellido, edad, genero);
		this.padecimientos = padecimientos;
	}

	public ArrayList<Padecimiento> getPadecimientos() {
		return padecimientos;
	}

	public void setPadecimientos(ArrayList<Padecimiento> padecimientos) {
		this.padecimientos = padecimientos;
	}
	
	@Override
	public String toString(){
		return super.toString()+"(Edad:" + edad + ")";
	}
}
