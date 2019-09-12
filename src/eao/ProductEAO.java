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
	
	/**
	 * Adds a stand to the database
	 * @param stand
	 */
	public void leggTilStand(Product p) {
		em.persist(p);
	}
	/**
	 * retrieves a stand from the batabase
	 * @param stand
	 * @return
	 */
	public Stand hentStandInformasjon(String standNavn) {
		Stand stand = em.find(Stand.class, standNavn);
		return stand;
	}
	
	public List<Stand> hentAlleStands(){
		return em.createQuery("SELECT s FROM Stand s ORDER BY s.navn").getResultList();
	}
	public boolean finnes(String standnavn) {
		if(standnavn == null) {
			return false;
		}
		Stand stand = em.find(Stand.class, standnavn);
		return stand != null;
	}
}
