package br.com.bolsaValores.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.bolsaValores.model.Transacao;
import br.com.bolsaValores.service.impl.TransacaoServiceImpl;

@Controller
@RequestMapping("/transacao")
public class TransacaoController {
	
	@Autowired
	private TransacaoServiceImpl transacaoServiceImpl;
	
	@GetMapping("/list")
	public String listaTransacoes(Model model) {
		List<Transacao> transacoes = transacaoServiceImpl.listTransacoes();
		model.addAttribute("transacoes", transacoes);
		
		return "transacoes";
	}

}
