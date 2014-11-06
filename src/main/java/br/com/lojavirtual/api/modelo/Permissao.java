package br.com.lojavirtual.api.modelo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the permissao database table.
 */
@Entity
@Table(name = "Permissao")
public class Permissao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "id_operacao")
    private Operacao operacao;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name="id_grupo")
    private Grupo grupo;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "id_funcionalidade")
    private Funcionalidade funcionalidade;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "id_tipo_de_cadastro")
    private TipoDeCadastro tipoDeCadastro;

    public Permissao() {
    }



    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}