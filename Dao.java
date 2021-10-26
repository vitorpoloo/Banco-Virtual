package br.com.projeto.banco;

import java.util.List;

public interface Dao<T> {

    public void salvar(T objeto) throws Exception;

    public List<T> listar() throws Exception;

    public void excluir(T objeto) throws Exception;

}
