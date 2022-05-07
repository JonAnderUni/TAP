package capadatos;

import java.util.ArrayList;
import java.util.List;
import db.ControladorDB;

public class gestorProducto {
	
	
	private ArrayList<Producto> listaProducto = new ArrayList<Producto>();
	private ArrayList<Tienda> listaTiendas = new ArrayList<Tienda>();
	private static gestorProducto mGestor;
	
	private gestorProducto() {
		listaTiendas = ControladorDB.getControladorDB().getTiendas();
	}
	
	public static gestorProducto getGestorProducto() {
		if (mGestor == null)
			mGestor = new gestorProducto();
		
		return(mGestor); //Hay que retornar un gestorProducto
	}
	
	public ArrayList<Producto> getLista(String busqueda){
		
		listaProducto = ControladorDB.getControladorDB().getLista(busqueda);
		
		return(listaProducto);
	}
	
	public Producto getProducto(String nombre) {
		
		Producto prod=null;
		
		for(Producto p:listaProducto)
			if(p.getNombre().equalsIgnoreCase(nombre))
				prod = p;
		
		return(prod);
	}
	
	public Tienda getLocation(String nombre) { //Obtiene la localización de un producto mediante su Id
		
		Producto prd = null;
		Tienda shop = null;
		
		for(Producto p:listaProducto)
			if(p.getNombre().equalsIgnoreCase(nombre))
				prd = p;
		
		if(prd != null)
			for(Tienda t:listaTiendas)
				if(t.getNombre().equalsIgnoreCase(prd.getNombreTienda()))
					shop = t;
		
		return(shop);
	}

}
