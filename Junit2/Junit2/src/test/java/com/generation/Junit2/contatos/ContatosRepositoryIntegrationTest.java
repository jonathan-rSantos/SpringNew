package com.generation.Junit2.contatos;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.generation.Junit2.model.ContatoModel;
import com.generation.Junit2.repository.ContatoRepository;



//Run with rodará com o spring runner,
//que suporta testes de integração de interfaces (testa se a 
//repository está funcionando)

@RunWith(SpringRunner.class)
@DataJpaTest //melhor testador de JPA
public class ContatosRepositoryIntegrationTest {

	private ContatoModel contato;
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	String message= "Employee ID is null";
	
	@Before
	public void start() {
		contato = new ContatoModel("Gabriel", "011y", "9xxxxxxx9");
	}
	
	//regra, não aceita exceções, é a maneira de especificar
	//que a execução de um teste lançará uma exceção
	//Verifica se o @NotEmpty está funcionando

	
	@Test (expected = RuntimeException.class)
	public void salvarComTelNulo() throws Exception {
		
		
		contato.setTelefone(null);
		contatoRepository.save(contato);
	}
	
	@Test (expected = RuntimeException.class)
	public void salvarComDddNulo() throws Exception {
		
		
		contato.setDdd(null);
		contatoRepository.save(contato);
	}
	
	@Test (expected = RuntimeException.class)
	public void salvarComNomeNulo() throws Exception {
		
		contato.setNome(null);
		contatoRepository.save(contato);
	}
	
}