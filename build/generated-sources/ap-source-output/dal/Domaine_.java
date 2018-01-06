package dal;

import dal.Article;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-06T12:12:48")
@StaticMetamodel(Domaine.class)
public class Domaine_ { 

    public static volatile SingularAttribute<Domaine, Integer> idDomaine;
    public static volatile ListAttribute<Domaine, Article> articleList;
    public static volatile SingularAttribute<Domaine, String> libdomaine;

}