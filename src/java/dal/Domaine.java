package dal;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "domaine")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Domaine.findAll", query = "SELECT d FROM Domaine d"),
    @NamedQuery(name = "Domaine.findByIdDomaine", query = "SELECT d FROM Domaine d WHERE d.idDomaine = :idDomaine"),
    @NamedQuery(name = "Domaine.findByLibdomaine", query = "SELECT d FROM Domaine d WHERE d.libdomaine = :libdomaine")})
public class Domaine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @TableGenerator(name = "cleDomaine", table = "cles", pkColumnName = "id_cle", valueColumnName = "val_cle", pkColumnValue = "DOMAINE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "cleDomaine")
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_domaine")
    private Integer idDomaine;
    @Size(max = 80)
    @Column(name = "libdomaine")
    private String libdomaine;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "domaine")
    private List<Article> articleList;

    public Domaine() {
    }

    public Domaine(Integer idDomaine) {
        this.idDomaine = idDomaine;
    }

    public Integer getIdDomaine() {
        return idDomaine;
    }

    public void setIdDomaine(Integer idDomaine) {
        this.idDomaine = idDomaine;
    }

    public String getLibdomaine() {
        return libdomaine;
    }

    public void setLibdomaine(String libdomaine) {
        this.libdomaine = libdomaine;
    }

    @XmlTransient
    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDomaine != null ? idDomaine.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Domaine)) {
            return false;
        }
        Domaine other = (Domaine) object;
        if ((this.idDomaine == null && other.idDomaine != null) || (this.idDomaine != null && !this.idDomaine.equals(other.idDomaine))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dal.Domaine[ idDomaine=" + idDomaine + " ]";
    }

}
