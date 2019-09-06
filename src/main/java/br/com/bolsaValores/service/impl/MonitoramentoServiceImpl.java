package br.com.bolsaValores.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bolsaValores.model.Conta;
import br.com.bolsaValores.model.Empresa;
import br.com.bolsaValores.model.Monitoramento;
import br.com.bolsaValores.repository.MonitoramentoRepository;
import br.com.bolsaValores.service.MonitoramentoService;

@Service
public class MonitoramentoServiceImpl implements MonitoramentoService {

	@Autowired
	private MonitoramentoRepository monitoramentoRepository;
	@Autowired
	private ContaServiceImpl contaServiceImpl;

	@Override
	public Monitoramento save(Integer id, Monitoramento monitoramento) {
		Conta conta = contaServiceImpl.listById(id);
		monitoramento.setConta(conta);
		List<Monitoramento> monitoramentosDaConta = monitoramentosByContaAndEmpresa(conta, monitoramento.getEmpresa());
		if (monitoramentosDaConta.isEmpty()) {
			return monitoramentoRepository.save(monitoramento);
		} else {
			return null;
		}
	}

	@Override
	public void deleteById(Integer id) {
		monitoramentoRepository.deleteById(id);

	}

	@Override
	public List<Monitoramento> list() {
		return monitoramentoRepository.findAll();
	}

	@Override
	public Monitoramento listById(Integer id) {
		return monitoramentoRepository.getOne(id);
	}

	public List<Monitoramento> monitoramentosByContaAndEmpresa(Conta conta, Empresa emp) {
		return monitoramentoRepository.findByContaAndEmpresa(conta, emp);
	}
	
	public List<Monitoramento> monitoramentosByConta(Conta conta){
		return monitoramentoRepository.findByConta(conta);
	}

}
