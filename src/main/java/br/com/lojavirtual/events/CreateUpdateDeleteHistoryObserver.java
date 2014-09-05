package br.com.lojavirtual.events;

import static ch.lambdaj.Lambda.having;
import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.Lambda.select;
import static ch.lambdaj.Lambda.selectFirst;
import static ch.lambdaj.Lambda.sort;
import static org.hamcrest.Matchers.equalTo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import br.com.lojavirtual.api.events.CreateEvent;
import br.com.lojavirtual.api.events.DMLEvent;
import br.com.lojavirtual.api.events.DeleteEvent;
import br.com.lojavirtual.api.events.FieldState;
import br.com.lojavirtual.api.events.UpdateEvent;
import br.com.lojavirtual.api.modelo.Entidade;

public class CreateUpdateDeleteHistoryObserver {

//	private IFieldProvider provider;
//	private final ITipoDoCadastroDao tipoDoCadastroDao;
//	private ISecurityUtils securityUtils;
//	private IOperacaoDao operacaoDao;
//	private ExecutionBlock<Historico, Void> insertionBlock;
//	private IHistoricoDao historicoDao;
//	private ExecutionBlock<Historico, Integer> deletionBlock;
//	private Operacao operacaoAtual;

	private static final Integer MAX_BUFFER_UPDATE_ACTIONS_SIZE = 50;

//	@Inject
//	public CreateUpdateDeleteHistoryObserver(IFieldProvider provider, ITipoDoCadastroDao tipoDoCadastroDao, ISecurityUtils securityUtils, IOperacaoDao operacaoDao,
//											 @InsertBlock ExecutionBlock<Historico, Void> insertionBlock, IHistoricoDao historicoDao, @DeleteBlock ExecutionBlock<Historico, Integer> deletionBlock) {
//		this.provider = provider;
//		this.tipoDoCadastroDao = tipoDoCadastroDao;
//		this.securityUtils = securityUtils;
//		this.operacaoDao = operacaoDao;
//		this.insertionBlock = insertionBlock;
//		this.historicoDao = historicoDao;
//		this.deletionBlock = deletionBlock;
//	}

//	public void observe(@Observes CreateEvent createEvent) {
//		operacaoAtual = operacaoDao.carreguePorId("I");
//		Historico historico = createHistoricoFrom(createEvent);
//		insertionBlock.apply(historico);
//	}
//
//	public void observe(@Observes UpdateEvent updateEvent) {
//		operacaoAtual = operacaoDao.carreguePorId("A");
//		Historico historico = createHistoricoFrom(updateEvent);
//		clearHistoricoBufferFrom(updateEvent.getEntidade());
//		insertionBlock.apply(historico);
//	}
//
//	public void observe(@Observes DeleteEvent deleteEvent) {
//		operacaoAtual = operacaoDao.carreguePorId("E");
//		Historico historico = createHistoricoFrom(deleteEvent);
//		insertionBlock.apply(historico);
//	}
//
//	private Historico createHistoricoFrom(DMLEvent dmlEvent) {
//		Entidade entidade = dmlEvent.getEntidade();
//		TipoDoCadastro tipoDoCadastro = tipoDoCadastroDao.busquePeloNomeDaClasse(entidade.getClass().getSimpleName());
//		List<ValorDoHistorico> valorDoHistoricos = createHistoricoValuesFrom(dmlEvent);
//		return new Historico(securityUtils.usuarioLogado(), Long.valueOf(entidade.getId().toString()), valorDoHistoricos, operacaoAtual, tipoDoCadastro);
//	}
//
//	private List<ValorDoHistorico> createHistoricoValuesFrom(DMLEvent dmlEvent) {
//		Entidade entidade = dmlEvent.getEntidade();
//		List<Field> auditableFields = provider.getAuditableFieldsFrom(entidade.getClass());
//		List<ValorDoHistorico> valorDoHistoricos = new ArrayList<ValorDoHistorico>();
//		for (Field field : auditableFields) {
//			FieldState fieldState = selectFirst(dmlEvent.getFieldStates(), having(on(FieldState.class).getName(), equalTo(field.getId())));
//			boolean existsFieldInXml = fieldState != null;
//			if (existsFieldInXml) {
//				String value = (fieldState.getCurrentState() instanceof Date) ? String.format("%1$td/%1$tm/%1$tY", fieldState.getCurrentState()) : fieldState.getCurrentState().toString();
//				ValorDoHistorico valorDoHistorico = new ValorDoHistorico(field.getLabel(), value);
//				valorDoHistoricos.add(valorDoHistorico);
//			}
//		}
//		return valorDoHistoricos;
//	}
//
//	private void clearHistoricoBufferFrom(Entidade entidade) {
//		TipoDoCadastro tipoDoCadastro = tipoDoCadastroDao.busquePeloNomeDaClasse(entidade.getClass().getSimpleName());
//		List<Historico> historicos = historicoDao.busquePeloIdDaEntidadeETipoDeCadastro(new Long(entidade.getId().toString()), tipoDoCadastro);
//		List<Historico> updates = select(historicos, having(on(Historico.class).getOperacao().getIdOperacao(), equalTo("A")));
//		if (updates.size() == MAX_BUFFER_UPDATE_ACTIONS_SIZE) {
//			updates = sort(updates, on(Historico.class).getDataDaOperacao());
//			Historico historico = updates.get(0);
//			deletionBlock.apply(historico);
//		}
//	}
}
