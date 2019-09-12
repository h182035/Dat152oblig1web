package eao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import objekt.Product;

@Stateless
public class ProductEAO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 863220272519411796L;

	@PersistenceContext(unitName ="storePu")
    private EntityManager em;
	

	
	public List<Product> gettAllProducts(){
		return em.createQuery("SELECT s FROM Product s ORDER BY s.pno").getResultList();
	}
	
}
