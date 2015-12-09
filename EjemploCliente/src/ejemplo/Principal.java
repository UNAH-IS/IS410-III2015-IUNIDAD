package ejemplo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Principal {
	private Socket socketCliente;
	private DataInputStream lectura;
	private DataOutputStream escritura;
	
	public Principal(){
		try {
			System.out.println("Intentando conectar a servidor");
			socketCliente = new Socket("192.168.10.210",1234);
			System.out.println("Conexion exitosa");
			
			escritura = new DataOutputStream(socketCliente.getOutputStream());
			escritura.writeUTF("Hola soy el cliente.");
			
			lectura = new DataInputStream(socketCliente.getInputStream());
			System.out.println("SERVIDOR DICE: " + lectura.readUTF());
			
			lectura.close();
			escritura.close();
			socketCliente.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Principal();
	}

}
