package br.com.anhanguera.pos.dao;

import java.util.List;

/**
 *
 * @author rafaelpoveda
 */
public interface IBaseDAO<T> {
    public List<T> listar();
    public boolean inserir(T t);
    public boolean alterar(T t);
    public boolean excluir(T t);
}
