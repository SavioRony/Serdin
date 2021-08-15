package br.com.serdin.repository;

import br.com.serdin.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query("select u from Usuario u where u.email like :email AND u.status = 'ATIVO'")
    Optional<Usuario> findByEmailEAtivo(String email);
}
