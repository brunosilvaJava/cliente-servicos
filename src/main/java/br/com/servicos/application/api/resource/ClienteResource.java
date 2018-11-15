package br.com.servicos.application.api.resource;

import br.com.servicos.domain.dto.ServicosClienteDTO;
import br.com.servicos.domain.exception.PagamentoJaEfetuadoException;
import br.com.servicos.domain.model.Cliente;
import br.com.servicos.domain.model.ClienteServico;
import br.com.servicos.domain.model.Servico;
import br.com.servicos.domain.model.TipoDesconto;
import br.com.servicos.domain.service.ClienteService;
import br.com.servicos.domain.service.ClienteServicoService;
import br.com.servicos.domain.service.ServicoService;
import br.com.servicos.domain.service.TipoDescontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteServicoService clienteServicoService;

    @Autowired
    private TipoDescontoService tipoDescontoService;

    @GetMapping
    public ResponseEntity<Servico> findAll(){
        return new ResponseEntity(clienteService.findAll(), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody @Valid final Cliente cliente) {

        cliente.setTipoDesconto(tipoDescontoService.findByTipo(cliente.getTipoDesconto().getTipo()));

        clienteService.save(cliente);

        final URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PostMapping(value = "/{id}/servicos", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> postServicos(@PathVariable final Long id, @RequestBody @Valid final List<ClienteServico> clienteServicos){

        clienteServicoService.saveAll(clienteServicos);

        final URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}/servicos").buildAndExpand(id).toUri();
        return ResponseEntity.created(location).build();

    }

    @GetMapping(value = "/{id}/servicos")
    public ResponseEntity<List<ServicosClienteDTO>> getServicos(@PathVariable Long id){
        return new ResponseEntity(clienteService.getServicos(id), HttpStatus.OK);
    }

    @PostMapping(value = "/{id}/servicos/{idClienteServico}/pagamentos")
    public ResponseEntity<Void> postServicos(@PathVariable final Long id, @PathVariable final Long idClienteServico) {

        Cliente cliente = clienteService.findById(id);
        ClienteServico clienteServico = clienteServicoService.findById(idClienteServico);

        if(!cliente.equals(clienteServico.getCliente())){
            return ResponseEntity.badRequest().build();
        }

        clienteServicoService.efetuarPagamento(clienteServico);

        final URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}/servicos").buildAndExpand(id).toUri();
        return ResponseEntity.created(location).build();

    }

}
