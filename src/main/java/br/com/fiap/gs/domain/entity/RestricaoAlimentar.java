package br.com.fiap.gs.domain.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_RESTRICAO_ALIMENTAR")
@DiscriminatorValue("RESTRICAO_ALIMENTAR")
public class RestricaoAlimentar extends InformacaoUsuario {

    private Integer progresso;

    public RestricaoAlimentar() {

    }

    public RestricaoAlimentar(Long id, String nome, String descricao, Integer progresso) {
        super(id, nome, descricao);
        this.progresso = progresso;
    }

    public Integer getProgresso() {
        return progresso;
    }

    public RestricaoAlimentar setProgresso(Integer progresso) {
        this.progresso = progresso;
        return this;
    }

    @Override
    public String toString() {
        return "RestricaoAlimentar{" +
                "progresso=" + progresso +
                "} " + super.toString();
    }
}
