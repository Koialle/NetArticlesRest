package dal;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "categorie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categorie.findAll", query = "SELECT c FROM Categorie c"),
    @NamedQuery(name = "Categorie.findByIdCategorie", query = "SELECT c FROM Categorie c WHERE c.idCategorie = :idCategorie"),
    @NamedQuery(name = "Categorie.findByLibcategorie", query = "SELECT c FROM Categorie c WHERE c.libcategorie = :libcategorie")})
public class Categorie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @TableGenerator(name = "cleCategorie", table = "cles", pkColumnName = "id_cle", valueColumnName = "val_cle", pkColumnValue = "CATEGORIE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "cleCategorie")
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_categorie")
    private Integer idCategorie;
    @Size(max = 80)
    @Column(name = "libcategorie")
    private String libcategorie;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categorie")
    private List<Client> clientList;

    public Categorie() {
    }

    public Categorie(Integer idCategorie) {
        this.idCategorie = idCategorie;
    }

    public Integer getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Integer idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getLibcategorie() {
        return libcategorie;
    }

    public void setLibcategorie(String libcategorie) {
        this.libcategorie = libcategorie;
    }

    @XmlTransient
    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategorie != null ? idCategorie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categorie)) {
            return false;
        }
        Categorie other = (Categorie) object;
        if ((this.idCategorie == null && other.idCategorie != null) || (this.idCategorie != null && !this.idCategorie.equals(other.idCategorie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dal.Categorie[ idCategorie=" + idCategorie + " ]";
    }

}
