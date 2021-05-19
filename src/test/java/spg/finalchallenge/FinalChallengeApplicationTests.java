package spg.finalchallenge;

import jdk.dynalink.linker.support.Guards;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spg.finalchallenge.entity.Client;
import spg.finalchallenge.service.ClientService;

import static org.assertj.core.api.Assertions.assertThat;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
class FinalChallengeApplicationTests {

	@Test
	void contextLoads() {
	}


}
