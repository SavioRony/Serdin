package br.com.serdin.service;

import br.com.serdin.model.Usuario;
import br.com.serdin.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = false)
public class UsuarioService implements Services<Usuario>, UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void salvar(Usuario objeto) {
        usuarioRepository.save(objeto);
    }

    @Override
    public void deletar(Usuario objeto) {
        usuarioRepository.delete(objeto);
    }

    @Override
    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public void alterar(Usuario objeto) {
        usuarioRepository.save(objeto);
    }

    @Transactional(readOnly = true)
    public Optional<Usuario> buscarPorEmailEAtivo(String email) {
        return usuarioRepository.findByEmailEAtivo(email);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Usuario usuario = buscarPorEmailEAtivo(s).orElseThrow(() -> new UsernameNotFoundException("Usuario " + s + " não encontrado."));
        if (usuario.getStatus().equals("Inativo")) {
            throw new UsernameNotFoundException("Usuario Inativo");
        }
        return new User(usuario.getEmail(), usuario.getSenha(), AuthorityUtils.createAuthorityList(usuario.getTipo()));    }
}
