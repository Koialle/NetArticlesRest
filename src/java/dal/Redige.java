package dal;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "redige")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Redige.findAll", query = "SELECT r FROM Redige r"),
    @NamedQuery(name = "Redige.findByIdArticle", query = "SELECT r FROM Redige r WHERE r.redigePK.idArticle = :idArticle"),
    @NamedQuery(name = "Redige.findByIdAuteur", query = "SELECT r FROM Redige r WHERE r.redigePK.idAuteur = :idAuteur"),
    @NamedQuery(name = "Redige.findByPart", query = "SELECT r FROM Redige r WHERE r.part = :part")})
public class Redige implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RedigePK redigePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "part")
    private int part;
    @JoinColumn(name = "id_article", referencedColumnName = "id_article", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Article article;
    @JoinColumn(name = "id_auteur", referencedColumnName = "id_auteur", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Auteur auteur;

    public Redige() {
    }

    public Redige(RedigePK redigePK) {
        this.redigePK = redigePK;
    }

    public Redige(RedigePK redigePK, int part) {
        this.redigePK = redigePK;
        this.part = part;
    }

    public Redige(int idArticle, int idAuteur) {
        this.redigePK = new RedigePK(idArticle, idAuteur);
    }

    public RedigePK getRedigePK() {
        return redigePK;
    }

    public void setRedigePK(RedigePK redigePK) {
        this.redigePK = redigePK;
    }

    public int getPart() {
        return part;
    }

    public void setPart(int part) {
        this.part = part;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (redigePK != null ? redigePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Redige)) {
            return false;
        }
        Redige other = (Redige) object;
        if ((this.redigePK == null && other.redigePK != null) || (this.redigePK != null && !this.redigePK.equals(other.redigePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dal.Redige[ redigePK=" + redigePK + " ]";
    }
    
}
