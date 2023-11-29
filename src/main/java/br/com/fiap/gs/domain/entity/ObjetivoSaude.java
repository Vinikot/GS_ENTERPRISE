package br.com.fiap.gs.domain.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_OBJETIVO_SAUDE")
@DiscriminatorValue("OBJETIVO_SAUDE")
public class ObjetivoSaude extends InformacaoUsuario {

    public ObjetivoSaude() {
    }

    public ObjetivoSaude(Long id, String nome, String descricao) {
        super(id, nome, descricao);
    }

    @Override
    public String toString() {
        return "ObjetivoSaude{} " + super.toString();
    }
}
