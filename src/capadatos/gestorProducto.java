package capadatos;

import java.util.ArrayList;
import java.util.List;

import Producto;

public class gestorProducto {
	
	@PersistenceUnit
	EntityManagerFactory emf;
	
	@PersistenceContext
	private EntityManager em = emf.createEntityManager();
	
	private List<Producto> lista = new ArrayList<Producto>();
	
	public gestorProducto() {}
	
	public EntityManager getGestorProducto() {
		
		return(em);
	}
	
	public void addProducto(Producto p) {
		
		if(lista.isEmpty()) {
			lista = em.createNamedQuery("producto.findAll").getResultList();
		}
		
		lista.add(p);
		em.persist(p);
		
	}
	
	public String getLocation(int Id) {
		
		Producto p = em.find(Producto.class, Id);
		
		return(p.getLocation());
	}

}
