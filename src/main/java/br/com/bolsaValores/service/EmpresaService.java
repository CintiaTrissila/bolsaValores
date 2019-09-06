package br.com.bolsaValores.service;

import java.util.List;

import br.com.bolsaValores.model.Empresa;

public interface EmpresaService {
	
	Empresa save(Empresa empresa);

	Empresa update(Integer id, Empresa empresa);

	void deleteById(Integer id);
	
	Empresa listById(Integer id);

	List<Empresa> list();

	Empresa listByNome(String nome);

}
