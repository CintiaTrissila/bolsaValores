package br.com.bolsaValores.service.impl;

import java.util.Random;

import org.springframework.stereotype.Service;

import br.com.bolsaValores.service.RandomService;

@Service
public class RandomNumberServiceImpl implements RandomService{

	@Override
	public Double randomValorAcao() {
		Random random = new Random();
		return 10 + (1 * random.nextDouble());
	}

}
