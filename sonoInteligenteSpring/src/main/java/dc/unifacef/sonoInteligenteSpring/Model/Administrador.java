package dc.unifacef.sonoInteligenteSpring.Model;

import dc.unifacef.sonoInteligenteSpring.Model.Autenticacao;
import dc.unifacef.sonoInteligenteSpring.Model.Paciente;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "administradores")
public class Administrador implements Autenticacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "administradorId")
    private List<Paciente> pacientes;

    @Transient
    private boolean isLogged;

    public Administrador() {
        this.isLogged = false;
    }

    public Administrador(Long id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.pacientes = new ArrayList<>();
        this.isLogged = false;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Long getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public String getSenha() {
        return this.senha;
    }

    public List<Paciente> getPacientes() {
        return this.pacientes;
    }

    @Override
    public void login(String email, String senha) {
        this.isLogged = true;
    }

    @Override
    public void logout() {
        this.isLogged = false;
    }
}
