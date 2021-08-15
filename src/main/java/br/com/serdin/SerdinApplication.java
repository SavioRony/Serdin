package br.com.serdin;

import br.com.serdin.Enum.Status;
import br.com.serdin.Enum.TipoUsuario;
import br.com.serdin.model.Usuario;
import br.com.serdin.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@EntityScan(basePackages = "br.com.serdin.model")
@ComponentScan(basePackages = { "br.*" })
@EnableJpaRepositories(basePackages = { "br.*" })
@EnableTransactionManagement
public class SerdinApplication implements CommandLineRunner {

	public static void main(String[] args){
		SpringApplication.run(SerdinApplication.class, args);
		System.out.println("API RODANDO!");
	}

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Transactional
	@Override
	public void run(String... args) throws Exception {
		if(usuarioRepository.count() == 0){
			usuarioRepository.save(new Usuario("Elizangela Xavier","langexavier@hotmail.com",new BCryptPasswordEncoder().encode("123456"), TipoUsuario.ADMIN.getDesc(), Status.ATIVO.getDesc()));
		}
	}
}
