package session;

import dal.Achete;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class AcheteFacade {
    
    @EJB
    ClientFacade clientF;
    
    @EJB
    ArticleFacade articleF;
    
    @PersistenceContext(unitName="NetArticlesRestPU")
    private EntityManager em;
    
    /**
     * Lister tous les achats relatifs à un client
     * @param idClient identifiant du client dont on souhaite récupérer les achats
     * @return Liste d'Achete
     * @throws Exception 
     */
    public List<Achete> listerByClient(int idClient) throws Exception {
        Query q = em.createNamedQuery("Achete.findByIdClient");
        q.setParameter("idClient", idClient);
        List<Achete> achats = q.getResultList();
        for(Achete a : achats) {
            em.refresh(a);
        }
        return achats;
    }
    
    /**
     * Record a purchase coming from a client
     * @param a Achete
     * @throws Exception 
     */
    public void effectuerAchat(int idClient, int idArticle, Date dateAchat) throws Exception {      
        Achete ach = new Achete(idClient, idArticle);       
        ach.setDateAchat(dateAchat);
        em.persist(ach);
    }    
}
