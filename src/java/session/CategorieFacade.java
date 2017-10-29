package session;

import dal.Categorie;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class CategorieFacade {

    @PersistenceContext(unitName = "NetArticlesRestPU")
    private EntityManager em;
    
    /**
     * Récupère la liste des categories
     * @return Collection de Categorie
     * @throws Exception 
     */
    public List<Categorie> lister() throws Exception {
        return em.createNamedQuery("Categorie.findAll").getResultList();
    }
    
    /**
     * Lecture d'une categorie sur son Id
     * @param idCategorie Id de la categorie à lire
     * @return Categorie
     * @throws Exception 
     */
    public Categorie lire(int idCategorie) throws Exception {
        return em.find(Categorie.class, idCategorie);
    }
}
