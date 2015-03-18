package br.com.lojavirtual.impl.servico;

import br.com.lojavirtual.api.modelo.Cliente;
import br.com.lojavirtual.api.modelo.Entidade;
import br.com.lojavirtual.api.modelo.EntidadeCliente;
import br.com.lojavirtual.api.servico.IEntidadeDao;
import org.springframework.transaction.annotation.Transactional;

import javax.enterprise.inject.Instance;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;
public abstract class EntidadeDao<T extends Entidade> implements IEntidadeDao<T>, Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceContext
    protected EntityManager entityManager;

    private Class<?> clazz;

    private Instance<Cliente> clienteInstance;

    protected EntidadeDao() {}

    public EntidadeDao(Class<?> clazz, Instance<Cliente> clienteInstance) {
        this.clienteInstance = clienteInstance;
        this.clazz = clazz;
    }


    public EntidadeDao(Class<?> clazz) {
        this.clazz = clazz;
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public TypedQuery<T> createTypedQuery(String query) {
        return (TypedQuery<T>) entityManager.createQuery(montaQueryCliente(query), clazz);
    }

    public Query createQuery(String query) {
        return entityManager.createQuery(montaQueryCliente(query));
    }

    @Transactional
    @Override
    public T salve(T t) {
        return entityManager.merge(t);
    }

    @Transactional
    @Override
    public void delete(T t) {
        entityManager.remove(t);
    }

    public Integer totalDeRegistros() {
        if (clienteInstance != null && !clienteInstance.get().isLojaCliente() && instanceEntidadeCliente(clazz)) {
            return (Integer) entityManager.createQuery("select count t from " + clazz.getSimpleName() + " t where t.cliente.id = :idCliente").setParameter("idCliente", clienteInstance.get().getId()).getSingleResult();
        }
        return (Integer) entityManager.createQuery("select count  from " + clazz.getSimpleName()).getSingleResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> busqueTodos() {
        if (clienteInstance != null && !clienteInstance.get().isLojaCliente() && instanceEntidadeCliente(clazz)) {
            return entityManager.createQuery("select t from " + clazz.getSimpleName() + " t where t.cliente.id = :idCliente").setParameter("idCliente", clienteInstance.get().getId()).getResultList();
        }
        return entityManager.createQuery(" from " + clazz.getSimpleName()).getResultList();
    }


    public List<T> busqueTodosLazy(Integer first, Integer pageSize, String orderBy) {
        if (clienteInstance != null && !clienteInstance.get().isLojaCliente() && instanceEntidadeCliente(clazz)) {
            return entityManager.createQuery("select t from " + clazz.getSimpleName() + " t where t.cliente.id = :idCliente")
                    .setParameter("idCliente", clienteInstance.get().getId())
                    .setFirstResult(first).setMaxResults(pageSize)
                    .getResultList();
        }
        return entityManager.createQuery(" from " + clazz.getSimpleName()).setFirstResult(first).setMaxResults(pageSize).getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public T carreguePorId(Object id) {
        return (T) entityManager.find(clazz, id);
    }

    @Override
    public void clearContext() {
        entityManager.clear();
    }


    private void insereCliente(T t) {
        if (t instanceof EntidadeCliente && t.getId() == null && (((EntidadeCliente) t).getCliente()) == null) {
            ((EntidadeCliente) t).setCliente(clienteInstance.get());
        }
    }

    private String montaQueryCliente(String query) {
        StringBuilder queryBuilder = new StringBuilder(query);
        if (clienteInstance == null) {
            return queryBuilder.toString();
        }
        Cliente cliente = clienteInstance.get();

        if (cliente.getId() != null && !cliente.isLojaCliente() && instanceEntidadeCliente(clazz)) {
            String queryLowerCase = query.toLowerCase();

            if (!queryLowerCase.contains("delete")) {
                String argument = "select";

                if (queryLowerCase.contains("distinct")) {
                    argument = "distinct";
                }

                StringBuilder alias = new StringBuilder(queryBuilder.substring(queryLowerCase.indexOf(argument) + argument.length(), queryLowerCase.indexOf("from")).replaceAll(" ", "") + ".");
                argument = " where ";
                Integer indexWhere = queryLowerCase.indexOf(argument);

                if (indexWhere > -1) {
                    return queryBuilder.insert(indexWhere + argument.length(), alias.append("cliente.id = ").append(cliente.getId()).append(" and ")).toString();
                }
                return queryBuilder.insert(queryBuilder.length(), argument + alias.append("cliente.id = ").append(cliente.getId())).toString();
            }
        }

        return queryBuilder.toString();
    }

    private boolean instanceEntidadeCliente(Class<?> clazz) {
        try {
            return (clazz.getSuperclass() == EntidadeCliente.class) || instanceEntidadeCliente(clazz.getSuperclass());
        } catch (Exception e) {
            return false;
        }
    }

    protected Cliente getCliente() {
        return clienteInstance.get();
    }

}
