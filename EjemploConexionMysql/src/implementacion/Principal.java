package implementacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal {
	//JDBC --> Java DataBase Connectivity
	private String url = "jdbc:mysql://localhost/db_eventos"; //jdbc:mysql://direccion_ip/nombre_base_de_datos
	private Connection conexion;
	private Statement instruccion;
	private ResultSet resultado;
	public Principal(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Intentando conectar a Mysql");
			conexion = DriverManager.getConnection(url, "root", "");//Si pasa de esta linea se pudo conectar correctamente
			System.out.println("Conexion exitosa");
			instruccion = conexion.createStatement();
			resultado = instruccion.executeQuery(
					"SELECT codigo_invitado, "+
				    "nombre_invitado, "+
				    "telefono, "+
				    "correo, "+
				    "direccion, "+
				    "genero "+
				    "FROM tbl_invitados"
			);
			
			while (resultado.next()){
				System.out.println("Nombre: "+
						resultado.getString("nombre_invitado")+
						"("+resultado.getString("correo")+")");
			}
			
			System.out.println("Fin del ResultSet");
			conexion.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Principal();
	}

}
