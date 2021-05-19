package spg.finalchallenge.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import spg.finalchallenge.entity.Client;

import static org.assertj.core.api.Assertions.assertThat;

public class ClientServiceTest {

    @Autowired
    ClientService clientServiceTest;

    @Test
    void salvarClienteNoBanco() {
        // given
        Client cli = new Client();
        cli.setCpf("12346789015");
        cli.setName("Edith");
        cli.setAddress("Rua das flores 98");

        // when
        Client clienteSalvo = clientServiceTest.saveClient(cli);

        // then
        assertThat(clienteSalvo).isNotNull();
    }


    @Test
    void verificarIdDoClienteSalvo() {
        // given
        Client cli = new Client();
        cli.setCpf("12346789015");
        cli.setName("Edith");
        cli.setAddress("Rua das flores 98");

        // when
        Client clienteSalvo = clientServiceTest.saveClient(cli);

        // then
        assertThat(clienteSalvo.getId()).isEqualTo(1);
    }

    @Test
    public void getUserByID() {
        // given
        Client cli = new Client();
        cli.setCpf("12346789015");
        cli.setName("Edith");
        cli.setAddress("Rua das flores 98");

        clientServiceTest.saveClient(cli);

        // when
        Client found = clientServiceTest.getId(cli.getId());

        // then
        assertThat(found.getName())
                .isEqualTo(cli.getName());
    }

    @Test
    public void contaQuantosClientesNoBanco() {
        // given
        Client cli = new Client();
        cli.setCpf("12346789015");
        cli.setName("Edith");
        cli.setAddress("Rua das flores 98");

        clientServiceTest.saveClient(cli);

        // when
        long qtd = clientServiceTest.count();

        // then
        assertThat(qtd).isEqualTo(1);
    }
}
