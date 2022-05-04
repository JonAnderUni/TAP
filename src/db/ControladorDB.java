package db;

import java.util.ArrayList;
import java.sql.*;
import com.mysql.cj.jdbc.JdbcConnection;

import capadatos.Producto;
import capadatos.Tiendas;

public class ControladorDB {
	Connection conn = null;
	private final String usuario = "tap";
	private final String pass = "tapfinal2022";
	private final String url = "jdbc:mysql://188.166.16.194:3306/";
	private final String dbName = "tap";
	private final String driver = "com.mysql.cj.jdbc.Driver";
	private final String url2 = "jdbc:mysql://209.97.135.139:3306/";
	
	
	private static ControladorDB controlador;
	
	public static ControladorDB getControladorDB() {
		if (controlador == null)
			controlador = new ControladorDB();
		return controlador;
	}
	
	private ControladorDB() {
		
	}
	
	public ArrayList<Producto> getLista(String pN){
		ArrayList<Producto> lista = new ArrayList<Producto>();
		try {
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url + dbName, usuario, pass);
				
				if (!conn.isClosed())
					System.out.println("Conectado a las base de datos");
				
				
				try {
					Statement st = conn.createStatement();
					String sql = "SELECT * FROM producto where nombre='" + pN + "';";
					ResultSet rs = st.executeQuery(sql);
					while(rs.next()) {
						System.out.println(rs.getString("id"));
						System.out.println(rs.getFloat("precio"));
						lista.add(new Producto(Integer.parseInt(rs.getString("id")), rs.getString("nombre"), rs.getString("descr"),rs.getFloat("precio"), rs.getString("nombreTienda"), rs.getString("tipo")));
						
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			} catch (ClassNotFoundException e) {
				System.err.println("Error al registrar el driver de MySQL: " + e.getMessage());
			} finally {
				try {
					if(conn != null) 
						conn.close();
				} catch (SQLException e) {
					System.err.println("Error al cerrar la conexion" + e.getMessage());
				 }
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public void anadirProducto(String desc, float precio, String loc) {
		try {
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url + dbName, usuario, pass);
				
				if (!conn.isClosed())
					System.out.println("Conectado a las base de datos");
				
			} catch (ClassNotFoundException e) {
				System.err.println("Error al registrar el driver de MySQL: " + e.getMessage());
			} finally {
				try {
					if(conn != null) 
						conn.close();
				} catch (SQLException e) {
					System.err.println("Error al cerrar la conexion" + e.getMessage());
				 }
			}
			
		} catch (Exception e) {
			System.err.println("Error del primer try: " + e.getMessage());
		}
		try {
			Statement st = conn.createStatement();
			String sql = "INSERT INTO producto (nombre, precio, localizacion) values (" + desc + ", " + String.valueOf(precio) + ", " + loc + ")";
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Tiendas> getTiendas(){
		ArrayList<Tiendas> lista = new ArrayList<Tiendas>();
		try {
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url + dbName, usuario, pass);
				
				if (!conn.isClosed())
					System.out.println("Conectado a las base de datos");
				
				Statement st = conn.createStatement();
				String sql = "SELECT * FROM tiendas";
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()) {
					lista.add(new Tiendas(Integer.parseInt(rs.getString("idTienda")),rs.getString("nombre"),rs.getFloat("latitud"), rs.getFloat("longitud")));
					
				}
				
			} catch (ClassNotFoundException e) {
				System.err.println("Error al registrar el driver de MySQL: " + e.getMessage());
			} finally {
				try {
					if(conn != null) 
						conn.close();
				} catch (SQLException e) {
					System.err.println("Error al cerrar la conexion" + e.getMessage());
				 }
			}
			
		} catch (Exception e) {
			System.err.println("Error del primer try en getTienda: " + e.getMessage());
		}
		
		
		
		return lista;
	}
	
	
	
	public static void main(String args[]) {
		System.out.println(ControladorDB.getControladorDB().getLista("Vaqueros"));
	}
	
}
