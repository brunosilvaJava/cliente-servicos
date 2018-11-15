package br.com.servicos.domain.repository;

import br.com.servicos.domain.model.ClienteServico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteServicoRespository extends JpaRepository<ClienteServico, Long> {

    List<ClienteServico> findClienteServicoByCliente_Id(Long id);

}
