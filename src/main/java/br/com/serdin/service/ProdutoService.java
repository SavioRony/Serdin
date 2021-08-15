package br.com.serdin.service;

import br.com.serdin.model.Produto;
import br.com.serdin.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService implements Services<Produto> {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public void salvar(Produto objeto) {
        produtoRepository.save(objeto);
    }

    @Override
    public void deletar(Produto objeto) {
        produtoRepository.delete(objeto);
    }

    @Override
    public List<Produto> buscarTodos() {
        return produtoRepository.findAll();
    }

    @Override
    public void alterar(Produto objeto) {
        produtoRepository.save(objeto);
    }
}
