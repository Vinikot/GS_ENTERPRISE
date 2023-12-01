package br.com.fiap.gs.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_RESTRICAO_ALIMENTAR")
public class RestricaoAlimentar {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_RESTRICAO_ALIMENTAR")
    @SequenceGenerator(name = "SQ_RESTRICAO_ALIMENTAR", sequenceName = "SQ_RESTRICAO_ALIMENTAR", allocationSize = 1)
    @Column(name = "ID_RESTRICAO_ALIMENTAR")
    private Long id;

    @Column(name = "NOME_RESTRICAO_ALIMENTAR")
    private String nome;

    @Column(name = "DESCRICAO_RESTRICAO_ALIMENTAR")
    private String descricao;

    public RestricaoAlimentar() {
    }

    public RestricaoAlimentar(Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public RestricaoAlimentar setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public RestricaoAlimentar setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public RestricaoAlimentar setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    @Override
    public String toString() {
        return "RestricaoAlimentar{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
