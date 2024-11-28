package ma.rest.spring.entities.projections;

import ma.rest.spring.entities.Compte;
import ma.rest.spring.entities.TypeCompte;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "mobile", types = Compte.class)
public interface CompteProjection2 {
    double getSolde();
    TypeCompte getType();
}
