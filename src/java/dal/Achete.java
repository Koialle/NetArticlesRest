package dal;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "achete")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Achete.findAll", query = "SELECT a FROM Achete a"),
    @NamedQuery(name = "Achete.findByIdClient", query = "SELECT a FROM Achete a WHERE a.achetePK.idClient = :idClient"),
    @NamedQuery(name = "Achete.findByIdArticle", query = "SELECT a FROM Achete a WHERE a.achetePK.idArticle = :idArticle"),
    @NamedQuery(name = "Achete.findByDateAchat", query = "SELECT a FROM Achete a WHERE a.dateAchat = :dateAchat")})
public class Achete implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AchetePK achetePK;
    @Column(name = "date_achat")
    @Temporal(TemporalType.DATE)
    private Date dateAchat;
    @JoinColumn(name = "id_article", referencedColumnName = "id_article", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Article article;
    @JoinColumn(name = "id_client", referencedColumnName = "id_client", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Client client;

    public Achete() {
    }

    public Achete(AchetePK achetePK) {
        this.achetePK = achetePK;
    }

    public Achete(int idClient, int idArticle) {
        this.achetePK = new AchetePK(idClient, idArticle);
    }

    public AchetePK getAchetePK() {
        return achetePK;
    }

    public void setAchetePK(AchetePK achetePK) {
        this.achetePK = achetePK;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (achetePK != null ? achetePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Achete)) {
            return false;
        }
        Achete other = (Achete) object;
        if ((this.achetePK == null && other.achetePK != null) || (this.achetePK != null && !this.achetePK.equals(other.achetePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dal.Achete[ achetePK=" + achetePK + " ]";
    }
    
}
