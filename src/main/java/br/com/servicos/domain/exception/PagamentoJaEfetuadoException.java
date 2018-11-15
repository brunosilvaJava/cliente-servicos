package br.com.servicos.domain.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PagamentoJaEfetuadoException extends RuntimeException {

    public PagamentoJaEfetuadoException() {

    }

    public PagamentoJaEfetuadoException(String message) {
        super(message);
    }

}
