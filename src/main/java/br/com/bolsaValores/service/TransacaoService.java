package br.com.bolsaValores.service;

import java.util.List;

import br.com.bolsaValores.model.Monitoramento;
import br.com.bolsaValores.model.Transacao;

public interface TransacaoService {
	
	Transacao save(Transacao transacao);

	Transacao compra(Monitoramento monitoramento);

	Transacao venda(Monitoramento monitoramento);
	
	void compraVendaAcoes(Integer id);
	
	String historicoTransacoes(Integer id);
	
	void deleteById(Integer id);
	
	List<Transacao> listTransacoes();
	
}
