package br.com.bolsaValores.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bolsaValores.model.Conta;
import br.com.bolsaValores.model.Empresa;
import br.com.bolsaValores.model.Monitoramento;

@Repository
public interface MonitoramentoRepository extends JpaRepository<Monitoramento, Integer>{
	List<Monitoramento> findByContaAndEmpresa(Conta conta, Empresa empresa);
	
	List<Monitoramento> findByConta(Conta conta);
}
