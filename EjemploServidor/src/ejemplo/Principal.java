package ejemplo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Principal {
	private ServerSocket socketServidor;
	private Socket socketClienteConectado;
	private DataInputStream lectura;
	private DataOutputStream escritura;
	public Principal(){
		try {
			socketServidor = new ServerSocket(1234);
			System.out.println("Esperando conexion de cliente....");
			socketClienteConectado = socketServidor.accept();
			System.out.println("Se ha conectado un cliente");
			
			escritura = new DataOutputStream(socketClienteConectado.getOutputStream());
			escritura.writeUTF("Hola, soy el servidor.");
			
			lectura = new DataInputStream(socketClienteConectado.getInputStream());
			System.out.println("CLIENTE DICE: " + lectura.readUTF());
			
			
			lectura.close();
			escritura.close();
			socketServidor.close();
			socketClienteConectado.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Principal();
	}

}
