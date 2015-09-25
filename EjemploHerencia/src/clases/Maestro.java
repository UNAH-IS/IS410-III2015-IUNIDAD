package clases;

public class Maestro extends Persona{
	private int codigoEmpleado;
	private double sueldo;
	
	public Maestro(
			String identidad, 
			String nombre, 
			String genero, 
			int edad,
			int codigoEmpleado, 
			double sueldo) {
		super(identidad, nombre, genero, edad);//Llamar al constructor de la clase padre.
		this.codigoEmpleado = codigoEmpleado;
		this.sueldo = sueldo;
	}
	
	public Maestro(){
	}

	public int getCodigoEmpleado() {
		return codigoEmpleado;
	}

	public void setCodigoEmpleado(int codigoEmpleado) {
		this.codigoEmpleado = codigoEmpleado;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}	
	
	public void gestionarPago(){
		System.out.println(nombre);
		System.out.println("Metodo gestionar pago");
	}
	
	@Override
	public String toString(){
		return super.toString() + codigoEmpleado + "\t\t"+ sueldo;
	}
	
	@Override
	public void guardarDatos(){
		System.out.println("Guardar datos");
	}
}
