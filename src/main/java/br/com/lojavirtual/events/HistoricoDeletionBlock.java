package br.com.lojavirtual.events;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.jdbc.Work;

@DeleteBlock
public class HistoricoDeletionBlock {//implements ExecutionBlock<Historico, Integer> {

	private final EntityManager entityManager;

	private static final String DELETE_VALOR_HISTORICO = "DELETE FROM HISTORICO_OPERACAO_VALOR WHERE ID_HISTORICO_OPERACAO = ?";
	private static final String DELETE_HISTORICO = "DELETE FROM HISTORICO_OPERACAO WHERE ID_HISTORICO_OPERACAO = ?";

	@Inject
	public HistoricoDeletionBlock(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

//	@Override
//	public Integer apply(final Historico historico) {
//		final int[] rowsAffected = {0};
//		entityManager.unwrap(Session.class).doWork(new Work() {
//			@Override
//			public void execute(Connection connection) throws SQLException {
//				PreparedStatement preparedStatement = null;
//				try{
//					connection.setAutoCommit(false);
//					preparedStatement = connection.prepareStatement(DELETE_VALOR_HISTORICO);
//					preparedStatement.setLong(1, historico.getId());
//					rowsAffected[0] += preparedStatement.executeUpdate();
//					preparedStatement = connection.prepareStatement(DELETE_HISTORICO);
//					preparedStatement.setLong(1, historico.getId());
//					rowsAffected[0] += preparedStatement.executeUpdate();
//					connection.commit();
//				} catch (Exception ex) {
//					connection.rollback();
//					throw new RuntimeException(ex);
//				} finally {
//					if (preparedStatement != null) {
//						preparedStatement.close();
//					}
//				}
//			}
//		});
//		return rowsAffected[0];
//	}
}
