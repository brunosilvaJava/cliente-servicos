package br.com.servicos.domain.repository;

import br.com.servicos.domain.model.Cliente;
import br.com.servicos.domain.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServicoRepository extends JpaRepository<Servico, Long> {

}
