package session;

import dal.Domaine;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DomaineFacade {

    @PersistenceContext(unitName = "NetArticlesRestPU")
    private EntityManager em;
    
    /**
     * Liste des domaines
     * @return Collection de Domaine
     * @throws Exception 
     */
    public List<Domaine> lister() throws Exception {
        return em.createNamedQuery("Domaine.findAll").getResultList();
    }
    
    /**
     * Lecture d'un Domaine sir son Id
     * @param idDomaine Id du Domaine à lire
     * @return Domaine
     * @throws Exception 
     */
    public Domaine lire(int idDomaine) throws Exception {
        return em.find(Domaine.class, idDomaine);
    }
}
