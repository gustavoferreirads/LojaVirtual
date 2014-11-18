package br.com.lojavirtual.api.modelo;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the chamado database table.
 */
@Entity
@Table(name = "Chamado")
public class Chamado extends Entidade implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_chamado")
    private Long id;

    @Column(name = "assunto")
    private String assunto;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "status")
    private short status;

    @OneToMany(mappedBy = "chamado")
    private List<Atendimento> atendimentos;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_cadastro")
    private Date dataCadastro;

    @Version
    @Column(name = "ultimaModificacao")
    private Timestamp ultimaModificacao;

    public Chamado() {
    }

    @PrePersist
    public void prePersist() {
        this.dataCadastro = new Timestamp(System.currentTimeMillis());
    }


    @Override
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAssunto() {
        return this.assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public short getStatus() {
        return this.status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public List<Atendimento> getAtendimentos() {
        return this.atendimentos;
    }

    public void setAtendimentos(List<Atendimento> atendimentos) {
        this.atendimentos = atendimentos;
    }

    public Atendimento addAtendimento(Atendimento atendimento) {
        getAtendimentos().add(atendimento);
        atendimento.setChamado(this);

        return atendimento;
    }

    public Atendimento removeAtendimento(Atendimento atendimento) {
        getAtendimentos().remove(atendimento);
        atendimento.setChamado(null);

        return atendimento;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    @Override
    public Timestamp getUltimaModificacao() {
        return null;
    }

}