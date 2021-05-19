package spg.finalchallenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spg.finalchallenge.entity.Client;
import spg.finalchallenge.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

//  Cadastrar clients
    public Client saveClient(Client client){
        return clientRepository.save(client);
    }

//  Buscar todos os Clients
    public List<Client> listAllClient(){
        return clientRepository.findAll();
    }

    public  Client findByCpfClient(String cpf){
        return clientRepository.findByCpf(cpf);
    }

    public void deleteClient(Client client) {
        clientRepository.delete(client);
    }

    public Client getId(long id) {
        return clientRepository.findById(id);
    }

    public Optional<Client> findByIdClient(Long id) {
        return clientRepository.findById(id);
    }

    public Client update(Client client) {
        return clientRepository.save(client);
    }

    public long count() {
        return clientRepository.count();
    }
}
