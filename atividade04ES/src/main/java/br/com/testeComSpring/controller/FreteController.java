package br.com.testeComSpring.controller;

import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.testeComSpring.model.Frete;
import br.com.testeComSpring.service.api.FreteService;



@RestController
@RequestMapping("/")
public class FreteController {

	@Autowired
	private FreteService freteService;
	

	@GetMapping("fretes")
	public ResponseEntity<List<Frete>> fretes(){
		List<Frete> fretes = freteService.buscarFretes();
		return ResponseEntity.ok(fretes);
	}
	
	@GetMapping("frete/{id}")
	public ResponseEntity<Frete> contato(@PathVariable Long id){
		return ResponseEntity.ok().body(freteService.buscarFrete(id)); 
	}
	
	@PostMapping("fretes")
	public ResponseEntity<Frete> inserir(@Valid @RequestBody Frete frete) throws URISyntaxException {
		frete = freteService.inserirOuAlterar(frete);
		return new ResponseEntity<>(frete, HttpStatus.CREATED);
	}
	
	@PutMapping("/fretes/{id}")
	public ResponseEntity<Frete> alterar(@PathVariable Long id, @RequestBody @Valid Frete frete) throws URISyntaxException {
		frete = freteService.inserirOuAlterar(frete);
		return new ResponseEntity<>(frete, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/fretes/{id}")
	public ResponseEntity<Frete> remover(@PathVariable Long id) {
		freteService.remover(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
	
}
