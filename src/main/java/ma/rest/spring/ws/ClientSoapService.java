package ma.rest.spring.ws;

import ma.rest.spring.entities.Client;
import ma.rest.spring.repositories.ClientRepository;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@WebService(serviceName = "ClientWS")
public class ClientSoapService {

    @Autowired
    private ClientRepository clientRepository;

    @WebMethod
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    @WebMethod
    public Client getClientById(@WebParam(name = "id") Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @WebMethod
    public Client createClient(@WebParam(name = "nom") String nom, @WebParam(name = "email") String email) {
        Client client = new Client(null, nom, email);
        return clientRepository.save(client);
    }

    @WebMethod
    public boolean deleteClient(@WebParam(name = "id") Long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
