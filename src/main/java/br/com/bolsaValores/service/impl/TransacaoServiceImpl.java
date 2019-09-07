package br.com.bolsaValores.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bolsaValores.model.Conta;
import br.com.bolsaValores.model.Empresa;
import br.com.bolsaValores.model.Monitoramento;
import br.com.bolsaValores.model.Transacao;
import br.com.bolsaValores.model.enums.TipoTransacao;
import br.com.bolsaValores.repository.TransacaoRepository;
import br.com.bolsaValores.service.TransacaoService;

@Service
public class TransacaoServiceImpl implements TransacaoService{

	@Autowired
	private TransacaoRepository transacaoRepository;
	@Autowired
	private ContaServiceImpl contaServiceImpl;
	@Autowired
	private MonitoramentoServiceImpl monitoramentoServiceImpl;
	@Autowired
	private EmailServiceImpl emailServiceImpl;
	
	@Override
	public Transacao save(Transacao transacao) {
		//negociacao.setConta(contaServiceImpl.listaContaPeloId(id));
		return transacaoRepository.save(transacao);
	}

	@Override
	public Transacao compra(Monitoramento monitoramento) {
		Empresa empresa = monitoramento.getEmpresa();
		Conta conta = monitoramento.getConta();
		Double acoes = conta.getSaldo() / empresa.getValorAcao();

		Transacao transacao = new Transacao();
		transacao.setTipoTransacao(TipoTransacao.COMPRA);
		transacao.setData(LocalDateTime.now());
		transacao.setEmpresa(monitoramento.getEmpresa());
		transacao.setConta(conta);
		transacao.setQuantidadeAcoes(acoes);
		transacao.setValor(empresa.getValorAcao());
		conta.setSaldo(0.0);
		conta.setNumeroAcoes(acoes);
		Transacao tra = save(transacao);
		contaServiceImpl.save(conta);

		emailServiceImpl.sendEmail(tra, monitoramento, empresa);
		return tra;
	}

	@Override
	public Transacao venda(Monitoramento monitoramento) {
		Empresa empresa = monitoramento.getEmpresa();
		Conta conta = monitoramento.getConta();

		Transacao transacao = new Transacao();
		transacao.setValor(empresa.getValorAcao());
		transacao.setTipoTransacao(TipoTransacao.VENDA);
		transacao.setData(LocalDateTime.now());
		transacao.setEmpresa(monitoramento.getEmpresa());
		transacao.setConta(conta);
		transacao.setQuantidadeAcoes(conta.getNumeroAcoes());
		conta.setSaldo(conta.getNumeroAcoes() * empresa.getValorAcao());
		conta.setNumeroAcoes(0.0);
		Transacao tra = save(transacao);
		contaServiceImpl.save(conta);

		emailServiceImpl.sendEmail(tra, monitoramento, empresa);
		return tra;
	}

	@Override
	public void compraVendaAcoes(Integer id) {
		Conta conta = contaServiceImpl.listById(id);
		System.out.println("carregou conta ");
		List<Monitoramento> monitoramentos = monitoramentoServiceImpl.monitoramentosByConta(conta);
		System.out.println("carregou monitoramentos");
		for (Monitoramento monitoramento : monitoramentos) {
			Empresa empresa = monitoramento.getEmpresa();
			if (monitoramento.getConta().getSaldo() > 0) {
				if (monitoramento.getPrecoCompra() >= empresa.getValorAcao()) {
					System.out.println("Vai comprar");
					compra(monitoramento);
					System.out.println("Comprou");
				}
			} else if (monitoramento.getConta().getNumeroAcoes() > 0) {
				if (empresa.getValorAcao() >= monitoramento.getPrecoVenda()) {
					System.out.println("Vai vender");
					venda(monitoramento);
					System.out.println("Vendeu");
				}
			}
		}
	}

	@Override
	public String historicoTransacoes(Integer id) {
		Conta conta = contaServiceImpl.listById(id);
		List<Transacao> transacoes = conta.getTransacoes();
		String retorno = "";
		for (Transacao transacao : transacoes) {
			retorno += "------------------------------------------------------------";
			retorno += "-------------------------------------------------";
			retorno += "-----------------------------------";
			retorno += "Identificador: " + transacao.getId();
			retorno += "Tipo : " + transacao.getTipoTransacao();
			retorno += "Empresa: " + transacao.getEmpresa();
			retorno += "Valor: " + transacao.getValor();
			retorno += "Quantidade de ações: " + transacao.getQuantidadeAcoes();
			retorno += "Data: " + transacao.getData();
			retorno += "------------------------------------------------------------";
			retorno += "-------------------------------------------------";
			retorno += "------------------------------------------";
			retorno += "-----------------------------------";
		}
		retorno += "------------------------------------------------------------";
		retorno += "---                                                      ---";
		retorno += "---                                                      ---";
		retorno += "---    Saldo Final: " + conta.getSaldo() + "             ---";
		retorno += "---    Número de ações: " + conta.getNumeroAcoes() + "   ---";
		retorno += "---                                                      ---";
		retorno += "---                                                      ---";
		retorno += "------------------------------------------------------------";
		retorno += "------------------------------------------------------------";
		retorno += "------------------------------------------------------------";
		return retorno;
	}

	@Override
	public void deleteById(Integer id) {
		transacaoRepository.deleteById(id);
	}

	@Override
	public List<Transacao> listTransacoes() {
		return transacaoRepository.findAll();
		//return transacaoRepository.findByConta(contaServiceImpl.listById(id));
	}

}
