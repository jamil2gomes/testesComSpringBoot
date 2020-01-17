package br.com.testeComSpring.service;

import java.math.BigDecimal;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import br.com.testeComSpring.model.Frete;
import br.com.testeComSpring.repository.FreteRepository;
import br.com.testeComSpring.service.exception.FreteException;

@Service
public class FreteService {
	
	@Autowired
	private FreteRepository freteRepository;
	
	public void inserir(Frete frete) throws FreteException {
		
		try {
			
			freteRepository.save(frete);
			
		} catch (ConstraintViolationException |InvalidDataAccessApiUsageException e) {
			throw new FreteException(e);
		}
	}
	
	public BigDecimal buscaValorDo(Frete frete) {
		return freteRepository.buscaValor(frete.getId());
	}
	
	public BigDecimal buscaMaiorValorDeFrete() {
		return freteRepository.buscaMaiorValorDoFrete();
	}
	
	
		
}
