package br.com.serdin.service;

import br.com.serdin.model.Endereco;
import br.com.serdin.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService implements Services<Endereco>{

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public void salvar(Endereco objeto) {
        enderecoRepository.save(objeto);
    }

    @Override
    public void deletar(Endereco objeto) {
        enderecoRepository.delete(objeto);
    }

    @Override
    public List<Endereco> buscarTodos() {
        return enderecoRepository.findAll();
    }

    @Override
    public void alterar(Endereco objeto) {
        enderecoRepository.save(objeto);
    }
}
