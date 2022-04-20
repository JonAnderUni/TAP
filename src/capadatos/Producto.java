package capadatos;

import java.io.Serializable;

@Entity
@NamedQueries({
	@NamedQuery(name = "producto.findAll", query = "SELECT n FROM Producto n"),
	@NamedQuery(name = "producto.findOne", query = "SELECT n FROM Producto n WHERE n.Id = :Id")
})
public class Producto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
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
	
	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		
		return(nombre);
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		
		return(precio);
	}
	
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getLocation() {
		
		return(location);
	}
	
	public void setLocation(String location) {
		this.location = location;
	}

}
