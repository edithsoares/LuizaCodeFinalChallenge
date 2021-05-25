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

    public Client saveClient(Client client){
        return clientRepository.save(client);
    }

    public List<Client> listAllClient(){
        return clientRepository.findAll();
    }

    public Client findByCpf(String cpf) {
        return clientRepository.findByCpf(cpf);
    }

    public Client getId(long id) {
        return clientRepository.findById(id);
    }

    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

    public Client update(Client client) {
        return clientRepository.save(client);
    }

    public void deleteClient(Client client) {
        clientRepository.delete(client);
    }

    public long count() {
        return clientRepository.count();
    }



//    public void delete(long id){
//        clientRepository.deleteById(id);
//    }
}
