package br.com.servicos.domain.enumeradores;

import java.util.stream.Stream;

public enum EnumTipoDesconto {

    OURO(1),
    PRATA(2),
    PAGAMENTO_ANTECIPADO(3);

    private Integer tipo;

    EnumTipoDesconto(Integer tipo){
        this.tipo = tipo;
    }

    public static EnumTipoDesconto getTipo(Integer tipo){

        return Stream.of(EnumTipoDesconto.values())
                .filter(e -> tipo.equals(e.getTipo()))
                .findAny()
                .orElseThrow(() -> new EnumConstantNotPresentException(EnumTipoDesconto.class, String.valueOf(tipo)));

    }

    public Integer getTipo() {
        return tipo;
    }

}
