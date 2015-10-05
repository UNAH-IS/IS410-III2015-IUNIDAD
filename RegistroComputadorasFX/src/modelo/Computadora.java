package modelo;

public class Computadora {
	private String marca;
	private String modelo;
	private float procesador; //Ghz
	private float ram; //Gb
	private float espacioDisco; //Gb
	private float video; //Mb
	
	public Computadora(
			String marca, 
			String modelo, 
			float procesador,
			float ram, 
			float espacioDisco, 
			float video) {
		this.marca = marca;
		this.modelo = modelo;
		this.procesador = procesador;
		this.ram = ram;
		this.espacioDisco = espacioDisco;
		this.video = video;
	}
	
	public Computadora(){}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public float getProcesador() {
		return procesador;
	}

	public void setProcesador(float procesador) {
		this.procesador = procesador;
	}

	public float getRam() {
		return ram;
	}

	public void setRam(float ram) {
		this.ram = ram;
	}

	public float getEspacioDisco() {
		return espacioDisco;
	}

	public void setEspacioDisco(float espacioDisco) {
		this.espacioDisco = espacioDisco;
	}

	public float getVideo() {
		return video;
	}

	public void setVideo(float video) {
		this.video = video;
	}
	
	public String toString(){
		return 	marca + "\t\t" + 
				modelo + "\t\t" + 
				procesador + "\t\t" + 
				ram + "\t\t" + 
				espacioDisco + "\t\t" + 
				video; 
	}
	
	
}
