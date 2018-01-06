package dal;

import dal.Achete;
import dal.Categorie;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-06T12:12:48")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile ListAttribute<Client, Achete> acheteList;
    public static volatile SingularAttribute<Client, Categorie> categorie;
    public static volatile SingularAttribute<Client, Integer> idClient;
    public static volatile SingularAttribute<Client, Integer> credits;
    public static volatile SingularAttribute<Client, String> adresseClient;
    public static volatile SingularAttribute<Client, String> loginClient;
    public static volatile SingularAttribute<Client, String> identiteClient;
    public static volatile SingularAttribute<Client, String> pwdClient;

}