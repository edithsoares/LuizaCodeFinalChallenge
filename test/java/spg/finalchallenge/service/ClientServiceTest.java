package spg.finalchallenge.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import spg.finalchallenge.entity.Client;



import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServiceTest {

    @Autowired
    ClientService clientServiceTest;

    private Client instaceClient(String name, String cpf){
        Client client = new Client();
        client.setName(name);
        client.setCpf(cpf);
        return clientServiceTest.saveClient(client);
    }


    @Test
    public void saveClient(){
        Client client = instaceClient("Edith", "123");

        assertThat(client).isNotNull();
    }


    @Test
    public void checkIdClientSave(){
        Client client = instaceClient("Edith", "123");

        //Client clientSave = clientServiceTest.saveClient(client);

        assertThat(client.getId()).isEqualTo(1);
    }

    @Test
    public void getClientById(){
        Client client = instaceClient("Edith", "123");

        //Client clientSave = clientServiceTest.saveClient(client);

        Client found = clientServiceTest.getId(client.getId());

        assertThat(found.getName()).isEqualTo(client.getName());
    }

    @Test
    public void countClient(){
        Client client = instaceClient("Edith", "123");//

//        Client clientSvae = clientServiceTest.saveClient(client);

        long qtd = clientServiceTest.count();

        assertThat(qtd).isEqualTo(1);
    }
}
