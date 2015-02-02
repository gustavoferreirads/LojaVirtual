package br.com.lojavirtual.api.servico;

import br.com.lojavirtual.api.modelo.Entidade;

import java.util.List;


public interface IEntidadeDao<T extends Entidade> {

	public T salve(T t);
	
	public List<T> busqueTodos();
    public List<T> busqueTodosLazy(Integer first, Integer pageSize, String orderBy);
	
	public T carreguePorId(Object id);
	
	void delete(T t);
	
	void clearContext();
}
