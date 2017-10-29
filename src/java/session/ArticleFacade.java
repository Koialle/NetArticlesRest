package session;

import dal.Article;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ArticleFacade {
    @PersistenceContext(unitName="NetArticlesRestPU")
    private EntityManager em;
    
    /**
     * Liste des articles
     * @return Collection de Article
     * @throws Exception
     */
    public List<Article> lister() throws Exception{
        return em.createNamedQuery("Article.findAll").getResultList();
    }
    
    /**
     * Lecture d'un client sur son id
     * @param id identifiant du client à lire
     * @return Client
     * @throws Exception 
     */
    public Article lire(int id) throws Exception {
        return em.find(Article.class, id);
    }
    
    /**
     * Récupère le dernier aricle paru
     * @return Article
     * @throws Exception 
     */
    public Article getLatest() throws Exception {
        return (Article)em.createNamedQuery("Article.findLatest").getSingleResult();
    }
    
    /**
     * Récupère la liste des article d'un domaine
     * @param id_domaine id du domaine
     * @return Collection de Article
     * @throws Exception 
     */
    public List<Article> listerByDomaine(int id_domaine) throws Exception {
        Query q = em.createNamedQuery("Article.findByDomaine");
        q.setParameter("idDomaine", id_domaine);
        return q.getResultList();
    }
}
