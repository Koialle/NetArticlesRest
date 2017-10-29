package dal;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "auteur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auteur.findAll", query = "SELECT a FROM Auteur a"),
    @NamedQuery(name = "Auteur.findByIdAuteur", query = "SELECT a FROM Auteur a WHERE a.idAuteur = :idAuteur"),
    @NamedQuery(name = "Auteur.findByIdentiteAuteur", query = "SELECT a FROM Auteur a WHERE a.identiteAuteur = :identiteAuteur"),
    @NamedQuery(name = "Auteur.findByAdresseAuteur", query = "SELECT a FROM Auteur a WHERE a.adresseAuteur = :adresseAuteur"),
    @NamedQuery(name = "Auteur.findByLoginAuteur", query = "SELECT a FROM Auteur a WHERE a.loginAuteur = :loginAuteur"),
    @NamedQuery(name = "Auteur.findByPwdAuteur", query = "SELECT a FROM Auteur a WHERE a.pwdAuteur = :pwdAuteur")})
public class Auteur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @TableGenerator(name = "cleAuteur", table = "cles", pkColumnName = "id_cle", valueColumnName = "val_cle", pkColumnValue = "AUTEUR", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "cleAuteur")
    @NotNull
    @Column(name = "id_auteur")
    private Integer idAuteur;
    @Size(max = 80)
    @Column(name = "identite_auteur")
    private String identiteAuteur;
    @Size(max = 200)
    @Column(name = "adresse_auteur")
    private String adresseAuteur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "login_auteur")
    private String loginAuteur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "pwd_auteur")
    private String pwdAuteur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "auteur")
    private List<Redige> redigeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "auteur")
    private List<Droits> droitsList;

    public Auteur() {
    }

    public Auteur(Integer idAuteur) {
        this.idAuteur = idAuteur;
    }

    public Auteur(Integer idAuteur, String loginAuteur, String pwdAuteur) {
        this.idAuteur = idAuteur;
        this.loginAuteur = loginAuteur;
        this.pwdAuteur = pwdAuteur;
    }

    public Integer getIdAuteur() {
        return idAuteur;
    }

    public void setIdAuteur(Integer idAuteur) {
        this.idAuteur = idAuteur;
    }

    public String getIdentiteAuteur() {
        return identiteAuteur;
    }

    public void setIdentiteAuteur(String identiteAuteur) {
        this.identiteAuteur = identiteAuteur;
    }

    public String getAdresseAuteur() {
        return adresseAuteur;
    }

    public void setAdresseAuteur(String adresseAuteur) {
        this.adresseAuteur = adresseAuteur;
    }

    public String getLoginAuteur() {
        return loginAuteur;
    }

    public void setLoginAuteur(String loginAuteur) {
        this.loginAuteur = loginAuteur;
    }

    public String getPwdAuteur() {
        return pwdAuteur;
    }

    public void setPwdAuteur(String pwdAuteur) {
        this.pwdAuteur = pwdAuteur;
    }

    @XmlTransient
    public List<Redige> getRedigeList() {
        return redigeList;
    }

    public void setRedigeList(List<Redige> redigeList) {
        this.redigeList = redigeList;
    }

    @XmlTransient
    public List<Droits> getDroitsList() {
        return droitsList;
    }

    public void setDroitsList(List<Droits> droitsList) {
        this.droitsList = droitsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAuteur != null ? idAuteur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auteur)) {
            return false;
        }
        Auteur other = (Auteur) object;
        if ((this.idAuteur == null && other.idAuteur != null) || (this.idAuteur != null && !this.idAuteur.equals(other.idAuteur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dal.Auteur[ idAuteur=" + idAuteur + " ]";
    }

}
