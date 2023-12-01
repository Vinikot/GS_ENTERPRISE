package br.com.fiap.gs.domain.entity;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import jakarta.persistence.*;

@Entity
@Table(name = "TB_USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_USUARIO")
    @SequenceGenerator(name = "SQ_USUARIO", sequenceName = "SQ_USUARIO", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_USUARIO")
    private Long id;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "SENHA")
    private String senha;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "IDADE")
    private Integer idade;

    @Column(name = "ALTURA")
    private Double altura;

    @Column(name = "PESO")
    private Double peso;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "TB_USUARIO_ACOMPANHAMENTO",
            joinColumns = {
                    @JoinColumn(
                            name = "USUARIO",
                            referencedColumnName = "ID_USUARIO",
                            foreignKey = @ForeignKey(name = "TB_USUARIO_ACOMPANHAMENTO_FK_USUARIO")
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "USUARIO_ACOMPANHAMENTO",
                            referencedColumnName = "ID_ACOMPANHAMENTO_MEDICO",
                            foreignKey = @ForeignKey(name = "TB_USUARIO_ACOMPANHAMENTO_FK_ACOMPANHAMENTO_USUARIO")
                    )
            }
    )
    private Set<AcompanhamentoMedico> acompanhamentoUsuario = new LinkedHashSet<>();

    public Usuario() {
    }

    public Usuario(Long id, String email, String senha, String nome, Integer idade, Double altura, Double peso, Sexo sexo, Set<AcompanhamentoMedico> acompanhamentoUsuario) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        this.sexo = sexo;
        this.acompanhamentoUsuario = acompanhamentoUsuario;
    }

    public Long getId() {
        return id;
    }

    public Usuario setId(Long id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Usuario setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getSenha() {
        return senha;
    }

    public Usuario setSenha(String senha) {
        this.senha = senha;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Usuario setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Integer getIdade() {
        return idade;
    }

    public Usuario setIdade(Integer idade) {
        this.idade = idade;
        return this;
    }

    public Double getAltura() {
        return altura;
    }

    public Usuario setAltura(Double altura) {
        this.altura = altura;
        return this;
    }

    public Double getPeso() {
        return peso;
    }

    public Usuario setPeso(Double peso) {
        this.peso = peso;
        return this;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public Usuario setSexo(Sexo sexo) {
        this.sexo = sexo;
        return this;
    }

    public Set<AcompanhamentoMedico> getAcompanhamentoUsuario() {
        return acompanhamentoUsuario;
    }

    public Usuario setAcompanhamentoUsuario(Set<AcompanhamentoMedico> acompanhamentoUsuario) {
        this.acompanhamentoUsuario = acompanhamentoUsuario;
        return this;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", altura=" + altura +
                ", peso=" + peso +
                ", sexo=" + sexo +
                ", acompanhamentoUsuario=" + acompanhamentoUsuario +
                '}';
    }
}
