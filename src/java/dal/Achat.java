package dal;

import java.util.Date;
import javax.ejb.Stateless;

@Stateless
public class Achat {
    private int idClient;
    private int idArticle;
    private Date dateAchat;

    /**
     * @return the idClient
     */
    public int getIdClient() {
        return idClient;
    }

    /**
     * @param idClient the idClient to set
     */
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    /**
     * @return the idArticle
     */
    public int getIdArticle() {
        return idArticle;
    }

    /**
     * @param idArticle the idArticle to set
     */
    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    /**
     * @return the dateAchat
     */
    public Date getDateAchat() {
        return dateAchat;
    }

    /**
     * @param dateAchat the dateAchat to set
     */
    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }
}
