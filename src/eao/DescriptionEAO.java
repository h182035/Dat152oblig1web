package eao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import objekt.Description;
import objekt.Product;

@Stateless
public class DescriptionEAO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 863220272519411796L;

	@PersistenceContext(unitName ="storePu")
    private EntityManager em;
	

	
	public List<Description> getAllDescriptions(){
		return em.createQuery("SELECT s FROM Description s ORDER BY s.pno").getResultList();
	}
}
