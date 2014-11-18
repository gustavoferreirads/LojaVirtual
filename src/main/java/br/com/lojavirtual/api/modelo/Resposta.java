package br.com.lojavirtual.api.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the resposta database table.
 */
@Entity
@NamedQuery(name = "Resposta.findAll", query = "SELECT r FROM Resposta r")
public class Resposta implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resposta")
    private int idResposta;

    @Lob
    private String resposta;

    //bi-directional many-to-one association to Comentario
    @ManyToOne
    @JoinColumn(name = "id_comentario")
    private Comentario comentario;

    //bi-directional many-to-one association to Resposta
    @ManyToOne
    @JoinColumn(name = "id_sub_resposta")
    private Resposta respostaBean;

    //bi-directional many-to-one association to Resposta
    @OneToMany(mappedBy = "respostaBean")
    private List<Resposta> respostas;

    public Resposta() {
    }

    public int getIdResposta() {
        return this.idResposta;
    }

    public void setIdResposta(int idResposta) {
        this.idResposta = idResposta;
    }

    public String getResposta() {
        return this.resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public Comentario getComentario() {
        return this.comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

    public Resposta getRespostaBean() {
        return this.respostaBean;
    }

    public void setRespostaBean(Resposta respostaBean) {
        this.respostaBean = respostaBean;
    }

    public List<Resposta> getRespostas() {
        return this.respostas;
    }

    public void setRespostas(List<Resposta> respostas) {
        this.respostas = respostas;
    }

    public Resposta addResposta(Resposta resposta) {
        getRespostas().add(resposta);
        resposta.setRespostaBean(this);

        return resposta;
    }

    public Resposta removeResposta(Resposta resposta) {
        getRespostas().remove(resposta);
        resposta.setRespostaBean(null);

        return resposta;
    }

}