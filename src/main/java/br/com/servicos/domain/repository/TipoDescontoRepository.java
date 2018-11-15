package br.com.servicos.domain.repository;

import br.com.servicos.domain.model.TipoDesconto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoDescontoRepository extends JpaRepository<TipoDesconto, Long> {

    TipoDesconto findByTipo(Integer tipo);

}
