package br.com.servicos.domain.service;

import br.com.servicos.domain.enumeradores.EnumTipoDesconto;
import br.com.servicos.domain.exception.PagamentoJaEfetuadoException;
import br.com.servicos.domain.model.Cliente;
import br.com.servicos.domain.model.ClienteServico;
import br.com.servicos.domain.model.Servico;
import br.com.servicos.domain.model.TipoDesconto;
import br.com.servicos.domain.repository.ClienteServicoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class ClienteServicoService {

    @Autowired
    private ClienteServicoRespository clienteServicoRespository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ServicoService servicoService;

    @Autowired
    private TipoDescontoService tipoDescontoService;

    @Transactional
    public void efetuarPagamento(final ClienteServico clienteServico) throws PagamentoJaEfetuadoException {

        if(clienteServico.getPago()){
            throw new PagamentoJaEfetuadoException("Pagamento já efetuado em " + clienteServico.getDataPgto());
        }

        LocalDate dataAtual = LocalDate.now();
        LocalDate dataFim = clienteServico.getDataFim();

        if(DAYS.between(dataAtual, dataFim) >= 10){
            clienteServico.setValor(
                    adicionarDesconto(
                        clienteServico.getValor(),
                        tipoDescontoService.findByTipo(EnumTipoDesconto.PAGAMENTO_ANTECIPADO.getTipo())
                    )
            );
        }

        clienteServico.setPago(Boolean.TRUE);
        clienteServico.setDataPgto(dataAtual);

        save(clienteServico);

    }

    @Transactional
    public void adicionarDesconto(final ClienteServico clienteServico){

        Cliente cliente = clienteService.findById(clienteServico.getCliente().getId());
        Servico servico = servicoService.findById(clienteServico.getServico().getId());

        clienteServico.setValor(adicionarDesconto(servico.getValor(), cliente.getTipoDesconto()));

    }

    @Transactional
    public BigDecimal adicionarDesconto(BigDecimal valor, final TipoDesconto tipoDesconto){
        return valor.subtract(valor.multiply(tipoDesconto.getDesconto()));
    }

    @Transactional
    public void save(ClienteServico clienteServico){

        if(Objects.isNull(clienteServico.getId())){
            adicionarDesconto(clienteServico);
        }

        clienteServicoRespository.save(clienteServico);

    }

    @Transactional
    public void saveAll(List<ClienteServico> clienteServicos){

        clienteServicos.forEach(this::save);

    }

    public ClienteServico findById(Long id){
        return clienteServicoRespository.findById(id).orElse(null);
    }

    public List<ClienteServico> findClienteServicoByClienteId(Long idCliente){
        return clienteServicoRespository.findClienteServicoByCliente_Id(idCliente);
    }

}
