package br.com.fiap.gs.domain.repository;

import br.com.fiap.gs.domain.entity.RestricaoAlimentar;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class RestricaoAlimentarRepository implements Repository<RestricaoAlimentar, Long>{

    private static final AtomicReference<RestricaoAlimentarRepository> instance = new AtomicReference<>();
    private final EntityManager manager;

    private RestricaoAlimentarRepository(EntityManager manager) {
        this.manager = manager;
    }

    public static RestricaoAlimentarRepository build(EntityManager manager) {
        RestricaoAlimentarRepository result = instance.get();
        if (Objects.isNull(result)) {
            RestricaoAlimentarRepository repo = new RestricaoAlimentarRepository(manager);
            if (instance.compareAndSet(null, repo)) {
                result = repo;
            } else {
                result = instance.get();
            }
        }
        return result;
    }

    @Override
    public List<RestricaoAlimentar> findAll() {
        return manager.createQuery("From RestricaoAlimentar").getResultList();
    }

    @Override
    public RestricaoAlimentar findById(Long id) {
        return manager.find(RestricaoAlimentar.class, id);
    }

    @Override
    public RestricaoAlimentar persist(RestricaoAlimentar restricaoAlimentar) {
        manager.getTransaction().begin();
        manager.persist(restricaoAlimentar);
        manager.getTransaction().commit();
        return restricaoAlimentar;
    }

    @Override
    public RestricaoAlimentar update(RestricaoAlimentar restricaoAlimentar) {
        manager.getTransaction().begin();
        restricaoAlimentar = manager.merge(restricaoAlimentar);
        manager.getTransaction().commit();
        return restricaoAlimentar;
    }

    @Override
    public boolean delete(RestricaoAlimentar restricaoAlimentar) {
        manager.getTransaction().begin();
        manager.remove(restricaoAlimentar);
        manager.getTransaction().commit();
        return true;
    }
}
