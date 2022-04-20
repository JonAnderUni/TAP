package capadatos;

import java.util.ArrayList;
import java.util.List;
import db.controladorDB;

public class gestorProducto {
	
	private controladorDB controler = new controladorDB();
	private List<Producto> lista = new ArrayList<Producto>();
	private static gestorProducto mGestor;
	
	private gestorProducto() {}
	
	public static gestorProducto getGestorProducto() {
		return(mGestor); //Hay que retornar un gestorProducto
	}
	
	public void addProducto(Producto p) {
		
		if(lista.isEmpty()) {
			lista = controler.getGestorDB().getLista(); //Recibe una lista de todos los productos que hay en BD
		}
		
		lista.add(p); //Añade el producto a la lista de productos
		controler.getGestorDB().anadirProducto(p.getNombre(), p.getPrecio(), p.getLocation()); //Añade el producto ->
		//a la BD
		
	}
	
	public void delProducto(Producto p) {
		
		if(lista.isEmpty()) {
			lista = controler.getGestorDB().getLista();
		}
		
		lista.remove(p); //Elimina el producto de la lista de productos
		controler.getGestorDB().quitarProducto(p.getNombre(), p.getPrecio(), p.getLocation()); //Elimina el producto ->
		//de la base de datos
		
	}
	
	public String getLocation(int Id) { //Obtiene la localización de un producto mediante su Id
		
		String location = controler.getGestorDB().getLocalizacion(Id);
		
		return(location);
	}

}
