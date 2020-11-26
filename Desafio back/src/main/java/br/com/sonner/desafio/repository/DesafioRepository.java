package br.com.sonner.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sonner.desafio.modelo.Descricao;

public interface DesafioRepository extends JpaRepository<Descricao, Long> {

}
