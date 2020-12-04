package br.com.sonner.desafio.controller;

import java.net.URI;
import java.util.List;

import br.com.sonner.desafio.modelo.NotaFiscal;
import br.com.sonner.desafio.repository.NotaFiscalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.sonner.desafio.modelo.ItensNota;
import br.com.sonner.desafio.repository.ItensNotaRepository;

@RestController
public class DesafioController {
	
	@Autowired
	private ItensNotaRepository itensNotaRepository;
	@Autowired
	private NotaFiscalRepository notaFiscalRepository;
	
	@GetMapping("/itens")
	public List<ItensNota> lista() {
		List<ItensNota> itens = itensNotaRepository.findAll();
		return itens;
	}
	
	@PostMapping("/itens")
	public ResponseEntity<ItensNota> cadastrar(@RequestBody ItensNota itens, UriComponentsBuilder uriBuilder) {
		itensNotaRepository.save(itens);
		
		URI uri = uriBuilder.path("/itens/{id}").buildAndExpand(itens.getId()).toUri();
		return ResponseEntity.created(uri).body(new ItensNota(itens.getId(),itens.getItem(),itens.getValor()));
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
