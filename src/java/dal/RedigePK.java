package dal;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class RedigePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_article")
    private int idArticle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_auteur")
    private int idAuteur;

    public RedigePK() {
    }

    public RedigePK(int idArticle, int idAuteur) {
        this.idArticle = idArticle;
        this.idAuteur = idAuteur;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public int getIdAuteur() {
        return idAuteur;
    }

    public void setIdAuteur(int idAuteur) {
        this.idAuteur = idAuteur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idArticle;
        hash += (int) idAuteur;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RedigePK)) {
            return false;
        }
        RedigePK other = (RedigePK) object;
        if (this.idArticle != other.idArticle) {
            return false;
        }
        if (this.idAuteur != other.idAuteur) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dal.RedigePK[ idArticle=" + idArticle + ", idAuteur=" + idAuteur + " ]";
    }
    
}
