package clases;

public class Alumno extends Persona{
	private String cuenta;
	private Carrera carrera;
	
	public Alumno(String identidad, 
			String nombre, 
			String genero, 
			int edad,
			String cuenta, 
			Carrera carrera) {
		super(identidad, nombre, genero, edad);
		this.cuenta = cuenta;
		this.carrera = carrera;
	}

	public Alumno(){}

	
	
	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	
	public void matricularAsignatura(){
		System.out.println("Metodo matricular asignatura");
	}
	
	@Override
	public String toString(){
		return super.toString() + cuenta + "\t\t"+ carrera.toString();		
	}

	@Override
	public void guardarDatos() {
		
	}
	
	@Override
	public void actualizarInformacion(){
		//super.actualizarInformacion();
		System.out.println("Actualizar informacion (Clase Alumno)");
	}
}
