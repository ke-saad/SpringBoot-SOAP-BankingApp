package ma.rest.spring;

import ma.rest.spring.entities.Compte;
import ma.rest.spring.entities.Client;
import ma.rest.spring.entities.TypeCompte;
import ma.rest.spring.repositories.CompteRepository;
import ma.rest.spring.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class TpRestDataCxf {

    public static void main(String[] args) {
        SpringApplication.run(TpRestDataCxf.class, args);
    }

    @Bean
    CommandLineRunner start(CompteRepository compteRepository, ClientRepository clientRepository, RepositoryRestConfiguration restConfiguration) {
        return args -> {
            restConfiguration.exposeIdsFor(Compte.class);
            restConfiguration.exposeIdsFor(Client.class);

            for (int i = 1; i <= 5; i++) {
                Client client = clientRepository.save(new Client(null, "Client" + i, null));

                compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.COURANT, client));
                compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.EPARGNE, client));
            }

            compteRepository.findAll().forEach(c -> {
                System.out.println(c.toString());
            });
        };
    }

}