package spg.finalchallenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spg.finalchallenge.entity.Client;
import spg.finalchallenge.service.ClientService;

import java.util.Optional;

@RestController
@RequestMapping( "/api")
public class ClientController {

    @Autowired
    private ClientService clientService;


    @PostMapping("/client")
    public ResponseEntity<Client> addClient(@RequestBody Client client){
        try{
            return new ResponseEntity<>(clientService.add(client), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<Client> getId(@PathVariable(value = "id") long id) {
        try{
            return new ResponseEntity<>(clientService.getId(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/client/{id}")
    public ResponseEntity<Client> update(@RequestBody Client client, @PathVariable(value = "id") long id) {
        try{
            Optional<Client> clientResult = clientService.findById(id);
            if(clientResult.isPresent()){
                client.setId(clientResult.get().getId());
                return new ResponseEntity<>(clientService.update(client), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/client/cout")
    public long qtdeClient() {
        return clientService.count();
    }
}
