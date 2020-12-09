package br.com.sonner.desafio.repository;

import br.com.sonner.desafio.modelo.NotaFiscal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface NotaFiscalRepository extends JpaRepository<NotaFiscal, Long> {

}
