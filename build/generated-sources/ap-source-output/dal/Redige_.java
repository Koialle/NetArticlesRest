package dal;

import dal.Article;
import dal.Auteur;
import dal.RedigePK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-06T12:12:48")
@StaticMetamodel(Redige.class)
public class Redige_ { 

    public static volatile SingularAttribute<Redige, RedigePK> redigePK;
    public static volatile SingularAttribute<Redige, Integer> part;
    public static volatile SingularAttribute<Redige, Article> article;
    public static volatile SingularAttribute<Redige, Auteur> auteur;

}