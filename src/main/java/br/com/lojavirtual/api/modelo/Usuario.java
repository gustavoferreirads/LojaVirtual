package br.com.lojavirtual.api.modelo;

import br.com.lojavirtual.util.Strings;
import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 */
@Entity
public class Usuario extends Entidade implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    @Expose
    private Long id;

    @Expose
    private String login;

    @Expose
    private String nome;

    @Expose
    private String senha;

    @Getter
    @Setter
    private String confirmSenha;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Categoria> categorias;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Chamado> chamados;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Permissao> permissaos;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Produto> produtos;

    @Getter
    private Timestamp ultimaModificacao = new Timestamp(System.currentTimeMillis());

    @Temporal(TemporalType.DATE)
    @Column(name = "data_cadastro")
    private Date dataCadastro = new Date();

    public Usuario() {
    }


    public Date getDataCadastro() {
        return this.dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
            this.senha = Strings.hashMD5(senha);
    }

    public Timestamp getUltimaModificacao() {
        return this.ultimaModificacao;
    }

    public void setUltimaModificacao(Timestamp ultimaModificacao) {
        this.ultimaModificacao = ultimaModificacao;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConfirmSenha() {
        return confirmSenha;
    }

    public void setConfirmSenha(String confirmSenha) {
        this.confirmSenha = Strings.hashMD5(confirmSenha);
    }
}