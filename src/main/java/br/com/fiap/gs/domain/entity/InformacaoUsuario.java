package br.com.fiap.gs.domain.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "TB_INFORMACAO_USUARIO")
@Inheritance(strategy = InheritanceType.JOINED)
public class InformacaoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_INFORMACAO_USUARIO")
    @SequenceGenerator(name = "SQ_INFORMACAO_USUARIO", sequenceName = "SQ_INFORMACAO_USUARIO", allocationSize = 1)
    @Column(name = "ID_INFORMACAO_USUARIO")
    protected Long id;

    @Column(name = "NOME_INFORMACAO_USUARIO")
    protected String nome;

    @Column(name = "DESCRICAO_INFORMACAO_USUARIO")
    protected String descricao;

    public InformacaoUsuario() {
    }

    public InformacaoUsuario(Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public InformacaoUsuario setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public InformacaoUsuario setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public InformacaoUsuario setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    @Override
    public String toString() {
        return "InformacaoUsuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
