package br.com.servicos.domain.service;

import br.com.servicos.domain.model.Servico;
import br.com.servicos.domain.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public void save(Servico servico){
        servicoRepository.save(servico);
    }

    public Servico findById(Long id){
        return servicoRepository.findById(id).orElse(null);
    }

    public List<Servico> findAll(){
        return servicoRepository.findAll();
    }

}
