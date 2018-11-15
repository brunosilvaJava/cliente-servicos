package br.com.servicos.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "tipos_desconto")
public class TipoDesconto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @NotBlank
    @Size(max = 30)
    @Column(name = "nome", nullable = false)
    private String nome;

    @NotNull
    @Column(name = "tipo", nullable = false, unique = true)
    private Integer tipo;

    @NotNull
    @Column(name = "desconto", nullable = false)
    private BigDecimal desconto;

    public TipoDesconto(){

    }

    public TipoDesconto(Integer tipo){
        this.tipo = tipo;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }
}
