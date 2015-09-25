package interfaces;

public interface Humano extends SerVivo{
	public static final int EDAD_PROMEDIO = 5;
	
	public abstract void caminar();
	public abstract void correr();
	public abstract void comer();
}
