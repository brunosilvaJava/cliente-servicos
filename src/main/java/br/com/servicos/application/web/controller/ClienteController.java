package br.com.servicos.application.web.controller;

import br.com.servicos.domain.service.ClienteService;
import br.com.servicos.domain.service.TipoDescontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Serializable;

@Controller
@RequestMapping("/cliente")
public class ClienteController implements Serializable {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private TipoDescontoService tipoDescontoService;

    @RequestMapping(value = "/formCadastrarCliente")
    public String formCadastrarCliente(Model model){

        model.addAttribute("tiposDesconto", tipoDescontoService.findAll());
        model.addAttribute("clientes", clienteService.findAll());

        return "/cliente/cliente";

    }

}
