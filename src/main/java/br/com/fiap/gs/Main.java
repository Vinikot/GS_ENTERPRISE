package br.com.fiap.gs;

import br.com.fiap.gs.domain.entity.*;
import br.com.fiap.gs.domain.repository.AcompanhamentoMedicoRepository;
import br.com.fiap.gs.domain.repository.ObjetivoSaudeRepository;
import br.com.fiap.gs.domain.repository.RestricaoAlimentarRepository;
import br.com.fiap.gs.domain.repository.UsuarioRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("oracle-fiap");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ObjetivoSaudeRepository objetivoSaudeRepository = ObjetivoSaudeRepository.build(entityManager);
        RestricaoAlimentarRepository restricaoAlimentarRepository = RestricaoAlimentarRepository.build(entityManager);
        AcompanhamentoMedicoRepository acompanhamentoMedicoRepository = AcompanhamentoMedicoRepository.build(entityManager);
        UsuarioRepository usuarioRepository = UsuarioRepository.build(entityManager);

        // Criando ObjetivoSaude
        ObjetivoSaude objetivo1 = new ObjetivoSaude()
                .setNome("Emagrecimento")
                .setDescricao("Perder peso")
                .setProgresso(50);
        objetivoSaudeRepository.persist(objetivo1);

        ObjetivoSaude objetivo2 = new ObjetivoSaude()
                .setNome("Ganho de Massa")
                .setDescricao("Aumento de massa muscular")
                .setProgresso(30);
        objetivoSaudeRepository.persist(objetivo2);

        ObjetivoSaude objetivo3 = new ObjetivoSaude()
                .setNome("Manutenção")
                .setDescricao("Manter o peso atual")
                .setProgresso(80);
        objetivoSaudeRepository.persist(objetivo3);

        // Criando RestricaoAlimentar
        RestricaoAlimentar restricao1 = new RestricaoAlimentar()
                .setNome("Sem glúten")
                .setDescricao("Restrição alimentar de glúten");
        restricaoAlimentarRepository.persist(restricao1);

        RestricaoAlimentar restricao2 = new RestricaoAlimentar()
                .setNome("Sem lactose")
                .setDescricao("Restrição alimentar de lactose");
        restricaoAlimentarRepository.persist(restricao2);

        RestricaoAlimentar restricao3 = new RestricaoAlimentar()
                .setNome("Veganismo")
                .setDescricao("Restrição alimentar vegana");
        restricaoAlimentarRepository.persist(restricao3);

        // Criando três AcompanhamentoMedico e associando ObjetivoSaude e RestricaoAlimentar
        Set<ObjetivoSaude> objt1 = new LinkedHashSet<>();
        objt1.add(objetivo1);
        Set<RestricaoAlimentar> rest1 = new LinkedHashSet<>();
        rest1.add(restricao1);
        AcompanhamentoMedico acompanhamento1 = new AcompanhamentoMedico()
                .setDataAcompanhamento(LocalDate.now())
                .setObjetivoSaude(objt1)
                .setRestricaoAlimentar(rest1);
        acompanhamentoMedicoRepository.persist(acompanhamento1);

        Set<ObjetivoSaude> objt2 = new LinkedHashSet<>();
        objt2.add(objetivo2);
        Set<RestricaoAlimentar> rest2 = new LinkedHashSet<>();
        rest2.add(restricao2);
        AcompanhamentoMedico acompanhamento2 = new AcompanhamentoMedico()
                .setDataAcompanhamento(LocalDate.now())
                .setObjetivoSaude(objt2)
                .setRestricaoAlimentar(rest2);
        acompanhamentoMedicoRepository.persist(acompanhamento2);

        Set<ObjetivoSaude> objt3 = new LinkedHashSet<>();
        objt3.add(objetivo3);
        Set<RestricaoAlimentar> rest3 = new LinkedHashSet<>();
        rest3.add(restricao3);
        AcompanhamentoMedico acompanhamento3 = new AcompanhamentoMedico()
                .setDataAcompanhamento(LocalDate.now())
                .setObjetivoSaude(objt3)
                .setRestricaoAlimentar(rest3);
        acompanhamentoMedicoRepository.persist(acompanhamento3);

        // Criando usuário e associando aos acompanhamentos
        Set<AcompanhamentoMedico> acompanhamentosUsuario = new HashSet<>();
        acompanhamentosUsuario.add(acompanhamento1);

        Usuario usuario = new Usuario()
                .setEmail("usuario@teste.com")
                .setSenha("123456")
                .setNome("Usuário Teste")
                .setIdade(30)
                .setAltura(1.75)
                .setPeso(70.0)
                .setSexo(Sexo.MASCULINO)
                .setAcompanhamentoUsuario(acompanhamentosUsuario);
        usuarioRepository.persist(usuario);

        Set<AcompanhamentoMedico> acompanhamentosUsuario2 = new HashSet<>();
        acompanhamentosUsuario2.add(acompanhamento2);

        Usuario usuario2 = new Usuario()
                .setEmail("usuario2@teste.com")
                .setSenha("123456")
                .setNome("Usuário 2 Teste")
                .setIdade(25)
                .setAltura(1.65)
                .setPeso(60.0)
                .setSexo(Sexo.FEMININO)
                .setAcompanhamentoUsuario(acompanhamentosUsuario2);
        usuarioRepository.persist(usuario2);

        Set<AcompanhamentoMedico> acompanhamentosUsuario3 = new HashSet<>();
        acompanhamentosUsuario3.add(acompanhamento3);

        Usuario usuario3 = new Usuario()
                .setEmail("usuario3@teste.com")
                .setSenha("123456")
                .setNome("Usuário 3 Teste")
                .setIdade(35)
                .setAltura(1.80)
                .setPeso(80.0)
                .setSexo(Sexo.MASCULINO)
                .setAcompanhamentoUsuario(acompanhamentosUsuario3);
        usuarioRepository.persist(usuario3);

        // Exemplo de utilização dos métodos da Repository para ObjetivoSaude
        ObjetivoSaude objetivoEncontrado = objetivoSaudeRepository.findById(objetivo1.getId());
        objetivoEncontrado.setProgresso(70); // Altera o progresso
        objetivoSaudeRepository.update(objetivoEncontrado);

        objetivoSaudeRepository.delete(objetivo3); // Deleta o terceiro objetivo

        // Exemplo de utilização dos métodos da Repository para RestricaoAlimentar
        RestricaoAlimentar restricaoEncontrada = restricaoAlimentarRepository.findById(restricao1.getId());
        restricaoEncontrada.setDescricao("Nova descrição"); // Altera a descrição
        restricaoAlimentarRepository.update(restricaoEncontrada);

        restricaoAlimentarRepository.delete(restricao2); // Deleta a segunda restrição

        // Exemplo de utilização dos métodos da Repository para AcompanhamentoMedico
        AcompanhamentoMedico acompanhamentoEncontrado = acompanhamentoMedicoRepository.findById(acompanhamento1.getId());
        acompanhamentoEncontrado.setDataAcompanhamento(LocalDate.now().minusDays(2)); // Altera a data
        acompanhamentoMedicoRepository.update(acompanhamentoEncontrado);

        acompanhamentoMedicoRepository.delete(acompanhamento3); // Deleta o terceiro acompanhamento

        // Exemplo de utilização dos métodos da Repository para Usuario
        Usuario usuarioEncontrado = usuarioRepository.findById(usuario.getId());
        usuarioEncontrado.setNome("Novo Nome"); // Altera o nome
        usuarioRepository.update(usuarioEncontrado);

        usuarioRepository.delete(usuario3); // Deleta o terceiro usuário

        entityManager.close();
        entityManagerFactory.close();
    }
}
