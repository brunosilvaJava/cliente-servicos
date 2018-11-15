package br.com.servicos.application.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Serializable;

@Controller
@RequestMapping("/servico")
public class ServicoController implements Serializable {

    @RequestMapping(value = "/formCadastrarServico")
    public String formCadastrarCliente(){

        return "/servico/servico";

    }

}
