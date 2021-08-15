package br.com.serdin.service;

import java.util.List;

public interface Services<T> {
    public void salvar(T objeto);
    public void deletar(T objeto);
    public List<T> buscarTodos();
    public void alterar(T objeto);

}
