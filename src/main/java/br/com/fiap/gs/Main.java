package br.com.fiap.gs;

import br.com.fiap.gs.domain.entity.*;
import br.com.fiap.gs.domain.repository.ObjetivoSaudeRepository;
import br.com.fiap.gs.domain.repository.RestricaoAlimentarRepository;
import br.com.fiap.gs.domain.repository.UsuarioRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // EntityManager setup
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("oracle-fiap");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Create objects for ObjetivoSaude
        ObjetivoSaude objetivoSaude1 = new ObjetivoSaude(null, "Objetivo 1", "Descrição do objetivo 1");
        ObjetivoSaude objetivoSaude2 = new ObjetivoSaude(null, "Objetivo 2", "Descrição do objetivo 2");
        ObjetivoSaude objetivoSaude3 = new ObjetivoSaude(null, "Objetivo 3", "Descrição do objetivo 3");

        // Create objects for RestricaoAlimentar
        RestricaoAlimentar restricaoAlimentar1 = new RestricaoAlimentar(null, "Restricao 1", "Descrição da restrição 1", 50);
        RestricaoAlimentar restricaoAlimentar2 = new RestricaoAlimentar(null, "Restricao 2", "Descrição da restrição 2", 70);
        RestricaoAlimentar restricaoAlimentar3 = new RestricaoAlimentar(null, "Restricao 3", "Descrição da restrição 3", 80);

        // Create objects for Usuario
        Set<InformacaoUsuario> informacoesUsuario1 = new HashSet<>();
        informacoesUsuario1.add(objetivoSaude1);
        informacoesUsuario1.add(restricaoAlimentar1);

        Set<InformacaoUsuario> informacoesUsuario2 = new HashSet<>();
        informacoesUsuario2.add(objetivoSaude2);
        informacoesUsuario2.add(restricaoAlimentar2);

        Set<InformacaoUsuario> informacoesUsuario3 = new HashSet<>();
        informacoesUsuario3.add(objetivoSaude3);
        informacoesUsuario3.add(restricaoAlimentar3);

        Usuario usuario1 = new Usuario(null, "email1@example.com", "senha1", "Usuário 1", 30, 170.0, 65.0, Sexo.MASCULINO, informacoesUsuario1);
        Usuario usuario2 = new Usuario(null, "email2@example.com", "senha2", "Usuário 2", 25, 160.0, 55.0, Sexo.FEMININO, informacoesUsuario2);
        Usuario usuario3 = new Usuario(null, "email3@example.com", "senha3", "Usuário 3", 35, 175.0, 70.0, Sexo.MASCULINO, informacoesUsuario3);

        // Using repositories to persist the entities
        ObjetivoSaudeRepository objetivoSaudeRepository = ObjetivoSaudeRepository.build(entityManager);
        objetivoSaudeRepository.persist(objetivoSaude1);
        objetivoSaudeRepository.persist(objetivoSaude2);
        objetivoSaudeRepository.persist(objetivoSaude3);

        RestricaoAlimentarRepository restricaoAlimentarRepository = RestricaoAlimentarRepository.build(entityManager);
        restricaoAlimentarRepository.persist(restricaoAlimentar1);
        restricaoAlimentarRepository.persist(restricaoAlimentar2);
        restricaoAlimentarRepository.persist(restricaoAlimentar3);

        UsuarioRepository usuarioRepository = UsuarioRepository.build(entityManager);
        usuarioRepository.persist(usuario1);
        usuarioRepository.persist(usuario2);
        usuarioRepository.persist(usuario3);

        entityManager.close();
        entityManagerFactory.close();
    }
}
