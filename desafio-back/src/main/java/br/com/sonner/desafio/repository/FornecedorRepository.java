package br.com.sonner.desafio.repository;

import br.com.sonner.desafio.modelo.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

}
