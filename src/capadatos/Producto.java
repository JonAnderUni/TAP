package capadatos;

public class Producto{
	
	private int id;
	private String nombre;
	private float precio;
	private String location;
	
	public Producto(int id, String nombre, float precio, String location) {
		
		this.id = id;;
		this.nombre = nombre;
		this.precio = precio;
		this.location = location;
		
	}
	
	public int getId() {
		
		return(id);
	}

	public String getNombre() {
		
		return(nombre);
	}

	public float getPrecio() {
		
		return(precio);
	}

	public String getLocation() {
		
		return(location);
	}

}
