package br.com.bolsaValores.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.bolsaValores.model.Conta;
import br.com.bolsaValores.service.impl.ContaServiceImpl;
import br.com.bolsaValores.service.impl.EmpresaServiceImpl;
import br.com.bolsaValores.service.impl.TransacaoServiceImpl;

@Component
public class BolsaThread extends Thread{
	
	@Autowired
	private TransacaoServiceImpl transacaoServiceImpl;
	@Autowired
	private EmpresaServiceImpl empresaServiceImpl;
	@Autowired 
	private ContaServiceImpl contaServiceImpl;
	
	public void run() {
		long startTime = System.currentTimeMillis();
        int i = 0;
        while (true) {
        	empresaServiceImpl.SimuladorConexaoPreco();
        	List<Conta> listConta = contaServiceImpl.list();
        	System.out.println("carregou contas");
        	for (Conta conta : listConta) {
        		transacaoServiceImpl.compraVendaAcoes(conta.getId());
			}        	
        	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
	}

}
