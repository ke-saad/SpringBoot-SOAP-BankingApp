package ma.rest.spring.config;

import lombok.AllArgsConstructor;
import ma.rest.spring.ws.ClientSoapService;
import ma.rest.spring.ws.CompteSoapService;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class CxfConfig {
    private final CompteSoapService compteSoapService;
    private final ClientSoapService clientSoapService;
    private final Bus bus;

    @Bean
    public EndpointImpl endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, compteSoapService);
        endpoint.publish("/comptews");
        return endpoint;
    }

    @Bean
    public EndpointImpl clientEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, clientSoapService);
        endpoint.publish("/clientws");
        return endpoint;
    }
}
