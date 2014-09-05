package br.com.lojavirtual.api.servico;

public interface ServiceLocator {

    public <T> T getInstanceFor(Class<T> clazz);

}
