package spg.finalchallenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spg.finalchallenge.entity.Client;
import spg.finalchallenge.repository.ClientRepository;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client add(Client client) {
        return clientRepository.save( client);
    }

    public Client getId(long id) {
        return clientRepository.findById(id);
    }

    public Client update(Client client) {
        return clientRepository.save(client);
    }

    public long count() {
        return clientRepository.count();
    }

    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }
}
