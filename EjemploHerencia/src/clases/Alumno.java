package clases;

public class Alumno extends Persona{
	private String cuenta;
	private String carrera;
	
	public Alumno(
			String identidad, 
			String nombre, 
			String genero, 
			int edad,
			String cuenta, 
			String carrera) {
		super(identidad, nombre, genero, edad);
		this.cuenta = cuenta;
		this.carrera = carrera;
	}
		
	public Alumno(){}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	
	public void matricularAsignatura(){
		System.out.println("Metodo matricular asignatura");
	}
	
	@Override
	public String toString(){
		return super.toString() + cuenta + "\t\t"+ carrera;		
	}
}
