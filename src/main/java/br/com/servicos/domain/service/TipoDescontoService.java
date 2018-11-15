package br.com.servicos.domain.service;

import br.com.servicos.domain.model.TipoDesconto;
import br.com.servicos.domain.repository.TipoDescontoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoDescontoService {

    @Autowired
    private TipoDescontoRepository tipoDescontoRepository;

    public List<TipoDesconto> findAll(){
        return tipoDescontoRepository.findAll();
    }

    public TipoDesconto findByTipo(Integer tipo){
        return tipoDescontoRepository.findByTipo(tipo);
    }

}