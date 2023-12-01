package br.com.fiap.gs.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_OBJETIVO_SAUDE")
public class ObjetivoSaude {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_OBJETIVO_SAUDE")
    @SequenceGenerator(name = "SQ_OBJETIVO_SAUDE", sequenceName = "SQ_OBJETIVO_SAUDE", allocationSize = 1)
    @Column(name = "ID_OBJETIVO_SAUDE")
    private Long id;

    @Column(name = "NOME_OBJETIVO_SAUDE")
    private String nome;

    @Column(name = "DESCRICAO_OBJETIVO_SAUDE")
    private String descricao;

    @Column(name = "PROGRESSO_OBJETIVO_SAUDE")
    private Integer progresso;

    public ObjetivoSaude() {
    }

    public ObjetivoSaude(Long id, String nome, String descricao, Integer progresso) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.progresso = progresso;
    }

    public Long getId() {
        return id;
    }

    public ObjetivoSaude setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public ObjetivoSaude setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public ObjetivoSaude setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public Integer getProgresso() {
        return progresso;
    }

    public ObjetivoSaude setProgresso(Integer progresso) {
        this.progresso = progresso;
        return this;
    }

    @Override
    public String toString() {
        return "ObjetivoSaude{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", progresso=" + progresso +
                '}';
    }
}
