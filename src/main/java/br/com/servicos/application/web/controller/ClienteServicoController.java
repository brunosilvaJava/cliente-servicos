package br.com.servicos.application.web.controller;

import br.com.servicos.domain.service.ClienteService;
import br.com.servicos.domain.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Serializable;

@Controller
@RequestMapping("/clienteServico")
public class ClienteServicoController implements Serializable {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ServicoService servicoService;

    @RequestMapping(value = "/formClienteServico")
    public String formCadastrarCliente(Model model){

        model.addAttribute("clientes", clienteService.findAll());
        model.addAttribute("servicos", servicoService.findAll());

        return "/cliente-servico/cliente-servico";

    }

}
