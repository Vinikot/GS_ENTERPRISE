package br.com.fiap.gs.domain.repository;


import br.com.fiap.gs.domain.entity.ObjetivoSaude;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class ObjetivoSaudeRepository implements Repository<ObjetivoSaude, Long>{

    private static final AtomicReference<ObjetivoSaudeRepository> instance = new AtomicReference<>();
    private final EntityManager manager;

    private ObjetivoSaudeRepository(EntityManager manager) {
        this.manager = manager;
    }

    public static ObjetivoSaudeRepository build(EntityManager manager) {
        ObjetivoSaudeRepository result = instance.get();
        if (Objects.isNull(result)) {
            ObjetivoSaudeRepository repo = new ObjetivoSaudeRepository(manager);
            if (instance.compareAndSet(null, repo)) {
                result = repo;
            } else {
                result = instance.get();
            }
        }
        return result;
    }

    @Override
    public List<ObjetivoSaude> findAll() {
        return manager.createQuery("From ObjetivoSaude").getResultList();
    }

    @Override
    public ObjetivoSaude findById(Long id) {
        return manager.find(ObjetivoSaude.class, id);
    }

    @Override
    public ObjetivoSaude persist(ObjetivoSaude objetivoSaude) {
        manager.getTransaction().begin();
        manager.persist(objetivoSaude);
        manager.getTransaction().commit();
        return objetivoSaude;
    }

    @Override
    public ObjetivoSaude update(ObjetivoSaude objetivoSaude) {
        manager.getTransaction().begin();
        objetivoSaude = manager.merge(objetivoSaude);
        manager.getTransaction().commit();
        return objetivoSaude;
    }

    @Override
    public boolean delete(ObjetivoSaude objetivoSaude) {
        manager.getTransaction().begin();
        manager.remove(objetivoSaude);
        manager.getTransaction().commit();
        return true;
    }
}
