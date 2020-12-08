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

import javax.transaction.Transactional;


@RestController
public class DesafioController {
	
	@Autowired
	private NotaFiscalRepository notaFiscalRepository;
	@Autowired
	private ItensRepository itensRepository;

	@GetMapping("/notaFiscal")
	public List<NotaFiscal> listaNota() {
		List<NotaFiscal> nota = notaFiscalRepository.findAll();
		return nota;
	}

	@PostMapping("/notaFiscal")
	@Transactional
	public ResponseEntity<NotaFiscal> cadastrarNotas(@RequestBody NotaFiscal notas, UriComponentsBuilder uriBuilder) {
		notaFiscalRepository.save(notas);

		URI uri = uriBuilder.path("/itens/{id}").buildAndExpand(notas.getId()).toUri();
		return ResponseEntity.created(uri).body(new NotaFiscal(
				notas.getId(),notas.getFornecedor(),notas.getNumero(),notas.getData()));
	}

	/*@PostMapping("/notaFiscal")
	@Transactional
	public ResponseEntity<Itens> cadastrarItens(@RequestBody Itens itens, UriComponentsBuilder uriBuilder) {
		itensRepository.save(itens);

		URI uri = uriBuilder.path("/itens/{id}").buildAndExpand(itens.getId()).toUri();
		return ResponseEntity.created(uri).body(new Itens(
				itens.getId(), itens.getItem(), itens.getValor()
		));
	}*/

}
