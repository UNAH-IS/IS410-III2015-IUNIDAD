package clases;

public abstract class Persona{
	protected String identidad;
	protected String nombre;
	protected String genero;
	protected int edad;
	
	public Persona(String identidad, String nombre, String genero, int edad) {
		this.identidad = identidad;
		this.nombre = nombre;
		this.genero = genero;
		this.edad = edad;
	}
	
	public Persona(){
	}

	public String getIdentidad() {
		return identidad;
	}

	public void setIdentidad(String identidad) {
		this.identidad = identidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}	
	
	@Override
	public String toString(){
		return identidad + "\t\t"+
				nombre + "\t\t" + 
				genero + "\t\t" +
				edad + "\t\t";
	}
	
	public abstract void guardarDatos();
	
	public void actualizarInformacion(){
		System.out.println("Actualizar informacion (Clase persona)");
	}
}
