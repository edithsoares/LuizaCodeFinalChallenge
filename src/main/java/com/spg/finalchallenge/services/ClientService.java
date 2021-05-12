package com.spg.finalchallenge.services;

import com.spg.finalchallenge.entity.Client;
import com.spg.finalchallenge.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client adicionarClient(Client client){
        return clientRepository.save(client);
    }

    public Client buscarClient(long id){
        return clientRepository.findById(id);
    }

    public long count(){
        return clientRepository.count();
    }

}
