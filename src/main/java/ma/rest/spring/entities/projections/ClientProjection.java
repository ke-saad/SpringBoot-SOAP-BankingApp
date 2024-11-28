package ma.rest.spring.entities.projections;

import ma.rest.spring.entities.Client;
import org.springframework.data.rest.core.config.Projection;

@Projection(name ="clientDetails", types = Client.class)
public interface ClientProjection {
    public String getNom();
    public String getEmail();
}
