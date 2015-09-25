package clases;
//POJO (Plain Old Java Object)
//Java Bean
public class Vehiculo {
	private String color;
	private String marca;
	private String tamanio;
	private String placa;
	private String chasis;
	private String modelo;
	private String anio;
	private String combustible;
	public  final static String COLOR_POR_DEFECTO = "Blanco";
	
	public Vehiculo(String color, String marca,
				String tamanio, String placa,
				String chasis, String modelo,
				String anio,
				String combustible){
		this.color = color;
		this.marca = marca;
		this.tamanio = tamanio;
		this.chasis = chasis;
		this.modelo = modelo;
		this.anio = anio;
		this.combustible = combustible;
	}
	
	public Vehiculo(){}
	
	public void metodoX(){
		//
	}
	
	public void metodoX(int x){
		//
	}
	
	public void metodoX(double x){
		//
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getTamanio() {
		return tamanio;
	}
	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getChasis() {
		return chasis;
	}
	public void setChasis(String chasis) {
		this.chasis = chasis;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getAnio() {
		return anio;
	}
	public void setAnio(String anio) {
		this.anio = anio;
	}
	public String getCombustible() {
		return combustible;
	}
	public void setCombustible(String combustible) {
		this.combustible = combustible;
	}
}
