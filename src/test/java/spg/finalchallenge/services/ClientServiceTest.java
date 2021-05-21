package spg.finalchallenge.services;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spg.finalchallenge.entity.Client;
import spg.finalchallenge.service.ClientService;


import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class ClientServiceTest {

    @Autowired
    ClientService clientServiceTest;

    @Test
    public void saveCliente() {
        // given
        Client client = new Client();
        client.setName("Maysa Matos");
        client.setCpf("123.345.567-8");

        // when

        Client cliente = clientServiceTest.findByCpfClient(client.getCpf());

        // then
        assertThat(client).isNull();
    }
}
