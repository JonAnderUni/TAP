package capadatos;

import java.util.ArrayList;
import java.util.List;
import db.ControladorDB;

public class gestorProducto {
	
	
	private ArrayList<Producto> lista = new ArrayList<Producto>();
	private ArrayList<Tiendas> listaTiendas = new ArrayList<Tiendas>();
	private static gestorProducto mGestor;
	
	private gestorProducto() {
		listaTiendas = ControladorDB.getControladorDB().getTiendas();
	}
	
	public static gestorProducto getGestorProducto() {
		return(mGestor); //Hay que retornar un gestorProducto
	}
	
	public ArrayList<Producto> getLista(String busqueda){
		
		lista = ControladorDB.getControladorDB().getLista(busqueda);
		
		return(lista);
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
