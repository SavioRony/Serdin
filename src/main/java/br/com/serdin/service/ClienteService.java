package br.com.serdin.service;

import br.com.serdin.model.Usuario;
import br.com.serdin.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements Services<Usuario> {

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
}
