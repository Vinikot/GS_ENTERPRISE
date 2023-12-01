package br.com.fiap.gs.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;


@Entity
@Table(name = "TB_ACOMPANHAMENTO_MEDICO")
public class AcompanhamentoMedico {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ACOMPANHAMENTO_MEDICO")
    @SequenceGenerator(name = "SQ_ACOMPANHAMENTO_MEDICO", sequenceName = "SQ_ACOMPANHAMENTO_MEDICO", allocationSize = 1)
    @Column(name = "ID_ACOMPANHAMENTO_MEDICO")
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "TB_ACOMPANHAMENTO_OBJETIVO",
            joinColumns = {
                    @JoinColumn(
                            name = "ACOMPANHAMENTO_MEDICO",
                            referencedColumnName = "ID_ACOMPANHAMENTO_MEDICO",
                            foreignKey = @ForeignKey(name = "TB_ACOMPANHAMENTO_OBJETIVO_FK_ACOMPANHAMENTO_MEDICO")
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "ACOMPANHAMENTO_OBJETIVO",
                            referencedColumnName = "ID_OBJETIVO_SAUDE",
                            foreignKey = @ForeignKey(name = "TB_ACOMPANHAMENTO_OBJETIVO_FK_OBJETIVO_SAUDE")
                    )
            }
    )
    private Set<ObjetivoSaude> objetivoSaude = new LinkedHashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "TB_ACOMPANHAMENTO_RESTRICAO",
            joinColumns = {
                    @JoinColumn(
                            name = "ACOMPANHAMENTO_MEDICO",
                            referencedColumnName = "ID_ACOMPANHAMENTO_MEDICO",
                            foreignKey = @ForeignKey(name = "TB_ACOMPANHAMENTO_RESTRICAO_FK_ACOMPANHAMENTO_MEDICO")
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "ACOMPANHAMENTO_RESTRICAO",
                            referencedColumnName = "ID_RESTRICAO_ALIMENTAR",
                            foreignKey = @ForeignKey(name = "TB_ACOMPANHAMENTO_RESTRICAO_FK_RESTRICAO_ALIMENTAR")
                    )
            }
    )
    private Set<RestricaoAlimentar> restricaoAlimentar = new LinkedHashSet<>();

    @Column(name = "DT_ACOMPANHAMENTO")
    private LocalDate dataAcompanhamento;

    public AcompanhamentoMedico() {
    }

    public AcompanhamentoMedico(Long id, ObjetivoSaude objetivoSaude, RestricaoAlimentar restricaoAlimentar, LocalDate dataAcompanhamento) {
        this.id = id;
        this.objetivoSaude = (Set<ObjetivoSaude>) objetivoSaude;
        this.restricaoAlimentar = (Set<RestricaoAlimentar>) restricaoAlimentar;
        this.dataAcompanhamento = dataAcompanhamento;
    }

    public Long getId() {
        return id;
    }

    public AcompanhamentoMedico setId(Long id) {
        this.id = id;
        return this;
    }

    public Set<ObjetivoSaude> getObjetivoSaude() {
        return objetivoSaude;
    }

    public AcompanhamentoMedico setObjetivoSaude(Set<ObjetivoSaude> objetivoSaude) {
        this.objetivoSaude = objetivoSaude;
        return this;
    }

    public Set<RestricaoAlimentar> getRestricaoAlimentar() {
        return restricaoAlimentar;
    }

    public AcompanhamentoMedico setRestricaoAlimentar(Set<RestricaoAlimentar> restricaoAlimentar) {
        this.restricaoAlimentar = restricaoAlimentar;
        return this;
    }

    public LocalDate getDataAcompanhamento() {
        return dataAcompanhamento;
    }

    public AcompanhamentoMedico setDataAcompanhamento(LocalDate dataAcompanhamento) {
        this.dataAcompanhamento = dataAcompanhamento;
        return this;
    }

    @Override
    public String toString() {
        return "AcompanhamentoMedico{" +
                "id=" + id +
                ", objetivoSaude=" + objetivoSaude +
                ", restricaoAlimentar=" + restricaoAlimentar +
                ", dataAcompanhamento=" + dataAcompanhamento +
                '}';
    }
}
