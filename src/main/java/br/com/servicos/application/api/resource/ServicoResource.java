package br.com.servicos.application.api.resource;

import br.com.servicos.domain.model.Servico;
import br.com.servicos.domain.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/servicos")
public class ServicoResource {

    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public ResponseEntity<Servico> findAll(){
        return new ResponseEntity(servicoService.findAll(), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody @Valid Servico servico) {

        servicoService.save(servico);

        final URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(servico.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

}
