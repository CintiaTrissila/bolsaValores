package br.com.bolsaValores.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.bolsaValores.manager.BolsaThread;
import br.com.bolsaValores.model.Conta;
import br.com.bolsaValores.service.impl.EmpresaServiceImpl;
import br.com.bolsaValores.service.impl.TransacaoServiceImpl;

@Controller
public class IndexController {
	
	@Autowired
	private TransacaoServiceImpl transacaoServiceImpl;
	@Autowired
	private EmpresaServiceImpl empresaServiceImpl;
	
	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {
 
        String message = "Hello Spring Boot + JSP";
 
        model.addAttribute("message", message);
 
        return "index";
    }
	
    @GetMapping("/start")
	public String start() {
		BolsaThread t = new BolsaThread();
        t.start();
        return "index";
	}

}
