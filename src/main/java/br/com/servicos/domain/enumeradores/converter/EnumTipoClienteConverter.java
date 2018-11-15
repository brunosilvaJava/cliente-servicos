package br.com.servicos.domain.enumeradores.converter;

import br.com.servicos.domain.enumeradores.EnumTipoDesconto;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public final class EnumTipoClienteConverter implements AttributeConverter<EnumTipoDesconto, Integer> {

    @Override
    public Integer convertToDatabaseColumn(EnumTipoDesconto enumTipoDesconto) {
        return enumTipoDesconto.getTipo();
    }

    @Override
    public EnumTipoDesconto convertToEntityAttribute(final Integer tipo) {

        return Stream.of(EnumTipoDesconto.values())
                .filter(e -> tipo.equals(e.getTipo()))
                .findAny()
                .orElseThrow(() -> new EnumConstantNotPresentException(EnumTipoDesconto.class, String.valueOf(tipo)));

    }

}
