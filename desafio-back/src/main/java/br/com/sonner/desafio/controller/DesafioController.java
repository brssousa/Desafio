package br.com.sonner.desafio.controller;

import java.net.URI;
import java.util.List;

import br.com.sonner.desafio.modelo.Fornecedor;
import br.com.sonner.desafio.modelo.Itens;
import br.com.sonner.desafio.modelo.NotaFiscal;
import br.com.sonner.desafio.repository.FornecedorRepository;
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
	private FornecedorRepository fornecedorRepository;

	@GetMapping("/notaFiscal")
	public List<NotaFiscal> listaNota() {
		List<NotaFiscal> notas = notaFiscalRepository.findAll();
		return notas;
	}

	@PostMapping("/notaFiscal")
	@Transactional
	public ResponseEntity<NotaFiscal> cadastrarNotas(@RequestBody NotaFiscal notas, UriComponentsBuilder uriBuilder) {
		notaFiscalRepository.save(notas);

		URI uri = uriBuilder.path("/itens/{id}").buildAndExpand(notas.getId()).toUri();
		return ResponseEntity.created(uri).body(new NotaFiscal(
				notas.getId(),
				notas.getFornecedor(),
				notas.getNumero(),
				notas.getData(),
				notas.getEstado(),
				notas.getCidades()));
	}

	@GetMapping("/fornecedor")
	public List<Fornecedor> listaFornecedor() {
		List<Fornecedor> forn = fornecedorRepository.findAll();
		return forn;
	}

	@PostMapping("/fornecedor")
	@Transactional
	public ResponseEntity<Fornecedor> cadastrarFornecedor(@RequestBody Fornecedor fornecedor, UriComponentsBuilder uriBuilder) {
		fornecedorRepository.save(fornecedor);

		URI uri = uriBuilder.path("/itens/{id}").buildAndExpand(fornecedor.getId()).toUri();
		return ResponseEntity.created(uri).body(new Fornecedor(
				fornecedor.getId(), fornecedor.getFornecedor()
		));
	}

}
