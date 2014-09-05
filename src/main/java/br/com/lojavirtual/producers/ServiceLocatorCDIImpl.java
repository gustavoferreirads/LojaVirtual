package br.com.lojavirtual.producers;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.lojavirtual.api.servico.ServiceLocator;

public class ServiceLocatorCDIImpl implements ServiceLocator {

	private BeanManager beanManager;

	public <T> T getInstanceFor(Class<T> clazz) {
		if (beanManager == null) {
			initBeanManager();
		}
		return newInstanceFor(clazz);
	}

	private void initBeanManager() {
		try{
			InitialContext initialContext = new InitialContext();
			beanManager = (BeanManager) initialContext.lookup("java:/comp/env/BeanManager");
		} catch (NamingException e) {
			throw new RuntimeException("BeanManager not found", e);
		}
	}


	@SuppressWarnings("unchecked")
	private <T> T newInstanceFor(Class<T> clazz) {
		Bean<Class<T>> bean = (Bean<Class<T>>) beanManager.getBeans(clazz).iterator().next();
		CreationalContext<Class<T>> context = beanManager.createCreationalContext(bean);
		return (T) beanManager.getReference(bean, clazz, context);
	}
}
