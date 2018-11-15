package br.com.servicos.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.proxy.HibernateProxyHelper;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 30)
    @Column(name = "nome", nullable = false)
    private String nome;

    @NotNull
    @NotBlank
    @Size(max = 11)
    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    @NotNull
    @JoinColumn(name="fk_tipo_desconto", referencedColumnName = "id", nullable = false)
    @ManyToOne
    private TipoDesconto tipoDesconto;

    @OneToMany(mappedBy = "cliente")
    private List<ClienteServico> clienteServicos;

    public Cliente(){

    }

    @Override
    public boolean equals(Object object) {
        if (object == null || !HibernateProxyHelper.getClassWithoutInitializingProxy(this).equals(HibernateProxyHelper.getClassWithoutInitializingProxy(object))) return false;
        if (this == object) return true;
        return Objects.equals(this.getCpf(), ((Cliente) object).getCpf());
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setTipoDesconto(TipoDesconto tipoDesconto) {
        this.tipoDesconto = tipoDesconto;
    }

    public TipoDesconto getTipoDesconto() {
        return tipoDesconto;
    }

    public void setClienteServicos(List<ClienteServico> clienteServicos) {
        this.clienteServicos = clienteServicos;
    }

    public List<ClienteServico> getClienteServicos() {
        return clienteServicos;
    }
}
