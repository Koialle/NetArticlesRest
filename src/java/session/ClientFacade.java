package session;

import dal.Client;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ClientFacade {
    
    @PersistenceContext(unitName="NetArticlesRestPU")
    private EntityManager em;
    
    @EJB
    ArticleFacade articleF;
    
    /**
     * Liste des clients
     * @return Collection de Client
     * @throws Exception
     */
    public List<Client> lister() throws Exception{
        return em.createNamedQuery("Client.findAll").getResultList();
    }
    
    /**
     * Lecture d'un client sur son id
     * @param idClient identifiant du client à lire
     * @return Client
     * @throws Exception 
     */
    public Client lire(int idClient) throws Exception {
        return em.find(Client.class, idClient);
    }
    
    /**
     * Lecteur du client sur son login
     * @param login login du client à lire
     * @return Client
     * @throws Exception 
     */
    public Client lireLogin(String login) throws Exception {
        Query requete = em.createNamedQuery("Client.findByLoginClient");
        requete.setParameter("loginClient", login);
        return (Client)requete.getSingleResult();
    }
    
    /**
     * Modification d'un client
     * @param client : Client à modifier
     * @throws Exception 
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void modifier(Client client) throws Exception {
        Client c = lire(client.getIdClient());
        c.setAdresseClient(client.getAdresseClient());
        c.setCredits(client.getCredits());
        c.setCategorie(client.getCategorie());
        c.setIdentiteClient(client.getIdentiteClient());
        c.setLoginClient(client.getLoginClient());
        c.setPwdClient(client.getPwdClient());
        em.merge(c);
    }
    
    /**
     * Ajotu d'un client
     * @param client : Client à ajouter
     * @throws Exception 
     */
    public void ajouter(Client client) throws Exception {
        em.persist(client);
    }
    
    /**
     * Suppression d'un client
     * @param idClient : id du client à supprimer
     * @throws Exception 
     */
    public void supprimer(int idClient) throws Exception {
        Client c = lire(idClient);
        em.remove(c);
    }
    
    /**
     * Débiter le compte d'un client
     * @param idClient Id du Client à débiter
     * @param montant montant à débiter du compte du Client
     * @throws Exception 
     */
    public void debiterCompte(int idClient, BigDecimal montant) throws Exception {
        Client client = lire(idClient);      
        client.setCredits(client.getCredits() - montant.intValue());
        em.merge(client);
    }
}
