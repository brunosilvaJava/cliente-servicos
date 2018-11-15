package br.com.servicos.domain.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ServicosClienteDTO implements Serializable {

    private Long idServico;
    private String servico;
    private Boolean pago;
    private BigDecimal valor;
    private LocalDate dataPagamento;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private long diasRestantes;

    public ServicosClienteDTO (Long idServico, String servico, LocalDate dataInicio, LocalDate dataFim, Boolean pago, LocalDate dataPagamento, BigDecimal valor, long diasRestantes){
        this.idServico = idServico;
        this.servico = servico;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.pago = pago;
        this.dataPagamento = dataPagamento;
        this.valor = valor;
        this.diasRestantes = diasRestantes;
    }

    public Long getIdServico() {
        return idServico;
    }

    public void setIdServico(Long idServico) {
        this.idServico = idServico;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Boolean getPago() {
        return pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setDiasRestantes(long diasRestantes) {
        this.diasRestantes = diasRestantes;
    }

    public long getDiasRestantes() {
        return diasRestantes;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }
}
