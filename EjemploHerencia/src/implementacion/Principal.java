package implementacion;

import java.util.ArrayList;

import clases.Alumno;
import clases.Carrera;
import clases.Maestro;
import clases.Persona;

public class Principal{
	private ArrayList<Persona> personas;
	private Persona p1;
	private Maestro m1;
	private Alumno a1;
	private Alumno a2;
		
	public Principal(){
		personas = new ArrayList<Persona>();
		//p1 = new Persona("0801195500111","Juan","M",20);
		m1 = new Maestro("0866198200111","Pedro","M",50, 123, 20000.05);
		a1 = new Alumno("0809200000111","Maria","F",20,"2001100123456",
							new Carrera(115,"Ing. en Sistemas",56));
		a2 = new Alumno("065465200000111","Luis","M",20,"201100123456",
					new Carrera(114,"Ing. Electrica",57));
		
		//personas.add(p1);
		personas.add(m1);
		personas.add(a1);
		personas.add(a2);
		
		for (Persona p : personas){ //For each
			//objeto instanceof Clase
			if (p instanceof Alumno)
				System.out.println(p.toString());
		}
		
		/*for (int i = 0; i< personas.size();i++){
			System.out.println(personas.get(i).toString());
		}*/
		/*System.out.println(p1.toString());
		System.out.println(m1.toString());
		System.out.println(a1.toString());*/
		
		
	}
	
	public void metodoX(){}
	
	public static void main(String[] args) {
		new Principal();
	}
}
