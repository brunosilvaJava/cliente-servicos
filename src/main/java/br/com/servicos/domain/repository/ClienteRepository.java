package br.com.servicos.domain.repository;

import br.com.servicos.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    

}
