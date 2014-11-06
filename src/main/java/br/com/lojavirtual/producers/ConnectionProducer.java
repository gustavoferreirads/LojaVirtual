package br.com.lojavirtual.producers;


import javax.enterprise.inject.Produces;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.SQLException;

public class ConnectionProducer {


	private InitialContext initialContext;

	public ConnectionProducer() throws NamingException {
		initialContext = new InitialContext();
	}

	@Produces
	@br.com.lojavirtual.producers.Connection
	public java.sql.Connection getConnection() throws NamingException, SQLException {
		DataSource dataSource = (DataSource) initialContext.lookup("java:/comp/env/jdbc/loja");
		return dataSource.getConnection();
	}

	protected void setInitialContext(InitialContext initialContext) {
		this.initialContext = initialContext;
	}

}
