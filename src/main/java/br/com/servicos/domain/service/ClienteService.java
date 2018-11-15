package br.com.servicos.domain.service;

import br.com.servicos.domain.dto.ServicosClienteDTO;
import br.com.servicos.domain.model.Cliente;
import br.com.servicos.domain.model.ClienteServico;
import br.com.servicos.domain.model.Servico;
import br.com.servicos.domain.repository.ClienteRepository;
import br.com.servicos.domain.repository.ClienteServicoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteServicoService clienteServicoService;

    public Cliente findById(Long id){
        return clienteRepository.findById(id).orElse(null);
    }

    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    public void save(Cliente cliente){
        clienteRepository.save(cliente);
    }

    public List<ServicosClienteDTO> getServicos(Long id) {

        List<ServicosClienteDTO> servicos = new ArrayList<>();

        List<ClienteServico> clienteServicos = clienteServicoService.findClienteServicoByClienteId(id);

        clienteServicos.forEach(cs -> servicos.add(
                new ServicosClienteDTO(
                        cs.getId(),
                        cs.getServico().getNome(),
                        cs.getDataInicio(),
                        cs.getDataFim(),
                        cs.getPago(),
                        cs.getDataPgto(),
                        cs.getValor(),
                        DAYS.between(LocalDate.now(), cs.getDataFim()))
        ));

        return servicos;

    }
}
