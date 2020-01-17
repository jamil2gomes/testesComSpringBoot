package br.com.testeComSpring.service.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.testeComSpring.model.Frete;
import br.com.testeComSpring.repository.FreteRepository;

@Service
public class FreteService {

	@Autowired
	private FreteRepository freteRepository;

	public Frete inserirOuAlterar(Frete frete) {
		return freteRepository.save(frete);
	}

	public List<Frete> buscarFretes() {
		return freteRepository.findAll();
	}

	public Frete buscarFrete(Long id) {
		return freteRepository.findById(id).orElse(null);
	}

	public void remover(Long id) {
		freteRepository.deleteById(id);
	}

}
