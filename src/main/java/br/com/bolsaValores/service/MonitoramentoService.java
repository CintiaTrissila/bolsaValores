package br.com.bolsaValores.service;

import java.util.List;

import br.com.bolsaValores.model.Monitoramento;

public interface MonitoramentoService {
	
	Monitoramento save(Integer id, Monitoramento monitoramento);

	void deleteById(Integer id);

	List<Monitoramento> list();

	Monitoramento listById(Integer id);

}
