package dal;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findByIdClient", query = "SELECT c FROM Client c WHERE c.idClient = :idClient"),
    @NamedQuery(name = "Client.findByIdentiteClient", query = "SELECT c FROM Client c WHERE c.identiteClient = :identiteClient"),
    @NamedQuery(name = "Client.findByAdresseClient", query = "SELECT c FROM Client c WHERE c.adresseClient = :adresseClient"),
    @NamedQuery(name = "Client.findByCredits", query = "SELECT c FROM Client c WHERE c.credits = :credits"),
    @NamedQuery(name = "Client.findByLoginClient", query = "SELECT c FROM Client c WHERE c.loginClient = :loginClient"),
    @NamedQuery(name = "Client.findByPwdClient", query = "SELECT c FROM Client c WHERE c.pwdClient = :pwdClient")})
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @TableGenerator(name = "cleClient", table = "cles", pkColumnName = "id_cle", valueColumnName = "val_cle", pkColumnValue = "CLIENT", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "cleClient")
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_client")
    private Integer idClient;
    @Size(max = 80)
    @Column(name = "identite_client")
    private String identiteClient;
    @Size(max = 200)
    @Column(name = "adresse_client")
    private String adresseClient;
    @Column(name = "credits")
    private Integer credits;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "login_client")
    private String loginClient;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "pwd_client")
    private String pwdClient;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<Achete> acheteList;
    @JoinColumn(name = "id_categorie", referencedColumnName = "id_categorie")
    @ManyToOne(optional = false)
    private Categorie categorie;

    public Client() {
    }

    public Client(Integer idClient) {
        this.idClient = idClient;
    }

    public Client(Integer idClient, String loginClient, String pwdClient) {
        this.idClient = idClient;
        this.loginClient = loginClient;
        this.pwdClient = pwdClient;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getIdentiteClient() {
        return identiteClient;
    }

    public void setIdentiteClient(String identiteClient) {
        this.identiteClient = identiteClient;
    }

    public String getAdresseClient() {
        return adresseClient;
    }

    public void setAdresseClient(String adresseClient) {
        this.adresseClient = adresseClient;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public String getLoginClient() {
        return loginClient;
    }

    public void setLoginClient(String loginClient) {
        this.loginClient = loginClient;
    }

    public String getPwdClient() {
        return pwdClient;
    }

    public void setPwdClient(String pwdClient) {
        this.pwdClient = pwdClient;
    }

    @XmlTransient
    public List<Achete> getAcheteList() {
        return acheteList;
    }

    public void setAcheteList(List<Achete> acheteList) {
        this.acheteList = acheteList;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClient != null ? idClient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.idClient == null && other.idClient != null) || (this.idClient != null && !this.idClient.equals(other.idClient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dal.Client[ idClient=" + idClient + " ]";
    }

}
