package dal;

import dal.Auteur;
import dal.DroitsPK;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-24T16:47:12")
@StaticMetamodel(Droits.class)
public class Droits_ { 

    public static volatile SingularAttribute<Droits, DroitsPK> droitsPK;
    public static volatile SingularAttribute<Droits, BigDecimal> montantsDroits;
    public static volatile SingularAttribute<Droits, Character> etatDroits;
    public static volatile SingularAttribute<Droits, Auteur> auteur;

}