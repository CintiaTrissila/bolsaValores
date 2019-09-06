package br.com.bolsaValores.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bolsaValores.model.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer>{
	Empresa findByNome(String nome);
}
