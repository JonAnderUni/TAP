package capadatos;

import java.util.ArrayList;
import java.util.List;
import db.ControladorDB;

public class gestorProducto {
	
	
	private List<Producto> lista = new ArrayList<Producto>();
	private List<Tiendas> listaTiendas = new ArrayList<Tiendas>();
	private static gestorProducto mGestor;
	
	private gestorProducto() {
		listaTiendas = ControladorDB.getControladorDB().getTiendas();
	}
	
	public static gestorProducto getGestorProducto() {
		return(mGestor); //Hay que retornar un gestorProducto
	}
	
	public void addProducto(Producto p) {
		
		if(lista.isEmpty()) {
			lista = ControladorDB.getControladorDB().getLista(); //Recibe una lista de todos los productos que hay en BD
		}
		
		lista.add(p); //Añade el producto a la lista de productos
		ControladorDB.getControladorDB().anadirProducto(p.getNombre(), p.getDesc(), p.getPrecio(), p.getNombreTienda(), p.getTipo()); //Añade el producto ->
		//a la BD
	}
	
	public void delProducto(Producto p) {
		
		if(lista.isEmpty()) {
			lista = ControladorDB.getControladorDB().getLista();
		}
		
		lista.remove(p); //Elimina el producto de la lista de productos
		ControladorDB.getControladorDB().quitarProducto(p.getNombre(), p.getDesc(), p.getPrecio(), p.getNombreTienda(), p.getTipo()); //Elimina el producto ->
		//de la base de datos
		
	}
	
	public Producto getProducto(String nombre) {
		
		Producto prod=null;
		
		for(Producto p:lista)
			if(p.getNombre().equalsIgnoreCase(nombre))
				prod = p;
		
		return(prod);
	}
	
	public Tiendas getLocation(String nombre) { //Obtiene la localización de un producto mediante su Id
		
		Producto prd = null;
		Tiendas shop = null;
		
		for(Producto p:lista)
			if(p.getNombre().equalsIgnoreCase(nombre))
				prd = p;
		
		if(prd != null)
			for(Tiendas t:listaTiendas)
				if(t.getNombre().equalsIgnoreCase(prd.getNombreTienda()))
					shop = t;
		
		return(shop);
	}

}
