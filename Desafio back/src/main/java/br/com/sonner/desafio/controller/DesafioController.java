package br.com.sonner.desafio.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.sonner.desafio.modelo.Descricao;
import br.com.sonner.desafio.repository.DesafioRepository;

@RestController
@RequestMapping("/descricao")
public class DesafioController {
	
	@Autowired
	private DesafioRepository desafioRepository;
	
	@GetMapping
	public List<Descricao> lista() {
		List<Descricao> descricao = desafioRepository.findAll();
		return descricao;
	}
	
	@PostMapping
	public ResponseEntity<Descricao> cadastrar(@RequestBody Descricao descricao, UriComponentsBuilder uriBuilder) {
		desafioRepository.save(descricao);
		
		URI uri = uriBuilder.path("/descricao/{id}").buildAndExpand(descricao.getId()).toUri();
		return ResponseEntity.created(uri).body(new Descricao(descricao.getId(),descricao.getDescricao()));
	}

}
