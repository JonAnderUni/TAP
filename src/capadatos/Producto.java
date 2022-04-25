package capadatos;

public class Producto{
	
	private int id;
	private String nombre;
	private String desc;
	private float precio;
	private String nombreTienda;
	private String tipo;
	
	public Producto(int id, String nombre, String desc, float precio, String tienda, String tipo) {
		
		this.id = id;;
		this.nombre = nombre;
		this.desc = desc;
		this.precio = precio;
		this.nombreTienda = tienda;
		this.tipo = tipo;
		
	}
	
	public int getId() {
		
		return(id);
	}

	public String getNombre() {
		
		return(nombre);
	}
	
	public String getDesc() {
		return(desc);
	}

	public float getPrecio() {
		
		return(precio);
	}

	public String getNombreTienda() {
		
		return(nombreTienda);
	}
	
	public String getTipo() {
		return(tipo);
	}

}
