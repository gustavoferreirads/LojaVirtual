package br.com.lojavirtual.impl.servico;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Instance;
import javax.naming.NamingException;
import javax.persistence.*;
import javax.transaction.Transactional;

import br.com.lojavirtual.api.modelo.Cliente;
import br.com.lojavirtual.api.modelo.Entidade;
import br.com.lojavirtual.api.modelo.EntidadeCliente;
import br.com.lojavirtual.api.servico.IEntidadeDao;
import org.springframework.jndi.JndiTemplate;
import org.springframework.stereotype.Repository;

public abstract class EntidadeDao<T extends Entidade> implements IEntidadeDao<T>, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	protected  EntityManager entityManager;
	
	private Class<?> clazz;

	private Instance<Cliente> clienteInstance;

	protected EntidadeDao() {
	}
	
	
	public EntidadeDao(Class<?> clazz, Instance<Cliente> clienteInstance) {
		this.clienteInstance = clienteInstance;
		this.clazz = clazz;
	}

	public EntidadeDao(EntityManager entityManager, Class<?> clazz) {
		this.entityManager = entityManager;
		this.clazz = clazz;
	}

	public EntidadeDao(Class<?> clazz) {
		this.clazz = clazz;
	}

	@SuppressWarnings("unchecked")
    @Transactional
	public TypedQuery<T> createTypedQuery(String query) {
		return (TypedQuery<T>) getEntityManager().createQuery(montaQueryCliente(query), clazz);
	}
	
	public Query createQuery(String query) {
		return getEntityManager().createQuery(montaQueryCliente(query));
	}
	
	@Transactional
	@Override
	public T salve(T t) {
		insereCliente(t);
		return getEntityManager().merge(t);
	}

	@Transactional
	@Override
	public void delete(T t) {
		t = getEntityManager().merge(t);
		getEntityManager().remove(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> busqueTodos() {
		if (clienteInstance != null && !clienteInstance.get().isLojaCliente() && instanceEntidadeCliente(clazz)) {
			return getEntityManager().createQuery("select t from "+clazz.getSimpleName()+" t where t.cliente.id = :idCliente").setParameter("idCliente", clienteInstance.get().getId()).getResultList();
		} else {
			return getEntityManager().createQuery(" from "+clazz.getSimpleName()).getResultList();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T carreguePorId(Object id) {
		return (T) getEntityManager().find(clazz, id);
	}

	@Override
	public void clearContext() {
		getEntityManager().clear();
	}

	private EntityManager getEntityManager() {
		return entityManager;
	}

	private void insereCliente(T t) {
		if (t instanceof EntidadeCliente && t.getId() == null && (((EntidadeCliente) t).getCliente()) == null ) {
			((EntidadeCliente) t).setCliente(clienteInstance.get());
		}
	}

	private String montaQueryCliente(String query) {
		StringBuilder queryBuilder = new StringBuilder(query);
		if (clienteInstance == null) {
			return queryBuilder.toString();
		}
		Cliente cliente = clienteInstance.get();
		
			if(cliente.getId() != null && !cliente.isLojaCliente() && instanceEntidadeCliente(clazz)){
				String queryLowerCase = query.toLowerCase();

				if(!queryLowerCase.contains("delete")){
					String argument = "select";
				
					if(queryLowerCase.contains("distinct")){
						argument = "distinct";	
					}
					
					StringBuilder alias = new StringBuilder(queryBuilder.substring(queryLowerCase.indexOf(argument) + argument.length(), queryLowerCase.indexOf("from")).replaceAll(" ", "") + ".");
					argument = " where ";
					Integer indexWhere = queryLowerCase.indexOf(argument);
					
					if(indexWhere > -1){
						queryBuilder.insert(indexWhere + argument.length(), alias.append("cliente.id = ").append(cliente.getId()).append(" and "));
					}else{
						queryBuilder.insert(queryBuilder.length(), argument + alias.append("cliente.id = ").append(cliente.getId()));
					}
				}
			}
	
		return queryBuilder.toString();
	}
	
	private boolean instanceEntidadeCliente(Class<?> clazz) {
		try{
			return (clazz.getSuperclass() == EntidadeCliente.class) || instanceEntidadeCliente(clazz.getSuperclass());
		}catch(Exception e){
			return false;	
		}
	}

	protected Cliente getCliente() {
		return clienteInstance.get();
	}

}
