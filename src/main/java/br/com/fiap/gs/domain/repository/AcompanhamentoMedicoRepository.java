package br.com.fiap.gs.domain.repository;

import br.com.fiap.gs.domain.entity.AcompanhamentoMedico;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class AcompanhamentoMedicoRepository implements Repository<AcompanhamentoMedico, Long>{

    private static final AtomicReference<AcompanhamentoMedicoRepository> instance = new AtomicReference<>();
    private final EntityManager manager;

    private AcompanhamentoMedicoRepository(EntityManager manager) {
        this.manager = manager;
    }

    public static AcompanhamentoMedicoRepository build(EntityManager manager) {
        AcompanhamentoMedicoRepository result = instance.get();
        if (Objects.isNull(result)) {
            AcompanhamentoMedicoRepository repo = new AcompanhamentoMedicoRepository(manager);
            if (instance.compareAndSet(null, repo)) {
                result = repo;
            } else {
                result = instance.get();
            }
        }
        return result;
    }

    @Override
    public List<AcompanhamentoMedico> findAll() {
        return manager.createQuery("From AcompanhamentoMedico").getResultList();
    }

    @Override
    public AcompanhamentoMedico findById(Long id) {
        return manager.find(AcompanhamentoMedico.class, id);
    }

    @Override
    public AcompanhamentoMedico persist(AcompanhamentoMedico acompanhamentoMedico) {
        manager.getTransaction().begin();
        manager.persist(acompanhamentoMedico);
        manager.getTransaction().commit();
        return acompanhamentoMedico;
    }

    @Override
    public AcompanhamentoMedico update(AcompanhamentoMedico acompanhamentoMedico) {
        manager.getTransaction().begin();
        acompanhamentoMedico = manager.merge(acompanhamentoMedico);
        manager.getTransaction().commit();
        return acompanhamentoMedico;
    }

    @Override
    public boolean delete(AcompanhamentoMedico acompanhamentoMedico) {
        manager.getTransaction().begin();
        manager.remove(acompanhamentoMedico);
        manager.getTransaction().commit();
        return true;
    }
}
