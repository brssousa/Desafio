package br.com.sonner.desafio.controller;

import java.net.URI;
import java.util.List;

import br.com.sonner.desafio.modelo.Itens;
import br.com.sonner.desafio.modelo.NotaFiscal;
import br.com.sonner.desafio.repository.ItensRepository;
import br.com.sonner.desafio.repository.NotaFiscalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;



@RestController
public class DesafioController {
	
	@Autowired
	private ItensRepository itensRepository;
	@Autowired
	private NotaFiscalRepository notaFiscalRepository;
	
	@GetMapping("/itens")
	public List<Itens> lista() {
		List<Itens> itens = itensRepository.findAll();
		return itens;
	}
	
	@PostMapping("/itens")
	public ResponseEntity<Itens> cadastrar(@RequestBody Itens itens, UriComponentsBuilder uriBuilder) {
		itensRepository.save(itens);
		
		URI uri = uriBuilder.path("/itens/{id}").buildAndExpand(itens.getId()).toUri();
		return ResponseEntity.created(uri).body(new Itens(itens.getId(),itens.getItem(),itens.getValor()));
	}

	@GetMapping("/notaFiscal")
	public List<NotaFiscal> listaNota() {
		List<NotaFiscal> nota = notaFiscalRepository.findAll();
		return nota;
	}

	@PostMapping("/notaFiscal")
	public ResponseEntity<NotaFiscal> cadastrarNotas(@RequestBody NotaFiscal notas, UriComponentsBuilder uriBuilder) {
		notaFiscalRepository.save(notas);

		URI uri = uriBuilder.path("/itens/{id}").buildAndExpand(notas.getId()).toUri();
		return ResponseEntity.created(uri).body(new NotaFiscal());
	}

}
