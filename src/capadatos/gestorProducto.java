package capadatos;

import java.util.ArrayList;
import java.util.List;
import db.ControladorDB;

public class gestorProducto {
	
	
	private List<Producto> lista = new ArrayList<Producto>();
	private static gestorProducto mGestor;
	
	private gestorProducto() {}
	
	public static gestorProducto getGestorProducto() {
		return(mGestor); //Hay que retornar un gestorProducto
	}
	
	public void addProducto(Producto p) {
		
		if(lista.isEmpty()) {
			lista = ControladorDB.getControladorDB().getLista(); //Recibe una lista de todos los productos que hay en BD
		}
		
		lista.add(p); //Añade el producto a la lista de productos
		ControladorDB.getControladorDB().anadirProducto(p.getNombre(), p.getPrecio(), p.getLocation()); //Añade el producto ->
		//a la BD
	}
	
	public void delProducto(Producto p) {
		
		if(lista.isEmpty()) {
			lista = ControladorDB.getControladorDB().getLista();
		}
		
		lista.remove(p); //Elimina el producto de la lista de productos
		ControladorDB.getControladorDB().quitarProducto(p.getNombre(), p.getPrecio(), p.getLocation()); //Elimina el producto ->
		//de la base de datos
		
	}
	
	public String getLocation(int Id) { //Obtiene la localización de un producto mediante su Id
		
		String location = ControladorDB.getControladorDB().getLocalizacion(Id);
		
		return(location);
	}

}
