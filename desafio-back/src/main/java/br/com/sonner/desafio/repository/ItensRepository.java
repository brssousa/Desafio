package br.com.sonner.desafio.repository;

import br.com.sonner.desafio.modelo.Itens;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensRepository extends JpaRepository<Itens, Long> {

}
