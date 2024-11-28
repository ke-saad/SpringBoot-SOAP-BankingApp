package ma.rest.spring.entities.projections;

import org.springframework.data.rest.core.config.Projection;
import ma.rest.spring.entities.Compte;

@Projection(name = "solde", types = Compte.class)
public interface CompteProjection1 {
    double getSolde();
}
