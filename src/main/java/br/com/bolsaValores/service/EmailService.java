package br.com.bolsaValores.service;

import org.springframework.mail.SimpleMailMessage;

import br.com.bolsaValores.model.Empresa;
import br.com.bolsaValores.model.Monitoramento;
import br.com.bolsaValores.model.Transacao;

public interface EmailService {
	
	SimpleMailMessage constructReportMail(Transacao transacao, Monitoramento monitoramento, Empresa empresa);

	SimpleMailMessage constructMail(String assunto, String corpo, Transacao transacao);

}
