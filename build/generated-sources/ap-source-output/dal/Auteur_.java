package dal;

import dal.Droits;
import dal.Redige;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-24T16:47:12")
@StaticMetamodel(Auteur.class)
public class Auteur_ { 

    public static volatile ListAttribute<Auteur, Droits> droitsList;
    public static volatile SingularAttribute<Auteur, Integer> idAuteur;
    public static volatile SingularAttribute<Auteur, String> pwdAuteur;
    public static volatile SingularAttribute<Auteur, String> identiteAuteur;
    public static volatile SingularAttribute<Auteur, String> adresseAuteur;
    public static volatile ListAttribute<Auteur, Redige> redigeList;
    public static volatile SingularAttribute<Auteur, String> loginAuteur;

}