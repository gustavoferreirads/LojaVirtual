package br.com.lojavirtual.events;

import javax.inject.Inject;
import javax.persistence.EntityManager;

@InsertBlock
public class HistoricoInsertionBlock {//implements ExecutionBlock<Historico, Void> {

	private EntityManager entityManager;
	private static final String HISTORICO_INSERT_SQL = "INSERT INTO HISTORICO_OPERACAO(ID_USUARIO_OU_GRUPO, ID_TIPO_CADASTRO, ID_ENTIDADE, ID_OPERACAO) VALUES (?, ?, ?, ?)";
	private static final String VALOR_HISTORICO_INSERT_SQL = "INSERT INTO HISTORICO_OPERACAO_VALOR(ID_HISTORICO_OPERACAO, TX_NOME_CAMPO, TX_VALOR_CAMPO) VALUES (?, ?, ?)";

	@Inject
	public HistoricoInsertionBlock(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

//	@Override
//	public Void apply(final Historico historico) {
//		entityManager.unwrap(Session.class).doWork(new Work() {
//			@Override
//			public void execute(Connection connection) throws SQLException {
//				PreparedStatement preparedStatement = null;
//				try {
//					connection.setAutoCommit(false);
//					preparedStatement = connection.prepareStatement(HISTORICO_INSERT_SQL, PreparedStatement.RETURN_GENERATED_KEYS);
//					preparedStatement.setLong(1, historico.getUsuario().getId());
//					preparedStatement.setLong(2, historico.getTipoDoCadastro().getId());
//					preparedStatement.setLong(3, historico.getIdDaEntidade());
//					preparedStatement.setString(4, historico.getOperacao().getIdOperacao());
//					preparedStatement.executeUpdate();
//					ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
//					preparedStatement = connection.prepareStatement(VALOR_HISTORICO_INSERT_SQL);
//					if (generatedKeys.next()) {
//						Long idHistorico = generatedKeys.getLong(1);
//						for (ValorDoHistorico valorDoHistorico : historico.getValores()) {
//							preparedStatement.setLong(1, idHistorico);
//							preparedStatement.setString(2, valorDoHistorico.getLabelDoCampo());
//							preparedStatement.setString(3, valorDoHistorico.getValorDoCampo());
//							preparedStatement.executeUpdate();
//						}
//					}
//					connection.commit();
//				} catch (Exception ex) {
//					connection.rollback();
//					throw new RuntimeException(ex);
//				} finally {
//					if (preparedStatement != null) {
//						preparedStatement.close();
//					}
//				}
//
//
//			}
//		});
//		return null;
//	}
}
