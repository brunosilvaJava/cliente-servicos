package br.com.servicos.domain.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "clientes_servicos")
public class ClienteServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @NotNull
    @JoinColumn(name="fk_servico", referencedColumnName = "id", nullable = false)
    @ManyToOne
    private Servico servico;

    @JsonIgnore
    @NotNull
    @JoinColumn(name="fk_cliente", referencedColumnName = "id", nullable = false)
    @ManyToOne
    private Cliente cliente;

    @NotNull
    @Column(name = "data_inicio", nullable = false)
    private LocalDate dataInicio;

    @NotNull
    @Column(name = "data_fim", nullable = false)
    private LocalDate dataFim;

    @NotNull
    @NumberFormat(style = NumberFormat.Style.NUMBER, pattern = "#,##0.00")
    @Column(name = "valor", precision = 19, scale = 2)
    private BigDecimal valor;

    @Column(name = "data_pgto")
    private LocalDate dataPgto;

    @NumberFormat(style = NumberFormat.Style.NUMBER, pattern = "#,##0.00")
    @Column(name = "valor_pago", precision = 19, scale = 2)
    private BigDecimal valorPago;

    @Column(name = "is_pago", nullable = false)
    private Boolean pago;

    public ClienteServico(){

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Servico getServico() {
        return servico;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setDataPgto(LocalDate dataPgto) {
        this.dataPgto = dataPgto;
    }

    public LocalDate getDataPgto() {
        return dataPgto;
    }

    public void setValorPago(BigDecimal valorPago) {
        this.valorPago = valorPago;
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
    }

    public Boolean getPago() {
        return pago;
    }
}
