package modelo;

public class Padecimiento {
	private String nombrePadecimiento;
	private String descripcion;
	private String fechaPadecimiento;
	public Padecimiento(String nombrePadecimiento, String descripcion,
			String fechaPadecimiento) {
		super();
		this.nombrePadecimiento = nombrePadecimiento;
		this.descripcion = descripcion;
		this.fechaPadecimiento = fechaPadecimiento;
	}
	public String getNombrePadecimiento() {
		return nombrePadecimiento;
	}
	public void setNombrePadecimiento(String nombrePadecimiento) {
		this.nombrePadecimiento = nombrePadecimiento;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFechaPadecimiento() {
		return fechaPadecimiento;
	}
	public void setFechaPadecimiento(String fechaPadecimiento) {
		this.fechaPadecimiento = fechaPadecimiento;
	}
	
	@Override
	public String toString(){
		return nombrePadecimiento;
	}
}
