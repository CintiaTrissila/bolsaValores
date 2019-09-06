package br.com.bolsaValores.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bolsaValores.model.Conta;
import br.com.bolsaValores.model.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Integer>{
	List<Transacao> findByConta(Conta conta);
}
