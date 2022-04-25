package capadatos;

public class Tiendas {
	
	private int id;
	private String nombre;
	private float lat;
	private float lngtd;
	
	public Tiendas(int id, String nombre, float lat, float lngtd) {
		
		this.id = id;
		this.nombre = nombre;
		this.lat = lat;
		this.lngtd = lngtd;
		
	}
	
	public int getId() {
		return(id);
	}
	
	public String getNombre() {
		return(nombre);
	}
	
	public float getLat() {
		return(lat);
	}
	
	public float getLng() {
		return(lngtd);
	}

}
